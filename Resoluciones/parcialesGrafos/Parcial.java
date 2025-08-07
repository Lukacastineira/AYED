package parcialesGrafos;
import tp5.ejercicio1.*;
import java.util.*;


public class Parcial {
	
	
	public int resolver (Graph<Recintos> sitios, int tiempo) {
		boolean seguir = true;
		TiempoMax max = new TiempoMax();
		Vertex<Recintos> origen = null;
		if (!sitios.isEmpty()) {
			List<Vertex<Recintos>> vertices = sitios.getVertices();
			Iterator<Vertex<Recintos>> it = vertices.iterator();

			while (it.hasNext() && seguir) {
				Vertex<Recintos> v = it.next();
				if (v.getData().getRecinto().equals("Entrada")) {
					origen = v;
					seguir = false;
				}
			}
			
			if (origen != null) {
				this.resolverPrivado(sitios, origen,tiempo,0, 0,max, new boolean[sitios.getSize()]);
			}
		}
		return max.getRecintosMax();
	}
	
	private void resolverPrivado(Graph<Recintos> sitios, Vertex<Recintos> origen, int tiempoTotal, int tiempoActual, int recintosVisitados, TiempoMax tiempoMax, boolean[] marca) {

			tiempoActual += origen.getData().getTiempo();
			recintosVisitados++;
			marca[origen.getPosition()] = true;

			if (recintosVisitados > tiempoMax.getRecintosMax()) {
					tiempoMax.setRecintosMax(recintosVisitados);
					tiempoMax.setTiempoMax(tiempoActual);
			}

			Iterator<Edge<Recintos>> it = sitios.getEdges(origen).iterator();
			while (it.hasNext()) {
				Edge<Recintos> e = it.next();
				Vertex<Recintos> vecino = e.getTarget();

				int tiempoProximo = tiempoActual + e.getWeight() + vecino.getData().getTiempo();
				if (!marca[vecino.getPosition()] && tiempoProximo <= tiempoTotal) {
					resolverPrivado(sitios, vecino, tiempoTotal, tiempoActual + e.getWeight(), recintosVisitados, tiempoMax, marca);
				}
			}

			marca[origen.getPosition()] = false; // backtracking
	}
	
	
	
	
}
