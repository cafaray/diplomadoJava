package mx.unam.dgscati.pixup.model;

import java.util.ArrayList;
import java.util.List;

public class PreguntaSecreta extends Catalogo {

	List<Catalogo> lista;
	
	
	
	public PreguntaSecreta() {
		super();
		// TODO falta incluir la consulta a la base de datos para obtener el listado de preguntas
		lista = new ArrayList<>();
		lista.add(new Catalogo(1, "Cuál es el nombre de tu primer mascota"));
		lista.add(new Catalogo(2, "Cuál es el nombre de tu mejor amigo"));
		lista.add(new Catalogo(3, "Cuál es el nombre de la secundaria que asististe"));
		lista.add(new Catalogo(4, "Cuál es tu nombre de pila"));
		lista.add(new Catalogo(5, "Cuál es tu artista favorito"));
	}

	public List<Catalogo> listar(){
		return lista;
	}
	
	public Catalogo buscarPorId(int id){
		// TODO falta realizar la implementación de las excepciones DAO para solucionar cuando no existe el elemento
		return lista.get(id);
	}
	
}
