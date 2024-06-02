package introNotes;

public class recursionIntro {

	public static void main(String[] args) {
		// Recursion is when a method calls itself
		
	} 
	
	public static void goodRecursion(int depth) {
		
		if (depth == 0)
			return;
		System.out.println("Everthing is fine...");
		
		goodRecursion(depth - 1); 
		
	}
	
	
	public static void badRecursion() {
		System.out.println("Everything is fine...");
		badRecursion();
		
		
	}
	
	
	

}
