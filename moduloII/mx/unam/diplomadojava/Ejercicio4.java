package mx.unam.diplomadojava;

import mx.unam.diplomadojava.modelo.Artista;

public class Ejercicio4 {
  public static void main(String[] args){
    Artista artista = new Artista();
    artista.setNombre("Jimmy");
    artista.setPrimerApellido("Neutron");
    artista.setSegundoApellido("");
    artista.imprimeNombreArtista();
  }
}