package mx.com.pixup.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "PixUpMensajero")
        }, mappedName="queue/PixUpMensajero"
)
        
public class Notificador implements MessageListener {    
    
    @Resource
    private MessageDrivenContext mdc;
    
    @Override
    public void onMessage(Message inMessage) {
        TextMessage msg = null;

    try {
        if (inMessage instanceof TextMessage) {
            msg = (TextMessage) inMessage;
            System.out.println("MESSAGE BEAN: Message received: " +
                msg.getText());
        } else {
            System.out.println("Message of wrong type: " +
                inMessage.getClass().getName());
        }
    } catch (JMSException e) {
        e.printStackTrace(System.out);
        mdc.setRollbackOnly();
    } catch (Throwable te) {
        te.printStackTrace(System.out);
    }
    }
    
}
