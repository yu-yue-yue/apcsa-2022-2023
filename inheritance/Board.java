package inheritance;

import processing.core.PApplet;

public class Board extends GameParts implements Drawable {

	private int[][] board;
	private Food food;
	
	/**
	 * draws a board of 17 by 17 for the snake to run in 
	 * creates a new food in the board
	 * edge pieces are all walls
	 */
	public Board() {
		gameOver = false;
		board = new int[17][17];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if(r == 0 || c == 0 || 
					r == board.length - 1 || c == board[r].length - 1)
					board[r][c] = WALL;
				else board[r][c] = OPEN;

			}
		}
		
		setFood(new Food(this));
		
	}
	@Override
	/**
	 * draws the board in p
	 */
	public void draw(PApplet p) {
		for (int r = 0; r < board.length; r++) {
			
			for (int c = 0; c < board[r].length; c++) {
				if (board[r][c] == WALL) p.fill(0);
				else if ((r + c) % 2 == 0) p.fill(100);
				else p.fill(50);
				
				float xc = (float) p.width/board.length*r;
				float yc = (float) p.height/board[r].length*c;
				float squareSize = (float) p.width/board.length;
				
				p.rect(xc, yc, squareSize, squareSize);
		
			}
		}
		
	}
	
	/**
	 * 
	 * @return the board
	 */
	public int[][] getBoard() {
		return board;
	}
	/**
	 * sets [r][c] on the board to the value
	 * @param r
	 * @param c
	 * @param value
	 */
	public void setSquare(int r, int c, int value) {
		board[r][c] = value;
	}

	
	public Food getFood() {
		return food;
	}
	
	public void setFood(Food food) {
		this.food = food;
	}
	
	
}
