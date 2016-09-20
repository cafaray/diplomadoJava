package mx.com.pixup;

import javax.xml.ws.Endpoint;
import mx.com.pixup.ws.PixUpServices;

public class StartUp {

    
    
    
    public static void main(String args[]){
        String urlPartial = "http://localhost:7070/pixup/";
        
        PixUpServices services = new PixUpServices();
        System.out.print("Registrando el servicio de: " + urlPartial.concat("pixup-servicios"));
        Endpoint.publish(urlPartial.concat("pixup-servicios"), services);
        System.out.println("\t\t\t[OK]");
    
    }
}
