
public class IntLinkedListTester {

	public static void main(String[] args) {

		IntNode n = new IntNode(100000,null);
		n = addBeforeLast(n,10);
		n = addBeforeLast(n,100);
		n = addBeforeLast(n,1000);
		n = addBeforeLast(n,10000);



		System.out.println(n);
		System.out.println(n.next);
		System.out.println(n.next.next);
		System.out.println(n.next.next.next);
		System.out.println(n.next.next.next.next);



	}
	
	public static IntNode addBeforeLast(IntNode front, int item){
		
		IntNode n = new IntNode(item, null);
		IntNode tmp = front;
		
		if (tmp == null){
			return null;
		}
		
		if (tmp.next == null){
			n.next = tmp;
			return n;
		}
		
		if (tmp.next.next == null){
			n.next = tmp.next;
			tmp.next = n;
			return front;
		}
		
		while (tmp.next.next != null){
			tmp = tmp.next;
		}
		n.next = tmp.next;
		tmp.next = n;
		return front;
		
		
	}

}
