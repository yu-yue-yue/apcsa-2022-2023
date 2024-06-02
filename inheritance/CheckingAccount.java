package inheritance;

public class CheckingAccount extends Account {
	
	private final int OVERDRAFT_LIMIT = -100;
	
	public CheckingAccount(String name) {
		super(name);
		
	}
	
	@Override
	public void withdraw(double num) {
		if (this.getCurrentBalance() - num < OVERDRAFT_LIMIT) {
			System.out.println(this.getHolder().getName() + ", you may not withdraw this amount. Please try again.");
		}
		else super.withdraw(num);
		
		
	}
	
	@Override 
	public void monthlyUpdate() {
		super.monthlyUpdate();
		if (this.getCurrentBalance() < 0) {
			System.out.println("Overdraft fee: " + 10);
			this.setCurrentBalance(this.getCurrentBalance() - 10);
		}
		else System.out.println("Account in good standing.");
	}
	
	
}
