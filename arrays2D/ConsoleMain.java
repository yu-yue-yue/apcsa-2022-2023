package arrays2D;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMain {
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		play(game);
		
	}
	
	public static void printBoard(TicTacToe t) {
		// prints out the board 
				for (int[] row: t.getBoard()) {
					for (int value: row) {
						if (value == 1)
							System.out.print("X");
						else if (value == -1)
							System.out.print("O");
						else 
							System.out.print("_");
						
						System.out.print(" ");
					}
					System.out.println();
				}
	}
	
	public static void play(TicTacToe t) {
		while(!t.won() && !t.boardFilled()) {
			printBoard(t);
			getPlayer(t);
			if (t.boardFilled() || t.won()) break;
			getComputer(t);
		
		}
			
		printBoard(t);
		System.out.println("Game Over:");
		if(t.getWinner() == 0) System.out.println("Draw.");
		else if(t.getWinner() > 0) System.out.println("You won.");
		else System.out.println("You lost.");
				
	}
	
	public static void getPlayer(TicTacToe t) {
		Scanner rowScan = new Scanner(System.in);
		System.out.print("Row: ");
		int moveR = rowScan.nextInt();
		Scanner columnScan = new Scanner(System.in);
		System.out.print("Column: ");
		int moveC = columnScan.nextInt();
		
		if (moveR < 0 || moveR > 2 || moveC < 0 || moveC > 2) {
			System.out.println("That is not a valid move. Please try again.");
			getPlayer(t);
		}
		
		else if (!t.moveAvailable(moveR, moveC)) {
			System.out.println("That is not a valid move. Please try again.");
			getPlayer(t);
		}
		
		else t.playerMove(moveR, moveC);
		
	}
	
	public static void getComputer(TicTacToe t) {
		t.computerMove(t.randomComputer()[0], t.randomComputer()[1]);
		
	}

}
