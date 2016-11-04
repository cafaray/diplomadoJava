package mx.unam.dgscati.pixup.bo.impl;

import java.util.ArrayList;
import java.util.List;

import mx.unam.dgscati.pixup.bo.CatalogoBO;
import mx.unam.dgscati.pixup.exception.PixUpBOException;
import mx.unam.dgscati.pixup.model.Catalogo;
import mx.unam.dgscati.pixup.model.PreguntaSecreta;
import mx.unam.dgscati.pixup.model.TipoUsuario;

public class CatalogoBOImpl implements CatalogoBO {
	private static final PreguntaSecreta PREGUNTA_SECRETA = new PreguntaSecreta();
	private static final TipoUsuario TIPO_USUARIO = new TipoUsuario();

	@Override
	public List<String> listarPreguntaSecreta() throws PixUpBOException {
		return armaListado(PREGUNTA_SECRETA.listar());
	}

	@Override
	public List<String> listarTipoUsuario() throws PixUpBOException {
		return armaListado(TIPO_USUARIO.listar());
	}

	@Override
	public String encontrarPreguntaSecretaPorId(int id) throws PixUpBOException {
		try {
			Catalogo elemento = PREGUNTA_SECRETA.buscarPorId(id);
			return elemento.getDescripcion();
		} catch (IndexOutOfBoundsException e) {
			// TODO manejo de la excepción en caso de que no se localice el
			// valor
			throw new PixUpBOException(e);
		}
	}

	@Override
	public String encontrarTipousuarioPorId(int id) throws PixUpBOException {
		try {
			Catalogo elemento = TIPO_USUARIO.buscarPorId(id);
			return elemento.getDescripcion();
		} catch (IndexOutOfBoundsException e) {
			// TODO manejo de la excepción en caso de que no se localice el
			// valor
			throw new PixUpBOException(e);
		}
	}

	private List<String> armaListado(List<Catalogo> lista) {
		List<String> listado = new ArrayList<>();
		for (Catalogo catalogo : lista) {
			StringBuilder registro = new StringBuilder();
			registro.append(String.valueOf(catalogo.getIdentificador())).append(" - ");
			registro.append(catalogo.getDescripcion());
			listado.add(registro.toString());
		}
		return listado;
	}

}
