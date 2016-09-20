package mx.com.pixup.model.wrapper;

import java.io.Serializable;
import mx.com.pixup.model.Oferta;

public class OfertaWrapper extends Oferta implements Serializable {
    private String tituloDisco;
    private String cuentaUsuario;

    public OfertaWrapper(Oferta oferta) {
        super.setDisco(oferta.getDisco());
        super.setFechaInicio(oferta.getFechaInicio());
        super.setFechaFinal(oferta.getFechaFinal());
        super.setIdentificador(oferta.getIdentificador());
        super.setPrecio(oferta.getPrecio());
        super.setTextoOferta(oferta.getTextoOferta());
        super.setUsuario(oferta.getUsuario());
    }

    public OfertaWrapper(String tituloDisco, String cuentaUsuario) {
        this.tituloDisco = tituloDisco;
        this.cuentaUsuario = cuentaUsuario;
    }

    public String getTituloDisco() {
        return tituloDisco;
    }

    public void setTituloDisco(String tituloDisco) {
        this.tituloDisco = tituloDisco;
    }

    public String getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(String cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }
    
    
    
}
