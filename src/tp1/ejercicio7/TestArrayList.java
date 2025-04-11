package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.Random;

public class TestArrayList<T> {
	private ArrayList<T> lista;
	
	public TestArrayList() {
		this.lista = new ArrayList<>();
	}

	public void agregar (T elem) {
		lista.add(elem);
	}
	
	public void eliminar (int i) {
		if (i >= 0 && i < lista.size()) {
			lista.remove(i);
		}else {
			System.out.println(" Indice Fuera De Rango. ");
		}
		
	}
	
	public T obtener (int i) {
		if (i >= 0 && i < lista.size()) {
			return lista.get(i);
		}
		return null;
	}
	
	public void mostrarL () {
		for (T elem : lista) {
			System.out.println(elem);
		}
	}
	
	public static void main (String[] args) {
		Random rand = new Random();
		TestArrayList<Integer> al = new TestArrayList<>();
		
		int indice = rand.nextInt(40+1);
		
		
		for(int i=0; i< indice; i++) {
			al.agregar(rand.nextInt(4567+1));;
		}
		al.mostrarL();
	}
	
	
	
}