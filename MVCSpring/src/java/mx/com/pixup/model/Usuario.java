package mx.com.pixup.model;

public class Usuario {

    private String cuenta;
    private String contrasenia;

    public Usuario() {
    }

    public Usuario(String cuenta, String contrasenia) {
        this.cuenta = cuenta;
        this.contrasenia = contrasenia;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
        
}
