public class PracticeFinal3{


	public static void main(String[] args){

		System.out.println("Enter decimal number");
		double x = IO.readDouble();
		System.out.println("Enter decimal place to round to");
		int n = IO.readInt();
		System.out.println(round(x,n));
	}


	public static double round(double x, int n){
		
		if (n <= 0)
		{
			return Math.round(x);
		}
		else
		{
			return round(x*10,n-1)/10;
		}
	}

}