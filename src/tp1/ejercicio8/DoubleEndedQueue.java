package tp1.ejercicio8;

public class DoubleEndedQueue<T> extends Queue<T> {
	
    public void enqueueFirst(T data) {
    	super.data.add(0, data);; //Accedo a la variable protegida data del padre por medio de super y agrego data en la primera posicion.
    }
}
