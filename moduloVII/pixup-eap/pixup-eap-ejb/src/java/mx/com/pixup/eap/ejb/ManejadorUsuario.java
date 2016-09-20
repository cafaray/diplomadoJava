package mx.com.pixup.eap.ejb;

import javax.ejb.Stateless;
import mx.com.pixup.bo.UsuarioBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.bo.impl.UsuarioBOImpl;
import mx.com.pixup.model.Usuario;

@Stateless
public class ManejadorUsuario implements ManejadorUsuarioLocal {

private final UsuarioBO bo;
    
    public ManejadorUsuario(){
        bo = new UsuarioBOImpl();
    }
    

    @Override
    public Usuario ingresaUsuario(Usuario usuario) throws PixUpBOException {
        return bo.registrar(usuario);
    }

    @Override
    public Usuario validaUsuario(String cuenta, String contrasenia) throws PixUpBOException {
        return bo.validaAcceso(cuenta, contrasenia);
    }
}
