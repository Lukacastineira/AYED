package tp2.ejercicio3;
import tp2.ejercicio1y2.BinaryTree;
import java.util.List;
import java.util.LinkedList;

public class ContadorArbol {
	private BinaryTree<Integer> aE; 

	public ContadorArbol(BinaryTree<Integer> a) {
		this.aE = a;
	}
	
	public List<Integer> lParesSinOrden(){
		List<Integer> l = new LinkedList<Integer>();
		if(!aE.isEmpty()) {
			this.paresSinOrden(l, aE);
		}else {
			l = null;
		}
        return l;		
	}
	
	private void paresSinOrden (List<Integer> l, BinaryTree<Integer> a) {
		if (a.getData() % 2== 0) l.add(a.getData());
		if(a.hasLeftChild()) this.paresSinOrden(l, a.getLeftChild());
		if(a.hasRightChild()) this.paresSinOrden(l, a.getRightChild());
	} // PRE ORDER
	
	public List<Integer> lParesInOrden(){
		List<Integer> l= new LinkedList<Integer>();
		if(!this.aE.isEmpty()) { this.paresInOrden(l,this.aE);
		
		}else {
			l = null;
		}
        return l;
	}
	
	private void paresInOrden(List<Integer> l, BinaryTree<Integer> a) {
		if (a.hasLeftChild()) this.paresInOrden(l, a.getLeftChild());
		if (a.getData() % 2 == 0) l.add(a.getData());
		if (a.hasRightChild()) this.paresInOrden(l, a.getRightChild());
	} // In Order
	
	
	
	public List<Integer> lparesPostOrden (){
		List<Integer> l = new LinkedList<Integer>();
		if(!this.aE.isEmpty()) {
			this.paresPostOrden(l,this.aE);			
		}else {
			l = null;
		}
        return l;
	}
	
	private void paresPostOrden(List<Integer> l, BinaryTree<Integer> a) {
		if(a.hasLeftChild()) this.paresPostOrden(l, a.getLeftChild());
		if(a.hasRightChild()) this.paresPostOrden(l, a.getRightChild());
		if(a.getData() % 2 == 0) l.add(a.getData());
	}// Post Order
	
	public static void main (String[] args) {
		BinaryTree<Integer> a = new BinaryTree<Integer> (7);
		
		a.addLeftChild(new BinaryTree<Integer>(4));
		a.addRightChild(new BinaryTree<Integer>(9));
		
		a.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
		a.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
		
		a.getRightChild().addLeftChild(new BinaryTree<Integer>(8));
		a.getRightChild().addRightChild(new BinaryTree<Integer>(14));
		
		ContadorArbol cont = new ContadorArbol(a);
		
		System.out.println(" Imprimir los Pares del Arbol sin orden(PreOrden):");
		List<Integer> listaPreOrden = cont.lParesSinOrden();
		System.out.println(listaPreOrden);
		
		System.out.println(" Imprimir los Pares del Arbol en orden:");
		List<Integer> listaInOrden = cont.lParesInOrden();
		System.out.println(listaInOrden);
		
		System.out.println(" Imprimir los Pares del Arbol Post Orden:");
		List<Integer> listaPostOrden = cont.lparesPostOrden();
		System.out.println(listaPostOrden);
		
	}
	
	
	
	
}
