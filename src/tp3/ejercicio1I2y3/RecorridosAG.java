package tp3.ejercicio1I2y3;
import java.util.List;
import java.util.LinkedList;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1I2y3.GeneralTree;
public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> ag, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if (ag!= null && !ag.isEmpty()) numerosImparesMayoresQuePreOrdenHelper(ag,n,lista);
		return lista;
	}
	
	
	private void numerosImparesMayoresQuePreOrdenHelper(GeneralTree<Integer> ag, Integer n, List<Integer> lista) {
		if (ag.getData() % 2 != 0 && ag.getData() > n) {
			lista.add(ag.getData());
		}
		
	    List<GeneralTree<Integer>> children = ag.getChildren();
		for (GeneralTree<Integer> child : children) {
			numerosImparesMayoresQuePreOrdenHelper(child,n,lista);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree<Integer> ag, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if (ag != null && !ag.isEmpty()) numerosImparesMayoresQueInOrdenHelper (ag,n,lista);
		return lista;
		
	}
	
	
	// un recorrido In Orden es mas un recorrido para arboles binarios
	
	private void numerosImparesMayoresQueInOrdenHelper (GeneralTree<Integer> ag, Integer n, List<Integer> lista){
		List<GeneralTree<Integer>> children = ag.getChildren();
		if (ag.hasChildren()) {
			this.numerosImparesMayoresQueInOrdenHelper(children.get(0), n,lista);
		}
		
		if (ag.getData() % 2 != 0 && ag.getData()>n) {
			lista.add(ag.getData());
		}
		
		for (int i=1; i < children.size(); i++) {
			this.numerosImparesMayoresQueInOrdenHelper(children.get(i), n, lista);
		}
	}
	
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree<Integer> ag, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if (ag!=null && !ag.isEmpty()) this.numerosImparesMayoresQuePostOrdenHelper(ag,n,lista);
		return lista;
	
	}
	
	private void numerosImparesMayoresQuePostOrdenHelper (GeneralTree<Integer> ag, Integer n, List<Integer> lista){
		List<GeneralTree<Integer>> children = ag.getChildren();
		
		for (GeneralTree<Integer> child : children) {
			this.numerosImparesMayoresQuePostOrdenHelper(child, n, lista);
		}
		
		if (ag.getData() % 2 != 0 && ag.getData() > n) {
			lista.add(ag.getData());
		}
    }
	
	public List<Integer> numerosImparesMayoresQuePorNiveles (GeneralTree<Integer> ag, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if (ag!=null && !ag.isEmpty()) this.numerosImparesMayoresQuePorNivelesHelper(ag,n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQuePorNivelesHelper (GeneralTree<Integer> ag, Integer n, List<Integer> lista){
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> aux;
		cola.enqueue(ag);
		
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
            if (aux.getData() % 2 != 0 && aux.getData() > n) {
            	lista.add(0,aux.getData());
            }
            List<GeneralTree<Integer>> children = aux.getChildren();
            for (GeneralTree<Integer> child : children) {
            	cola.enqueue(child);
            }
		}
		
	}
}

/* B) si ahora tendria que implementar los metodos en la clase GeneralTree<T>, en la firma 
 *    por ejemplo podria eliminar la declaracion del GeneralTree y usar la variable de la clase
 *    obviamente tendria que poner todo con dato generico y castear lo que se tenga que castear
 *    a integer. 
 * 
 * 
 */
