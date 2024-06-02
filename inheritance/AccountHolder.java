package inheritance;

public class AccountHolder {
	
	private String name;
	private int IDNum;
	private static int PERSON_COUNT = 0;
	private String address;
	
	public AccountHolder(String n) {
		name = n;
		IDNum = PERSON_COUNT;
		PERSON_COUNT++;
		address = Math.random()*100 + " Fake Road Drive";
	}

	public String getName() {
		return name;
	}

	public int getIDNum() {
		return IDNum;
	}
	
	public String getAddress() {
		return address;
	}

	
	
	

}
