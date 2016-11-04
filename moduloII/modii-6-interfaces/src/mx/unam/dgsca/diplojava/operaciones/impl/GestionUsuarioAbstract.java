package mx.unam.dgsca.diplojava.operaciones.impl;

import java.util.LinkedList;
import java.util.List;

import mx.unam.dgsca.diplojava.modelo.Usuario;
import mx.unam.dgsca.diplojava.operaciones.GestionUsuario;

public abstract class GestionUsuarioAbstract implements GestionUsuario {

	
	
	public GestionUsuarioAbstract() {}

	public abstract void restablecerContrasenia(String cuentaCorreo);
	
	@Override
	public Usuario registrar(Usuario usuario) {
		// registra a un nuevo usuario, ya sea administrador, local o web
		return usuario;
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		// realiza la adecuación de un usuario existente, ya sea administrador, local o web
		return null;
	}

	@Override
	public void desactivar(int identificador) {
		// desactiva una cuenta de usuario exsitente por su identificador, ya sea administrador, local o web
		
	}

	@Override
	public Usuario buscar(int identificador) {
		// busca un usuario existente en el repositorio
		return null;
	}

	@Override
	public void desactivar(Usuario usuario) {
		// desactiva una cuenta de usuario exsitente por su identificador, ya sea administrador, local o web
		
	}

	@Override
	public List<Usuario> listar() {
		// lista los usuarios existentes en el repositorio
		List<Usuario> lista = new LinkedList<>();
		return lista;
	}

}
