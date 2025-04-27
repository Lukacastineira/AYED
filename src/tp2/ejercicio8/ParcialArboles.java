package tp2.ejercicio8;
import tp2.ejercicio1y2.BinaryTree;

public class ParcialArboles {
	
	public boolean esPrefijo (BinaryTree<Integer> arbol1, BinaryTree<Integer>arbol2) {
		if (arbol1.isEmpty())
			return true;
		if (arbol2.isEmpty())
			return false;
		return esPrefijoHelper(arbol1,arbol2);
	}
    
	private boolean esPrefijoHelper(BinaryTree<Integer> ab1, BinaryTree<Integer>ab2) {
		
		if (ab1.getData() != ab2.getData())
			return false;

		
		if (ab1.hasLeftChild() != ab2.hasLeftChild()) return false;
		
	    if (ab1.hasRightChild() != ab2.hasRightChild()) return false;
	    
		if (ab1.hasLeftChild() && ab2.hasLeftChild()) {
			if(!this.esPrefijoHelper(ab1.getLeftChild(), ab2.getLeftChild()))
				return false;
		}
		
		if (ab1.hasRightChild() && ab2.hasRightChild()) {
			if (!this.esPrefijoHelper(ab1.getRightChild(), ab2.getRightChild()))
				return false;
		}
		
		return true;
	}
	
}
