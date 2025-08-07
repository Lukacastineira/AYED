package ParcialArboles;
import tp3.ejercicio1I2y3.GeneralTree;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import tp1.ejercicio8.Queue;
public class ParcialArboles {
	GeneralTree<Integer> arbol;
	
	public List<Integer> nivel (int num){
		List<Integer> lista = new LinkedList<Integer>();
		if (this.arbol!=null && !this.arbol.isEmpty()) {
			this.nivelHelper(this.arbol,lista,num);
		}
		return lista;
	}
	
	private void nivelHelper (GeneralTree<Integer> arbol,List<Integer> lista, int num ) {
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        GeneralTree<Integer> aux = new GeneralTree<Integer> ();
        
        boolean encontre = true;    
        boolean termina = false;
        cola.enqueue(arbol);
        cola.enqueue(null);
        List<Integer> listaAux = new LinkedList<Integer>();
        
        if (arbol.hasChildren() && arbol.getChildren().size() >= num) {
        	termina = true; 
        	lista.add(arbol.getData());
        }
        s
        while (!termina && !cola.isEmpty()) {
        	aux = cola.dequeue();
        	
        	if (aux != null) {
                
                if (aux.hasChildren() && aux.getChildren().size()>=num) {
                    listaAux.add(aux.getData());
                }else {
                	encontre = false;
                }
                    
        		List<GeneralTree<Integer>> children = aux.getChildren();
        		Iterator<GeneralTree<Integer>> it = children.iterator();
        		while (it.hasNext()) {
        			cola.enqueue(it.next());		
        		}
        		
        	}else if (!cola.isEmpty()) {
                if (encontre && !listaAux.isEmpty()) {
                	termina = true ;
                    lista.addAll(listaAux);
                }
                listaAux.clear();
                encontre = true;
                cola.enqueue(null);
            }
	    }
	
    }
}  
