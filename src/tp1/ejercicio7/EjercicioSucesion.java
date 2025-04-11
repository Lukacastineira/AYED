package tp1.ejercicio7;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class EjercicioSucesion {
	
	public ArrayList<Integer> calcularSucesion(int n){
		ArrayList<Integer> l= new ArrayList<>();
		l.add(n);
		while (n!=1){
			if (n % 2 == 0) {
				n=n/2;
			}else {
				n=3*n+1;
			}
			l.add(n);
		}
	    return l;
	}
	
	public void mostrarLista (ArrayList<Integer> l) {
		for(Integer elem:l) {
			System.out.println(elem);
		}
	}
	
	// metodo recursivo invierte el arraylist.
	
	public void invertirElementosList(ArrayList<Integer> l) { 
		if (l.size() <= 1) { // ccaso base si hay 0 o 1 datos en la lista.
			return;
		}
		
		Integer primero =l.remove(0); // tomo el primer dato y lo guardo como copia y lo elimino.
		invertirElementosList(l); // llamo recursivamente con la lista acortada.
		l.add(primero); // agrego los elementos a la ArrayList.
		}
    	
    // metodo calcule suma de elementos LinkedList.
	
	public int sumarLinkedList(LinkedList<Integer>lista) {
		if (lista.isEmpty()) {
			return 0;
		}
		
		Integer i = lista.removeLast();
		int suma = i +  sumarLinkedList(lista);
		lista.addLast(i);
		return suma;
	}
	
	
	
	// metodo combinar 2 listas ordenadas.
	
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> list1, ArrayList<Integer> list2){
		ArrayList<Integer> listaCombi = new ArrayList<>();
		int i =0; int j=0;
		while (i < list1.size() && j < list2.size()) {
		    if (list1.get(i) < list2.get(j)) {
		    	listaCombi.add(list1.get(i));
		    	i++;
		    }else {
			    listaCombi.add(list2.get(j));
			    j++;
		    }

		}
		// Agregar los elementos restantes de list1 (si hay)
		while (i < list1.size()) {
		    listaCombi.add(list1.get(i));
		    i++;
		}

		// Agregar los elementos restantes de list2 (si hay)
		while (j < list2.size()) {
		    listaCombi.add(list2.get(j));
		    j++;
		}
		
		
		return listaCombi;
	}
	
	
	public static void main (String[] args) {
		EjercicioSucesion ejS = new EjercicioSucesion();
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese primer numero de la sucesion: ");
		ArrayList<Integer> al = new ArrayList<> (ejS.calcularSucesion(s.nextInt()));
		ejS.mostrarLista(al);
		
		ejS.invertirElementosList(al);
		
		ejS.mostrarLista(al);
		
		LinkedList<Integer> list = new LinkedList<>();
		for (int i=0; i < 5; i++) {
			list.add(i);
		}
		
		System.out.println(ejS.sumarLinkedList(list));
		
		ArrayList<Integer> list1 = new ArrayList<>();
		for (int i=0; i < 3; i++) {
			list1.add(i*4);
		}
		
		ArrayList<Integer> list2 = new ArrayList<>();
		for (int i=0; i < 6; i++) {
			list2.add(i);
		}
		
		ArrayList<Integer> listCombinada = new ArrayList<Integer>(ejS.combinarOrdenado(list1, list2));
		System.out.println(" Lista Combinada: ");
		ejS.mostrarLista(listCombinada);
		
		s.close();
	}

}
