package inheritance;

import processing.core.PApplet;

public class Food extends GameParts implements Drawable {

	private int x;
	private int y;
	private Board board;
	
	/** 
	 * sets a random open square on the board to be food
	 * @param b
	 */
	public Food(Board b) {
		board = b;
		
		do {x = (int) (Math.random()*board.getBoard().length);
		y = (int) (Math.random()*board.getBoard()[x].length);
		} while (board.getBoard()[x][y] != OPEN);
		
		board.setSquare(x, y, FOOD);
	}
	
	/**
	 * draws the food in p
	 */
	@Override
	public void draw(PApplet p) {
		float xc = (float) p.width/board.getBoard().length*(x + .5f);
		float yc = (float) p.height/board.getBoard()[x].length*(y + .5f);
		
		float diameter = (float) p.width/board.getBoard().length;
		p.noStroke();
		p.fill(255, 0, 0);
		p.ellipse(xc, yc, diameter*.9f, diameter*.9f);
	}
	
	
}
