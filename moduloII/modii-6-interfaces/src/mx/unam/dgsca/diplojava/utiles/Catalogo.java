package mx.unam.dgsca.diplojava.utiles;

import java.util.LinkedList;
import java.util.List;

/***
 * 
 * @author Carlos Farias 
 * @category Cargador de catalogos generales
 *
 */


public class Catalogo {

	private int identificador;
	private String descripcion;
	
	//public Catalogo(){}

	
	/***
	 * Constructor especializado de la clase para dar oportunidad de aplicar una mala práctica en programación OO
	 * @param identificador valor entero que representa la identificación de la tupla dentro de la proyección del almacenaje
	 * @param descripcion valor descriptivo del identificador
	 * 
	 */
	public Catalogo(int identificador, String descripcion) {
		this.identificador = identificador;
		setDescripcion(descripcion);
	}

	/***
	 * 
	 * @return
	 * @throws Exception
	 * 
	 */
	
	public int getIdentificador() throws Exception {
		//TODO Justificar el uso de exception
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public List<Catalogo> listar(){
		List<Catalogo> catalogos = new LinkedList<>();
		catalogos.add(new Catalogo(identificador, descripcion));		
		// --> cofa 211016 Se marca por negocio que solo se debe de regresar un único valor.
		return catalogos;
		// <-- cofa 211016 
	}
	
}










