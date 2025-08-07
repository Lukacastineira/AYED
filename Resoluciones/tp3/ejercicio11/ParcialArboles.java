package tp3.ejercicio11;
import tp3.ejercicio1I2y3.GeneralTree;
import tp1.ejercicio8.Queue;
import java.util.List;

public class ParcialArboles {
	
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		if (arbol!=null && !arbol.isEmpty()) return resolverHelper(arbol);
		return false;
	}
	
	
	private static boolean resolverHelper (GeneralTree<Integer> ag) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> aux;
		
		int cantNodos=0;
		int cantNodoAnt=0;
		boolean cumple = true;
		
		cola.enqueue(ag);
		cola.enqueue(null);
		
		while (!cola.isEmpty() && cumple) {
			aux = cola.dequeue();
			
			if (aux != null) {
				cantNodos += 1;
				
				List<GeneralTree<Integer>> children = aux.getChildren();
				for (GeneralTree<Integer> child:children) {
					cola.enqueue(child);
				}
				
			}else if(!cola.isEmpty()) {
				if (cantNodos == ++cantNodoAnt) {
					cantNodos = cantNodoAnt;
					cantNodos=0;
				}else
					cumple = false;
				cola.enqueue(null);
			}
		}
		return cumple;
	}
}
