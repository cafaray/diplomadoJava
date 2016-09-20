package mx.com.pixup.bo;

import java.util.List;
import mx.com.pixup.bo.exception.PixUpBOException;

import mx.com.pixup.model.jpa.Usuario;

public interface UsuarioBO {

    Usuario validarAcceso(String cuenta, String contrasena) throws PixUpBOException;
    List<Usuario> listar() throws PixUpBOException;
    Usuario buscarPorCuenta(String cuenta) throws PixUpBOException;
    Usuario registrarUsuario(Usuario usuario) throws PixUpBOException;
    List<Usuario> encontrarPorNombreCompleto(String nombre, String paterno, String materno) throws PixUpBOException;
    
}
