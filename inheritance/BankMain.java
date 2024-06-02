package inheritance;

public class BankMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckingAccount c1 = new CheckingAccount("Julie");
		CheckingAccount c2 = new CheckingAccount("Harry");
		CheckingAccount c3 = new CheckingAccount("Jed");
		CheckingAccount c4 = new CheckingAccount("Hank");
		
		SavingsAccount s1 = new SavingsAccount("Jane");
		SavingsAccount s2 = new SavingsAccount("Hattie");
		SavingsAccount s3 = new SavingsAccount("Jerry");
		SavingsAccount s4 = new SavingsAccount("Hal");
		
		Bank b = new Bank();
		b.addAccount(c1);
		b.addAccount(c2);
		b.addAccount(c3);
		b.addAccount(c4);
		
		b.addAccount(s1);
		b.addAccount(s2);
		b.addAccount(s3);
		b.addAccount(s4);
		
		c1.deposit(25000);
		c2.deposit(25000);
		c3.deposit(25000);
		c4.deposit(25000);
		
		c1.withdraw(30);
		c2.withdraw(25000);
		c3.withdraw(25100);
		c4.withdraw(26000);
		
		s1.deposit(25000);
		s2.deposit(25000);
		s3.deposit(25000);
		s4.deposit(25000);
		
		s1.withdraw(30);
		s2.withdraw(25000);
		s3.withdraw(25100);
		s4.withdraw(10);
		s4.withdraw(10);
		s4.withdraw(10);
		s4.withdraw(10);
		s4.withdraw(10);
		s4.withdraw(10);
		s4.withdraw(10);
		
		
		
		b.monthlyUpdate();
	
	}

}
