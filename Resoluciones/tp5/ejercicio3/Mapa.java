package tp5.ejercicio3;

import java.util.*;
import tp5.ejercicio1.*;


public class Mapa {
	private Graph<String> mapaCiudades;
	
	
	public List<String> devolverCamino (String ciudad1, String ciudad2){
		List<String> camino1a2 = new LinkedList<String>();
	    if (!this.mapaCiudades.isEmpty()) {
	    	Vertex<String> ciudadOrigen = this.mapaCiudades.search(ciudad1);
	    	Vertex<String> ciudadDestino = this.mapaCiudades.search(ciudad2);
	    	
	    	if (ciudadOrigen != null && ciudadDestino!=null) {
	    		if (this.devolverCamino(camino1a2,ciudadOrigen,ciudadDestino,new boolean[this.mapaCiudades.getSize()])) {
	    			return camino1a2;
	    		}
	    	}
	    }
	    
	    return new LinkedList<String>();
		
	}
	
	private boolean devolverCamino (List<String> camino, Vertex<String> origen, Vertex<String> destino, boolean[] marca) {
		boolean encontre = false;
		
		marca[origen.getPosition()] = true ;
		
		camino.add(origen.getData());
		
		if (origen.getData() == destino.getData()) {
			return true;
		}
		
		List<Edge<String>> adyacencias = this.mapaCiudades.getEdges(origen);
		Iterator<Edge<String>> it = adyacencias.iterator();
		
		while (it.hasNext() && !encontre) {
			Vertex<String> v = it.next().getTarget();
			int j = v.getPosition();
			
			if (!marca[j]) {
				encontre = devolverCamino(camino,v,destino,marca);
			}
		}
		
		if (!encontre) {
			camino.remove(camino.size()-1);
		}
		marca[origen.getPosition()] = false;
		return encontre;
		
	}
	
	
	private void marcarCiudadesRestringidas (List<String> ciudadesRestringidas, boolean[] marca) {
		for(String ciu:ciudadesRestringidas) {
			Vertex<String> v = this.mapaCiudades.search(ciu);
			
			if(v != null) {
				marca[v.getPosition()] = true;
			}
		}
	}
	
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		 List<String> camino1a2Exceptuando = new LinkedList<String>();
		 
		 if (!this.mapaCiudades.isEmpty()) {
			 Vertex<String> ciudadOrigen = this.mapaCiudades.search(ciudad1);
			 Vertex<String> ciudadDestino = this.mapaCiudades.search(ciudad2);
			 
			 if (ciudadOrigen != null && ciudadDestino != null) {
				 boolean[] marcas = new boolean[this.mapaCiudades.getSize()];
				 this.marcarCiudadesRestringidas(ciudades, marcas );
				 if (this.devolverCamino(camino1a2Exceptuando, ciudadOrigen, ciudadDestino, marcas)) {
					 return camino1a2Exceptuando;
				 }
			 }
		 }
		 
