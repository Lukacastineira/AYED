package parcialesGrafos;
import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;
import java.util.*;


public class Parcial2 {
		
	
	public List<Usuario> invitacionMasterClass (Graph<String> red, String usuario,int distancia, int limite){
		List<Usuario> invitados = new LinkedList<Usuario>();
		
		Vertex<String> origen = null;
		
		List<Vertex<String>> listaVertices = red.getVertices();
		Iterator<Vertex<String>> it = listaVertices.iterator();
		boolean seguir = true ;
		while (it.hasNext() && seguir) {
			Vertex<String> v  = it.next();
			if (v.getData().equals(usuario)) {
			     origen =v;
			     seguir = false;
			}
		}
		
		if (origen != null) {
			this.invitacionMasterClass(red,origen,new boolean [red.getSize()],distancia,limite,invitados);
		}
		
		return invitados;
		
    }
	
	private void invitacionMasterClass (Graph<String> red, Vertex<String> origen, boolean[] marca, int distancia, int limite, List<Usuario> invitados) {
		Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
		
		int nivelAct=0;
		boolean seguir = true ;
		
		cola.enqueue(origen);
		cola.enqueue(null);
		marca[origen.getPosition()] = true;
		
		while (!cola.isEmpty() && seguir) {
			
			Vertex<String> v = cola.dequeue();
			
			if (v != null) {
				
			if (!v.equals(origen) && invitados.size() < limite) {
				invitados.add(new Usuario(v.getData(),nivelAct));
			} if (invitados.size() == limite ) {
				seguir = false;
			}
			
			List<Edge<String>> adyacentes = red.getEdges(v);
			Iterator<Edge<String>> it = adyacentes.iterator();
			
			while (it.hasNext() && seguir) {
				Edge<String> e = it.next();
				Vertex<String> destino = e.getTarget();
				if (!marca[destino.getPosition()]) {
					cola.enqueue(destino);
					marca[destino.getPosition()] = true;
				}
			}
				
			}else if(!cola.isEmpty()) {
				cola.enqueue(null);
				nivelAct++;
				if (nivelAct > distancia) {
					seguir = false;
				}
			}
			
			
			
			
		} 	
		
		
	}


}