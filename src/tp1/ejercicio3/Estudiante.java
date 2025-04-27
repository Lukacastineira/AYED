package tp1.ejercicio3;

public class Estudiante extends Persona{
	private String comision;
	private String direccion;
	
	public Estudiante () {
		
	}
	
    public Estudiante (String nom, String ape, String mail, String comi, String direc) {
		 super(nom,ape,mail);
		 this.setComision(comi);
		 this.setDireccion(direc);
	}
	
	public String getComision() {
		return comision;
	}
	
	public void setComision(String comision) {
		this.comision = comision;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public String toString () {
		String str;
		str = " El etudiante " + super.toString() + " Comision: " + this.getComision() 
		+ " y Direccion:" + this.getDireccion() + ".";
		return str;
	}

}