		 return new LinkedList<String>();
	}
	
	
	public List<String> devolverCaminoMinimo (String ciudad1, String ciudad2){
		  List<String> caminoMinimo = new LinkedList<String>();
		  
		  if (!this.mapaCiudades.isEmpty()) {
			  Vertex<String> ciudadOrigen = this.mapaCiudades.search(ciudad1);
			  Vertex<String> ciudadDestino = this.mapaCiudades.search(ciudad2);
			  
			  if (ciudadOrigen != null && ciudadDestino != null) {
				  this.devolverCaminoMinimo(ciudadOrigen,ciudadDestino,new boolean[this.mapaCiudades.getSize()],caminoMinimo, new LinkedList<String>(), 0 , Integer.MAX_VALUE);
			  }
		  }
		  
		  return caminoMinimo;
		  
	}
	
	
	private int devolverCaminoMinimo (Vertex<String> origen, Vertex<String> destino, boolean [] marca, List<String> caminoMin, List<String> caminoAct, int total, int min ) {
		marca[origen.getPosition()] = true;
		caminoAct.add(origen.getData());
		
		if (origen.getData().equals(destino.getData()) && total < min) {
			caminoMin.removeAll(caminoMin);
			caminoMin.addAll(caminoAct);
			min = total;
		} else {
			List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(v);
			Iterator<Edge<String>> it = adyacentes.iterator();
			
			while(it.hasNext() && total < min) {
				Edge<String> v = it.next();
				int j = it.next().getTarget().getPosition();
			    int aux = total + it.next().getWeight();
			    
			    if (!marca[j] &&  aux < min) {
			    	devolverCaminoMinimo(v.getTarget(),destino,marca,caminoMin,caminoAct,aux,min);
			    }
			}
		}
		
		marca[origen.getPosition()] = false;
		caminoAct.remove(caminoAct.size()-1);
		
		return min;
	}
	
	public List<String> caminoSinCargarCombustible (String ciudad1, String ciudad2, int tanqueAuto) {
		List<String> caminoSinCargar = new LinkedList<String> ();
		
		if (!this.mapaCiudades.isEmpty()) {
			Vertex<String> ciudadOrigen = this.mapaCiudades.search(ciudad1);
			Vertex<String> ciudadDestino = this.mapaCiudades.search(ciudad2);
			
			if (ciudadOrigen != null && ciudadDestino != null) {
				this.caminoSinCargarCombustible(ciudadOrigen,ciudadDestino,caminoSinCargar, new boolean[this.mapaCiudades.getSize()], tanqueAuto);
		    }
	    }
		
		return new LinkedList<String>();
	
	}
	
	private boolean caminoSinCargarCombustible ( Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[]marca,int tanque) {
	    boolean encontre = false;
		marca[origen.getPosition()] = true;
		camino.add(origen.getData());
		
		if (origen.equals(destino)) {
			return true;
		} else {
		
			List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = adyacentes.iterator();
			
			while (it.hasNext() && !encontre) {
				Edge<String> v = it.next();
				int j = v.getTarget().getPosition();
				
				if (!marca[j] && tanque - v.getWeight() > 0) {
					encontre = this.caminoSinCargarCombustible(v.getTarget(), destino, camino, marca, tanque-it.next().getWeight());
				}
			}
		}
		
		if (!encontre) {
			camino.remove(camino.size()-1);
		}
		marca[origen.getPosition()] = false;
		
		return encontre;
			
	}
	
	
	public List<String> caminoConMenorCargasDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		List<String> caminoMinCargas = new LinkedList<String> ();
		
		if (!this.mapaCiudades.isEmpty()) {
			Vertex<String> ciudadOrigen = this.mapaCiudades.search(ciudad1);
			Vertex<String> ciudadDestino = this.mapaCiudades.search(ciudad2);
			
			if (ciudadOrigen != null && ciudadDestino != null) {
				this.caminoConMenorCargasDeCombustible(ciudadOrigen,ciudadDestino,0, Integer.MAX_VALUE, tanqueAuto, tanqueAuto, caminoMinCargas, new LinkedList<String>(), new boolean[this.mapaCiudades.getSize()]);
			}
		}
		
		return caminoMinCargas;
	}
	
	private int caminoConMenorCargasDeCombustible(Vertex<String> origen, Vertex<String> destino, int recargasAct, int recargasMin, int tanque, int tanqueAct, List<String> caminoMin, List<String> caminoAct, boolean[] marca) {
		
		
		  marca[origen.getPosition()] = true;
		  caminoAct.add(origen.getData());
		  
		  if ((origen == destino) && (recargasAct < recargasMin)) {
			  caminoMin.clear();
			  caminoMin.addAll(caminoAct);
			  recargasMin = recargasAct;
		  } else {
			  
			  List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
			  Iterator<Edge<String>> it = adyacentes.iterator();
			  
			  while (it.hasNext() && recargasAct < recargasMin ) {
				  Edge<String> e = it.next(); 
				  
				  int j = e.getTarget().getPosition();
				  int distanciaRecorrer = e.getWeight();
				  if (!marca[j]) {
					  if (distanciaRecorrer <= tanqueAct) {
						  recargasMin = this.caminoConMenorCargasDeCombustible(e.getTarget(), destino, recargasAct, recargasMin, tanque, tanqueAct-distanciaRecorrer, caminoMin, caminoAct, marca);
					  }else if(distanciaRecorrer <= tanque) {
						  recargasMin = this.caminoConMenorCargasDeCombustible(e.getTarget(), destino, recargasAct+=1, recargasMin, tanque, tanque-distanciaRecorrer, caminoMin, caminoAct, marca);
					  }
				  }
			  }
			  
		  }
		  
		  caminoAct.remove(caminoAct.size()-1);	  
		  marca[origen.getPosition()] = false;
		  
		  return recargasMin;
	}
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
