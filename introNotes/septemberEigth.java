package introNotes;
import java.util.Scanner;

public class septemberEigth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int x = 1;
			
			while (x < 101) {
				System.out.println(x);
				x++; 
			}
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Please enter a number greater than 50: ");
			int input = sc.nextInt();
			
			while (input <= 50) {
				System.out.println("That number is not greater than 50. Please try again.");
				System.out.print("Please enter a number greater than 50: ");
				input = sc.nextInt();
				
			}
			System.out.println("Your number is " + input);
	}

}
