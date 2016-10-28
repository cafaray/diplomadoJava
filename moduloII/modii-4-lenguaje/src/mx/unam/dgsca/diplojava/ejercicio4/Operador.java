package mx.unam.dgsca.diplojava.ejercicio4;

public class Operador {

	public int sumar(int valor1, int valor2) {
		return valor1 + valor2;
	}
	
	public void aplicarPrecedencia(){
		 int c = 25 - 5 * 4 / 2 - 10 + 4;
		 System.out.println("El valor de c : " + c);
	}
	
	public short obtenerRestante(int valor1, float valor2){
		//TODO qué sugieres para resolver el error?
		return (valor2 % valor1);
	}
	
	private void incrementar(){
		int valorIncremento = 0;
		
		System.out.println("valorIncremento++ " + valorIncremento++);
		System.out.println("++valorIncremento " + ++valorIncremento);
	}
	
	
	private void decrementar(){
		int valorDecremento = 1001;
		
		System.out.println("valorDecremento++ " + valorDecremento--);
		System.out.println("++valorDecremento " + --valorDecremento);
	}
}
