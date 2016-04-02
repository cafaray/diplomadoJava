package mx.com.pixup.app;

import java.util.Calendar;
import mx.com.pixup.bo.UsuarioBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.bo.impl.UsuarioBOImpl;
import mx.com.pixup.model.Usuario;

public class Main {

    public static void main(String[] args) {
        UsuarioBO bo = new UsuarioBOImpl();
        Usuario usuario = new Usuario();
        usuario.setNombre("Alberto");
        usuario.setApellidoPaterno("Ruiz");
        usuario.setApellidoMaterno("Vazquez");
        usuario.setEmail("aruizv@gmail.com");
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(Calendar.YEAR, 1979);
        fechaNacimiento.set(Calendar.MONTH, 9);
        fechaNacimiento.set(Calendar.DATE, 19);
        usuario.setFechaNacimiento(fechaNacimiento.getTime());
        usuario.setGenero("H");
        usuario.setNumeroTelefonico("5560121201");
        usuario.setPassword("elPaso");
        try{
            usuario = bo.registrar(usuario);
            System.out.println("Se ingreso el usuario correctamente: "+usuario.getNombre());
        }catch(PixUpBOException e){
            e.printStackTrace(System.out);
        }

    }

}
