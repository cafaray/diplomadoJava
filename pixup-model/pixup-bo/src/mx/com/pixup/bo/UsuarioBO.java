package mx.com.pixup.bo;

import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Usuario;

public interface UsuarioBO {
    
    Usuario registrar(Usuario usuario) throws PixUpBOException;
    Usuario validaAcceso(String email, String contrasenia) throws PixUpBOException;
    
}
