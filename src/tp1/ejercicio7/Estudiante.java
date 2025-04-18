package tp1.ejercicio7;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String email;
	private String comision;
	private String direccion;
	
	public Estudiante(String nom, String ape, String mail, String comi, String direc) {
		this.setNombre(nom);
		this.setApellido(ape);
		this.setEmail(mail);
		this.setComision(comi);
		this.setDireccion(direc);
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
		str = "nombre del Alumno: " + this.getNombre() + " Apellido: " + this.getApellido() + " Email Alumno: " + this.getEmail() + " Comision: " + this.getComision() + " Direccion:  " + this.getDireccion() + "." + "\n";
		return str;
	}
	

}
