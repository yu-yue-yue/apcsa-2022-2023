package processing;

import processing.core.PApplet;

public class unit0Homework2 extends PApplet{

	public static void main(String[] args) {
		//"packageName.ClassName
		PApplet.main("processing.unit0Homework2");

	}
	public void settings() {
		// 2 options : 
//		fullScreen();
		size(800, 600); // width = 800, height = 600
	}
	
	
	// runs once at the beginning
	// do not capitalize up
	public void setup() {
		background(255);
	}
	
	
	int x = 0;
	int y = 0;
	
	// runs once every frame 
	public void draw() {
		
		background(255);
		
		ellipse(x, y, 5, 5);
		fill(255, 0, 0);
		

		x++;
		y++;


		
	}
}
