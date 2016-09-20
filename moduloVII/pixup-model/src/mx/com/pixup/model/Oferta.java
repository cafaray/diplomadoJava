package mx.com.pixup.model;

import java.io.Serializable;
import java.util.Date;

public class Oferta implements Serializable{

    private int identificador;
    private int disco;
    private int usuario;
    private Date fechaInicio;
    private Date fechaFinal;
    private double precio;
    private String textoOferta;

    public Oferta() {}

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTextoOferta() {
        return textoOferta;
    }

    public void setTextoOferta(String textoOferta) {
        this.textoOferta = textoOferta;
    }    
    
}
