package mx.unam.dgsca.diplojava.ejercicio4;

public class Iterador {

	
	private void iterarFor(int inicio, int detiene){
		for(int x = inicio;x<detiene;x++){
			System.out.printf("Estamos en la iteración %d%n",x);
		}
	}
	
	private void iterarDo(int inicio, int detiene){
		int x = inicio;
		do{
			System.out.printf("Estamos en la iteración %d%n",x++);
		}while (x <= detiene);
			
	}	
	
	
	private void iterarWhile(int inicio, int detiene){
		int x = inicio;
		while (x <= detiene){
			System.out.printf("Estamos en la iteración %d%n",x++);
		}
	}
			
	private void iterarForEach(int... valores){
		for(int valor:valores){
			System.out.printf("Este es el valor %d%n",valor);
		}
	}
}
