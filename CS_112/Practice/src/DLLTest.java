
public class DLLTest {

	public static void main(String[] args) {
		DLLNode front = new DLLNode("1",null,null);
// test with 1 node
		System.out.println(makeString(front));
		DLLNode uno = reverse(front);
		System.out.println(makeString(uno));
		
// test with 2 nodes
		DLLNode second = new DLLNode("2",null,front);
		front.next = second;
		
		System.out.println();
		System.out.println(makeString(front));
		DLLNode one = reverse(front);
		System.out.println(makeString(one));
		System.out.println();


// test with 5 nodes
		DLLNode third = new DLLNode("3",null,second);
		DLLNode fourth = new DLLNode("4",null,third);
		DLLNode fifth = new DLLNode("5",null,fourth);

		front.prev = null;
		front.next = second;
		second.prev = front;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		System.out.println(makeString(front));
		front = reverse(front);
		System.out.println(makeString(front));

	}
	
	
	public static DLLNode reverse(DLLNode front) {
        DLLNode tmp = front;
        DLLNode lasttmp;
        DLLNode nexttmp;
        DLLNode prevtmp;
        if (tmp == null){
        	return null;
        }
        else if(tmp.next == null){
        	return tmp;
        }
        else{
        	do{
	        	nexttmp = tmp.next;
	        	prevtmp = tmp.prev;
	        	tmp.prev = nexttmp;
	        	tmp.next = prevtmp;
	        	lasttmp = tmp;
	        	tmp = tmp.prev;
	        } while(tmp!=null);

        }
        return lasttmp;
       
  }
    public static String makeString(DLLNode front){
    	String answer = "";
    	DLLNode tmp = front;
    	if (tmp == null){
    		return answer;
    		}
    	else if(tmp.next == null){
    		answer+=front.data;
    	}
    	else{
            while(tmp!=null)
            {
            	answer+=tmp.data+"-->";
            	tmp = tmp.next;
            }
    	}
    	return answer;
    }

}
