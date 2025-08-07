package tp1.ejercicio3;

public class Profesor extends Persona {
     private String catedra;
     private String facultad;

	public Profesor(String nom, String ape, String mail, String cate, String facu) {
		super(nom,ape,mail);
		 this.setCatedra(cate);
		 this.setFacultad(facu);
	}


	public String getCatedra() {
		return catedra;
	}
	
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	
	public String getFacultad() {
		return facultad;
	}
	
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
     
	@Override
	public String toString () {
		String str;
		str = " El Profesor " + super.toString() + " Catedra: " + this.getCatedra() 
		+ " y Facultad:" + this.getFacultad() + ".";
		return str;
	}
     
}
