// Problem 3
public class NthPrime{
	public static void main(String[] args){
		System.out.println("Enter an integer 'n' to get the nth prime");
		int n = IO.readInt();

		while(n<1){
			IO.reportBadInput();
			System.out.println("Enter an integer 'n' to get the nth prime");
			n = IO.readInt();
		}

		int i = 0;
		double count = 0;
		while(i<=n){
			count++;
			int x = 0;
			for(double count2 = count;count2>0;count2--){
				if (count%count2 == 0){
					x++;	
				}
			}
			if (x<=2){
				i++;	
			}
		}
		int answer = (int) count;
		IO.outputIntAnswer(answer);
	}
}