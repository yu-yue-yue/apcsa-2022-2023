package randomStuff;

import java.util.Arrays;
import java.util.Scanner;

public class twentyfortyeight {
	
	private int[][] board;
	
	public twentyfortyeight() {
		
		board = new int[4][4];
		
		for (int r = 0; r < board.length; r++)
			for (int c = 0; c < board[r].length; c++) 
				board[r][c] = 0;
		
		int x = (int) (Math.random()*4);
		int y = (int) (Math.random()*4);
		board[x][y] = 2;
		newPiece();
			
	}
	
	public boolean isOver() {
		for (int r = 0; r < board.length; r++)
			for (int c = 0; c < board[r].length; c++) {
				if (board[r][c] == 0) return false;
				
				int value = board[r][c];
				if (r > 0 && board[r - 1][c] == value) return false;
				if (r < board.length - 1 && board[r + 1][c] == value) return false;
				if (c > 0 && board[r][c - 1] == value) return false;
				if (c < board.length - 1 && board[r][c + 1] == value) return false;
			}
		
		return true;
	}

	public void newPiece() {
		int x = (int) (Math.random()*4);
		int y = (int) (Math.random()*4);
		int z = (int) (Math.random()*4);
		
		while(board[x][y] != 0) {
			x = (int) (Math.random()*4);
			y = (int) (Math.random()*4);
		}
		
		if (z == 0) board[x][y] = 4;
		else board[x][y] = 2;
	}

	public void printBoard() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
				
				
	}
	
	public void move(int move) {
		int[][] oldBoard = new int[4][4];
		// creating a duplicate
		for (int r = 0; r < board.length; r++)
			for (int c = 0; c < board[r].length; c++)
				oldBoard[r][c] = board[r][c];
	// for Console: 
		
//		Scanner sc = new Scanner(System.in);
//		String move = sc.next();
//		
//		if (move.equals("w")) moveUp();
//		if (move.equals("s")) moveDown();
//		if (move.equals("a")) moveLeft();
//		if (move.equals("d")) moveRight();
		// only add a new piece if the moves did something
		
		// for processing: 
		if (move == 0) moveUp();
		if (move == 1) moveDown();
		if (move == 2) moveRight();
		if (move == 3) moveLeft();
		
		boolean equals = true;
		
		for (int r = 0; r < board.length; r++)
			for (int c = 0; c < board[r].length; c++)
				if(oldBoard[r][c] != board[r][c]) {
					equals = false;
					break;
				}
		if(!equals) newPiece();
		
	}
	
	public void moveUp() {
		for(int c = 0; c < board[0].length; c++) {
			upConsolidate(c);
			upAdd(c);
			upConsolidate(c);
	
		}
	}
	
	private void upConsolidate(int column) {
		// pushes together but doesn't add
		int r = 0;
		int row = 0;
		while(r < board.length) {
			if (board[r][column] == 0) r++; 
			
			else if (r == row) {
				r++;
				row++;
			}
			else {
				board[row][column] = board[r][column];
				board[r][column] = 0;
				row++;
			}
		}
		
	}
	
	private void upAdd(int column) {
		for (int r = 0; r < board.length - 1; r++) {
			if (board[r][column] == board[r + 1][column]) {
				board[r][column] *= 2;
				board[r + 1][column] = 0;
			}
		}
	}
	
	
	
	public void moveDown() {
		for(int c = 0; c < board[0].length; c++) {
			downConsolidate(c);
			downAdd(c);
			downConsolidate(c);
	
		}
	}
	
	private void downConsolidate(int column) {
		// pushes together but doesn't add
			int r = board.length - 1;
			int row = board.length - 1;
			while(r >= 0) {
			if (board[r][column] == 0) r--; 
				
				else if (r == row) {
					r--;
					row--;
				}
				else {
					board[row][column] = board[r][column];
					board[r][column] = 0;
					row--;
				}
			}
	}
	
	private void downAdd(int column) {
		for (int r = board.length - 1; r > 0; r--) {
			if (board[r][column] == board[r - 1][column]) {
				board[r][column] *= 2;
				board[r - 1][column] = 0;
			}
		}
	}
	
	public void moveRight() {
		for(int r = 0; r < board.length; r++) {
			rightConsolidate(r);
			rightAdd(r);
			rightConsolidate(r);
	
		}
	}
	
	private void rightConsolidate(int row) {
		// pushes together but doesn't add
			int c = board[row].length - 1;
			int column = board[row].length - 1;
			while(c >= 0) {
			if (board[row][c] == 0) c--; 
				
				else if (c == column) {
					c--;
					column--;
				}
				else {
					board[row][column] = board[row][c];
					board[row][c] = 0;
					column--;
				}
			}
	}
	
	private void rightAdd(int row) {
		for (int c = board[row].length - 1; c > 0; c--) {
			if (board[row][c] == board[row][c - 1]) {
				board[row][c] *= 2;
				board[row][c - 1] = 0;
			}
		}
	}
	
	public void moveLeft() {
		for(int r = 0; r < board.length; r++) {
			leftConsolidate(r);
			leftAdd(r);
			leftConsolidate(r);
	
		}
	}
	
	private void leftConsolidate(int row) {
		// pushes together but doesn't add
			int c = 0;
			int column = 0;
			while(c < board.length) {
			if (board[row][c] == 0) c++; 
				
				else if (c == column) {
					c++;
					column++;
				}
				else {
					board[row][column] = board[row][c];
					board[row][c] = 0;
					column++;
				}
			}
	}
	
	private void leftAdd(int row) {
		for (int c = 0; c < board.length - 1; c++) {
			if (board[row][c] == board[row][c + 1]) {
				board[row][c] *= 2;
				board[row][c + 1] = 0;
			}
		}
	}

	public int[][] getBoard() {
		return board;
	}
	
}
