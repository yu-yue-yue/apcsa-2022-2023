package inheritance;

public class Account {
	private AccountHolder holder;
	private int accNum;
	private static int NUM_ACCOUNTS;
	private double currentBalance;
	
	public Account(String name) {
		holder = new AccountHolder(name);
		accNum = NUM_ACCOUNTS;
		currentBalance = 0;
	}
	
	public void withdraw(double num) {
		if (num < 0) System.out.println("that is not a valid input.");
		else currentBalance -= num;
	}
	
	public void deposit(double num) {
		if (num < 0) System.out.println("that is not a valid input.");
		else currentBalance += num;
	}
	
	public void monthlyUpdate() {
		System.out.println("Account Holder: " + holder.getName());
		System.out.println("Account ID: " + holder.getIDNum() + ";");
		System.out.println("Account Balance: " + currentBalance);
		
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public AccountHolder getHolder() {
		return holder;
	}

	public int getAccNum() {
		return accNum;
	}
	
	

}
