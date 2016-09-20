package mx.com.pixup.back;

import javax.ejb.Local;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Usuario;

@Local
public interface ManejadorUsuarioLocal {

    Usuario insertaUsuario(Usuario usuario) throws PixUpBOException;
    Usuario validaUsuario(String usuario, String contrasenia) throws PixUpBOException;
    
}
