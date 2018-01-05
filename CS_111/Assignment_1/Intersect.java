// Problem 3 - Intersect
public class Intersect{
	public static void main(String[] args){
		System.out.println("Enter the constant d:");
		double d = IO.readDouble();
		System.out.println("Enter the constant f:");
		double f = IO.readDouble();
		System.out.println("Enter the constant g:");
		double g = IO.readDouble();
		System.out.println("Enter the constant m:");
		double m = IO.readDouble();
		System.out.println("Enter the constant b:");
		double b = IO.readDouble();
		double A = d;
		double B = f-m;
		double C = g-b;
		double root = (B*B)-4*A*C;
		double x1 = (-B+Math.sqrt(root))/(2*A);
		double x2 = (-B-Math.sqrt(root))/(2*A);
		double y1 = m*x1+b;
		double y2 = m*x2+b;
		System.out.println("The intersection(s) is/are:");
		if (root==0){
			System.out.println("("+x1+","+y1+")");}
		else if (root<0){
			System.out.println("none");}
		else{
		System.out.println("("+x1+","+y1+")");
		System.out.println("("+x2+","+y2+")");}
	}
}