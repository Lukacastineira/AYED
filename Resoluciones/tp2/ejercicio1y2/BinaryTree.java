package tp2.ejercicio1y2;

import tp1.ejercicio8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
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

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
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

	public  int contarHojas() {
	    return contarHojasHelper();
	}
	
	private int contarHojasHelper(){

		if (this.isLeaf()) {
			return 1;
		}
		
		int contar=0;
		
		if (this.hasLeftChild()) {
            contar += this.getLeftChild().contarHojasHelper();
		}
		
		if(this.hasRightChild()) {
			 contar += this.getRightChild().contarHojasHelper();
		}	
		
		return contar;
	   
	}
		
		
	public BinaryTree<T> espejo(){
		BinaryTree<T> ab = new BinaryTree<T>();
		this.espejoHelper(ab);
		return ab;
	}
    	 
    private void espejoHelper(BinaryTree<T> ab){
	    
	    ab.setData(this.getData());
	    
	    if (this.hasLeftChild()) {
	    	ab.addRightChild(new BinaryTree<T>());
	    	this.getLeftChild().espejoHelper(ab.getRightChild());
	    }
	    
    	if (this.hasRightChild()) {
    		ab.addLeftChild(new BinaryTree<T>());
    		this.getRightChild().espejoHelper(ab.getLeftChild());
    	}
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		this.entreNivelesHelper(n, m);
   }
	
	private void entreNivelesHelper(int n, int m) {
		BinaryTree<T> ab = new BinaryTree<T>();
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		
		int niveles = 0;
		
		cola.enqueue(this);
		cola.enqueue(null);
		if (n<=niveles && niveles <= m)
		    System.out.println("nivel " + niveles);
		
		while (!cola.isEmpty()) {
			
			ab = cola.dequeue();
			
			if(ab!=null) {
				if (n<=niveles && niveles <= m)
				    System.out.println(ab.getData());
				if (ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				
				if(ab.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
				}
				
				
			}else if (!cola.isEmpty()) {
				niveles += 1;
				if (n<=niveles && niveles <= m)
				    System.out.println("nivel " + niveles);
			}
			
			
		}
		
		
		
	}
		
}

