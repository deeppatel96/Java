// Problem 2
public class TwoSmallest{
	public static void main(String[] args){
		System.out.println("Enter a real number to be the terminating value");
		double t = IO.readDouble();

		double a;
		System.out.println("Enter a real number");
		a = IO.readDouble();
		while(a==t){
			IO.reportBadInput();
			System.out.println("Enter a real number");
			a = IO.readDouble();
		}
		double Smallest1 = a;
		double Smallest2;

		System.out.println("Enter a real number");
		a = IO.readDouble();
		while(a==t){
			IO.reportBadInput();
			System.out.println("Enter a real number");
			a = IO.readDouble();
		}

		if (a<Smallest1){
			Smallest2 = Smallest1;
			Smallest1 = a;
		}
		else{
			Smallest2 = a;
		}

		while(true){
			if (a==t){break;}
			System.out.println("Enter a real number");
			a = IO.readDouble();

			if (a!=t && a<=Smallest1){
				Smallest2 = Smallest1;
				Smallest1 = a;}

			else if (a!=t && a<Smallest2){
				Smallest2 = a;}
		}
		IO.outputDoubleAnswer(Smallest1);
		IO.outputDoubleAnswer(Smallest2);
	}
}