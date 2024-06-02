package arrays2D;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class knightsTourDisplay extends PApplet {
	public static void main(String[] args) {
		PApplet.main("arrays2D.knightsTourDisplay");
	}
	
	public void settings() { 
		size(300, 300);
	}
	
	PImage knightImage;
	PImage beenThereDoneThat;
	ArrayList<Square> answer;
	Knight arthur;
	int timesSolved;
	
	ArrayList<int[]> colorSchemes = new ArrayList<int[]>();
	
	
	int frame = 0;
	
	public void setup() {
		createSchemes(colorSchemes);
		
		knightImage = loadImage("Images/moon.png"); // because moon = night = knight haha
		beenThereDoneThat = loadImage("Images/moon2.png");
		int n = 8;
		arthur = new Knight(new Square(0, 0, 0), n, n);
			
		answer = arthur.solveClosed();
		fill(255);
		drawBoard(arthur.getBoard());
		
		
		
	}
	
	public void draw() {
		frameRate(30);
		
//		// putting the knight into position
//		if(frameCount % 2 == 1)
//		drawSolutionPart1(arthur.getBoard());
//		// replacing knight with star and drawing line
//		else
//		drawSolutionPart2(arthur.getBoard());
		drawBoard(arthur.getBoard());
		animateSolution(arthur.getBoard());
		
	
	}
	
	public void mouseClicked()  {
		exit();
	}

	public void drawBoard(boolean[][] board) {
		
		if (frame < board.length*board.length) {
		// draws the checkerboard
			float sqSize = ((float) width)/ board[0].length;
			for (int r = 0; r < board.length; r++) {
				for (int c = 0; c < board[r].length; c++) {
					noStroke();
					
					if ((r+c)%2 == 0) 
						fill(colorSchemes.get(timesSolved%colorSchemes.size())[0]);
					else 
						fill(colorSchemes.get(timesSolved%colorSchemes.size())[1]);
					
					for (int i = 0; i <= frame; i++) {
						if(r == answer.get(i).getRow() && c == answer.get(i).getColumn()) { 
							if ((r+c)%2 == 0) 
								fill(colorSchemes.get((timesSolved + 1)%colorSchemes.size())[0]);
							else 
								fill(colorSchemes.get((timesSolved + 1)%colorSchemes.size())[1]);
							
							}
					}
					
					
					rect(c*sqSize, r*sqSize, sqSize, sqSize);
				}
			}
		
		}
		
		
	}
	
	
	// but then i got bored so i made another 
	public void animateSolution(boolean[][] board) {
		if (frameCount%10 == 0) 
			frame++;
		
		if (frame == board.length*board.length) {
			frame = 0;
			timesSolved++; }
		
		if (frame < board.length*board.length) {
			Square nextMove = new Square(0, 0, 0);
			Square move = answer.get(frame);
			if (frame == board.length*board.length - 1) 
				nextMove = answer.get(0);
				
			else	
				nextMove = answer.get(frame + 1);
			
			
			int r = move.getRow();
			int c = move.getColumn();	
			int nr = nextMove.getRow();
			int nc = nextMove.getColumn();
			float sqSize = ((float) height)/ board.length;
			
			float lastX = c*sqSize + sqSize*.1f;
			float lastY = r*sqSize + sqSize*.1f;
			
			float nextX = nc*sqSize + sqSize*.1f;
			float nextY = nr*sqSize + sqSize*.1f;
			
			float change = frameCount % 10;
			
			float myX = lastX + (nextX - lastX)*change/10f;
			float myY = lastY + (nextY - lastY)*change/10f;
			
			
			image(knightImage, myX, myY, sqSize*.8f, sqSize*.8f);
			
			
			
		}	
		
	}
	
	public void createSchemes(ArrayList<int[]> scheme) {
		scheme.add(new int[] {color(24, 29, 49), color(103, 137, 131)});
		scheme.add(new int[] {color(230, 221, 196), color(240, 233, 210)});
		scheme.add(new int[] {color(255, 177, 0), color(251, 194, 82)});
		scheme.add(new int[] {color(163, 187, 152), color(78, 108, 80)});
		scheme.add(new int[] {color(255, 186, 186), color(200, 92, 142)});
		scheme.add(new int[] {color(230, 229, 163), color(169, 175, 126)});
		scheme.add(new int[] {color(240, 101, 12), color(255, 212, 149)});
		scheme.add(new int[] {color(134, 200, 188), color(206, 237, 199)});
		scheme.add(new int[] {color(194, 16, 16), color(255, 212, 178)});
		scheme.add(new int[] {color(199, 188, 161), color(139, 126, 116)});
		scheme.add(new int[] {color(157, 92, 13), color(247, 208, 138)});
		scheme.add(new int[] {color(123, 40, 105), color(176, 139, 187)});
		
	}
	
}
