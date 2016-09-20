package mx.com.pixup.dao;

import java.util.List;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.model.jpa.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {
    
    Usuario validaAcceso(String cuenta, String contrasenia) throws PixUpDAOException;
    Usuario findByEMail(String email) throws PixUpDAOException;
    List<Usuario> findByNombreCompleto(String nombre, String paterno, String materno) throws PixUpDAOException;
    
}
