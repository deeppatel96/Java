
import java.util.NoSuchElementException;

public class Queue<T> {

	Node<T> tail;
	
	public boolean isEmpty(){
		if (tail == null)
			return true;
		return false;
		
	}
	
	public void enqueue(T data){
		Node<T> n = new Node<T>(data);
		if (tail == null){
			
			tail = n;
			tail.next = tail;
		}else{
			n.next =tail.next;
			tail.next = n;
			tail = n;
		}
	}
	
	public T dequeue(){
		if (tail == null)
			throw new NoSuchElementException();
		T tmp = tail.next.data;
		if (tail == tail.next)
			tail = null;
		else{
			tail.next = tail.next.next;
		}
		
		return tmp;
		
	}
	
}