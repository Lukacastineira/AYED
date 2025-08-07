package tp3.ejercicio9;
import tp3.ejercicio1I2y3.GeneralTree;
import java.util.List;
public class ParcialArboles {
	
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		if (arbol != null && !arbol.isEmpty()) return esDeSeleccionHelper(arbol);
		return false;
	}
	
	private static boolean esDeSeleccionHelper(GeneralTree<Integer> arbol) {
		
		if (arbol.isLeaf()) return true;
		
		int minHijo = Integer.MAX_VALUE;
		
		boolean es = true;
		
		List<GeneralTree<Integer>> children = arbol.getChildren();
		
		
		for (GeneralTree<Integer> child:children) {
			minHijo = Math.min(minHijo, child.getData());
			
			if (!esDeSeleccionHelper(child)) es = false;
		}
		
		if (arbol.getData() != minHijo) return false;
		
		
		return es;
		
		
	}
	
	private static boolean esDeSeleccionHelper2(GeneralTree<Integer> arbol) {
		if (arbol.isLeaf()) return true;

		int minHijo = Integer.MAX_VALUE;
		List<GeneralTree<Integer>> children = arbol.getChildren();

		for (GeneralTree<Integer> child : children) {
			if (!esDeSeleccionHelper2(child)) return false;
			minHijo = Math.min(minHijo, child.getData());
		}

		return arbol.getData() == minHijo;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static boolean esDeSeleccionS (GeneralTree<Integer> arbol) {
		if (arbol!= null && !arbol.isEmpty()) return esDeSeleccionSHelper(arbol);
		return false;
	}
	
	private static boolean esDeSeleccionSHelper(GeneralTree<Integer> arbol) {
		int min = Integer.MAX_VALUE;
		
		if (arbol.isLeaf()) return true;
		
		List<GeneralTree<Integer>> children = arbol.getChildren();
		for(GeneralTree<Integer> child:children) {
			min = Math.min(min, child.getData());
			if (!esDeSeleccionSHelper(child)) return false;
		}
		
		return arbol.getData() == min;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

