package tp2.ejercicio5;
import tp2.ejercicio1y2.BinaryTree;


public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> ab;
	
	public ProfundidadDeArbolBinario (BinaryTree<Integer> arbolLleno) {
		this.ab = arbolLleno;
	}
	
	public int sumaElementosProfundidad (int p) {
		if (this.ab.isEmpty()){ // arbol vacio
			return 0;
		}else {
			return sumaElementos(p,0,this.ab); // llamo al metodo privado 
		}
	}
	
	
	private int sumaElementos (int p, int nivelAct, BinaryTree<Integer> ab) {
		
		int sumaIzquierda =0;
		int sumaDerecha = 0;
		
	   if(nivelAct==p) {
		   return ab.getData(); // suma si el lvl actual es igual a la profundidad objetivo
	   }
	   
	   if (ab.hasLeftChild()) {
	      sumaIzquierda = sumaElementos(p,nivelAct + 1,ab.getLeftChild()); // recorro parte izquierda 
	   }  
	   
	   if (ab.hasRightChild()) {
	      sumaDerecha = sumaElementos(p,nivelAct + 1,ab.getRightChild()); // recorro parte derecha
	   }
	   
	   return sumaDerecha + sumaIzquierda; // retorno la suma entre el nivel objetivo izquierdo y derecho
	   
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
		
		
		ProfundidadDeArbolBinario pdab = new ProfundidadDeArbolBinario(abLleno);
		
		System.out.println(pdab.sumaElementosProfundidad(2));
	}
	

}
