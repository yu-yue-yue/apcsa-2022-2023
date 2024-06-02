package introNotes;

public class ifElseExercises {

	public static void main(String[] args) {
		//go over exercises 
		int x = (int) Math.random()*101 - 50;
		System.out.println(x);
		if (x > 0)
			System.out.println("positive");
		else if (x == 0)
			System.out.println("zero");
		else 
			System.out.println("negative");
		//you only have to do brackets if you have more than one line
		
		int y = (int) Math.random()*100 + 1;
		if (y % 2 == 0)
			System.out.println("even");
		else 
			System.out.println("odd");
	}
	
	
	
	

}