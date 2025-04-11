package tp2.ejercicio4;
import tp2.ejercicio1y2.*;

public class RedBinariaLlena {
	private BinaryTree<Integer> ab;
	
	public RedBinariaLlena(BinaryTree<Integer> abLleno) {
		this.ab = abLleno;
	}
	
	public int retardoReenvio() {
		if(!this.ab.isEmpty()) {
			return this.calcularRetardoMaximo(ab);
		}else {
			return -1;
		}
		
	}
	
	
	private int calcularRetardoMaximo(BinaryTree<Integer> ab){
		int retardoRaiz =0;  int retardoIzquierdo = 0; int retardoDerecho = 0; int max=-1;
	    retardoRaiz = ab.getData(); // guarda retardo de la raiz
	    if (ab.hasLeftChild()) {
		    retardoIzquierdo = this.calcularRetardoMaximo(ab.getLeftChild()); // contiene el retardo mas grande de los hijos izquierdos
		}
	    if(ab.hasRightChild()) {
	    	retardoDerecho = this.calcularRetardoMaximo(ab.getRightChild()); //  contiene el retardo mas grande de los hijos derechos
	    }
		
	    max = (Math.max(retardoDerecho, retardoIzquierdo)+retardoRaiz); // saca el maximo entre izquierdo y derecho y suma el retardo de la raiz.
	    
		return max;
	}
	
	
	public static void main (String[] args) {
		BinaryTree<Integer> abLleno = new BinaryTree<Integer>(10);
		
		abLleno.addLeftChild(new BinaryTree<Integer>(2));
		abLleno.addRightChild(new BinaryTree<Integer>(3));
		
		abLleno.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));	
		abLleno.getLeftChild().addRightChild(new BinaryTree<Integer>(4));	
		
		abLleno.getRightChild().addLeftChild(new BinaryTree<Integer>(9));	
		abLleno.getRightChild().addRightChild(new BinaryTree<Integer>(8));	
		
		abLleno.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
		abLleno.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
		
		abLleno.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
		abLleno.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));
		
		abLleno.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(12));
		abLleno.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
		
		abLleno.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(2));
		abLleno.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(1));
		// completo el arbol tal como el de la practica. 
		
		
		RedBinariaLlena red = new RedBinariaLlena(abLleno);
		
		System.out.println(" El Retardo mas grande que se puede dar es: " + red.calcularRetardoMaximo(abLleno) + " en segundos.");
	}

}
