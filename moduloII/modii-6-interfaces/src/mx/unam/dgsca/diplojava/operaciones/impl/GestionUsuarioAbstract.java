package mx.unam.dgsca.diplojava.operaciones.impl;

import java.util.List;

import mx.unam.dgsca.diplojava.modelo.Usuario;
import mx.unam.dgsca.diplojava.operaciones.GestionUsuario;
import mx.unam.dgsca.diplojava.utiles.Catalogo;

public abstract class GestionUsuarioAbstract implements GestionUsuario {

	
	public abstract void setTipoDefault(Catalogo tipo);
	
	public GestionUsuarioAbstract() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario registrar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desactivar(int identificador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscar(int identificador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desactivar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
