package tp3.ejercicio1.ejercicio2.ejercicio3;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import tp1.ejercicio8.Queue;

public class RecorridosAG {
	
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n){
		List<Integer> listaImparesMayores = new LinkedList<Integer>();
		
		this.recorrerPreOrden(a, n, listaImparesMayores);
		
		return listaImparesMayores;
	}
	
	private void recorrerPreOrden (GeneralTree<Integer> nodo, Integer n, List<Integer> list) {
		if ((nodo.getData() % 2 != 0) && (nodo.getData() > n))
			list.add(nodo.getData());
		
		Iterator<GeneralTree<Integer>> it = nodo.getChildren().iterator();
		
		while (it.hasNext()) {
			GeneralTree<Integer> children = it.next();
			recorrerPreOrden(children,n,list);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> listaImparesMayores = new LinkedList<Integer>();
		
		this.recorrerInOrden(a,n,listaImparesMayores);
		
		return listaImparesMayores;
	}
	
	private void recorrerInOrden(GeneralTree<Integer>nodo, Integer n, List<Integer>list) {
		List<GeneralTree<Integer>> children = nodo.getChildren();
		
		if(children.size()>0)
			recorrerInOrden(children.get(0),n,list);
		
		if ((nodo.getData() % 2 != 0) && (nodo.getData() > n))
			list.add(nodo.getData());
		
		for (int i=1; i < children.size(); i++) {
			recorrerInOrden(children.get(i),n,list);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> listaImparesMayores = new LinkedList<Integer>();
		
		this.recorrerPostOrden(a,n,listaImparesMayores);
		
		return listaImparesMayores;
	}
	
	private void recorrerPostOrden(GeneralTree<Integer> nodo, Integer n, List<Integer> list) {
		Iterator<GeneralTree<Integer>> it = nodo.getChildren().iterator();
		
		while(it.hasNext()) {
			GeneralTree<Integer> children = it.next();
			recorrerPostOrden(children,n,list);
		}
		
		if ((nodo.getData() % 2 != 0) && (nodo.getData() > n))
			list.add(nodo.getData());
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n){
		List<Integer> listaImparesMayores = new LinkedList<Integer>();
		
		this.recorrerPorNiveles(a,n,listaImparesMayores);
		
		return listaImparesMayores;
		
	}
	
	private void recorrerPorNiveles(GeneralTree<Integer> nodo, Integer n, List<Integer> list) {
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		
		cola.enqueue(nodo); // se encola la raiz 
		cola.enqueue(null);
		
		while (!cola.isEmpty()) {
			GeneralTree<Integer> act = cola.dequeue();

			if (act != null) { 
			    if ((act.getData() %2 !=0 ) && (act.getData() > n))
			        list.add(act.getData());
			
			    for (GeneralTree<Integer> children : act.getChildren())
				    cola.enqueue(children);
			} else if (!cola.isEmpty()) { // si la cola no esta vacia pero quedan niveles
				cola.enqueue(null); // pongo un null para el cambio de nivel
			}
		}  
		
	}

}
