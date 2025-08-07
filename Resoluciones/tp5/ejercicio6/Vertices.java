package tp5.ejercicio6;
import tp5.ejercicio1.Vertex;


public class Vertices {
			private Vertex<String> vOrigen;
			private Vertex<String> vDestino;
			
			public Vertices(Vertex<String> vOrigen, Vertex<String> vDestino) {
				this.setvDestino(vDestino);
				this.setvOrigen(vOrigen);
			}

			public Vertex<String> getvOrigen() {
				return vOrigen;
			}

			public void setvOrigen(Vertex<String> vOrigen) {
				this.vOrigen = vOrigen;
			}

			public Vertex<String> getvDestino() {
				return vDestino;
			}

			public void setvDestino(Vertex<String> vDestino) {
				this.vDestino = vDestino;
			}
			
			
}
