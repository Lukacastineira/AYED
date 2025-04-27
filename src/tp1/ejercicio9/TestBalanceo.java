package tp1.ejercicio9;
import java.util.*;

/*  8)a) Voy a utilizar la estructura de datos stack que cada que entre
    un caracter de apertura voy a estar haciendo un push y cuando entre
    uno de cierre voy a estar haciendo un pop los demas caracteres los
    ignora. a su vez voy a guardar los caracteres de apertura en una 
    LinkedList y los de cierre en otra asi poder comparar de forma mas
    eficiente.

                                                                         */
public class TestBalanceo {
		
	public boolean estaBalanceado (String str) {
		List<Character> cie = new LinkedList<>();		
		    cie.add(')'); cie.add('}'); cie.add(']');
		
			List<Character> ape = new LinkedList<>();
			ape.add('(');  ape.add('{');  ape.add('['); 
			
			Stack<Character> stack = new Stack<Character>();
			
			Character act,elem; int i=0;
			
			while (i < str.length()){
				act = str.charAt(i);
				if(ape.contains(act)) {
					stack.push(act);
				}else if (cie.contains(act)){
					  if(stack.isEmpty()) {
						  return false;
					  }
					  elem = stack.pop();
					  if (ape.indexOf(elem) != cie.indexOf(act)) {
						  return false;
					  }
					  
				}
				i++;
			}
		return stack.isEmpty();
	}
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un String");
		String str = s.nextLine();
		
		s.close();
		
		TestBalanceo tb = new TestBalanceo();
		
	    if (tb.estaBalanceado(str)) {
	    	System.out.println("El String esta balanceado. ");
	    }else {
	    	System.out.println("El String no esta balanceado. ");
	    }
				
		
	}
}
