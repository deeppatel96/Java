
public class HeapDriver {

	public static void main(String[] args) {
		
		
		String[] n = {"A","X","Z","A","E","K","Y","Z","H","S","I","B","D"};
		for(int i = 0; i<n.length;i++){
			System.out.print(n[i]+", ");
		}
		Heapsort h = new Heapsort();
		h.sort(n);
		System.out.println();
		for(int i = 0; i<n.length;i++){
			System.out.print(n[i]+", ");
		}
	}

}
