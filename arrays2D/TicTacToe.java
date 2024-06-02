package arrays2D;

import java.util.Scanner;

/*  
 * create a board that is an array of integers 
 * 
 * empty squares are 0
 * player squares are 1
 * computer squares are -1
 * 
 * checks to see if three in a row are the same value 
 * asks for player input 
 * after player move, computer makes a move
 * 
 */


public class TicTacToe {
	
	private int[][] board; 
	private int PLAYER = 1;
	private int COMPUTER = -1;
	private int winner = 0;
	
	/**
	 * generates a new tictactoe board
	 * board (3x3) all squares empty
	 * 
	 */
	public TicTacToe() {
		board = new int[3][3];
		
		for (int r = 0; r < board.length; r++)
			for (int c = 0; c < board[r].length; c++) 
				board[r][c] = 0;
	}
	/**
	 * empties all squares, sets to 0
	 */
	public void clearBoard() {
		for (int r = 0; r < board.length; r++)
			for (int c = 0; c < board[r].length; c++) 
				board[r][c] = 0;
		
		winner = 0;
	}
	
	/**
	 * places the human player in the location [r, c]
	 * @param r = row
	 * @param c = column
	 */
	public void playerMove(int r, int c) {
		board[r][c] = PLAYER;
	}
	
	/**
	 * places the computer player in the location [r, c]
	 * @param r = row
	 * @param c = column
	 */
	public void computerMove(int r, int c) {
		board[r][c] = COMPUTER;
	}
	
	/**
	 * easy mode
	 * @return a random integer array [r, c] that is a currently available coordinate on the board
	 */
	public int[] randomComputer() {
		int r = (int) (Math.random()*board.length);
		int c = (int) (Math.random()*board[r].length);
		
		if(moveAvailable(r, c))
			return new int[] {r, c};
		
		else return randomComputer();
	}
	
	/**
	 * if there is two of any player in a row, column, or diagonal, the computer will choose the blank square in that r, c, or d
	 * if there is a situation where there are two such rows, columns, or diagonals, the computer will choose the diagonal, then the row, then the column
	 * otherwise it returns a random available square
	 * 
	 * 
	 * @return an integer array [r, c]
	 */
	public int[] mediumComputer() {
		int r = (int) (Math.random()*board.length);
		int c = (int) (Math.random()*board[r].length);
		
		for (int i = 0; i < board.length; i++) {
			if (Math.abs(board[i][0] + board [i][1] + board[i][2]) == 2) {
				r = i;
				
				if (moveAvailable(r, c))
					return new int[] {r, c};
				
				break;
				}
			
			else if (Math.abs(board[0][i] + board[1][i] + board[2][i]) == 2) {
				c = i;
				
				if (moveAvailable(r, c))
					return new int[] {r, c};
				
				break;
			}
		}
		
		if (Math.abs(board[0][0] + board[1][1] + board[2][2]) == 2) {
			r = (int) (Math.random()*board.length);
			c = r;
		}
		
		else if (Math.abs(board[0][2] + board[1][1] + board[2][0]) == 2) {
			r = (int) (Math.random()*board.length);
			c = board[r].length - r - 1;
		}
		
		
		if (moveAvailable(r, c))
			return new int[] {r, c};
		
		else return mediumComputer();
		
		
	}
	// thinking about putting in an impossible computer AI in here using recursion and minimax, but i already did 
	// that in python and i think it would be uninteresting to implement again
	// it was cool and very inception-core but i probably won't do it
	
	/**
	 * 
	 * @param r
	 * @param c
	 * @return true if [r, c] is an available coordinate on the board, false otherwise
	 */
	
	public boolean moveAvailable(int r, int c) {
		return board[r][c] == 0;
	}
	
	/**
	 * decides if there is a winner and who it is
	 * @return true if there is a winner, false otherwise
	 */
	
	public boolean won() {
		for (int i = 0; i < board.length; i++) {
			if (Math.abs(board[i][0] + board [i][1] + board[i][2]) == 3) {
				winner = (board[i][0] + board [i][1] + board[i][2])/3;
				return true;
			}
			
			if (Math.abs(board[0][i] + board[1][i] + board[2][i]) == 3) {
				winner = (board[0][i] + board[1][i] + board[2][i])/3;
				return true;
			}
		}
		
		if (Math.abs(board[0][0] + board[1][1] + board[2][2]) == 3) {
			winner = (board[0][0] + board[1][1] + board[2][2])/3;
			return true;
		}
		
		if (Math.abs(board[0][2] + board[1][1] + board[2][0]) == 3) {
			winner = (board[0][2] + board[1][1] + board[2][0])/3;
			return true;
		}
		
		return false;
		
		
	}
	
	/**
	 * 
	 * @return false if there are any empty squares left, true otherwise
	 */

	public boolean boardFilled() {
		for (int[] row: board) {
			for (int value: row) {
				if (value == 0) 
					return false;
			}
		}
		
		return true;
	}

	public int[][] getBoard() {
		// TODO Auto-generated method stub
		return board;
	}
	
	public int getWinner() {
		return winner;
	}
	
	
	
}
