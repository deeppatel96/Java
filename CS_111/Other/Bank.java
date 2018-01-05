public class BankAccount{

	String type;
	double balance;
	String owner;
	int accountNumber;
	int pin;

	public BankAccount(String accountType, double amount, String person, int number, int pinn){

		type = accountType;
		balance = amount;
		owner = person;
		acountNumber = number;
		pin = pinn;
	}

	public double withdraw(double amount, int pinn){
		if (pin == pinn && balance>amount && amount>0){
			balance-=amount;
			return amount;
		}
		else{
			return 0;
		}
	}
	public boolean deposit(double amount, int pinn){
		if (pin == pinn && amount>0){
			balance+=amount;
			return true;
		}
		else{
			return false;
		}




}