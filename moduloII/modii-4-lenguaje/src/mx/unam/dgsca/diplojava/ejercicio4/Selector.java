package mx.unam.dgsca.diplojava.ejercicio4;

public class Selector {

	
	private int x, y, z;
	
	// Manejo de instrucciones IF y SWITCH
	
	public void inicializarVariables(boolean inicializa){
		if(inicializa){
			x = 1;
			y = 3*x;
			//TODO cómo se resuelve este problema?
			Double temp = Math.pow(x, 2) + y;

			z = temp.intValue(); 
			System.out.println("Valor de z"+z);
		}else{
			// No hacer nada
		}		
	}
	
	private void manejarPresicion(short x, int y, long z){
		if(x<Short.MAX_VALUE){
			System.out.println("El valor del short es: "+ x);
		} else if(y<Integer.MAX_VALUE){
			System.out.println("El valor del entero es menor a: "+ Integer.MAX_VALUE);
		} else {
			System.out.println("El valor esta desbordado al entero es menor a: "+ Long.MAX_VALUE);
		}
	}
	
	private void conmutar(char opcion){
		System.out.println("Bienvenido a la aplicación, ahora deberás de seleccionar una opción");
		System.out.println("\tLa opción de \"a\" es para registrar");
		System.out.println("\tLa opción de \"m\" es para modificar");
		System.out.println("\tLa opción de \"e\" es para eliminar");
		System.out.println("Selecciona una opción");
		switch (opcion) {
			case 'a':
				System.out.println("Registrar: ");
				break;
			case 'm':
				System.out.println("Modificar: ");
				break;
			case 'e':
				System.out.println("Eliminar: ");
				break;
			default:
				System.out.println("no se localizo la opción...");
		}
		
	}
	
}
