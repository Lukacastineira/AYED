package tp1.ejercicio7;
import java.util.ArrayList;
import java.util.Scanner;
public class EsCapicua {
    
    public boolean esCapicua(ArrayList<Integer> lista) {
        int izquierda = 0; // indice primer elemento
        int derecha = lista.size() - 1; // indice ultimo elemento

        while (izquierda < derecha) {
            if (!lista.get(izquierda).equals(lista.get(derecha))) {
                return false;
            }
            izquierda++; 
            derecha--; 
        }
        return true;
    }
    
    
    public static void main (String[] args) {
    	ArrayList<Integer> l = new ArrayList<>();
    	EsCapicua es = new EsCapicua();
    	Scanner s = new Scanner(System.in);
    	System.out.println(" Ingrese cantidad de elementos a agregar a lista: ");
    	int n=s.nextInt();
    	for (int i=0; i<n; i++) {
    		System.out.println("Ingrese numero a agregar a la lista: ");
    		Integer num = s.nextInt();
    		l.add(num);
    	}
    	for (Integer elem:l) {
    		System.out.println(elem+ "\n");
    	}
    	
    	if (es.esCapicua(l)) {
    		System.out.println(" La lista es Capicua. ");
    	}else {
    		System.out.println(" La lista no es Capicua. ");
    	}
    	s.close();
    }

}
