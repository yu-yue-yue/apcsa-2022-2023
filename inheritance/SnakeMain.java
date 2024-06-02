package inheritance;

import java.util.HashSet;
import java.util.Set;

import processing.core.PApplet;

public class SnakeMain extends PApplet{

	public static void main(String[] args) {
		PApplet.main("inheritance.SnakeMain");
	}
	
	public void settings() {
		size(600, 600);
	}
	
	Board b;
	Food f;
	Snake s;
	
	int direction = 0;
	Set<Integer> toMove = new HashSet<Integer>(); 
	
	public void setup() {
		b = new Board();
		f = b.getFood();
		s = new Snake(b);
		drawBoard();
	}
	
	public void drawBoard() {

		b.draw(this);
		f.draw(this);
		s.draw(this);
		
	}
	
	public void draw() {
		
		frameRate(120);
		
		if (frameCount%20 == 0) {
			Integer[] directions = toMove.toArray(new Integer[toMove.size()]);
			if (directions.length == 0) s.move(0);
			else s.move(directions[directions.length - 1]);
			
			f = b.getFood();
			drawBoard();
			direction = 0;
			
		}
		
		if(GameParts.gameOver) {
			gameOver();
		};
		
	}
	
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) toMove.add(1);
			else if (keyCode == DOWN) toMove.add(2);
			else if (keyCode == RIGHT) toMove.add(-1);
			else if (keyCode == LEFT) toMove.add(-2);
			
		}
	}
	
	public void keyReleased() {
		if (key == CODED) {
			if (keyCode == UP) toMove.remove(1);
			else if (keyCode == DOWN) toMove.remove(2);
			else if (keyCode == RIGHT) toMove.remove(-1);
			else if (keyCode == LEFT) toMove.remove(-2);
			
		}
	}
	
	public void restart() {
		
	}
	
	public void gameOver() {
		background(0);
		fill(255, 0, 0);
		textSize(100);
		text("Game Over.", 25, 200);
		textSize(30);
		text("Click the screen to start again.", 60, 300);
	}
	
	public void mouseClicked() {
		if (GameParts.gameOver) {
			setup();
		}
	}
}
