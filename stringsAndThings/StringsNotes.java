package stringsAndThings;

public class StringsNotes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating a string object
		// 1. using the String Class Constructors
		String s1 = new String("Hello");
		String s2 = new String(new char[] {'H', 'e', 'l', 'l', 'o'});
		String empty = new String();
		
		// 2. Use the shortcut with just quotes (omit the constructor)
		
		String s3 = "Hello";
		String empty2 = "";
		
		// 3. Using String class methods to create strings
		
		String s4 = "H".concat("ello");
		String s5 = "H" + "ello";
		
		String s6 = "Hello"; // points to the same object as s3
		
		// Strings are immutable: cannot be modified after creation
		// when concatenating, creates new objects and returns them 
		
		// using 'new' gives the string a new memory address
		
		// not using the constructor gives them the same memory address
		
		// using .equals makes them equal 
		// equals ignores case
		
		// other ways to compare strings: by letter or substring 
		char[] letters = s1.toCharArray();
		// or getting a specific character
		char firstLetter = s1.charAt(0);
		
		// substring - College Board lovessssss substring
		for(int i = 0; i < s1.length(); i++) {
			String pairsOfLetters = s1.substring(i, i + 2);
		}
		
		String s7 = "PI DAY PI";
		
		// use contains or indexOf 
		if(s7.contains("PI")) System.out.println("found PI");
		
		int index = s7.indexOf("PI");
		if(index != -1) {
			System.out.println("found PI");
			String pi = s7.substring(index, index + 2);
		}
		
		// lastIndex: searches from the end, but it still counts correctly 
		
		// compareTo - more useful than equals because it gives us string ordering 
		// considers case: all capital letters come before lowercase ones
		String A = "Rohan";
		String B = "Raj";
		if (A.compareTo(B) < 0) // A comes before B in the dictionary 
			System.out.println(A + " comes before " + B);
		else if (A.compareTo(B) > 0) // A comes after B in the dictionary 
			System.out.println(A + " comes after " + B);
		else if (A.compareTo(B) == 0) // A and B are the same
			System.out.println(A + " equals " + B);
		
		// compareToIgnoreCase 
		// shorter words come first 
		
		
		
		
		
	}

}
