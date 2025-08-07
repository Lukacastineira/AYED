package tp2.ejercicio7;
import tp2.ejercicio1y2.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
    
	public boolean isLeftTree (int num) {
		return this.isLeftTreeHelper(num, this.arbol);
	}
	
	private boolean isLeftTreeHelper(int num, BinaryTree<Integer>ab) {
		if (ab.getData()==num) {
			
			int cantIzq = 0;
			int cantDer = 0;
			
			if(ab.hasLeftChild()) {
				cantIzq = contarUnicosHijos(ab.getLeftChild());
			}else {
				cantIzq = -1;	
			}
			
			if (ab.hasRightChild()) {
				cantDer = contarUnicosHijos(ab.getRightChild());
		    }else {
		    	cantDer = -1;
		    }
			
			return (cantIzq > cantDer);
		}
		
		if (ab.hasLeftChild()) {
			if (this.isLeftTreeHelper(num, ab.getLeftChild()))
				return true;
		}
		if(ab.hasRightChild()) {
			if(this.isLeftTreeHelper(num, ab.getRightChild()))
				return true;
		}
		
		return false;
	}
	
	private int contarUnicosHijos (BinaryTree<Integer> ab) {
		int cant = 0;
		if ((ab.hasLeftChild() && !ab.hasRightChild())|| (!ab.hasLeftChild() && ab.hasRightChild()) ) {
			cant++;
		}
		if (ab.hasLeftChild()) {
			cant += this.contarUnicosHijos(ab.getLeftChild());
		}
		if (ab.hasRightChild()) {
			cant += this.contarUnicosHijos(ab.getRightChild());
		}
		
		return cant;
	}
	

}
