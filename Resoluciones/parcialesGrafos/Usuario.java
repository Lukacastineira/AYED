package parcialesGrafos;

public class Usuario {
		private String nombre;
		private int distancia;
		
		public Usuario(String nombre,int distancia) {
			this.nombre = nombre;
			this.distancia = distancia;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getDistancia() {
			return distancia;
		}
		public void setDistancia(int distancia) {
			this.distancia = distancia;
		}
}
