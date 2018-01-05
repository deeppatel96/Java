// Problem 2
public class Poly{
	public static void main(String[] args){
		System.out.println("Enter the first root:");
		int a = IO.readInt();
		System.out.println("Enter the second root:");
		int b = IO.readInt();
		System.out.println("Enter the third root:");
		int c = IO.readInt();
		System.out.println();
		System.out.println("The polynomial is:");
		int one = -a-b-c;
		int two = a*b+a*c+c*b;
		int three = -c*a*b;
		if (one>=0){
			System.out.print("x^3 + "+one);}
		else{
			System.out.print("x^3 - "+Math.abs(one));}
		if (two>=0){
			System.out.print("x^2 + "+two);}
		else{
			System.out.print("x^2 - "+Math.abs(two));}
		if (three>=0){
			System.out.println("x + "+three);}
		else{
			System.out.println("x - "+Math.abs(three));}
	}
}