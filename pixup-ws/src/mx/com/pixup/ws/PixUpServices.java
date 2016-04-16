package mx.com.pixup.ws;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;
import mx.com.pixup.bo.DiscoBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.bo.impl.DiscoBOImpl;
import mx.com.pixup.model.jpa.Disco;

@WebService
public class PixUpServices {
    
    public PixUpServices(){}
    
    @WebMethod
    public String echo(String mensaje) {
        System.out.println("webService echo dice: ".concat(mensaje));
        return "webService echo dice: ".concat(mensaje);
    }
    
    @WebMethod(operationName = "listadoDiscos")
    public List<Disco> listadoDiscos() throws WebServiceException {        
        DiscoBO bo = new DiscoBOImpl();
        List<Disco> discos;        
        try {
            discos = bo.listar();
            return discos;
        } catch (PixUpBOException ex) {
            try {
                SOAPFactory factory = SOAPFactory.newInstance();
                SOAPFault fault = factory.createFault();
                fault.setFaultActor("PixUpServices");
                fault.setFaultCode(factory.createName("local name", "prefix", "uri"));
                fault.setFaultString(ex.getMessage());
                throw new SOAPFaultException(fault);
            } catch(SOAPException e){
                ex.printStackTrace(System.out);
                throw new WebServiceException(e.getMessage());
            }            
        }        
    }
    
}
