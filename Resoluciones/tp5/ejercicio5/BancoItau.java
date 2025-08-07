package tp5.ejercicio5;
import java.util.*;
import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;


public class BancoItau {
	
	private Vertex<Persona> buscarEmple (Graph<Persona> grafo, String empleado) {
		List<Vertex<Persona>> vertices = grafo.getVertices();
		Iterator <Vertex<Persona>> it = vertices.iterator();
		Vertex<Persona> emple = null;
		boolean encontre = false;
		
		while (it.hasNext() && !encontre) {
			Vertex<Persona> v = it.next();
			
			if(v.getData().getNombre().equals(empleado)) {
				emple = v;
				encontre = true;
			}
		}
		
		return emple;
		
	}
	
	public List<Persona> conseguirListaJubilados (Graph<Persona> grafo, String emple, int grado){
		List<Persona> jubiladosDistanciaMenor = new LinkedList<Persona>();
		
		if (!grafo.isEmpty()) {
			Vertex<Persona> empleado = this.buscarEmple(grafo, emple);
			if (empleado != null) {
				this.conseguirListaJubilados(grafo, empleado, grado, jubiladosDistanciaMenor, new boolean [grafo.getSize()]);
			}
		}
		
		return jubiladosDistanciaMenor;
	}
	

	private void conseguirListaJubilados (Graph<Persona> grafo, Vertex<Persona> emple, int grado, List<Persona> lista, boolean[] marca) {
		   
		   Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
		   marca[emple.getPosition()] = true;
		   int nivelAct = 0;
		   cola.enqueue(emple);
		   cola.enqueue(null);
		   
		   while (!cola.isEmpty() && nivelAct<= grado) {
			   Vertex<Persona> v = cola.dequeue();
			   
			   if (v != null) {
			   		
			   		if ((v.getData().getTipo().equals("Jubilado")) && (!v.getData().isCobro()) && lista.size() < 40){
			   			lista.add(v.getData());
			   		}
			   
			   		List<Edge<Persona>> adyacentes = grafo.getEdges(v);
			   		Iterator<Edge<Persona>> it = adyacentes.iterator();
			   
			   		while (it.hasNext() &&  lista.size() < 40) {
			   			Edge<Persona> e = it.next();
			   			int j = e.getTarget().getPosition();
				        
			   			if (!marca[j]) {
			   				cola.enqueue(e.getTarget());
			   				marca[j] = true;
			   			}
		            }
		   
		        }else if (!cola.isEmpty()) {		   	   
		        	cola.enqueue(null);
		        	nivelAct++;
		        }
	      }
	}
	
	
	
}


