package tp3.ejercicio8;
import tp3.ejercicio1I2y3.GeneralTree;
import java.util.List;

public class Navidad {
	
	private GeneralTree<Integer> abeto;
	
	public String esAbetoNavidenio() {
		boolean es = esAbetoNavidenioHelper(this.abeto);
		if (es) {
			return "Yes";
		}else
			return "no";
	}
	
	private boolean esAbetoNavidenioHelper(GeneralTree<Integer> ag) {
		if (ag.isLeaf()) return true; // no necesaria ya que afirma que la raiz tiene al menos dos hijos.
		
		int hijosHojas = 0;
		
	    List<GeneralTree<Integer>> children = ag.getChildren();
	    for(GeneralTree<Integer> child: children) {
	    	if (child.isLeaf()) hijosHojas++;
	    	else if (!esAbetoNavidenioHelper(child)) return false; // si no es hoja llamo recursivamente con ese hijo.
	    }
	    
	    return hijosHojas >= 3;
	}

	
}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
