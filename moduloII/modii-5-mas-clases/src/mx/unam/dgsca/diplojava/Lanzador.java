package mx.unam.dgsca.diplojava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lanzador {

	public static void main(String[] args) {
		Lanzador lanzador = new Lanzador();
		lanzador.generarIteracion(Short.MAX_VALUE);
		
//		String argumento = args[0];
//		try {
//			Long numeroIteraciones = Long.getLong(argumento);
//			lanzador.generarIteracion(numeroIteraciones);
//		} catch(NumberFormatException e){
//			e.printStackTrace();
//		}
	}

	private void generarIteracion(long iteraciones){		
		Iterador iterador = new Iterador(iteraciones);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
		System.out.printf("Inicio de la iteracion: %s%n", dateFormat.format(new Date()));
		iterador.iterar();
		System.out.printf("Fin de la iteracion: %s%n", dateFormat.format(new Date()));
	}
	
	private class Iterador {
		private Long iteraciones;
		
		public Iterador(long iteraciones){
			this.setIteraciones(iteraciones);
		}
		
		public void iterar(){
			for(int iteracion = 0; iteracion < getIteraciones(); iteracion++){
				System.out.printf("\t--> Estamos en la iteración %d%n", iteracion);
			}
		}

		public long getIteraciones() {
			return iteraciones;
		}

		public void setIteraciones(long iteraciones) {
			this.iteraciones = iteraciones;
		}
		
	}
	
}
