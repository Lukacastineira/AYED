package tp2.ejercicioAdicional2;
import tp2.ejercicio1y2.BinaryTree;
public class AlturaNodoBuscado {
     public int alturaNodo(BinaryTree<Integer> arbol, int num) {
    	 if (arbol != null && !arbol.isEmpty()) {
    		 return alturaNodoHelper(arbol,num);
    	 }else 
    		 return -1;
     }
     
     private int alturaNodoHelper(BinaryTree<Integer> ab, int valorBuscado) {
    	 if (ab.getData() == valorBuscado) {
    		 return calcularAltura(ab);
    	 }
    	 
    	 int alturaIzq = -1;
    	 int alturaDer = -1;
    	 if (ab.hasLeftChild()) {
    		 alturaIzq = this.alturaNodoHelper(ab.getLeftChild(), valorBuscado);
    	 }
    	 
    	 if (alturaIzq != -1) {
    		 return alturaIzq;
    	 }
    	 
    	 if (ab.hasRightChild()) {
    		 alturaDer = this.alturaNodoHelper(ab.getRightChild(), valorBuscado);
    	 }

    	 if (alturaDer != -1) {
    		 return alturaDer;
    	 }
    	 
    	 return -1; 
     }
     
     private int calcularAltura(BinaryTree<Integer> ab) {
    	 int hd=0;
    	 int hi=0;
    	 
    	 if (ab.hasLeftChild()) {
    		 hi = calcularAltura(ab.getLeftChild());
    	 }
    	 if (ab.hasRightChild()) {
    		 hd = calcularAltura(ab.getRightChild());
    	 }
    	 if (ab.isLeaf()) {
    		 return 0;
    	 }
    	 
    	 return 1 + (int)Math.max(hd, hi);
     }
}
