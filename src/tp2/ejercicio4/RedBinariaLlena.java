package tp2.ejercicio4;
import tp2.ejercicio1y2.BinaryTree;
public class RedBinariaLlena {
	 private BinaryTree<Integer> redBinaria;
	 
	 public RedBinariaLlena(BinaryTree<Integer> red) {
		 this.redBinaria = red;
	 }
	
	// voy a utilizar un recorrido en profundidad (especificamente el pre orden) 
	public int retardoReenvio() {
		if (!this.redBinaria.isEmpty()) {
			return this.retardoReenvioHelper(this.redBinaria);
		}else 
		    return 0;
	}
	
	private int retardoReenvioHelper(BinaryTree<Integer> ab) {

		int retHI = 0;
		int retHD = 0;
		
		
		if (ab.hasLeftChild()) {
			retHI += this.retardoReenvioHelper(ab.getLeftChild());			
		}
		
		if (ab.hasRightChild()) {
			retHD += this.retardoReenvioHelper(ab.getRightChild());
		}

		
		return ab.getData() + Math.max(retHI, retHD);
		
	}

}
