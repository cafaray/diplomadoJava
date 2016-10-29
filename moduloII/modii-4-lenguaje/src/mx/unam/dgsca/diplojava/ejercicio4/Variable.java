package mx.unam.dgsca.diplojava.ejercicio4;

public class Variable {

	
	// variables de instancia
	int a;
	int b;
	private int c=0;
	public int d;
	
	private int edad;
	
	
	public static void main(String[] args){
		System.out.println("resultado es: " + casting());
	}
	
	public Variable(int edad){
		this.setEdad(edad);
	}
	
	public Variable() {
		//variables locales:
		int x = 0;
		int y = 1;
		//byte z;
		//z = x + y;
		int z = x + y;
		//z = (byte)(x+y);
	}


	public int getC() {
		return c;
	}


	public void setC(int c) {
		this.c = c;
	}
	
	private void realizarPromote(){
		int valorEntero = 5;
		long valorLargo;
		valorLargo = valorEntero;
		//aplicar cast
		short valorCorto;
		valorLargo = Long.MAX_VALUE;
		//valorCorto = valorLargo;
		//valorCorto = (short)valorLargo;
		
		// --> Cast de valores cortos:
		short s1, s2, s3;
		s1 = 21;
		s2 = 20;
		//s3 = s1 + s2;
		 s3 = (short)(s1+s2);
	}
	
	private static short casting(){

int x = 23;

int  y = 17;

int z = -1;

z = ((x + y) - z) / 3;
return (short)z;
	}
	
	public void calculaEdad(){
		int edadEnDias = getEdad() * 365;
		long edadEnSegundos = edad * 365 * 24L * 60 *60;
		
		System.out.println("Tu edad en días: " + edadEnDias + 5);
		System.out.println("Tu edad en segundo: " + edadEnSegundos);
	}

	int getEdad() {
		return edad;
	}

	private void setEdad(int edad) {
		this.edad = edad;
	}
	

}
