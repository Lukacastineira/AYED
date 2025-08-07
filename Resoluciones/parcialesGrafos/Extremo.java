package parcialesGrafos;

public class Extremo {
	private String ciudad;
	private int transbordos;
	
	
	public Extremo(String ciudad, int transbordos) {
		this.setCiudad(ciudad);
		this.setTransbordos(transbordos);
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public int getTransbordos() {
		return transbordos;
	}


	public void setTransbordos(int transbordos) {
		this.transbordos = transbordos;
	}
	
	
}
