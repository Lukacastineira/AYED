package tp2.ejercicio3;
import tp2.ejercicio1y2.BinaryTree;
import java.util.LinkedList;
import java.util.List;

public class ContadorArbol {
	private BinaryTree<Integer> ab;
	
	
	
	
	public List<Integer> numerosParesPre() {
		  List<Integer> lista = new LinkedList<Integer>();
		  this.numerosParesHelperPre(lista,this.ab);
		  return lista;
	}
	
	// PreOrden
	private void numerosParesHelperPre(List<Integer> lista, BinaryTree<Integer> ab){
		
		if (ab.getData() % 2 == 0)
			lista.add(ab.getData());
		
		if (ab.hasLeftChild()) {
			this.numerosParesHelperPre(lista, ab.getLeftChild());
		}
		
		if (ab.hasRightChild()) {
			this.numerosParesHelperPre(lista, ab.getRightChild());
		}
	}
	
	public List<Integer> numerosParesIn(){
		List<Integer> lista = new LinkedList<Integer>();
		this.numerosParesHelperIn(lista,this.ab);
		return lista;
	}
	
	// InOrden
	private void numerosParesHelperIn(List<Integer> lista, BinaryTree<Integer> ab) {
		
		if (ab.hasLeftChild()) {
			this.numerosParesHelperIn(lista, ab.getLeftChild());
		}
		
		
		if (ab.getData() % 2 ==0)
			lista.add(ab.getData());
		
		if (ab.hasRightChild()) {
			this.numerosParesHelperIn(lista, ab.getRightChild());
		}
		
	}
	
	public List<Integer> numerosParesPost(){
		List<Integer> lista = new LinkedList<Integer>();
		this.numerosParesHelperPost(lista,this.ab);
		return lista;
	}
	
	//PostOrden
    private void numerosParesHelperPost(List<Integer>lista, BinaryTree<Integer>ab) {
    	
    	if (ab.hasLeftChild()) {
    		this.numerosParesHelperPost(lista, ab.getLeftChild());
    	}
    	
    	if (ab.hasRightChild()) {
    		this.numerosParesHelperPost(lista, ab.getRightChild());
    	}
    	
    	if (ab.getData() % 2 == 0)
    		lista.add(ab.getData());
    }
	
	

}
