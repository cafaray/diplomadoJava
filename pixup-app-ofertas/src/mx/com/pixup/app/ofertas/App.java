package mx.com.pixup.app.ofertas;

import java.io.Console;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.eap.ejb.ManejadorOfertasRemote;
import mx.com.pixup.model.wrapper.OfertaWrapper;

public class App {

    private static Context context;
    private static ManejadorOfertasRemote manejador;
    private static final Console console = System.console();

    public App() {}

    public void abreConexion() {
        try {
            context = getContext();
            manejador = (ManejadorOfertasRemote) context.lookup("pixup-eap/pixup-eap-ejb.jar/ManejadorOfertas!remote");
            System.out.println("Listos para iniciar");
            manejarOfertas();
        } catch (PixUpBOException e) {
            e.printStackTrace(System.out);
            System.out.println("Ocurrio un error de negocio, revise la bitacora para más detalle.");
        } catch (NamingException e) {
            e.printStackTrace(System.out);
            System.err.println("Imposible establece el contexto con el application Server, no se puede iniciar la aplicación.");
            System.exit(-500);
        }
    }

    private void manejarOfertas() throws PixUpBOException {
        console.printf(TEXTO_SEPARADOR + TEXTO_TITULO + TEXTO_TITULO_APLICACION + TEXTO_SEPARADOR + TEXTO_LINEA);
        String opcion = "";
        do {
            console.printf("%n" + TEXTO_SEPARADOR + TEXTO_LINEA + TEXTO_TITULO_MENU + TEXTO_LINEA + TEXTO_SEPARADOR + TEXTO_LINEA + TEXTO_MENU);
            opcion = console.readLine(TEXTO_LINEA + "Opción: ");
            switch (opcion.charAt(0)) {
                case '1':
                    listaOfertasDisponibles();
                    console.printf("Listo ...");
                    break;
                case '2':
                    // TODO implementar solución
                    break;
                case '3':
                    // TODO implementar solución
                    break;
                case '4':
                    // TODO implementar solución
                    break;
                case '0':
                    console.printf(TEXTO_LINEA + "Salir." + TEXTO_LINEA);
                    break;
                default:
                    console.printf("Opción Invalida." + TEXTO_LINEA + TEXTO_LINEA + TEXTO_LINEA);
            }
        } while (!opcion.equals("0"));
        console.printf("Ha decidido salir de la aplicación, se cerrará la conexión.");
        console.flush();
        cerrarConexion();
    }

    private void listaOfertasDisponibles() throws PixUpBOException {
        List<OfertaWrapper> ofertas = manejador.ofertasDisponibles();      
        console.printf("%n%s",CABECERA_OFERTA);
        console.printf("%n%s",TEXTO_SEPARADOR);
        for (OfertaWrapper oferta : ofertas) {
            //System.out.printf("| %d |%s |%s%n", oferta.getIdentificador(),  padRight(oferta.getTituloDisco(),80), format.format(oferta.getPrecio()));
            console.printf("%n| %s | %s | %s|", padRight(String.valueOf(oferta.getIdentificador()),2), 
                    padRight(oferta.getTituloDisco(),61), padRight(FORMAT_NUMBER.format(oferta.getPrecio()),9));
        }
        console.printf("%n%s",TEXTO_SEPARADOR);
    }

    private Context getContext() throws NamingException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jnp.interfaces.NamingContextFactory");
        properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
        properties.put(InitialContext.URL_PKG_PREFIXES,
                "org.jboss.naming:org.jnp.interfaces");
        Context ctx = new InitialContext(properties);
        return ctx;
    }

    public void cerrarConexion() {
        manejador = null;
        System.out.println("El objeto remoto ha sído destruido.");
    }

    private static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);  
    }
    
    private static final DecimalFormat FORMAT_NUMBER = new DecimalFormat("#,###,##0.0#");
    private static final String TEXTO_LINEA = System.getProperty("line.separator");
    private static final String CABECERA_OFERTA = "| Id | Título del disco                                              | Precio   |";
    private static final String TEXTO_SEPARADOR = "+-------------------------------------------------------------------------------+";
    private static final String TEXTO_TITULO = "\n|Manejador de ofertas V1.0                                                      |";
    private static final String TEXTO_TITULO_APLICACION = "\n|\"Diplomado construcción de aplicaciones empresariales con JEE6\"                |\n";
    //private static final String usuario = "Por favor, ingrese su nombre de usuario:";
    //private static final String pass = "Contraseña:";
    private static final String TEXTO_TITULO_MENU = "|   Seleccione una opción de la lista, use 0 (cero) si desea salir              |";

    private static final String TEXTO_MENU
            = "1. Listar Ofertas disponibles" + TEXTO_LINEA
            + "2. Agregar oferta" + TEXTO_LINEA
            + "3. Actualizar oferta" + TEXTO_LINEA
            + "4. Eliminar oferta" + TEXTO_LINEA;

}
