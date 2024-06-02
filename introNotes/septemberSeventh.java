package introNotes;
import java.util.*;

public class septemberSeventh {
	static int input;
	static int winCounter = 0;
	static int drawCounter = 0;
	static int loseCounter = 0;
		
	public static void guess() {
		Scanner sc = new Scanner(System.in);
		
		try {		
			System.out.println("Guess a number between 1-6: ");
			int guess = sc.nextInt();

			
			if (guess >= 1 && guess <=6) {
				input = guess;
			}
			else {
				System.out.println("That is not a valid guess.");
				System.out.println("Guess must be an integer between 1 and 6.");
				guess();
			}
			}
		
		catch (InputMismatchException e) {
			System.out.println("That is not a valid guess.");
			System.out.println("Guess must be an integer between 1 and 6.");
			guess();
		}
		
		
		
	}
	
	public static void play() {
		Scanner sc = new Scanner(System.in);
		
		int x = (int) (Math.random()*(6) + 1);
		guess();
		
		if (input == x) {
			System.out.println("You won. The number was " + x);
			winCounter ++;
		}
		
		else if (Math.abs(input - x) == 1) {
			System.out.println("You drew. The number was " + x);
			drawCounter ++;
		}
		
		else {
			System.out.println("You lost. The number was " + x);
			loseCounter ++;
		}
		
	}
	
	public static boolean playAgain() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to play again? Please type yes or no.");
		String answer = sc.next();
		boolean playOrNot = false;
		
		if (answer.equals("yes")) {
		playOrNot = true;
		}
		
		else if (answer.equals("no")) {
		playOrNot = false;
		}
			
		else {
		System.out.println("That is not a valid answer. Please type yes or no.");
		playAgain(); 
		
		}
		return playOrNot;
	}
		

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Roll Dice!");
		System.out.println();
		play(); 
		while (playAgain()) {
			System.out.println();
			play();
		}
		System.out.println("Game Over.");
		System.out.println("You won " + winCounter + " times.");
		System.out.println("You drew " + drawCounter + " times.");
		System.out.println("You lost " + loseCounter + " times.");
		
	}
			
		

}
