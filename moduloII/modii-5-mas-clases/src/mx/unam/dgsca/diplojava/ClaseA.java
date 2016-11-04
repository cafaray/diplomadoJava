package mx.unam.dgsca.diplojava;

public class ClaseA {

	public int enA;
	
	public ClaseA() {}
	
	public ClaseB getInstanceClaseB(){
		return new ClaseB();
	}
	
	public class ClaseB {
		public int enB = 1;
	}

}
