package tp2.ejercicio5;
import tp2.ejercicio1y2.BinaryTree;
import tp1.ejercicio8.Queue;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	
	public int sumaElementosProfundidad (int p) {
		return this.sumaElementosProfundidadHelper(p);
	}
	
	private int sumaElementosProfundidadHelper (int p) {
		BinaryTree<Integer> ab;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		
	    int sumaElementos =0;
		int nivel = 0;
		
		cola.enqueue(this.arbol);
		cola.enqueue(null);
		
		
		while (!cola.isEmpty()) {
			ab = cola.dequeue();
			if (ab!=null) {
				if (nivel == p)
					sumaElementos += ab.getData();
				if (ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				if(ab.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
				}
			}else if (!cola.isEmpty()){
				nivel += 1;
				cola.enqueue(null);
			}
		}
		return sumaElementos;
	}
}
