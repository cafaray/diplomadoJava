package mx.com.pixup.eap.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Usuario;

@Stateless
public class FacadeWeb implements FacadeWebRemote, FacadeWebLocal {

    
    @Override
    public Usuario ingresaUsuario(Usuario usuario) throws PixUpBOException {
        try {
            Context context = new InitialContext();
            ManejadorUsuarioLocal manejaUsuario = (ManejadorUsuarioLocal) context.lookup("pixup-eap/pixup-eap-ejb.jar/ManejadorUsuario!local");            
            return manejaUsuario.ingresaUsuario(usuario);
        } catch (NamingException ex) {
            Logger.getLogger(FacadeWeb.class.getName()).log(Level.SEVERE, null, ex);
            throw new PixUpBOException(ex.getMessage());
        }
    }

    @Override
    public Usuario validaUsuario(String cuenta, String contrasenia) throws PixUpBOException {
        try {
            Context context = new InitialContext();
            ManejadorUsuarioLocal manejaUsuario = (ManejadorUsuarioLocal) context.lookup("pixup-eap/pixup-eap-ejb.jar/ManejadorUsuario!local");            
            return manejaUsuario.validaUsuario(cuenta, contrasenia);
        } catch (NamingException ex) {
            Logger.getLogger(FacadeWeb.class.getName()).log(Level.SEVERE, null, ex);
            throw new PixUpBOException(ex.getMessage());
        }
    }
    
}
