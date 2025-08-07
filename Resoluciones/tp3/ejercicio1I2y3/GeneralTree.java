package tp3.ejercicio1I2y3;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;
import java.util.Iterator;


public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		if (this!=null && !this.isEmpty()) return this.alturaHelper();
		return -1;
	}
	
	private int alturaHelper() {
		int cont = 0;
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child : children ) {
			cont = Math.max(cont,child.alturaHelper());
		}
		return cont + 1 ;
	}
	
	public int nivel(T dato){
		if (this!=null && !this.isEmpty()) return this.nivelHelper(dato);
		return -1;
	  }
	
	private int nivelHelper (T dato) {
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux ;
		
		int nivel=0;
		cola.enqueue(this);
		cola.enqueue(null);
		
		while (!cola.isEmpty()) {
			
			aux = cola.dequeue();
			
			if (aux != null) {
				
				if (aux.getData() == dato) { // aux.getData().equals(dato) si dato es un objeto.
					return nivel;
				}
				
				List<GeneralTree<T>> children = aux.getChildren();
				Iterator<GeneralTree<T>> it = children.iterator();
                while (it.hasNext()) {
                	cola.enqueue(it.next());
                }
			}else if (!cola.isEmpty()) {
				nivel++;
			}
		}
		return -1;
	}
	
	

	public int ancho(){
		if (this!=null && !this.isEmpty()) return this.anchoHelper();
		return -1;
	}
	
	private int anchoHelper () {
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		GeneralTree<T> aux;
		
		int cont = 0;
		int max = 0;
		
		cola.enqueue(this);
		cola.enqueue(null);
		
		if (!this.hasChildren()) return 1;
		
		while (!cola.isEmpty()) {
			
			aux = cola.dequeue();

			if (aux != null) {
				List<GeneralTree<T>> children = aux.getChildren();
				for (GeneralTree<T> child: children) {
					cola.enqueue(child);
					cont++;
				}
				
			}else if (!cola.isEmpty()) {
				max = Math.max(max, cont);
				cont = 0;
				cola.enqueue(null);
			}
		}
		return max;
	}
	
	
	// EJERCICIO 5: 
	
	public boolean esAncestro (T a, T b) {
		if (this!=null && !this.isEmpty()) return esAncestroHelper(a,b);
		return false;
	}
	
	private boolean esAncestroHelper (T a, T b) {

		if(this.getData().equals(a)) {
			return recorridoSi(this,b);
		}
		
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child: children) {
			if (child.esAncestroHelper(a, b)) return true;
		}
		return false;
	}
	
	private boolean recorridoSi (GeneralTree<T>ag, T b) {
		if (ag.getData().equals(b)) return true;
		
		List<GeneralTree<T>> children = ag.getChildren();
		Iterator<GeneralTree<T>> it = children.iterator();
		while (it.hasNext()){
			if (this.recorridoSi(it.next(), b)) return true;
		}
		return false;
	}
	
	
	
	
	
	
}