package arrays2D;

import processing.core.PApplet;
import processing.core.PImage;

public class NQueensProcessing extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("arrays2D.NQueensProcessing");
	}
	
	public void settings() {
		size(600, 600);
	}
	
	NQueensBoard queens;
	PImage queenImage;
	
	public void setup() {
		queenImage = loadImage("Images/pic0.jpg");
				
		int n = 8;
		int queenCount = 0;
		queens = new NQueensBoard(n);
		while(queenCount < n) {
			queens.scoreSpaces();
			queens.findAndPlace();
			queenCount++;
			
			if(queenCount == n) 
				break;
			
			if(!queens.checkBoard()) {
				queens.refreshBoard();
				queenCount = 0;
			}
		}
		
	}
	
	public void draw() {
		drawSolution(queens.getBoard());
		setup();
		
		frameRate(1);
		
		drawSolution(queens.getBoard());
		
	}
	
	public void drawBoard(int[][] board) {
		float sqSize = ((float) width)/ board.length;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if ((r+c)%2 == 0) fill(0, 50, 0);
				else fill(255, 230, 230);
				
				rect(c*sqSize, r*sqSize, sqSize, sqSize);
			}
		}
	}
	
	public void drawSolution(int [][] board) {
		float sqSize = ((float) width)/ board.length;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if ((r+c)%2 == 0) fill(0, 50, 0);
				else fill(255, 230, 230);
				
				rect(c*sqSize, r*sqSize, sqSize, sqSize);
				if (board[r][c] == -2) {
					image(queenImage, c*sqSize, r*sqSize, sqSize, sqSize);
				}
			}
		}
	}

}
