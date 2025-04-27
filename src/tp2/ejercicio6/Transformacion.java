package tp2.ejercicio6;
import tp2.ejercicio1y2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> suma (){
		this.sumaHelper(this.arbol);
		return this.arbol;
	}
	
	private int sumaHelper (BinaryTree<Integer> ab) {
		 int suma = 0;
		
		 if(ab.isLeaf()) {
			   suma = ab.getData();
			   ab.setData(0);
			   return suma;
		 }
		 
		 if (this.arbol.hasLeftChild()) {
			 suma += this.sumaHelper(ab.getLeftChild());
		 }
		 
		 if(this.arbol.hasRightChild()) {
			 suma += this.sumaHelper(ab.getRightChild());
		 }
		 
		 
		 return suma + ab.getData();
		 	 

	}
	
}
