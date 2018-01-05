//Practice 2
public class Practice2{
	public static void main(String[] args){
		System.out.println("What is the base monthly fee?");
		double base = IO.readDouble();
		System.out.println("How many minutes are included in this base fee?");
		double basemin = IO.readDouble();
		System.out.println("What is the overage charge rate per minute?");
		double overagerate = IO.readDouble();
		System.out.println("How many minutes did you use this month?");
		double totalmin = IO.readDouble();

		double overmin = totalmin-basemin;
		double overage = overagerate*overmin;
		double bill;
		if(overmin<=0){
			bill=base;
		}
		else{
			bill = base+overage;
		}
		System.out.println("Your cellphone bill is: "+bill);
	}
}