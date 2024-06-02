package introNotes;
//import java.util.InputMismatchException;
//import java.util.Scanner;
import java.util.*;

public class RandomAndScanner {
	
	public static void grade() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your grade: ");
		// defensive programming 
		try {
			int grade = sc.nextInt();
			
			if(grade == 9) {
				System.out.println("You are a freshman.");
			}
			
			else if (grade == 10) {
				System.out.println("You are a sophomore.");
			}
				
			else if (grade == 11) {
				System.out.println("You are a junior.");
				
			}
			
			else if (grade == 12) {
				System.out.println("You are a senior.");
			}
			
			else {
				System.out.println("You are not in high school.");
				
			}

		}
		catch (InputMismatchException e) {
			System.out.println("Invalid input. Must be an integer.");
			System.out.println();
			grade(); 
		}
		
	}

	public static void main(String[] args) {
		// returns a double between 0 (inclusive) and 1(exclusive) [0, 1)
		int range = 1000; //# of random values
		int offset = 1;
		
		double x = (int) (Math.random()*range + offset);
		// System.out.println(x);
		
//		Random ran = new Random();
//		ran.netInt(10);
		
		// calling the Scanner class constructor to create a Scanner object 
		// use the "new" keyword
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your name: ");
		String name = sc.nextLine(); 
		// string concatenation
		System.out.println("Hello, " + name + '.');
		grade();
		
		// || logical or 
		// && logical and
		// !  logical not
		
	}

}
