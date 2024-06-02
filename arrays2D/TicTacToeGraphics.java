package arrays2D;

import processing.core.PApplet;

public class TicTacToeGraphics extends PApplet{

	public static void main(String[] args) {
		PApplet.main("arrays2D.TicTacToeGraphics");
	}
	
	public void settings() {
		size(600, 600);
		
	}
	
	// determines who is playing - the person is always first
	boolean humanPlayer = true;
	
	// difficulty - false is easy, true is hard
	boolean difficulty = false;
	// are we on the beginning screen or not
	boolean beginning = true;
	
	TicTacToe game = new TicTacToe();
	public void setup() {
		// sets up the screen for choosing difficulty
		background(0);
		fill(255);
		textSize(40);
		text("Easy", width/2 - 50, height/4);
		text("Hard", width/2 - 50, height/4*3);
		
	}
	
	public void blank() {
		//draws blank board with no Xs or Os
		background(255, 255, 200);
		
		stroke(175, 155, 100);
		strokeWeight(15);
		
		line(0, 200, 600, 200);
		line(0, 400, 600, 400);
		
		line(200, 0, 200, 600);
		line(400, 0, 400, 600);
	}
	
	public void draw() {

	// draws the gameOver screen	
		if (game.boardFilled() || game.won()) 
			gameOver(game);
		
		// if mouseClicked was recently called, it plays the computer play, then waits for mouseClicked to be called again
		else if (! humanPlayer) {
			delay(500);
			placeComputer(game);
		}
		
	}
	
	public void placeComputer(TicTacToe t) {
		int r, c;
		// hard
		if (difficulty) {
			r = t.mediumComputer()[0];
			c = t.mediumComputer()[1];
		}
		// easy
		else {
			r = t.randomComputer()[0];
			c = t.randomComputer()[1];
		}

		// draws out the computer's move
		t.computerMove(r, c);
		stroke(100, 50, 0);
		noFill();
		ellipse(r*200 + 100, c*200 + 100, 100, 100);
		// switches the current player to the human player, once again waiting for mouseClicked
		humanPlayer = true;
	}
	
	public void placePlayer(TicTacToe t) {
		int r, c;
		// finding the row
		if (mouseX > width/3*2) 
			r = 2;
		else if (mouseX > width/3)
			r = 1;
		else r = 0;
		
		// finding the column
		if (mouseY > height/3*2) 
			c = 2;
		else if (mouseY > height/3)
			c = 1;
		else c = 0;
		
		// if the player clicks on an unavailable square or the game is over, nothing happens
		if (t.moveAvailable(r, c) && !t.won() && !t.boardFilled()) {
			// draws out the player's move
			stroke(100, 50, 0);
			t.playerMove(r, c);
			line(r*200 + 50, c*200 + 50, r*200 + 150, c*200 + 150);
			line(r*200 + 50, c*200 + 150, r*200 + 150, c*200 + 50);
			// switches to computer's turn
			humanPlayer = false;
		}
		
		
	}
	
	public void gameOver(TicTacToe t) {
		// draws the game over square
		fill(255);
		noStroke();
		rect(width/4, height/4, width/2, height/2);
		fill(0);
		textSize(40);
		text("Game over", width/4 + 20, height/4 + 80);
		// who the winner is
		if (t.getWinner() == 0) text("Draw. ", width/4 + 20, height/4 + 180);
		else if (t.getWinner() > 0) text("You won. ", width/4 + 20, height/4 + 180);
		else text("You lost. ", width/4 + 20, height/4 + 180);
		
		textSize(20);
		text("Press any key to restart.", width/4 + 20, height/4 + 280);
		
	}
	
	public void mouseClicked() {
		if (beginning) {
			// hard
			if (mouseY > height/2) difficulty = true;
			// otherwise easy
			
			blank();
			// calls blank again
			beginning = false;
		}
		
		
		else placePlayer(game);
		
	}
	
	public void keyPressed() {
		// restart everything
		setup();
		beginning = true;
		game.clearBoard();
		difficulty = false;
		humanPlayer = true;
	}
	
	
}
