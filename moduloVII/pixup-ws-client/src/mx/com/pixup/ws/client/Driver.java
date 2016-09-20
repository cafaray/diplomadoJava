package mx.com.pixup.ws.client;

import java.text.DecimalFormat;
import java.util.List;
import mx.com.pixup.ws.Disco;

public class Driver {

    private final static DecimalFormat formatNumber = new DecimalFormat("##,###,##0.0#");
    
    public static void main(String[] args) {
        Driver driver = new Driver();
        String texto = driver.echo("Hello World!!!");
        System.out.println("TEXTO desde el WebService: ".concat(texto));
        
        List<Disco> discos = driver.listado();
        for(Disco disco:discos){            
            System.out.printf("Disco: %s, Precio: %s %n", disco.getTitulo(), formatNumber.format(disco.getPrecio()));
        }
        
    }

    private String echo(java.lang.String arg0) {
        mx.com.pixup.ws.PixUpServicesService service = new mx.com.pixup.ws.PixUpServicesService();
        mx.com.pixup.ws.PixUpServices port = service.getPixUpServicesPort();
        return port.echo(arg0);
    }

    private java.util.List<mx.com.pixup.ws.Disco> listado() {
        mx.com.pixup.ws.PixUpServicesService service = new mx.com.pixup.ws.PixUpServicesService();
        mx.com.pixup.ws.PixUpServices port = service.getPixUpServicesPort();
        return port.listado();
    }

    
}
