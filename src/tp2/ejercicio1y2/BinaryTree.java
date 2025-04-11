package tp2.ejercicio1y2;
import java.util.List;
import java.util.LinkedList;
import tp1.ejercicio8.Queue;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;
    
    public BinaryTree() {
    	super();
    }
    
    public BinaryTree(T data) {
    	this.data=data;
    }
    
    public T getData() {
    	return this.data;
    }
    
    public void setData(T data) {
    	this.data = data;
    }
    public BinaryTree<T> getLeftChild() { // preguntar siempre antes de invocar si hasLeftChild()/hasRightChild()
    	return this.leftChild;    	
    }

    public BinaryTree<T> getRightChild() {
    	return this.rightChild;    	
    }    
    
    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;	
    }
    
    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;	
    }
    
    public void removeLeftChild() {
        this.leftChild = null;
    }
    
    public void removeRightChild() {
        this.rightChild = null;
    }
    
    public boolean isLeaf() {
    	   return (!this.hasLeftChild() && !this.hasRightChild());
    }
    
    public boolean hasLeftChild() {
    	    return this.leftChild!=null;
    }
    	    
    public boolean hasRightChild() {
    	    return this.rightChild!=null;
    }
    
    @Override	    
   public String toString() {
    	    return this.getData().toString();
   }
    
    
    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }
    
    public int contarHojas() {
    	int cont=0;
    	if(this.isEmpty()) {
    		return 0;
    	}else {
    	  if(this.isLeaf()) {
    		  cont = 1;
    	  }else { 
    	    if (this.hasLeftChild()) {
    	  	  cont += this.getLeftChild().contarHojas();
    	    }
    	    if (this.hasRightChild()) {
    	  	  cont += this.getRightChild().contarHojas();
    	    }
    	  }
    	}
    	return cont;
    }
    
    public BinaryTree<T> espejo(){
    	
    	if (this.isEmpty()) {
    		return null;
    	}else {
    		BinaryTree<T> espe = new BinaryTree<T>(this.getData());
    		if (this.hasLeftChild()) {
    			  espe.addRightChild(this.getLeftChild().espejo());
    		}
    		if (this.hasRightChild()) {
  			  espe.addLeftChild(this.getRightChild().espejo());
  		}
    	return espe;
    	}
    }
    
    
    public void preOrden() {
    	System.out.println(this.getData());
    	if (this.hasLeftChild()) {
    		this.getLeftChild().preOrden();
    	}
    	if(this.hasRightChild()) {
    		this.getRightChild().preOrden();
    	}
    }
    
    public void inOrden() {
    	if (this.hasLeftChild()) {
    		this.getLeftChild().inOrden();
    	}
    	System.out.println(this.getData());
    	if (this.hasRightChild()) {
    		this.getRightChild().inOrden();
    	}
    }
    
    public void postOrden() {
    	if (this.hasLeftChild()) {
    		this.getLeftChild().postOrden();
    	}
    	if (this.hasRightChild()) {
    		this.getRightChild().postOrden();
    	}
    	System.out.println(this.getData());
    }
    
    
    public List<T> preorden(BinaryTree<T> ab) {
        List<T> result = new LinkedList<T>();
        this.preorden_private(ab, result);
        return result;
    }
    
    private void preorden_private(BinaryTree<T> ab, List<T> result) {
        result.add(ab.getData());
        if (ab.hasLeftChild()) {
          preorden_private(ab.getLeftChild(), result);
        }
        if (ab.hasRightChild()) {
          preorden_private(ab.getRightChild(), result);
        }
     }
 
    public void porNiveles() {
    	BinaryTree<T> ab = null;
        Queue<BinaryTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
        	ab = cola.dequeue();
          if (ab != null) {
        	System.out.println(ab.getData());
        	
        	if (ab.hasLeftChild()) {
        		cola.enqueue(ab.getLeftChild());
        	}
        	if(ab.hasRightChild()) {
        		cola.enqueue(ab.getRightChild());
        	}
          } else if(!cola.isEmpty()) {
        	  System.out.println();
        	  cola.enqueue(null);
          }
        }
        
    }
    
    public void porNivelesEntre(int n, int m) {
    	if (this.isEmpty()) return;
    	
        Queue<BinaryTree<T>> cola = new Queue<>();
        
        cola.enqueue(this);
        
        int level=0;

          while (!cola.isEmpty()) {
        	  
             int cantNodos= cola.size();
             
             if (level >= n && level <= m) {
                 for (int i=0; i<cantNodos; i++) {

                    	 BinaryTree<T> ab = cola.dequeue();
        	             System.out.println(ab.getData());

        	         if (ab.hasLeftChild()) {
        	  	         cola.enqueue(ab.getLeftChild());
        	         }
          	         if(ab.hasRightChild()) {
        	  	         cola.enqueue(ab.getRightChild());
         	         }
                 }
                 System.out.println();
             }  else  {
            	 for (int i=0; i<cantNodos; i++) {
            	   BinaryTree<T> nodo = cola.dequeue();
            	 
            	   if (nodo.hasLeftChild()) cola.enqueue(nodo.getLeftChild());
                   if (nodo.hasRightChild()) cola.enqueue(nodo.getRightChild());
            	 }
              }
             level++;
          }
        }
        
    
    
    
    public static void main  (String[] args) {
    	BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
    	BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
    	
    	hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
    	hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
    	
    	BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(78);
    	
    	ab.addLeftChild(hijoIzquierdo);
    	ab.addRightChild(hijoDerecho);

        System.out.println(" Arbol PreOrden: ");
    	ab.preOrden();
    	
    	System.out.println(" Arbol Inorden: ");
    	ab.inOrden();
    	
    }
    
    
    
}
