// Problem 4
public class Practice4{
	public static void main(String[] args){
		System.out.println("Enter a sequence of integers, terminated by zero");
		int a = IO.readInt();
		int even = 0;
		int odd = 0;

		while(a!=0){
			if(a%2==0){
				even++;
			}
			else{
				odd++;
			}
			a = IO.readInt();
		}

		System.out.println("even: "+even);
		System.out.println("odd: "+odd);
	}
}