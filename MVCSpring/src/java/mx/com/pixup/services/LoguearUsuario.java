package mx.com.pixup.services;

import mx.com.pixup.model.Usuario;

public class LoguearUsuario {

    public LoguearUsuario() {
    }

    public String login(Usuario usuario) {
        if(usuario.getCuenta().equals("usuario") && usuario.getContrasenia().equals("123456")){
            return "Usuario valido :D";
        } else {
            return "Sigue intentado, no es complicado.";
        }
    }
    
}
