package tp3.ejercicio6;
import tp3.ejercicio1I2y3.GeneralTree;
import java.util.List;
public class RedDeAguaPotable {
	private GeneralTree<Character> arbol;
	
	
	public double minimoCaudal(double caudal) {
		if (this.arbol!=null && !this.arbol.isEmpty()) return minimoCaudalHelper(this.arbol,caudal);
		return -1;
	}
	
	private double minimoCaudalHelper(GeneralTree<Character> arbol, double caudal) {
		double cauMin = Double.MAX_VALUE;
		
		if (arbol.isLeaf()) 
			return caudal;
			
		double cantidadHijo = caudal / arbol.getChildren().size();
		
		List<GeneralTree<Character>> children = arbol.getChildren();
		for (GeneralTree<Character> child: children) {
			double caudalH = minimoCaudalHelper(child,cantidadHijo);
			cauMin = Math.min(cauMin,caudalH);
		}
		
		return cauMin;
	}

}   
