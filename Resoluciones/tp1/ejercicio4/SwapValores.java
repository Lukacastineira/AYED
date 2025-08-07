package tp1.ejercicio4;

public class SwapValores {
    public static void swap1 (int x, int y) {
        if (x < y) {   // si num x menor a num y. 
            int tmp = x ;  // me guardo en tmp el valor de x.
            x = y ; // x = y
            y = tmp; // y = tmp o sea que igual a x.
        }
    }
    public static void swap2 (Integer x, Integer y) {
          if (x < y) {
              int tmp = x ;  // se hace lo mismo pero con wrappers como parametro.
              x = y ;
              y = tmp;
           }
    }
    public static void main(String[] args) {
    	 int a = 1, b = 2;
    	 Integer c = 3, d = 4;
    	 swap1(a,b);
    	 swap2(c,d);
    	 System.out.println("a=" + a + " b=" + b) ; // imprime 1 y 2
    	 System.out.println("c=" + c + " d=" + d) ;// imprime 3 y 4 
    	 
  /* 
 ¿los valores que adoptan las variables x, y coinciden con los valores impresos por
 consola? 
 no ya que al estarle pasando parametros por valor estos no van a modificarse c
 se vuelva al programa principal.
         */  	 
    }
}



