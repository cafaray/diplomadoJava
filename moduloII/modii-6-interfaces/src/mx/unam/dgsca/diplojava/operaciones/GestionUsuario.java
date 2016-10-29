package mx.unam.dgsca.diplojava.operaciones;

import java.util.List;

import mx.unam.dgsca.diplojava.modelo.Usuario;

public interface GestionUsuario {

	Usuario registrar(Usuario usuario);
	Usuario modificar(Usuario usuario);
	void desactivar(int identificador);
	Usuario buscar(int identificador);
	void desactivar(Usuario usuario);
	List<Usuario> listar();
	
}
