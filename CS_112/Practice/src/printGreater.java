
public class printGreater {

	public static void main(String[] args) {
		
		int[] H = {10,8,8,7,7,7,7,6,3,7,5,4,5,6,4,2,2,2,2,2,2,2,2};
		int n = H.length;
		printGreater(H,n,5);

	}

	public static void printGreater(int[] H, int n, int k){
		
		recPrint(H,n,k,0);
	}
	
	private static void recPrint(int[] H, int n, int k, int r){
		
		if(r>=n){
			return;
		}
		else if (H[r]<=k){
			return;
		}
		else{
			System.out.print(H[r]+", ");
			recPrint(H,n,k,2*r+1);
			recPrint(H,n,k,2*r+2);
		}
	}
	
}
