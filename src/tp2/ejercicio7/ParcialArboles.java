package tp2.ejercicio7;
import tp2.ejercicio1y2.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> ab;
	
	public ParcialArboles (BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<Integer> getAb() {
		return this.ab;
	}
	
	public boolean isLeftTree(int num) {
		
		BinaryTree<Integer> nodoBuscado = buscarNodo(this.ab,num);
		
		if (nodoBuscado == null || nodoBuscado.isEmpty()) { 
            // Si no se encuentra el nodo o está vacío, devuelve false
            return false;
        }else {
		
		  int contadorIzquierda = contar(nodoBuscado.getLeftChild());
		  
		  int contadorDerecha = contar(nodoBuscado.getRightChild());
		
		  return contadorIzquierda > contadorDerecha; // comparo cant arboles con un solo hijo 
        }
		
	}
	
	private int contar(BinaryTree<Integer> sub) {
	    if (sub == null) return 0; // Si está vacío no cuento y devuelvo 0
	    
	    if (sub.isLeaf()) return 0; // Si es hoja (no tiene hijos), devuelvo 0

	    int nodosUnHijo = 0; // Contador de nodos con un solo hijo

	    // Verificamos si el nodo tiene un solo hijo izquierdo o derecho
	    if (sub.hasLeftChild() && !sub.hasRightChild()) {
	        nodosUnHijo += 1; // Solo tiene un hijo izquierdo
	    } else if (!sub.hasLeftChild() && sub.hasRightChild()) {
	        nodosUnHijo += 1; // Solo tiene un hijo derecho
	    }

	    // Recursión para contar nodos con un solo hijo en el subárbol izquierdo
	    if (sub.hasLeftChild()) {
	        nodosUnHijo += this.contar(sub.getLeftChild());
	    }

	    // Recursión para contar nodos con un solo hijo en el subárbol derecho
	    if (sub.hasRightChild()) {
	        nodosUnHijo += this.contar(sub.getRightChild());
	    }

	    return nodosUnHijo; // Devuelvo el contador de nodos con un solo hijo
	}
	
	private BinaryTree<Integer> buscarNodo (BinaryTree<Integer> a, int num) {
	    if (a == null || a.isEmpty()) return null;
	    if (a.getData() == num) return a;

	    if (a.hasLeftChild()) {
	        BinaryTree<Integer> izq = buscarNodo(a.getLeftChild(), num);
	        if (izq != null) return izq;
	    }

	    if (a.hasRightChild()) {
	        BinaryTree<Integer> der = buscarNodo(a.getRightChild(), num);
	        if (der != null) return der;
	    }

	    return null;
	}

	
	
	public static void main (String[] args) {
        BinaryTree<Integer> abLleno = new BinaryTree<Integer>(2);
        
		abLleno.addLeftChild(new BinaryTree<Integer>(7));
		abLleno.addRightChild(new BinaryTree<Integer>(-5));
		
		abLleno.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
		abLleno.getLeftChild().addRightChild(new BinaryTree<Integer>(6));	
		
		abLleno.getRightChild().addLeftChild(new BinaryTree<Integer>(19));	

		
		abLleno.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
		
		abLleno.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
		abLleno.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
		
		abLleno.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		
		abLleno.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
		
        ParcialArboles pA = new ParcialArboles(abLleno);
        
        System.out.println(pA.isLeftTree(7));
	}

	
}

