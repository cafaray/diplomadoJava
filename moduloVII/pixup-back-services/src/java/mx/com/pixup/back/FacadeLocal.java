package mx.com.pixup.back;

import javax.ejb.Local;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Usuario;

@Local
public interface FacadeLocal  {
    Usuario registraUsuario(Usuario usuario) throws PixUpBOException;
}
