package recursion;

import processing.core.PApplet;

public class FlowerPower extends PApplet {
	
	public static void main(String[] args) {
		PApplet.main("recursion.FlowerPower");
	}
	
	public void settings() {
		size(600, 600);
		
	}
	
	final int DEPTH = 5;
	final float FLOWER_DIAMETER = 10;
	final float MIN_LENGTH_FACTOR = 0.25f;
	final float MAX_LENGTH_FACTOR = 0.90f;
	final float MIN_ANGLE_CHANGE = 2.0f;
	final float MAX_ANGLE_CHANGE = 35.0f;
	int[] colors = {
		color(250, 124, 70),
		color(194, 26, 8),
		color(237, 151, 138),
		color(250, 228, 140),
		color(237, 151, 138),
		color(255, 191, 28),
		color(252, 229, 73)
	};
	
	public void setup() {
		drawBackground();
		drawFlower(width/3);
		drawFlower(width/3*2);
	}
	
	public void draw() {
		
	}
	
	final int GROUND_HEIGHT = 70;
	public void drawBackground() {
		// draw sky background 
		background(213, 242, 250);
		fill(192, 78, 12);
		noStroke();
		rect(0, height - GROUND_HEIGHT, width, GROUND_HEIGHT);
		
	}
	
	public void drawFlower(float x) {
		float length = random(50, 150);
		float angle = random(-95, -85); //-angles because y values increase going down
		Branch root = new Branch(x, height-GROUND_HEIGHT, length, angle);
		drawRecursiveFlower(DEPTH, root);
	}
	
	private void drawRecursiveFlower(int depth, Branch b) {
		//draw branch first
		stroke(19, 80, 133); //stroke instead of fill because using lines
		strokeWeight(depth); //the closer to the flowers (depth 0) the thinner the lines get
		line(b.getBaseX(), b.getBaseY(), b.getEndX(), b.getEndY());
			
		// Base case: 
		
		if (depth == 0) {
			noStroke(); 
			fill(colors[(int) random(colors.length)]);
			ellipse(b.getEndX(), b.getEndY(), FLOWER_DIAMETER, FLOWER_DIAMETER);
			return;
		}
		
		int numBranches = (int) random(3, 8);
		for (int i = 0; i < numBranches; i++) {
			float length = random(MIN_LENGTH_FACTOR, MAX_LENGTH_FACTOR)*b.getLength();
			float angle = 0;
			if (Math.random() > 0.5)
				angle = b.getAngle() + random(MIN_ANGLE_CHANGE, MAX_ANGLE_CHANGE);
			if (Math.random() < 0.5)
				angle = b.getAngle() - random(MIN_ANGLE_CHANGE, MAX_ANGLE_CHANGE);
			Branch babyBranch = new Branch(b.getEndX(), b.getEndY(), length, angle);
			drawRecursiveFlower(depth - 1, babyBranch);
		}
	}
	
	public void mousePressed() {
		setup();
	}
}
