package mx.unam.dgsca.diplojava.ejercicio4;

public class Operador {

	public static void main(String[] args){
		Operador operador = new Operador();
//		int resultado = operador.sumar(5, 10);
//		System.out.println("El resultado de la suma es: " + resultado);
//		operador.incrementar();
//		operador.decrementar();

		operador.aplicarPrecedencia();
		//System.out.println("El resultado de 2%6 = " + operador.obtenerRestante(Integer.MAX_VALUE, Float.MAX_VALUE));
	}
	
	
	public int sumar(int valor1, int valor2) {
		return valor1 + valor2;
	}
	
	public void aplicarPrecedencia(){
		
		int x = 0;

        int y = 4;

        float z = -1f;
        x = 6 * y;

        z = 5 * 4 + x / 3 * y + 9 - 2 / 1 + 10;

        System.out.println("El valor de z es: " + z);
		
		
//		 int c = 25 - 5 * 4 / 2 - 10 + 4;
//		 System.out.println("El valor de c : " + c);
	}
	
	public short obtenerRestante(int valor1, float valor2){
		//TODO qué sugieres para resolver el error?
		return (short)(valor2 % valor1);
	}
	
	private void incrementar(){
		int valorIncremento = 0;
		
		System.out.println("valorIncremento++ " + valorIncremento++);
		System.out.println("++valorIncremento " + ++valorIncremento);
	}
	
	
	private void decrementar(){
		int valorDecremento = 1001;
		
		System.out.println("valorDecremento-- " + valorDecremento--);
		System.out.println("--valorDecremento " + --valorDecremento);
	}
}
