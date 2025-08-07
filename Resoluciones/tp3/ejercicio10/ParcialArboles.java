package tp3.ejercicio10;
import tp3.ejercicio1I2y3.GeneralTree;
import java.util.List;
import java.util.LinkedList;

public class ParcialArboles {
	
	public static List<Integer> resolver (GeneralTree<Integer> arbol){
		List<Integer> listaAct = new LinkedList<Integer>();
		List<Integer> listaMax = new LinkedList<Integer>();
		int[] sumaMax = {Integer.MIN_VALUE};
		resolverHelper(arbol,listaAct,listaMax,0,0,sumaMax);
		return listaMax;
	}
	
	private static void resolverHelper(GeneralTree<Integer> arbol,List<Integer> listaAct, List<Integer> listaMax, int nivel, int sumaNodo, int[] sumaMax) {
		
		int dato = arbol.getData();
		int sumaEsteNodo = sumaNodo + dato * nivel;
		
		if (dato == 1) {
			listaAct.add(dato);
		}
		
		if (!arbol.isLeaf()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for (GeneralTree<Integer> child:children) {
				resolverHelper(child,listaAct,listaMax,nivel++,sumaEsteNodo,sumaMax);
			}
		}else{
			if (sumaEsteNodo > sumaMax[0]) {
				sumaMax[0] = sumaEsteNodo;
				listaMax.removeAll(listaMax); //listaMax.clear();
				listaMax.addAll(listaAct);
			}
		}
		
		if (dato == 1) {
			listaAct.remove(listaAct.size()-1); // BackTracking
		}
			
	}
	
	
}
