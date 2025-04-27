package tp1.ejercicio8;
import java.util.*;



public class Queue<T> extends Sequence<T>{
	protected List<T> data;
	
	public Queue() {
        this.data = new ArrayList<>();
    }
	
	public void enqueue(T dato) {
		data.add(dato);
	}

	public T dequeue() {
	  return data.remove(0);
	}

	public T head() {
	  return data.get(0);
	}

	@Override
	public int size() {
		return this.data.size();
	}

	@Override
	public boolean isEmpty() {
		return this.data.isEmpty();
	}

	@Override
	public String toString() {
		String str;
		str = "[";
		for (T d:data) {
			str = str + d + " ";
		str = str.substring(0, str.length()-2)+ "]";
		}
		return str;
	}
	
	
}
