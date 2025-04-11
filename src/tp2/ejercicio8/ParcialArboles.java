package tp2.ejercicio8;
import tp2.ejercicio1y2.BinaryTree;

public class ParcialArboles {
	
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
	    if (arbol1 == null || arbol1.isEmpty()) return true;
	    if (arbol2 == null || arbol2.isEmpty()) return false;

	    if (!arbol1.getData().equals(arbol2.getData())) return false;

	    return esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild()) &&
	           esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
	}
	
	
	public static void main (String[] args) {
		
		ParcialArboles pA = new ParcialArboles();
        BinaryTree<Integer> ab1 = new BinaryTree<Integer>(2);
        BinaryTree<Integer> ab2 = new BinaryTree<Integer>(2);
        
        ab2.addLeftChild(new BinaryTree<Integer>(7));
        ab2.addRightChild(new BinaryTree<Integer>(-5));
        
        ab1.addLeftChild(new BinaryTree<Integer>(7));
        ab1.addRightChild(new BinaryTree<Integer>(-5));
		
        ab2.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        ab2.getLeftChild().addRightChild(new BinaryTree<Integer>(6));	
		
        ab2.getRightChild().addLeftChild(new BinaryTree<Integer>(19));	

        ab1.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        
        ab2.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
		
        ab2.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        ab2.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
		
        ab2.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        
        
        System.out.println(pA.esPrefijo(ab1, ab2));
        
	}

}
