package inheritance;

public class SavingsAccount extends Account {
	private final double INTEREST_RATE = 0.4;
	private final int WITHDRAWAL_MAX = 6;
	private int numWithdrawals;
	
	public SavingsAccount(String name) {
		super(name);
		numWithdrawals = 0;
	}
	
	@Override
	public void withdraw(double num) {
		if ((this.getCurrentBalance() - num) < 0) {
			System.out.println(this.getHolder().getName() + ", you may not withdraw this amount. Please try again.");
		}
		
		if (numWithdrawals == WITHDRAWAL_MAX) {
			System.out.println(this.getHolder().getName() + ", you have reached your withdrawal maximum this month.");
		}
		
		else {
			super.withdraw(num);
			numWithdrawals++;
		}
	}
	
	@Override 
	public void monthlyUpdate() {
		if(this.getCurrentBalance() > 0) this.setCurrentBalance(this.getCurrentBalance()*(1 + INTEREST_RATE/100));
		super.monthlyUpdate();
		if(this.getCurrentBalance() > 0) System.out.println("Interest Earned: " + this.getCurrentBalance()*(INTEREST_RATE/100));
		else System.out.println("Interest: 0");
		numWithdrawals = 0;
	}

}
