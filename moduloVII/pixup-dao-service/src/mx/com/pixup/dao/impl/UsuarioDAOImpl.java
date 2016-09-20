package mx.com.pixup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import mx.com.pixup.dao.UsuarioDAO;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.dao.util.Conexion;
import mx.com.pixup.dao.util.Constantes;
import mx.com.pixup.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

    private static Connection conexion;

    public UsuarioDAOImpl() {
        try {
            Conexion connection = Conexion.getInterface();
            conexion = connection.getConexionFromProperties(Constantes.CONNECTION_PROPERTIES);
        } catch(PixUpDAOException e){
            System.out.println("error: PixUp no tiene conexion a la base de datos.");
            e.printStackTrace(System.out);            
        }
    }

    @Override
    public Usuario inserta(Usuario usuario) throws PixUpDAOException {
        try {
            String sql = "INSERT INTO usuario VALUES (0, ?, ?,?,?,?,?,?,?)";
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, usuario.getNombre());
            stm.setString(2, usuario.getApellidoPaterno());
            stm.setString(3, usuario.getApellidoMaterno());
            stm.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            stm.setString(5, usuario.getEmail());
            stm.setString(6, usuario.getPassword());
            stm.setString(7, usuario.getGenero());
            stm.setString(8, usuario.getNumeroTelefonico());
            stm.executeUpdate();
            return usuario;
        }catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Error: PixUp. Imposible hacer el Insert, ocurrión una excepción al ejecutar la sentencia.");
        } finally{
            try{
                conexion.close();
            } catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public Usuario validaAcceso(String cuenta, String contrasenia) throws PixUpDAOException{
        try{
            String sql = "SELECT id, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, genero, numero_telefonico FROM usuario WHERE email = ? AND password = ?;";
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, cuenta);
            stm.setString(2, contrasenia);
            ResultSet rst = stm.executeQuery();
            Usuario usuario = null;
            while(rst.next()){
                usuario = new Usuario();
                usuario.setId(rst.getInt(1));
                usuario.setNombre(rst.getString(2));
                usuario.setApellidoPaterno(rst.getString(3));
                usuario.setApellidoMaterno(rst.getString(4));
                usuario.setFechaNacimiento(rst.getDate(5));
                usuario.setEmail(cuenta);
                usuario.setPassword(contrasenia);
                usuario.setGenero(rst.getString(6));
                usuario.setNumeroTelefonico(rst.getString(7));
            }
            return usuario;
        }catch(SQLException e){
            e.printStackTrace(System.out);
            throw new PixUpDAOException("Error: PixUp. Imposible hacer el Insert, ocurrión una excepción al ejecutar la sentencia.");
        } finally{
            try{
                conexion.close();
            } catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
    }
    
    @Override
    public Usuario actualiza(Usuario usuario) throws PixUpDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elimina(Usuario usuario) throws PixUpDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario encuentraPorId(Integer identificador) throws PixUpDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> lista() throws PixUpDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminaPorId(Integer identificador) throws PixUpDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
