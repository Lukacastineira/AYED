package tp5.ejercicio4;
import tp5.ejercicio1.*;
import java.util.*;
public class VisitaOslo {
     
	private void marcarLugaresRestringidos (Graph<String> grafo, List<String> restringidos, boolean[]marcas) {
		for (String lugar:restringidos) {
			Vertex<String> v = grafo.search(lugar);
			if (v!=null) {
				marcas[v.getPosition()] = true;
			}
			
		}
	}
	
		public List<String> paseoEnBici (Graph<String> grafo, String destino, int maxTiempo, List<String> lugaresRestringidos){
			List<String> camino = new LinkedList<String>();
			if (!grafo.isEmpty()) {
				Vertex<String> origen = grafo.search("Ayuntamiento");
				Vertex<String> dest = grafo.search(destino);
				
				if (origen != null && destino != null) {
					boolean [] marcas = new boolean[grafo.getSize()];
					this.marcarLugaresRestringidos(grafo,lugaresRestringidos,marcas);
					if (this.paseoEnBiciPrivado(grafo,origen, dest, maxTiempo,0,marcas,camino)) {
						return camino;
					}
				}
			}
			
			return new LinkedList<String>();
		}
			
		private boolean  paseoEnBiciPrivado (Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, int maxTiempo, int tiempoAct, boolean[] marcas, List<String> camino) {
			boolean encontre = false;
			camino.add(origen.getData());
			marcas[origen.getPosition()] = true;
			
			if (origen == destino) {
				return true;
			} else {
				List<Edge<String>> adyacentes = grafo.getEdges(origen);
				Iterator<Edge<String>> it = adyacentes.iterator();
				
				while (it.hasNext() && !encontre) {
					Edge<String> e = it.next();
					int j = e.getTarget().getPosition();
					
					if (!marcas[j] && tiempoAct + e.getWeight() < maxTiempo) {
						encontre = this.paseoEnBiciPrivado(grafo, e.getTarget(), destino, maxTiempo, tiempoAct+=e.getWeight(), marcas, camino);
					}
				}
			}
			
			if (!encontre) {
				camino.remove(camino.size()-1);
			}
			marcas[origen.getPosition()] = false;
			
			return encontre;
			
		}

}
