package tp2.ejercicio6;
import tp2.ejercicio1y2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> aE;
	
	public Transformacion (BinaryTree<Integer> arbolLleno) {
		this.aE = arbolLleno;
	}
	
	public BinaryTree<Integer> suma (){
		if (this.aE.isEmpty()) {
			return null; // si el arbol esta vacio devuelve null
		} else {
			this.arbolitoSuma(this.aE);
			return this.aE; // sino retorno el arbol
		}
	}
	
	
	private int arbolitoSuma (BinaryTree<Integer> ab){
		
		int sumaDerecha = 0;
		int sumaIzquierda = 0;
		
		if (ab.isLeaf()) {
			int valorOrigi = ab.getData(); // me guardo valor original 
			ab.setData(0); // si es hoja vale 0 
			return valorOrigi;  // retorno valor original al padre
		}	
			if (ab.hasLeftChild()) {
				sumaIzquierda = this.arbolitoSuma(ab.getLeftChild()); // suma hijos izquierdos
			}
			if(ab.hasRightChild()) {
				sumaDerecha = this.arbolitoSuma(ab.getRightChild()); // sumas hijos derechos
			}
			ab.setData(sumaDerecha+sumaIzquierda);	// se remplaza el valor con la suma
				
		
	    return sumaIzquierda + sumaDerecha;	// suma para modificar nodo
	}
	
	public void imprimirArbol(BinaryTree<Integer> arbol) {
	    if (arbol == null || arbol.isEmpty()) return;
	    
	    System.out.print(arbol.getData() + " ");
	    
	    if (arbol.hasLeftChild()) {
	        imprimirArbol(arbol.getLeftChild());
	    }
	    if (arbol.hasRightChild()) {
	        imprimirArbol(arbol.getRightChild());
	    }
	}
	
	
	

	public static void main (String[] args) {
        BinaryTree<Integer> abLleno = new BinaryTree<Integer>(1);
		
		abLleno.addLeftChild(new BinaryTree<Integer>(2));
		abLleno.addRightChild(new BinaryTree<Integer>(3));
		
		abLleno.getLeftChild().addRightChild(new BinaryTree<Integer>(4));	
		
		abLleno.getRightChild().addLeftChild(new BinaryTree<Integer>(5));	
		abLleno.getRightChild().addRightChild(new BinaryTree<Integer>(6));	
		
		
		abLleno.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
		abLleno.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
		
        Transformacion t = new Transformacion(abLleno);
        
        t.imprimirArbol(t.suma());
	}
	
}
