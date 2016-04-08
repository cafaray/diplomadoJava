package mx.com.pixup.app.ofertas;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
        try{
            Driver driver = new Driver();
            //driver.listaDiscos();
            //driver.registraOferta();            
            //driver.eliminaOferta(2);
            driver.listaOfertas();
        }catch(PixUpBOException e){
            e.printStackTrace(System.out);
        }
        App app = new App();
        app.abreConexion();        
        System.exit(0);
    }
    
    public void listaOfertas() throws PixUpBOException{
        List<OfertaWrapper> ofertas = ofertaBo.listarVigentes();
        DecimalFormat format = new DecimalFormat("#,###,##0.##");        
        for(OfertaWrapper oferta:ofertas){
            System.out.printf("%d. %s, %s%n", oferta.getIdentificador(), oferta.getTituloDisco(), format.format(oferta.getPrecio()));
        }        
    }
    
    public void listaDiscos() throws PixUpBOException{
        List<Disco> discos = discoBo.listar();
        DecimalFormat format = new DecimalFormat("#,###,##0.##");        
        for(Disco disco:discos){
            System.out.printf("%d. %s, %s%n",disco.getId(), disco.getTitulo(), format.format(disco.getPrecio()));
        }
    }

    public void registraOferta()throws PixUpBOException {
        
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
    
}
