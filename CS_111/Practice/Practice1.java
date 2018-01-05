// Problem
public class Practice1{
	public static void main(String[] args){
		System.out.println("What is the total sales charge?");
		double total = IO.readDouble();
		System.out.println("How much is the customer giving");
		double cash = IO.readDouble();

		double change = cash - total;
		int twenty=0;
		int ten=0;
		int five=0;
		int one=0;
		int quarter=0;
		int dime=0;
		int nickel=0;
		int penny=0;
		while(change>=20){
			twenty++;
			change-=20;
		}
		while(change>=10){
			ten++;
			change-=10;
		}while(change>=5){
			five++;
			change-=5;
		}while(change>=1){
			one++;
			change-=1;
		}while(change>=0.25){
			quarter++;
			change-=0.25;
		}
		while(change>=0.10){
			dime++;
			change-=0.10;
		}while(change>=0.05){
			nickel++;
			change-=0.05;
		}while(change>=0.01){
			penny++;
			change-=0.01;
		}

		System.out.println("The change is:");
		if (twenty>0){,
			if(twenty==1){
			System.out.println(twenty+" $20 bill");}
			else {
			System.out.println(twenty+" $20 bills");}
		}
		if (ten>0){
			if(ten==1){
			System.out.println(ten+" $10 bill");}
			else {
			System.out.println(ten+" $10 bills");}
		}
		if (five>0){
			if(five==1){
			System.out.println(five+" $5 bill");}
			else {
			System.out.println(five+" $5 bills");}
		}
		if (one>0){
			if(one==1){
			System.out.println(one+" $1 bill");}
			else {
			System.out.println(one+" $1 bills");}
		}
		if (quarter>0){
			if(quarter==1){
			System.out.println(quarter+" quarter");}
			else {
			System.out.println(quarter+" quarters");}
		}
		if (dime>0){
			if(dime==1){
			System.out.println(dime+" dime");}
			else {
			System.out.println(dime+" dimes");}
		}
		if (nickel>0){
			if(nickel==1){
			System.out.println(nickel+" nickel");}
			else {
			System.out.println(nickel+" nickels");}
		}
		if (penny>0){
			if(penny==1){
			System.out.println(penny+" penny");}
			else {
			System.out.println(penny+" pennies");}
		}
	}
}