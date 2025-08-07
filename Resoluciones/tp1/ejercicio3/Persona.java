package tp1.ejercicio3;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String email;
	
	public Persona () {
		
	}
	
	public Persona (String nom, String ape, String mail ) {
		this.setNombre(nom);
		this.setApellido(ape);
		this.setEmail(mail);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString () {
		String str;
		str = " " + this.getNombre() + " " + this.getApellido() + " Email: " + this.getEmail() + "" ;		
		return str;
	}
	

}
