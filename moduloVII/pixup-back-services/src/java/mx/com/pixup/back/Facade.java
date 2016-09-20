package mx.com.pixup.back;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.model.Usuario;

@Stateless(name = "PixUpFacade")
public class Facade implements FacadeLocal {
    
    @EJB(mappedName="PixUp/ManejadorUsuarioService/local") 
    private ManejadorUsuario manejador;

    
    @Override
    public Usuario registraUsuario(Usuario usuario) throws PixUpBOException {
        return manejador.insertaUsuario(usuario);
    }

}
