package tp2.ejercicioAdicional;
import tp2.ejercicio1y2.BinaryTree;
public class EjercitacionesArboles {
	
	
	public BinaryTree<Integer> sumarArboles (BinaryTree<Integer>arbol1, BinaryTree<Integer> arbol2){
		BinaryTree<Integer> arbolSuma = new BinaryTree<Integer>();
		
		if (arbol1.isEmpty() || arbol2.isEmpty()) {
			return arbolSuma;
		}
		
		if (sumarArbolesHelper(arbol1,arbol2,arbolSuma))
		    return arbolSuma;
		else
			return new BinaryTree<Integer>();
	}
	
	public boolean sumarArbolesHelper (BinaryTree<Integer>ab1, BinaryTree<Integer> ab2, BinaryTree<Integer>abs) {
		abs.setData(ab1.getData()+ab2.getData());
		
		if (ab1.hasLeftChild() && ab2.hasLeftChild()) {
			
			abs.addLeftChild(new BinaryTree<Integer>());
			
			if (!sumarArbolesHelper(ab1.getLeftChild(),ab2.getLeftChild(),abs.getLeftChild()))
			    	return false;
			
		}else if (ab1.hasLeftChild() || ab2.hasLeftChild())
			return false;
		
		
		if (ab1.hasRightChild() && ab2.hasRightChild()) {
			
			abs.addRightChild(new BinaryTree<Integer>());
			
			if(!sumarArbolesHelper(ab1.getRightChild(),ab2.getRightChild(),abs.getRightChild()))
				return false;
			
		}else if (ab1.hasRightChild()|| ab2.hasRightChild())
			   return false;
		
        return true;
	}

}
