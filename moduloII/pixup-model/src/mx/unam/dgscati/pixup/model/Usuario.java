package mx.unam.dgscati.pixup.model;

import java.util.Date;

public class Usuario {

	private int identificador;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String correoElectronico;
	private Catalogo tipo;
	private Date fechaNacimiento;
	private Catalogo preguntaSecreta;
	private String respuestaSecreta;
	private String contrasenia;

	public Usuario() {
		this.identificador = -1;
	}

	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador
	 *            the identificador to set
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the primerApellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * @param primerApellido
	 *            the primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * @return the segundoApellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * @param segundoApellido
	 *            the segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @param correoElectronico
	 *            the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * @return the tipo
	 */
	public Catalogo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(Catalogo tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the preguntaSecreta
	 */
	public Catalogo getPreguntaSecreta() {
		return preguntaSecreta;
	}

	/**
	 * @param preguntaSecreta
	 *            the preguntaSecreta to set
	 */
	public void setPreguntaSecreta(Catalogo preguntaSecreta) {
		this.preguntaSecreta = preguntaSecreta;
	}

	/**
	 * @return the respuestaSecreta
	 */
	public String getRespuestaSecreta() {
		return respuestaSecreta;
	}

	/**
	 * @param respuestaSecreta
	 *            the respuestaSecreta to set
	 */
	public void setRespuestaSecreta(String respuestaSecreta) {
		this.respuestaSecreta = respuestaSecreta;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia
	 *            the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void imprimeNombreCompleto() {
		System.out.println(this.nombre.concat(this.primerApellido).concat(this.segundoApellido));
	}

}
