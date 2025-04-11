package tp2.ejercicio9;
import tp2.ejercicio1y2.BinaryTree;


public class ParcialArboles {
	
	
	
	
	public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol){
	   if (arbol.isEmpty() || arbol.getData() == null) return null;
	   BinaryTree<int[]> ab = new BinaryTree<int[]>();
	   this.pasarDatos(arbol, ab, 0, null);
	   return ab;
	}
	 
	 
	 private void pasarDatos(BinaryTree<Integer> a, BinaryTree<int []> b, int suma, Integer padre) {
		if (a.isEmpty() || a.getData() == null) return; 
		
		int valorActual = a.getData();
		int sumaActual = suma + valorActual;
		int diferencia; 

		
		if (padre == null) {
			diferencia=0;
		}else {
			diferencia = valorActual - padre; 
		}
		
        int [] dato = new int[2];
		dato[0]=sumaActual;
		dato[1]=diferencia; 
		
		b.setData(dato);
		
		if (a.hasLeftChild()) {
			b.addLeftChild(new BinaryTree<>());
			this.pasarDatos(a.getLeftChild(), b.getLeftChild(), sumaActual, valorActual);
		}
		if(a.hasRightChild()) {
			b.addRightChild(new BinaryTree<>());
			this.pasarDatos(a.getRightChild(), b.getRightChild(), sumaActual, valorActual);
		}
		
		
	 }
}
