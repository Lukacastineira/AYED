package tp2.ejercicio9;

public class ObjParcial {
	private int sumaNums;
	private int dif;
	
	public ObjParcial(int suma,int dif) {
		this.setSuma(suma);
		this.setDif(dif);
	}
	
	public void setSuma (int suma) {
		this.sumaNums = suma;
	}
	
	public void setDif (int dif) {
		this.dif = dif;
	}
	
	public int getSuma() {
		return this.sumaNums;
	}
	public int getDif() {
		return this.dif;
	}
	
	

}
