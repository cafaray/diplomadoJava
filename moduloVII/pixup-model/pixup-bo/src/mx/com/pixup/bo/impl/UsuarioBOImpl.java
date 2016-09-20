package mx.com.pixup.bo.impl;

import mx.com.pixup.bo.UsuarioBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.dao.UsuarioDAO;
import mx.com.pixup.dao.exception.PixUpDAOException;
import mx.com.pixup.dao.impl.UsuarioDAOImpl;
import mx.com.pixup.model.Usuario;

public class UsuarioBOImpl implements UsuarioBO {
    
    private UsuarioDAO dao;

    public UsuarioBOImpl() {
        dao = new UsuarioDAOImpl();
    }
    
    @Override
    public Usuario registrar(Usuario usuario) throws PixUpBOException {
        try{
            /*
            En caso de existir lógica de negocio para esta operación, aquí es donde se tiene que codificar
            */
            return dao.inserta(usuario);
        }catch(PixUpDAOException e){
            e.printStackTrace(System.out);
            throw new PixUpBOException("PixUp: Ocurrió un error al intentar agregar esta cuenta como usuario de la aplicación.");
        }
    }

    @Override
    public Usuario validaAcceso(String email, String contrasenia) throws PixUpBOException {
        try{
            /*
            En caso de existir lógica de negocio para esta operación, aquí es donde se tiene que codificar
            */
            Usuario usuario = dao.validaAcceso(email, contrasenia);
            if(usuario==null){
                throw new PixUpBOException("El usuario no esta registrado en la aplicación. Verifique los datos de conexión.");
            }else{
                return usuario;
            }
        }catch(PixUpDAOException e){
            e.printStackTrace(System.out);
            throw new PixUpBOException("PixUp: No se ha logrado autenticar esta cuenta en la aplicación.");
        }
    }
    
}
