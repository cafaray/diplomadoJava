package mx.unam.diplomadojava.modelo;

public class Artista {

  private String nombre;
  private String primerApellido;
  private String segundoApellido;
  
  public Artista(){}
  
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public String getPrimerApellido() {
    return primerApellido;
  }

  public void setPrimerApellido(String primerApellido) {
    this.primerApellido = primerApellido;
  }

  public String getSegundoApellido() {
    return segundoApellido;
  }

  public void setSegundoApellido(String segundoApellido) {
    this.segundoApellido = segundoApellido;
  }

  public void imprimeNombreArtista(){
    System.out.println(this.nombre.concat(" ").concat(this.primerApellido).concat(" ").concat(this.segundoApellido));
  }
  
}