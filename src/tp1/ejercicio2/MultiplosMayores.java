package tp1.ejercicio2;
import java.util.Scanner;

public class MultiplosMayores {
	
	
    public static void nueArreglo(int n) {
    	int[] arreglo = new int[n];
    	for ( int i=0; i<n; i++) {
    		arreglo[i] = n * (i+1);
    	}
    	for ( int i=0; i<n; i++) {
    		System.out.println(arreglo[i]);
    	}
    }	

    public static void main (String[] args) {
    	Scanner s= new Scanner(System.in);
    	nueArreglo(s.nextInt());
    	s.close();
    	
    }
    
    
}
