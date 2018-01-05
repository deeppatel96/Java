
import java.util.NoSuchElementException;

public class Stack<T> {
	
	Node<T> head;
	
	
	public boolean isEmpty(){
		
		if (head == null)
			return true;
		return false;
	}
	
	public T peek(){
	
		if (head!=null)
			return head.data;
		else
			return null;
		
	}
	
	public T pop(){
		
		if (head == null)
			throw new NoSuchElementException();
		
		T tmp = head.data;
		head = head.next;
		return tmp;
	}
	
	public void push(T data){
		Node<T> n = new Node<T>(data);
		n.next = head;
		head = n;
	}

}
