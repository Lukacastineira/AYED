package tp1.ejercicio8;
import java.util.Queue;

public class TestQueue<T> {
    private Queue<T> cola;
    
    public TestQueue() {
    	
    }
    
    public void enqueue(T elem) {
    	this.cola.offer(elem);
    }
    
    public T dequeue() {
        return this.cola.poll();
    }
    
    public T head() {
    	if (!this.cola.isEmpty()) {
    		return this.cola.peek();
    	}else {
    		return null; // si la cola esta vacia devuelve null
    	}               // no se si es necesario chequear pero 
    	               // por si acaso chequeo que no este vacia.
    }
    
    public boolean isEmpty() {
    	return this.isEmpty();
    }
    
    public int size () {
    	return this.cola.size();
    }
    

    public String toString() {
    	return this.cola.toString();
    }
    
    
    
    
}
