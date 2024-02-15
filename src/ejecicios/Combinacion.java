package ejecicios;

public class Combinacion {

	int[] cadena;
	int colors = 5;
	int size = 5;

	
	public Combinacion() {
		super();
		cadena=new int[size];
	}

	public void generarCombinacion() {
		for (int i = 0; i < cadena.length; i++)
			cadena[i] = (int) (Math.random() * colors) + 1;
	}

	public int getColors() {
		return colors;
	}

	public int getSize() {
		return size;
	}

	public int[] getCadena() {
		return cadena;
	}
}
