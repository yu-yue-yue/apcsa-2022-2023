package stringsAndThings;

import java.util.ArrayList;

public class ThingsNotes {

	public static void main(String[] args) {
		// Wrapper class - a class that boxes the primitive type into an object 
		// also adds some additional functions
		// including useful static methods.
		
		int x = 3;
		Integer x2 = 3;
		System.out.println(x * x2); // math operations are the same 
		System.out.println(x == x2); // works when comparing int to Integer
		
		// Because they are also objects, you can do some additional things with them.
		
//		x2 = null;
		
		// x = null gives an error 
		// wrapper classes are considered to be nullable
		
		Boolean b = null;
		
		// One real-life use is when getting data from a database file, some of the entries may be blank
		// We can use null to represent a blank entry 
		
		
		// Generics - type in java that represents any specific object type
		// syntax is <type>
		
		ArrayList<Object> nums = new ArrayList<Object>();
		nums.add("three");
		nums.add(3);
		nums.add(true);
		
		ArrayList<Integer> numsGood = new ArrayList<Integer>();
		numsGood.add(3); // boxing -> java taking the primitive int 3 and converting it to an object 
		
		// unboxing 
		int x3 = numsGood.get(0); // taking the object Integer and converting it to a primitive
		
	
		Integer x4 = 3; // the 'new' keyword gives the object a unique address 
		System.out.println(x2 + "," + x4);
		System.out.println(x2 == x4);
		
		// Most useful wrapper class functionality 
		System.out.println(Double.max(3.5, 4.5));
		
		int y = Integer.parseInt("101"); // can throw an exception 
		System.out.println(y + 1);
		
		boolean b2 = Boolean.parseBoolean("true");
		System.out.println(b2);
		b2 = Boolean.parseBoolean("no");
		System.out.println(b2);
		
		// Two types of errors when dealing with numeric types 
		// Overflow error
		
		int z = (int) (Math.pow(2, 32) - 1);
		z = Integer.MAX_VALUE;
		System.out.println(z);
		z++;
		System.out.println(z);
		
		double d2 = 0.10093048298498398;
		d2 *= 123298492;
		d2 /= 123298492;
		System.out.println(d2);
		
	}

}
