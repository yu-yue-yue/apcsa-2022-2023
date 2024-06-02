package inheritance;

import java.util.ArrayList;

public class Bank {
	ArrayList<Account> accounts;
	
	public Bank() {
		accounts = new ArrayList<Account>();
	}
	
	public void monthlyUpdate() {
		for (Account acc : accounts) {
			acc.monthlyUpdate();
			System.out.println();
		}

	}
	
	public void addAccount(Account a) {
		accounts.add(a);
	}
	

}
