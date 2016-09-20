package mx.com.pixup.dao;

import java.util.List;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {
        
    @Override
    Usuario inserta(Usuario usuario) throws PixUpDAOException;
    
    @Override
    Usuario actualiza(Usuario usuario) throws PixUpDAOException;
    
    @Override
    void elimina(Usuario usuario) throws PixUpDAOException;
    
    @Override
    Usuario encuentraPorId(Integer identificador) throws PixUpDAOException;
    
    @Override
    List<Usuario> lista() throws PixUpDAOException;
    
    Usuario validaAcceso(String cuenta, String contrasenia) throws PixUpDAOException;
    
}
