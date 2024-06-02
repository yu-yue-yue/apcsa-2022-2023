package recursion;

import processing.core.PApplet;

public class MondrianImage extends PApplet {

	public static void main(String[] args) {
		PApplet.main("recursion.MondrianImage");
	}
	
	public void settings() {
		size(600, 600);
	}
	
	public void setup() {
		mondrianRect(3, 0, 0, width, height);
	}
	
	public void draw() {
		
	}
	
	int[] colors = {
		color(0),
		color(255),color(255),color(255),color(255),color(255),color(255),
		color(0, 0, 255),
		color(255, 190, 0),
		color(255, 0, 0)
	};
	
	int minWidth, minHeight = 75;
	
	public void mondrianRect(int depth, float x, float y, float w, float h) {
		if (depth == 0 || w < minWidth || h < minHeight) {
			fill(colors[(int) (colors.length*Math.random())]);
			strokeWeight((float) Math.random()*5);
			rect(x, y, w, h);
			return;
		}
		
		float newX = (float) (0.6*w*Math.random() + x + 0.2*w);
		float newY = (float) (0.6*h*Math.random() + y + 0.2*h);
		// 1. generate 2 random numbers (x, x + w), (y, y + h)
		// 2. call recursive method in the 4 rectangles
		
		mondrianRect(depth - 1, x, y, newX - x, newY - y);
		mondrianRect(depth - 1, newX, y, w - newX + x, newY - y);
		mondrianRect(depth - 1, x, newY, newX - x, h - newY + y);
		mondrianRect(depth - 1, newX, newY, w - newX + x, h - newY + y);
	}
	
	public void mousePressed() {
		mondrianRect(3, 0, 0, width, height);
	}
}
