//Practice 3
public class Practice3{
	public static void main(String[] args){
		System.out.println("Enter a year:");
		int year = IO.readInt();
		boolean leapyear = true;

		if (year%4!=0){
			leapyear = false;
		}
		if(year%100==0){
			leapyear = false;
		}
		if(year%400==0){
			leapyear = true;
		}
		
		System.out.println(leapyear);
	}
}