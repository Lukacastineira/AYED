package tp2.ejercicioAdicional3;
import tp2.ejercicio1y2.BinaryTree;

public class ProfundidadNodoBuscado {
	private BinaryTree<Integer> arbol;
	
	public int profundidadNodo (int num) {
		if (this.arbol != null && !this.arbol.isEmpty()) {
			return this.profundidadNodoHelper(num,this.arbol,0);
		}else
			return -1;
	}
	
	private int profundidadNodoHelper (int num, BinaryTree<Integer>ab, int nivelAct) {
		if (ab.getData() == num) {
			return nivelAct;
		}
		
		int nuevoNivel = nivelAct +  1;
		
		if (ab.hasLeftChild()) {
			int nivelIzq = this.profundidadNodoHelper(num, ab.getLeftChild(), nuevoNivel);
			if (nivelIzq != -1) return nivelIzq;
		}

		
		if (ab.hasRightChild()) {
			int nivelDer = this.profundidadNodoHelper(num, ab.getRightChild(), nuevoNivel);
			if (nivelDer != -1) return nivelDer;
		}
		
		return -1;
	}
}
