package introNotes;
import java.util.*;

public class PrimeNumbers {
	
	public static boolean primeOrNot(double variable) {

		for (int i = 2; i <= Math.sqrt(variable); i++) {
			if (variable % i == 0) {
				return false;
			}	
		}
		return true;
	}	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Please enter a number: ");
				double input = sc.nextInt(); 
				if (input == 0)
					break;
				
				if (primeOrNot(input) == true) {
					System.out.println("This number is prime.");
					System.out.println();
				}
				
				else {
					System.out.println("This number is not prime.");
					System.out.println();
				}
			}	
			
			catch (InputMismatchException e) {
				System.out.println("Invalid input. Must be an integer.");
				System.out.println();
				break;
				
			}
		}	
	}
}
