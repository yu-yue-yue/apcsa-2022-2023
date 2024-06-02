package inheritance;

public class Tetris {
	
	private int[][] board;
	public final int FILLED = 1;
	public final int EMPTY = 0;
	public final int CURRENT = 2;
	
	public Tetris() {
		board = new int[22][12];
		for(int r = 0; r < board.length; r++)
			for (int c = 0; c < board[r].length; c++) 
				board[r][c] = EMPTY;
	}
	
	public void refresh() {
		for (int c = 0; c < board[board.length].length; c++) 
			if (board[board.length][c] == FILLED) gameOver();
		
		for(int r = 0; r < board.length; r++) {
			if (checkRow(r)) {
				for (int c = 0; c < board[r].length; c++) 
					board[r][c] = EMPTY;
			}
		}
		
	}
	
	private boolean checkRow(int r) {
		// returns false if any of the squares in a row are empty 
		for (int c = 0; c < board[r].length; c++) {
			if (board[r][c] == 0) return false;
		}
		// returns true if all of the squares in the row are true 
		return true;
	}
	
	public void gameOver() {
		return;
	}
	

}
