package tp5.ejercicio6;
import tp5.ejercicio1.*;
import java.util.*;

public class BuscadorDeCaminos {
		private Graph<String> bosque; 
	
	private Vertices encontrarVertices (String origen, String destino) {
		  Vertex<String> verOrigen = this.bosque.search(origen);
		  Vertex<String> verDestino = this.bosque.search(destino);
		  
		  if (verOrigen != null && verDestino != null) {
			  return new Vertices(verOrigen,verDestino);
		  }else
			  return null;
	}
	
	public List<List<String>> recorridosMasSeguro(){
		List<List<String>> caminos = new LinkedList<List<String>>();
		String origen = "Casa Caperucita";
		String destino = "Casa Abuelita";
		
		if (!this.bosque.isEmpty()) {
			Vertices vertices = encontrarVertices(origen,destino);
			
			if (vertices != null) {
				this.recorridosMasSeguro(vertices.getvOrigen(),vertices.getvDestino(),caminos,new LinkedList<String>(), new boolean[this.bosque.getSize()]);
				
			}
		}
		
		return caminos;
	}
	
	private void recorridosMasSeguro (Vertex<String> origen, Vertex<String> destino, List<List<String>> caminos, List<String> caminoAct, boolean[]marca){ 
		   marca[origen.getPosition()] = true;
		   caminoAct.add(origen.getData());
		   
		   if (origen == destino) {
			   caminos.add(new LinkedList<String>(caminoAct));
		   } else {
			   List<Edge<String>> adyacentes = this.bosque.getEdges(origen);
			   for (Edge<String> e: adyacentes) {
				   int j = e.getTarget().getPosition();
				   if (!marca[j] && e.getWeight() < 5) {
					   this.recorridosMasSeguro(e.getTarget(), destino, caminos, caminoAct, marca);
				   }
			   }
		   }
		   
		   marca[origen.getPosition()] = false;
		   caminoAct.remove(caminoAct.size()-1);
	}
		
}	


