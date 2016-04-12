package mx.com.pixup.app.ofertas;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.jms.Queue;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.pixup.bo.DiscoBO;
import mx.com.pixup.bo.OfertaBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.bo.impl.DiscoBOImpl;
import mx.com.pixup.bo.impl.OfertaBOImpl;
import mx.com.pixup.model.Disco;
import mx.com.pixup.model.Oferta;
import mx.com.pixup.model.wrapper.OfertaWrapper;

public class Driver {

    private final static OfertaBO ofertaBo = new OfertaBOImpl();
    private final static DiscoBO discoBo = new DiscoBOImpl();

    public static void main(String[] args) {
//        try{
//            Driver driver = new Driver();
//            //driver.listaDiscos();
//            //driver.registraOferta();            
//            //driver.eliminaOferta(2);
//            //driver.listaOfertas();
//        }catch(PixUpBOException e){
//            e.printStackTrace(System.out);
//        }
//        App app = new App();
//        app.abreConexion();        
//        System.exit(0);
        Driver driver = new Driver();
        driver.lanzarMensaje();
    }

    public void listaOfertas() throws PixUpBOException {
        List<OfertaWrapper> ofertas = ofertaBo.listarVigentes();
        DecimalFormat format = new DecimalFormat("#,###,##0.##");
        for (OfertaWrapper oferta : ofertas) {
            System.out.printf("%d. %s, %s%n", oferta.getIdentificador(), oferta.getTituloDisco(), format.format(oferta.getPrecio()));
        }
    }

    public void listaDiscos() throws PixUpBOException {
        List<Disco> discos = discoBo.listar();
        DecimalFormat format = new DecimalFormat("#,###,##0.##");
        for (Disco disco : discos) {
            System.out.printf("%d. %s, %s%n", disco.getId(), disco.getTitulo(), format.format(disco.getPrecio()));
        }
    }

    public void registraOferta() throws PixUpBOException {

        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.YEAR, 2016);
        calendario.set(Calendar.MONTH, 0);
        calendario.set(Calendar.DATE, 9);
        Date inicio = calendario.getTime();

        // marca la fecha de fin de la oferta de cada disco
        calendario.set(Calendar.MONTH, 11);
        calendario.set(Calendar.DATE, 31);
        Date fin = calendario.getTime();
        Oferta oferta = new Oferta();
        oferta.setDisco(2);
        oferta.setFechaInicio(inicio);
        oferta.setFechaFinal(fin);
        oferta.setPrecio(99d);
        oferta.setTextoOferta("Discos por 99");
        oferta.setUsuario(1);
        ofertaBo.agregar(oferta);
    }

    public void eliminaOferta(int identificador) throws PixUpBOException {
        ofertaBo.eliminar(identificador);
        listaOfertas();
    }

    public void lanzarMensaje() {
        QueueConnection conexion = null;
        QueueSender sender;
        QueueSession session;
        try {
            Context ctx = getContext();
            Queue queue = (Queue) ctx.lookup("queue/PixUpMensajero");
            QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("ConnectionFactory");
            conexion = factory.createQueueConnection();
            session = conexion.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
//			Usuario usuario = new Usuario();
//			usuario.setNombre("Juan");
//			usuario.setApPaterno("López");
//			usuario.setApMaterno("Santana");
//			usuario.setEmail("cafaray@gmail.com");
//			usuario.setNick("nick");
//			usuario.setPassword("sinPassword");
//			ObjectMessage message = session.createObjectMessage(new Oferta());
            TextMessage message = (TextMessage) session.createTextMessage();
            message.setText("HEY!!!");
            message.setStringProperty("x", "x");

            sender = session.createSender(queue);
            sender.send(message);

        } catch (NamingException e) {
            e.printStackTrace(System.out);
        } catch (JMSException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (JMSException e) {
            }
        }
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

}
