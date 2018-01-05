// Problem 5
public class Practice5{
	public static void main(String[] args){
		System.out.println("How much money do you want to put in your savings account?");
		double principle = IO.readDouble();
		System.out.println("What percent interest does your bank give monthly?");
		double interest = IO.readDouble();
		double twice = principle*2;
		principle = principle*(1+interest/100);
		int month = 1;
		double deposit;
		while(principle<twice){
			month++;
			System.out.println("How much would you like to deposit for month number "+month+"?");
			deposit = IO.readDouble();
			while(deposit<0){
				IO.reportBadInput();
				System.out.println("How much would you like to deposit for this next month?");
				deposit = IO.readDouble();}
			principle = (principle+deposit)*(1+interest/100);}

		if(month>1){
			System.out.println("It will take "+month+" months to double your initial deposit");}
		else{
			System.out.println("It will take "+month+" month to double your initial deposit");}

	}
}