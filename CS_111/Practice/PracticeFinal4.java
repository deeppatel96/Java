public class PracticeFinal4{


	public static void main(String[] args){

		System.out.println("Enter String");
		String x = IO.readString();
		System.out.println(backwards(x));
	}

	public static String backwards(String x){
		
		int len = x.length();
		if(len<=1){
			return x;
		}
		else{
			return x.charAt(len-1) + backwards(x.substring(0,len-1));
		}

	}

}