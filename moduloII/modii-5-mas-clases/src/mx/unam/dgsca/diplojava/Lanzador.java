package mx.unam.dgsca.diplojava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lanzador {

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Lanzador lanzador = new Lanzador();
//		lanzador.generarIteracion(Short.MAX_VALUE);
		String argumento;
		long numeroIteraciones = Long.MAX_VALUE;		
		
		try {
			try {				
				argumento = args[0];
				numeroIteraciones = Long.valueOf(argumento);
			}catch(NumberFormatException e){
				System.out.println("El argumento debe ser numérico-");				
			}finally {
				// NO HACER NADA, DEJAR EL VALOR DEFAULT
			}								
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Podrías mandar al menos un parametro numérico");						
		}
		lanzador.generarIteracion(numeroIteraciones);
	}

	private void generarIteracion(long iteraciones){		
		Iterador iterador = new Iterador(iteraciones);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
		System.out.printf("Inicio de la iteracion: %s%n", dateFormat.format(new Date()));
		iterador.iterar();
		System.out.printf("Fin de la iteracion: %s%n", dateFormat.format(new Date()));
	}
	
	
	
	
	
	
	public class Iterador {
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


