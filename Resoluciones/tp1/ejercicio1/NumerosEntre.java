package tp1.ejercicio1;


public class NumerosEntre {
	
	public static void imprimirFor (int a, int b) {
		for (int i=a ; i < b; i++) {
			System.out.println(i);
		}	
	}
	
	
	public static void imprimirWhile (int a, int b) {
		int i=a;
		while (i<b) {
           System.out.println(i);
           i++;
		}
		
	}
	
	public static void imprimirRecursion (int a, int b) {
		if (a > b) {
			return; // Caso base: si a es mayor que b, terminamos la recursión
		}
		System.out.println(a);
		imprimirRecursion(a + 1,b);
	}
	
	public static void main (String[] args) {
	   System.out.println("Imprimir con For:");
	   imprimirFor(2, 9);
	   System.out.println("Imprimir con While:");
	   imprimirWhile(2, 9);
	   System.out.println("Imprimir con Recursion:");
	   imprimirRecursion(2, 9);
	}

}