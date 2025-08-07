package tp1.ejercicio5;
import java.util.Scanner;
import java.util.Random;

public class ArregloValores {
	private int[] array;
	private int tam;
	
	public ArregloValores(int n) {
		this.array = new int[n];
		this.setTam(n);
		Random rand = new Random();
		for (int i=0; i < this.getTam(); i++) {
			array[i] = rand.nextInt(100);
		}
	}

	
	public int getTam() {
		return tam;
	}


	public void setTam(int tam) {
		this.tam = tam;
	}


	public int[] getArray() {
		return array;
	}


	public void setArray(int [] array) {
		this.array = array;
	}


	public Pedido getTodoA (int[] a, int n) {
		if (n == 0) {
            return new Pedido(0, 0, 0); // Evita división por cero
        }
		Pedido ped = new Pedido(0,99999,0);
		for (int i=0; i<n; i++) {
			
			ped.setProm(ped.getProm()+a[i]); //sumo todos los valores del arreglo
			
			if (ped.getMax() < a[i]) {
				ped.setMax(a[i]); // si el dato actual es mayor al max actual actualizo.			
			}
			
			if(ped.getMin() > a[i]) {
				ped.setMin(a[i]); // si el dato es menor al min actual actualizo.
			}
		}
		if (n>0) {
		  ped.setProm(ped.getProm()/ n);
		} 
		return ped;
	}
	
	public Pedido getTodoB(int n, Pedido p) {
		int[] a;
	    a = ArregloValores.this.getArray();
	    p.setMax(0); p.setMin(99999); p.setProm(0);
	    if (n == 0) {
            return new Pedido(0, 0, 0); // Evita división por cero
        }
	    for (int i=0; i<n; i++) {
	    	
	    	p.setProm(p.getProm() + a[i]);
	    	
	    	if (p.getMax() < a[i]) {
	    		p.setMax(a[i]);
	    	}
	    	
	    	if (p.getMin() > a[i]) {
	    		p.setMin(a[i]);
	    	}
	    	
	    }
	    p.setProm(p.getProm()/n);  
	    return p;
	}
	
	public void getTodoC() {
		int[] a; int n; int min; int max; int prom;
		max=0; min=99999; prom=0;
		n = ArregloValores.this.getTam();
		a = ArregloValores.this.getArray();
		if (n == 0) {
            
        }else
		for (int i=0; i<n; i++) {
			
			if (max < a[i]) {
				max = a[i];
			}
			
			if (min > a[i]) {
				min = a[i];
			}
			
			prom = prom + a[i];
			
		}
		prom = prom / n;
		System.out.println(" El maximo es: " + max);
		System.out.println(" El minimo es: " + min);
		System.out.println(" El promedio es: " + prom);
	}
	
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in) ; 
		int n= s.nextInt();
		ArregloValores a = new ArregloValores(n);
		Pedido pedidoA;
		Pedido pedidoB = new Pedido(0,99999,0);
		
		System.out.println(" Punto a: "); 
		pedidoA = a.getTodoA(a.getArray(), n);
		System.out.println(" El Maximo es: " + pedidoA.getMax() + "\n" +  " El Minimo es: " + pedidoA.getMin() + "\n" + " El Promedio es:" + pedidoA.getProm() + ".");
		
		System.out.println(" Punto b: "); 
		pedidoB = a.getTodoB(n, pedidoB);
		System.out.println(" El Maximo es: " + pedidoB.getMax() + "\n" + " El Minimo es: " + pedidoB.getMin() + "\n"+" El Promedio es: " + pedidoB.getProm() + ".");
		
		System.out.println(" Punto c: "); 
		a.getTodoC();
		
		s.close();
	}
	

}
