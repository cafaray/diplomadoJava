package mx.com.pixup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import mx.com.pixup.dao.OfertaDAO;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.dao.util.Conexion;
import mx.com.pixup.dao.util.Constantes;
import mx.com.pixup.model.Oferta;
import mx.com.pixup.model.wrapper.OfertaWrapper;

public class OfertaDAOImpl implements OfertaDAO {

    private final static Conexion conexion = Conexion.getInterface();
    private Connection connection;
    
    public OfertaDAOImpl(){    }
    
    @Override
    public Oferta inserta(Oferta oferta) throws PixUpDAOException {
        try {
            connection = conexion.getConexionFromProperties(Constantes.CONNECTION_PROPERTIES);
            String sql = "INSERT INTO oferta VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, 0);
            stm.setInt(2, oferta.getDisco());
            stm.setInt(3, oferta.getUsuario());
            stm.setDate(4, new java.sql.Date(oferta.getFechaInicio().getTime()));
            stm.setDate(5, new java.sql.Date(oferta.getFechaFinal().getTime()));
            stm.setDouble(6, oferta.getPrecio());
            stm.setString(7, oferta.getTextoOferta());
            stm.executeUpdate();
            sql = "SELECT MAX(identificador) FROM oferta;";
            stm = connection.prepareStatement(sql);
            ResultSet rst = stm.executeQuery();
            if(rst.first()){
                int identificador = rst.getInt(1);
                oferta.setIdentificador(identificador);                
            }
            return oferta;            
        } catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("PixUp: Fallo al insertar la oferta");
        } catch(PixUpDAOException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Conexión fallida.");
        } finally{
            try{
                connection.close();
            } catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public Oferta actualiza(Oferta oferta) throws PixUpDAOException {
        try {
            connection = conexion.getConexionFromProperties(Constantes.CONNECTION_PROPERTIES);
            String sql = "UPDATE oferta SET iddisco = ?, fechainicio = ?, fechafinal = ?, precio = ?, texto_oferta = ? WHERE identificador = ?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, oferta.getDisco());
            stm.setDate(2, new java.sql.Date(oferta.getFechaInicio().getTime()));
            stm.setDate(3, new java.sql.Date(oferta.getFechaFinal().getTime()));
            stm.setDouble(4, oferta.getPrecio());
            stm.setString(5, oferta.getTextoOferta());
            stm.setInt(6, oferta.getIdentificador());
            stm.executeUpdate();
            return oferta;
        } catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("PixUp: Fallo al actualizar la oferta");
        } catch(PixUpDAOException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Conexión fallida.");        
        } finally{
            try{
                connection.close();
            } catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void elimina(Oferta oferta) throws PixUpDAOException {
        eliminaPorId(oferta.getIdentificador());
    }

    @Override
    public void eliminaPorId(Integer identificador) throws PixUpDAOException {
        try {
            connection = conexion.getConexionFromProperties(Constantes.CONNECTION_PROPERTIES);
            String sql = "DELETE FROM oferta WHERE identificador = ?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, identificador);
            stm.execute();
        } catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("PixUp: Fallo al eliminar la oferta");
        } catch(PixUpDAOException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Conexión fallida.");        
        } finally{
            try{
                connection.close();
            } catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public Oferta encuentraPorId(Integer identificador) throws PixUpDAOException {
        try{
            connection = conexion.getConexionFromProperties(Constantes.CONNECTION_PROPERTIES);
            String sql = "SELECT identificador, iddisco, fechainicio, fechafinal, precio, texto_oferta FROM oferta WHERE identificador = ?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, identificador);
            ResultSet rst = stm.executeQuery();
            if(rst.first()){                
                Oferta oferta = rellenaOferta(rst);
                return oferta;
            }
            return null;
        } catch(SQLException e) {
            e.printStackTrace(System.out);
            throw new PixUpDAOException("PixUp: Fallo al localizar la oferta");
        } catch(PixUpDAOException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Conexión fallida.");        
        } finally{
            try{
                connection.close();
            } catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }    
    
    @Override
    public OfertaWrapper buscarPorIdentificador(int identificador) throws PixUpDAOException {
        try{
            connection = conexion.getConexionFromProperties(Constantes.CONNECTION_PROPERTIES);
            String sql = "SELECT identificador, iddisco, fechainicio, fechafinal, A.precio precio, texto_oferta, titulo FROM oferta A INNER JOIN disco B ON A.iddisco = B.id WHERE identificador = ?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, identificador);            
            ResultSet rst = stm.executeQuery();
            if(rst.first()){                
                Oferta oferta = rellenaOferta(rst);
                OfertaWrapper wrapper = new OfertaWrapper(oferta);
                wrapper.setTituloDisco(rst.getString("titulo"));
                return wrapper;
            }
            return null;
        } catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("PixUp: Fallo al localizar la oferta");
        } catch(PixUpDAOException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Conexión fallida.");        
        } finally{
            try{
                connection.close();
            } catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }

    
    @Override
    public List<Oferta> lista() throws PixUpDAOException {
        try{
            connection = conexion.getConexionFromProperties(Constantes.CONNECTION_PROPERTIES);
            String sql = "SELECT identificador, iddisco, fechainicio, fechafinal, precio FROM oferta;";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rst = stm.executeQuery();
            List<Oferta> ofertas = new LinkedList<>();
            while(rst.next()){                                
                Oferta oferta = rellenaOferta(rst);
                ofertas.add(oferta);
            }
            return ofertas;
        } catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("PixUp: Fallo al listar las ofertas");
        } catch(PixUpDAOException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Conexión fallida.");        
        } finally{
            try{
                connection.close();
            } catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public List<OfertaWrapper> listar(Date fechaInicio, Date fechaFinal) throws PixUpDAOException {
        try{
            connection = conexion.getConexionFromProperties(Constantes.CONNECTION_PROPERTIES);
            String sql = "SELECT identificador, iddisco, fechainicio, fechafinal, A.precio precio, texto_oferta, titulo FROM oferta A INNER JOIN disco B ON A.iddisco = B.id;";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rst = stm.executeQuery();
            List<OfertaWrapper> ofertas = new LinkedList<>();
            while(rst.next()){                
                Oferta oferta = rellenaOferta(rst);
                OfertaWrapper wrapper = new OfertaWrapper(oferta);
                wrapper.setTituloDisco(rst.getString("titulo"));
                ofertas.add(wrapper);
            }
            return ofertas;
        } catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("PixUp: Fallo al listar la ofertas");
        } catch(PixUpDAOException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Conexión fallida.");        
        } finally{
            try{
                connection.close();
            } catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }

    private Oferta rellenaOferta(ResultSet rst) throws SQLException{
        Oferta oferta = new Oferta();
        oferta.setDisco(rst.getInt("iddisco"));
        oferta.setFechaInicio(rst.getDate("fechainicio"));
        oferta.setFechaFinal(rst.getDate("fechafinal"));
        oferta.setPrecio(rst.getDouble("precio"));
        oferta.setTextoOferta(rst.getString("texto_oferta"));   
        oferta.setIdentificador(rst.getInt("identificador"));
        return oferta;
    }
    
}
