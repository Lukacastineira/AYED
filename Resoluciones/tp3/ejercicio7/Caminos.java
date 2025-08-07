package tp3.ejercicio7;
import tp3.ejercicio1I2y3.GeneralTree;
import java.util.List;
import java.util.LinkedList;

public class Caminos {
	private GeneralTree<Integer> arbol;

	// con BackTracking
	public List<Integer> caminoAHojaMasLejana (){
		
		List<Integer> listaActual = new LinkedList<Integer>();
		List<Integer> listaMaximo = new LinkedList<Integer>();
		
		if (this.arbol != null && !this.arbol.isEmpty()) this.caminoAHojaMasLejanaHelper(arbol, listaActual, listaMaximo);
		return listaMaximo;
	}
	
	private void caminoAHojaMasLejanaHelper (GeneralTree<Integer> arbol, List<Integer> listaAct , List<Integer> listaMax){
		listaAct.add(arbol.getData());
		if (!arbol.isLeaf()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for (GeneralTree<Integer> child:children) {
				this.caminoAHojaMasLejanaHelper(child, listaAct, listaMax);
			}

		}else if (listaAct.size() > listaMax.size()){
			listaMax.clear();
			listaMax.addAll(listaAct);
		}

		listaAct.remove(listaAct.size()-1);
		
	}
	
	// sin BackTracking
		public List<Integer> caminoAHojaMasLejanaPost (){
			List<Integer> listaActual = new LinkedList<Integer>();
			List<Integer> listaMaximo = new LinkedList<Integer>();
			
			if (this.arbol != null && !this.arbol.isEmpty()) return this.caminoAHojaMasLejanaHelperPost(arbol, listaActual, listaMaximo);
			return listaMaximo;
		}
		
		private List<Integer> caminoAHojaMasLejanaHelperPost (GeneralTree<Integer> arbol, List<Integer> listaAct , List<Integer> listaMax){
			listaAct.add(arbol.getData());
			if (arbol.isLeaf()) {
				listaAct.add(0,arbol.getData());
				return listaAct;
			}

			List<GeneralTree<Integer>> children = arbol.getChildren();
			for (GeneralTree<Integer> child:children) {
				listaAct = this.caminoAHojaMasLejanaHelperPost(child, listaAct, listaMax);	
				
				if (listaAct.size() > listaMax.size()) {
					listaMax.clear();
					listaMax.addAll(listaAct);
					
				}
			}
			
			
			listaMax.add(0, arbol.getData());
			
			return listaMax;
		}
	
}
