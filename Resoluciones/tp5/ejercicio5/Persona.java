package tp5.ejercicio5;

public class Persona {
		private String nombre;
		private String tipo;
		private int domicilio;
		private boolean cobro;
		
	    public String getTipo() {
		        return tipo;
	    }

	    public void setTipo(String tipo) {
	          this.tipo = tipo;
	    }

	    public String getNombre() {
		        return nombre;
	    }

	    public void setNombre(String nombre) {
		        this.nombre = nombre;
	    }

	    public int getDomicilio() {
		        return domicilio;
	    }

	    public void setDomicilio(int domicilio) {
		        this.domicilio = domicilio;
		}

	    
	    public boolean isCobro() {
		        return cobro;
	    }
		public void setCobro(boolean cobro) {
	           	this.cobro = cobro;
	    }

}
