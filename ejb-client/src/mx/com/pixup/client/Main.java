package mx.com.pixup.client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.eap.ejb.FacadeWebRemote;
import mx.com.pixup.model.Usuario;

public class Main {

    public static void main(String[] args) {
        try{
		// Generar contexto con Jboss
		Context context = getContext();
                FacadeWebRemote manejaUsuario = 
                        (FacadeWebRemote)context.lookup("pixup-eap/pixup-eap-ejb.jar/FacadeWeb!remote");
                Usuario usuario = new Usuario();
                try{
                    usuario = manejaUsuario.validaUsuario("aruiz@gmail.com", "elPaso");
                    System.out.println("usuario: "+usuario.getNombre());
                }catch(PixUpBOException e){
                    e.printStackTrace(System.out);
                } catch(NullPointerException e){
                    System.out.println("Se encontró un valor nulo, imposible continuar.");
                }
		}catch(NamingException e){
			System.out.println(e);
			e.printStackTrace(System.out);
		}
	}
	
	private static Context getContext() throws NamingException{
                Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		props.put(InitialContext.URL_PKG_PREFIXES,
				"org.jboss.naming:org.jnp.interfaces");
		Context ctx = new InitialContext(props);
		return ctx;
	}    
}
