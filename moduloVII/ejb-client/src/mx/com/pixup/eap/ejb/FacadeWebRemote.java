package mx.com.pixup.eap.ejb;

import javax.ejb.Remote;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Usuario;

@Remote
public interface FacadeWebRemote {
    Usuario validaUsuario(String cuenta, String contrasenia) throws PixUpBOException;    
}
