package mx.unam.dgscati.pixup;

import mx.unam.dgscati.pixup.exception.PixUpBOException;
import mx.unam.dgscati.pixup.view.Vista;

public class Lanzador {

	public static void main(String[] args) {
		Vista app = new Vista();
		try {
			app.iniciar();
		} catch (PixUpBOException e) {			
			e.printStackTrace();
		}
	}

}
