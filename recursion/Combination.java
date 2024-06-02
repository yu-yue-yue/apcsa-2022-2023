package recursion;

import processing.core.PApplet;

public class Combination extends PApplet {
	

	static long[][] combs;
	static int maxRows = 64;
	int rowsDisplayed = 64;
	int rectWidth, rectHeight;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("recursion.Combination");

	}
	
	public void settings() {
		size(1000, 600);
		
	}
	
	public void setup() {
		combs = new long[maxRows][]; // jagged array 
		for (int i = 0; i < maxRows; i++) 
			combs[i] = new long[i+1];
		
		combs[0][0] = 1;
		for (int i = 0; i < maxRows; i++)
			combination(maxRows-1, i); // initializing combination array
		
		rectWidth = width/rowsDisplayed;
		rectHeight = height/rowsDisplayed;
		
		background(255);
	}
	
	public void draw() {
		int x = width/2 - rectWidth/2;
		for (int r = 0; r < rowsDisplayed; r++) {
			for(int c = 0; c < r + 1; c++) {
				if (combs[r][c] % 2 == 0) fill (0, 10, 100);
				
				else fill(255, 100, 130);
				rect(x + c*rectWidth, r*rectHeight, rectWidth, rectHeight);
//				fill(0);
//				text("" + combs[r][c], x + (c + .5f)*rectWidth, (r + .5f)*rectHeight);
			}
			
			x -= rectWidth/2;
		}
		
	}
	
	public static long combination(int r, int c) {
		if (r >= maxRows)
			throw new IllegalArgumentException("r must be less than " + maxRows);
		if (c > r)
			throw new IllegalArgumentException("c must be less than or equal to r");
		// check if we already found this r, c
		if (combs[r][c] != 0)
			return combs[r][c];
		// base case:
		if (r == c || c <= 0) { 
			combs[r][c] = 1;
			return 1;
		}
		// recursion:
		
		
		combs[r][c] = combination(r-1, c) + combination(r-1, c-1);
		return (combination(r-1, c) + combination(r-1, c-1));
	}
	
	public static void printPascals(int n) {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c <= r; c++) System.out.print(combination(r, c) + " ");
			System.out.println();
		}
		
	}
	
	
	
	
}
