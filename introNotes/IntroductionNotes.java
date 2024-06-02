package introNotes;

public class IntroductionNotes {
	// no global variables in java, largest scope is class level scope. ex:
	static int x = 3;
	
	public static void main(String[] args) {
		
		// method level scope
		int y; // variable declaration 
		y = 5; // variable initialization
		x = 10;
		
		y = test();
		//how to print
		
		y /= 2; // same as y = y/2
		
		x ++; //increment by one
		x --; //decrement by one
		
		System.out.println(x);
		System.out.println(y);
		
		
		
		// integer division - cutoff the decimal place
		// happens if you have the numerator and denominator as type int
		// float division (double) - use a float as either numerator or denominator
	}
	
	public static int test() { //method names are usually lower case/camel case: testSomeVariables
		x = 20;
		int y = 20; //you can reuse variable names in different scopes
		//System.out.println(x);
		//System.out.println(y);
		return y;
	}

}
