package tp2.ejercicio9;
import tp2.ejercicio1y2.BinaryTree;


public class ParcialArboles {
	
	
	public BinaryTree<ObjParcial> sumAndDif(BinaryTree<Integer>arbol){
		if (arbol != null &&!arbol.isEmpty()) {
			BinaryTree<ObjParcial> abP = new BinaryTree<ObjParcial>();
			this.sumaAndDifHelper(abP,arbol,0,0);
			return abP;
		}else
			return null;
	}
	
	private void sumaAndDifHelper(BinaryTree<ObjParcial> abP, BinaryTree<Integer> ab, int sumaTotal, int valorPadre) {
		
		int suma = sumaTotal + ab.getData();
		int diferencia = ab.getData() - valorPadre;
		
		ObjParcial obj = new ObjParcial(suma,diferencia);
		
		abP.setData(obj);
		
		if (ab.hasLeftChild()) {
			abP.addLeftChild(new BinaryTree<ObjParcial>());
			sumaAndDifHelper(abP.getLeftChild(),ab.getLeftChild(),suma,ab.getData());
		}
		
		if(ab.hasRightChild()) {
			abP.addRightChild(new BinaryTree<ObjParcial>());
			sumaAndDifHelper(abP.getRightChild(),ab.getRightChild(),suma,ab.getData());
		}
		
		
		
	}
}
