package arrays2D;

import java.util.ArrayList;

public class NQueensBoard
{
	private int[][] board;
	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}



	public final int QUEEN = -2;
	public final int ELIMINATED = -1;
	
	public static void main(String[] args) {
		int n = 4;
		int queenCount = 0;
		NQueensBoard queens = new NQueensBoard(n);
		while(queenCount < n) {
			queens.scoreSpaces();
			queens.findAndPlace();
			queenCount++;
			System.out.println(queenCount);
			
			if(queenCount == n) 
				break;
			
			if(!queens.checkBoard()) {
				queens.refreshBoard();
				queenCount = 0;
			}
		}
		
		queens.printGrid();
		
		
	}
	
	/**
	 * constructor
	 * initializes board to be of size n-by-n and containing all zeroes
	 */
	public NQueensBoard(int n) {
		board = new int[n][n]; 	
	}
	
	/**
	 * sets value of all cells in board to 0
	 */
	public void refreshBoard() {
		board = new int[board.length][board.length];
		}

	/**
	 * prints the contents of each square in board in tabular format
	 * if square contains QUEEN, print 'Q'
	 * if square contains ELIMINATED, print '~'
	 * otherwise, print '-'
	 */
	public void printGrid() {
		
		// EX: Queen in the top left of a 4x4
		// Q ~ ~ ~
		// ~ ~ - - 
		// ~ - ~ -
		// ~ - - ~
		
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if (board[r][c] == QUEEN) System.out.print("Q ");
				else if (board[r][c] == ELIMINATED) System.out.print("~ ");
				else System.out.print("- ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * calls scoreSquare method for each square on board
	 * places result from each call to scoreSquare in that square in board
	 */
	public void scoreSpaces() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++)
				board[r][c] = scoreSquare(r, c);
		}
		
	}

	/**
	 * returns true if there is an available square on board
	 * returns false if there are no available squares
	 */
	public boolean checkBoard() {
		for (int[] row : board) {
			for (int value : row) {
				if (value > 0) return true;
			}
		}
		
		return false;
		
	}
	
	/**
	 * changes the value of board[row][col] to QUEEN
	 * changes the value of all squares that are eliminated by this queen to ELIMINATED 
	 */
	public void placeQueen(int row, int col) {
		
		for (int r = 0; r < board.length; r++) 
			board[r][col] = ELIMINATED;
		for (int c = 0; c < board.length; c++) 
			board[row][c] = ELIMINATED;
		
		for (int i = 1; i < board.length; i++) {
			if (row + i < board.length && col + i < board[0].length && board[row + i][col + i] >= 0) 
				board[row + i][col + i] = ELIMINATED;
			if (row + i < board.length && col - i >= 0 && board[row + i][col - i] >= 0) 
				board[row + i][col - i] = ELIMINATED;
			if (row - i >= 0 && col - i >= 0 && board[row - i][col - i] >= 0) 
				board[row - i][col - i] = ELIMINATED;
			if (row - i >= 0 && col + i < board[0].length && board[row - i][col + i] >= 0) 
				board[row - i][col + i] = ELIMINATED;
		}
		
		board[row][col] = QUEEN;
	}
	
	/**
	 * returns ELIMINATED if square at row, col contains ELIMINATED 
	 * returns QUEEN if square at row, col contains QUEEN
	 * otherwise, counts the number of squares that would become unavailable 
	 * if the square at row, col were to receive a queen (including the 	  
       	 * square at row,col); this count is returned
	 */
	public int scoreSquare(int row, int col) {

		if(board[row][col] < 0) 
			return board[row][col];
		int score = 0; 
		
		// adding rows and columns
		for (int c = 0; c < board[0].length; c++) {
		if (board[row][c] >= 0)
			score++; }
		
		score--; // avoid double counting
		
		for (int r = 0; r < board.length; r++) {
			if(board[r][col] >= 0)
				score++; } 
		
		// figuring out how many diagonals to add
		
		for (int i = 1; i < board.length; i++) {
			if (row + i < board.length && col + i < board[0].length && board[row + i][col + i] >= 0) 
				score++;
			if (row + i < board.length && col - i >= 0 && board[row + i][col - i] >= 0) 
				score++;
			if (row - i >= 0 && col - i >= 0 && board[row - i][col - i] >= 0) 
				score++;
			if (row - i >= 0 && col + i < board[0].length && board[row - i][col + i] >= 0) 
				score++;
			
		}
		
		
		return score;
		
	}
	
	/**
	 * calculates the smallest non-negative score on the board
	 * determines the number of squares that contain this score
	 * randomly selects one of these squares 
	 * calls placeQueen method to place a queen in this square
	 */
	public void findAndPlace() {
		
		int min = board.length * board.length;
		for(int r = 0; r < board.length; r++) {
			for (int c= 0; c < board[r].length; c++) 
				if(board[r][c] < min && board[r][c] >= 0)
					min = board[r][c]; }
		
		ArrayList<Pos> minPos = new ArrayList<Pos>();
		
		for(int r = 0; r < board.length; r++) 
			for (int c = 0; c <board[r].length; c++)
				if(board[r][c] == min)
					minPos.add(new Pos(r,c));
		
		Pos p = minPos.get((int) (Math.random()*minPos.size()));
		placeQueen(p.r, p.c);
	}
	
	

	public class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
}