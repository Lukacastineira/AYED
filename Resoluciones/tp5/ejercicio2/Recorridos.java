package tp5.ejercicio2;

import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Edge;

import tp5.ejercicio1.adjList.AdjListEdge;
import tp5.ejercicio1.adjList.AdjListGraph;
import tp5.ejercicio1.adjList.AdjListVertex;
import java.util.List;
import java.util.LinkedList;
import tp1.ejercicio8.Queue;

public class Recorridos<T> {
	
	public List<T> dfs (Graph<T> grafo) {
		List<T> lista = new LinkedList<T>();
		boolean[] marca = new boolean[grafo.getSize()];
		for (int i=1; i <= grafo.getSize() ; i++) {
			if (!marca[i])
				this.dfs(i, grafo, lista, marca);
		}
		
		return lista;
	}
	
	
	private void dfs (int i, Graph<T> grafo, List<T> lista, boolean[] marca){
		marca[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		lista.add(v.getData());
		List<Edge<T>> adyacentes = grafo.getEdges(v);
		for (Edge<T> e: adyacentes) {
			int j = e.getTarget().getPosition();
			if (!marca[j]) {
				dfs(j,grafo,lista,marca);
			}
		}
	}
	
	public List<T> bfs (Graph<T> grafo){
		List<T> lista = new LinkedList<T>();
		boolean[] marca = new boolean[grafo.getSize()];
		for (int i = 1; i < grafo.getSize() ; i++) {
			this.bfs(i,grafo,lista,marca);
		}
		return lista;
	}
	
	private void bfs (int i, Graph<T> grafo, List<T> lista, boolean marca[]) {
		Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
		
		cola.enqueue(grafo.getVertex(i));
		marca[i] = true;
		
		while (!cola.isEmpty()) {
			Vertex<T> v = cola.dequeue();
			
			lista.add(v.getData());
			
			List<Edge<T>> adyacencias = grafo.getEdges(v);
			for (Edge<T> e:adyacencias) {
				int j = e.getTarget().getPosition();
				if (!marca[j]) {
					marca[j] = true;
					cola.enqueue(e.getTarget());
				}
			}
		}
	}
	
	public List<List<String>> dfsConCostos (Graph<T> grafo){
		  boolean[] marca = new boolean[grafo.getSize()];
		  List<String> vuelosAux = null;
		  List<List<String>> vuelos = new LinkedList<List<String>> ();
		  int costo = 0;
		  for (int i = 1; i < grafo.getSize() ; i++) {
			  vuelosAux = new LinkedList<String>();
			  vuelosAux.add(grafo.getVertex(i).getData().toString());
			  marca[i] = true;
			  this.dfsConCostos(i,costo,grafo,vuelos,marca,vuelosAux);
			  marca[i] = false;
		  }
		  return vuelos;
	}
	
	private void dfsConCostos (int i, int costo, Graph<T> grafo, List<List<String>> vuelos, boolean[] marca, List<String> vuelosAux) {
		Vertex<T> vDestino = null;
		int p = 0, j = 0;
		Vertex<T> v = grafo.getVertex(i);
		
		List<Edge<T>> adyacentes = grafo.getEdges(v);
		for (Edge<T> e:adyacentes) {
			j = e.getTarget().getPosition();
			if (!marca[j]) {
				p = e.getWeight();
				if ((costo + p) <= 10) {
					vDestino = e.getTarget();
					vuelosAux.add(vDestino.getData().toString());
					marca[j] = true;
					if ((costo + p) == 10) 
						vuelos.add(vuelosAux);
					else
						dfsConCostos(j,costo+p,grafo,vuelos,marca,vuelosAux);
				    vuelosAux.remove(vDestino.getData().toString());
				    marca[j] = false;
					
					
				}
					
			}
		}
	}
	
	
	public static int bfsVirusRed (Graph<String> grafo, Vertex<String> ini ) {
		int tiempo = 0;
		
		boolean [] infectada = new boolean [grafo.getSize()];
		
		infectada[ini.getPosition()] = true;
		
		Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
		
	    cola.enqueue(ini);
        
	    cola.enqueue(null);
	    
	    while (!cola.isEmpty()) {
	    	
	    	Vertex<String> v = cola.dequeue();
	    	
	    	if (v != null) {
	    		List<Edge<String>> adyacentes = grafo.getEdges(v);
	    		for (Edge<String> e : adyacentes) {
	    			Vertex<String> w = e.getTarget();
	    			if (!infectada[w.getPosition()]) {
	    				infectada[w.getPosition()] = true;
	    				cola.enqueue(w);
	    			}
	    		}
	    	}else if (!cola.isEmpty()) {
	    		cola.enqueue(null);
	    		tiempo += 1;
	    	}	
		} // end while
	    return tiempo;
	}
}
