package mx.com.pixup;

import java.util.Date;
import java.util.List;
import mx.com.pixup.bo.UsuarioBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.bo.impl.UsuarioBOImpl;
import mx.com.pixup.model.jpa.Usuario;

public class Driver {

    public static void main(String[] args){
        try{
            UsuarioBO bo = new UsuarioBOImpl();
            List<Usuario> usuarios = bo.encontrarPorNombreCompleto("", "far", "");
            for(Usuario usuario:usuarios){
                
                StringBuilder nombre = new StringBuilder();
                nombre.append(usuario.getNombre()).append(" ");
                nombre.append(usuario.getApellidoPaterno()).append(" ");
                nombre.append(usuario.getApellidoMaterno());
                System.out.println(nombre.toString());
                
            }
            
            
            
        }catch(PixUpBOException e){
            
        }        
    }
    
}
