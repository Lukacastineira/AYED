package tp3.ejercicio1.ejercicio2.ejercicio3;

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
		return this.getAltura(this); // this raiz del arbol 
	}
	
	private int getAltura(GeneralTree<T> nodo) {	 
		if (nodo.isLeaf()) return 0;
			
		int maxAltura = 0;
			
		for (GeneralTree<T> children : this.getChildren()) {
			int alturaHijo = this.getAltura(children);
			maxAltura = Math.max(alturaHijo, maxAltura); // se queda con el mayor
		}
		return maxAltura + 1; // sumo nivel nodo actual
	  
	}
	
	
	
	public int nivel(T dato){
		return this.getNivel(this,dato,0);
	  }
	
	private int getNivel (GeneralTree<T> nodo, T dato , int nivelActual) {
		if (nodo.getData().equals(dato)) return nivelActual;
		
		
		Iterator<GeneralTree<T>> it = nodo.getChildren().iterator();
		
		while (it.hasNext()) {
			GeneralTree<T> children = it.next();
			int nivelHijo = getNivel(children,dato,nivelActual + 1);
			if(nivelHijo != -1) 
				return nivelHijo;
		}
		return -1;
		
	}

	public int ancho(){
		if(this.isEmpty()) return -1;
		else 
		  return this.getAncho(this);
	}
	
	private int getAncho (GeneralTree<T> nodo) {
	     Queue<GeneralTree<T>> cola = new Queue<>();
	     
	     cola.enqueue(nodo); // encolo la raiz
	     
	     int maxAncho =0;
	     
	     while (!cola.isEmpty()) {
	    	 int tamanoNivel = cola.size(); // n nodos en el nivel actual
	    	 maxAncho = Math.max(maxAncho, tamanoNivel);
	    	 
	    	 for (int i = 0; i<tamanoNivel; i++) {
	    	     GeneralTree<T> act = cola.dequeue(); // saca el primer nodo de la cola
	    	     
	    	     // encola los hijos de ese nodo
	    	     for (GeneralTree<T> children: act.getChildren()) 
	    	          cola.enqueue(children);
	    	 }
	    }
	     return maxAncho;
	}
}