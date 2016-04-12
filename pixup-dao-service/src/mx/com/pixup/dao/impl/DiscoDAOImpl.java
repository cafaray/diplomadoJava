package mx.com.pixup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import mx.com.pixup.dao.DiscoDAO;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.dao.util.Conexion;
import mx.com.pixup.dao.util.Constantes;
import mx.com.pixup.model.Disco;

public class DiscoDAOImpl implements DiscoDAO {

    private Connection connection;
    
    public DiscoDAOImpl(){
        try {
            Conexion conexion = Conexion.getInterface();
            connection = conexion.getConexionFromProperties(Constantes.CONNECTION_PROPERTIES);
        } catch(PixUpDAOException e){
            e.printStackTrace(System.out);
        }
    }
    
    @Override
    public Disco inserta(Disco objeto) throws PixUpDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Disco actualiza(Disco objeto) throws PixUpDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elimina(Disco objeto) throws PixUpDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminaPorId(Integer identificador) throws PixUpDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Disco encuentraPorId(Integer identificador) throws PixUpDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Disco> lista() throws PixUpDAOException {
        try{
            String sql = "SELECT id, titulo, fecha_lanzamiento, precio, cantidad_disponible FROM disco;";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rst = stm.executeQuery();
            List<Disco> discos = new LinkedList<Disco>();
            while(rst.next()){                                
                Disco disco = rellenaDisco(rst);
                discos.add(disco);
            }
            return discos;
        } catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("PixUp: Fallo al listar los discos");
        } finally{
            try{
                connection.close();
            } catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }
    
    private Disco rellenaDisco(ResultSet rst) throws SQLException{
        Disco disco = new Disco();
        disco.setId(rst.getInt("id"));
        disco.setTitulo(rst.getString("titulo"));
        disco.setFechaLanzamiento(rst.getDate("fecha_lanzamiento"));
        disco.setCantidadDisponible(rst.getInt("cantidad_disponible"));
        disco.setPrecio(rst.getFloat("precio"));
        return disco;
    }
    
}
