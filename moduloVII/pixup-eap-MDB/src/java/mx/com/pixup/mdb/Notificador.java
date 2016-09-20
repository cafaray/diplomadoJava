package mx.com.pixup.mdb;

import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import mx.com.pixup.bo.DiscoBO;
import mx.com.pixup.bo.OfertaBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.bo.impl.DiscoBOImpl;
import mx.com.pixup.bo.impl.OfertaBOImpl;
import mx.com.pixup.model.jpa.Disco;
import mx.com.pixup.model.jpa.Oferta;

@MessageDriven(activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "PixUpMensajero")
        }, mappedName="queue/PixUpMensajero"
)
        
public class Notificador implements MessageListener {    
    
    @Resource
    private MessageDrivenContext mdc;
    
    @Resource(mappedName = "java:Mail")
    Session mailSession;
    
    @Override
    public void onMessage(Message inMessage) {
        TextMessage mensaje = null;
        try {
            if (inMessage instanceof TextMessage) {
                mensaje = (TextMessage) inMessage;
                String correo = inMessage.getStringProperty("correo");
                System.out.printf("MESSAGE BEAN: Mensaje recibido: %s, enviar correo a: %s%n", mensaje.getText(), correo);
                
                                
//                OfertaBO bo = new OfertaBOImpl();
//                List<Oferta> ofertas =  bo.ofertasDisponibles();
//                StringBuilder strOfertas = new StringBuilder(mensaje.getText());
//                if(ofertas.size()>0){                
//                    strOfertas.append("<br />").append("<h1>Ofertas disponibles</h1>").append("<br />");
//                    DiscoBO boDisco = new DiscoBOImpl();
//                    DecimalFormat formatNumber = new DecimalFormat("##,###,##0.##");
//                    for(Oferta oferta:ofertas){
//                        Disco disco = boDisco.encuentraPorId(oferta.getIddisco());
//                        strOfertas.append("<label>").append(disco.getTitulo());
//                        strOfertas.append("&nbsp;&nbsp;&nbsp;&nbsp;").append(formatNumber.format(disco.getPrecio()));
//                        strOfertas.append("</label><br />");
//                    }
//                } else {
//                    strOfertas.append("<br />").append("<h1>No hay ofertas disponibles</h1>");
//                }
                
//                sendMail(correo, strOfertas.toString());
                sendMail(correo, mensaje.getText());
                
            } else {
                System.out.printf("MESSAGE BEAN: Mensaje de tipo erroneo, imposible descifrarlo: %s%n", inMessage.getClass().getName());
            }
        } catch (MessagingException e){
            e.printStackTrace(System.out);
            mdc.setRollbackOnly();
            System.out.println("MESSAGE BEAN: El mensaje fue recibido, pero el correo no se ha logrado enviar.");
        } catch (JMSException e) {
            e.printStackTrace(System.out);
            mdc.setRollbackOnly();
//        } catch (PixUpBOException ex) {
//            ex.printStackTrace(System.out);
//            mdc.setRollbackOnly();
//        } catch (NumberFormatException ex){
//            ex.printStackTrace(System.out);
//            mdc.setRollbackOnly();
        }
    }
    
    private void sendMail(String email, String mensaje) throws MessagingException {
    
        //se envia un correo electrónico:
        MimeMessage mailMessage = new MimeMessage(mailSession);
        mailMessage.setSubject("Notificación de Pixup");
        //String user = mailSession.getProperty("mail.user");
        String user = "cafaray@gmail.com";
        
        mailMessage.setRecipients(javax.mail.Message.RecipientType.TO,
                        javax.mail.internet.InternetAddress.parse(email, false));
        mailMessage.setFrom(new InternetAddress(user));
        mailMessage.setContent(mensaje, "text/html; charset=utf-8");
        mailMessage.saveChanges();
        Transport transport = mailSession.getTransport("smtp");
        try {
                transport.connect();
                transport.sendMessage(mailMessage,mailMessage.getAllRecipients());
        } finally {
                transport.close();
        }

    }
    
}
