package parcialesGrafos;
import tp5.ejercicio1.*;
import java.util.*;
import tp1.ejercicio8.Queue;
public class MapaSaoPaulo {
	 
	 
	 public List<Extremo>  menosTrasbordos (Graph<String> mapa, String origen){
		 List<Extremo> extremos = new LinkedList<Extremo>();
		 
		 if (!mapa.isEmpty()) {
			 Vertex<String> vOrigen = mapa.search(origen);
			 if (vOrigen != null) {
				 this.menosTrasbordos (mapa,vOrigen,new boolean[mapa.getSize()], extremos);
			 }
		 }
		 return extremos;
	 }
	 
	 
	 private void menosTrasbordos (Graph<String> mapa, Vertex<String> origen, boolean [] marca, List<Extremo> extremos ) {
		   Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
		   int transbordos = 0;
		   marca[origen.getPosition()] = true;
		   cola.enqueue(origen);
           cola.enqueue(null);
		   
		   while (!cola.isEmpty()) {
		        Vertex<String> v = cola.dequeue();

		        if (v != null) {
		            List<Edge<String>> adyacentes = mapa.getEdges(v);
		            int conexiones = adyacentes.size();

		            // Si tiene una sola conexión y no es el origen, es extremo
		            if (conexiones == 1 && !v.equals(origen)) {
		                extremos.add(new Extremo(v.getData(), transbordos));
		            } else if (conexiones > 2) {
		            	cola.enqueue(null);
		            }

		            for (Edge<String> e : adyacentes) {
		                Vertex<String> vecino = e.getTarget();
		                if (!marca[vecino.getPosition()]) {
		                    cola.enqueue(vecino);
		                    marca[vecino.getPosition()] = true;
		                }
		            }

		        } else if (!cola.isEmpty()) {
		            transbordos++; // pasamos al siguiente nivel
		        }
		   }
		   
	 }
}
