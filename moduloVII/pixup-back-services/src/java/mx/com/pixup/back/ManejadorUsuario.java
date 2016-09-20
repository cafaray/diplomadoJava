package mx.com.pixup.back;

import javax.ejb.Stateless;

import mx.com.pixup.bo.UsuarioBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.bo.impl.UsuarioBOImpl;
import mx.com.pixup.model.Usuario;


@Stateless(name = "ManejadorUsuario")
public class ManejadorUsuario implements ManejadorUsuarioLocal {

    private final UsuarioBO bo;
    
    public ManejadorUsuario(){
        bo = new UsuarioBOImpl();
    }
    
    @Override
    public Usuario insertaUsuario(Usuario usuario) throws PixUpBOException {
        return bo.registrar(usuario);
    }

    @Override
    public Usuario validaUsuario(String usuario, String contrasenia) throws PixUpBOException {
        return bo.validaAcceso(usuario, contrasenia);
    }

    

}
