package mx.com.pixup.back;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Usuario;

@Stateless
public class Facade implements FacadeLocal {
    @EJB
    private ManejadorUsuario manejador;

    @Override
    public Usuario registraUsuario(Usuario usuario) throws PixUpBOException {
        return manejador.insertaUsuario(usuario);
    }

}
