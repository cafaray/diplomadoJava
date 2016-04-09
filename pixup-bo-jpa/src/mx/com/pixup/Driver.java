package mx.com.pixup;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.pixup.bo.DiscoBO;
import mx.com.pixup.bo.exception.PixUpBOException;
import mx.com.pixup.bo.impl.DiscoBOImpl;
import mx.com.pixup.model.jpa.Disco;

public class Driver {

    public static void main(String[] args){
        DiscoBO bo = new DiscoBOImpl();
        Disco disco = new Disco();
        disco.setCantidadDisponible(100);
        disco.setFechaLanzamiento(new Date());
        disco.setId(100);
        disco.setIdDisquera(null);
        disco.setIdGeneroMusical(null);
        disco.setIdIdioma(null);
        disco.setIdIva(null);
        disco.setIdPais(null);
        disco.setIdPromocion(null);
        disco.setPrecio(99.0f);
        disco.setTitulo("Aremonas de luz");
        try {
            bo.agregar(disco);
        } catch (PixUpBOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
