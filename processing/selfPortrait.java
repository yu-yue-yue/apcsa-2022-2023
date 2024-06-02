package processing;
import processing.core.PApplet;
import processing.core.PImage;

public class selfPortrait extends PApplet {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("processing.selfPortrait");
	}
	
	
	/**
	 * draws out the hair
	 * @param v1 the speed at which the top hair curve moves (horizontal)
	 * @param v2 the speed at which the bottom hair curve moves (horizontal)
	 */
	public void hair(int v1, int v2) {

		
		
		stroke(0, 0, 30);
		strokeWeight(10);
		
		fill(0, 0, 30);
		beginShape();
		vertex(500, 600);
		vertex(500, 150);
		vertex(300, 150);
		bezierVertex(350 + v1, 350, 150 + v2, 450, 250, 600);
		endShape();
		
		beginShape();
		vertex(500, 600);
		vertex(500, 150);
		vertex(700, 150);
		bezierVertex(850 + v1, 450, 650 + v2, 350, 750, 600);
		endShape();
		
	}
	
	/**
	 * draws the face
	 * one oval, rectangle for neck, arc for shoulders 
	 * highlights are arcs and rectangles
	 * nose is triangle
	 */
	
	public void face() {
		
		stroke(252, 186, 3);
		strokeWeight(35);
		fill(252, 186, 3);
		
		arc(500, 600, 500, 170, PI, 2*PI, CHORD );
		rect(450, 400, 100, 200);	
		
		stroke(255);
		fill(255);
		
		rect(490, 345, 60, 200);
		
		stroke(252, 186, 3);
		strokeWeight(35);
		fill(252, 186, 3);
		
		ellipse(500, 270, 210, 300);
		
		stroke(255);
		fill(255);
		
		strokeWeight(2);
		arc(500, 270, 245, 335, 3*PI/2, 5*PI/2, CHORD);
		triangle(500, 260, 475, 320, 500, 320);
		
		strokeWeight(35);
		arc(500, 600, 500, 170, 3*PI/2, 5*PI/2, CHORD);
		arc(500, 600, 400, 170, PI/2, 3*PI/2, CHORD);
	}
	
	
	/**
	 * draws out a hat using a two bezier curves and straight lines
	 * draws out a white ribbon
	 * @param r red value
	 * @param g green value
	 * @param b blue value
	 */
	public void hat(int r, int g, int b) {
		
		stroke(r, g, b);
		strokeWeight(10);
		fill(r, g, b);
		
		beginShape();
		vertex(350, 125);
		vertex(200, 175);
		bezierVertex(400, 225, 600, 225, 800, 175);
		vertex(650, 125);
		bezierVertex(600, 0, 400, 0, 350, 125);
		endShape();
		
		stroke(255);
		bezier(343, 125, 400, 140, 600, 140, 657, 125);
		
	}
	
	/**
	 * draws out the sunglasses and animates them
	 * @param blueShade initial color value
	 * @param w change in blue shade
	 */
	
	public void sunglasses(int blueShade, int w) {
		int d = 45;
		
		int x = (w + 1)% (4);
		int y = (x + 1)% (4);
		int z = (y + 1)% (4);
		
		stroke(0, 0, blueShade + (w%4)*d);
		strokeWeight(15);
		fill(0, 0, blueShade + x*d);
		
		beginShape();
		vertex(350, 220);
		vertex(650, 220);
		bezierVertex(640, 340, 550, 340, 510, 250);
		vertex(490, 250);
		bezierVertex(450, 340, 360, 340, 350, 220);
		endShape();
		
		stroke(0, 0, blueShade + y*d);
		fill(0, 0, blueShade + z*d);
		
		beginShape(); 
		vertex(390, 250);
		vertex(450, 250);
		bezierVertex(440, 290, 400, 290, 390, 250);
		endShape();
		
		beginShape(); 
		vertex(550, 250);
		vertex(610, 250);
		bezierVertex(600, 290, 560, 290, 550, 250);
		endShape();
	}
	
	/**
	 * dark red upper lip 
	 * bright red lower lip
	 */
	
	public void mouth() {
		strokeWeight(0);
		fill(200, 0, 0);
		
		beginShape();
		vertex(460, 360);
		bezierVertex(480, 360, 485, 340, 500, 355);
		bezierVertex(515, 340, 520, 360, 540, 360);
		vertex(460, 360);
		endShape();
		
		fill(240, 0, 0);
		beginShape();
		vertex(460, 360);
		bezierVertex(490, 400, 510, 400, 540, 360);
		endShape();
		
	}
	
	
	
	public void settings()  {
		size(1000, 600);
		
	}
	
	PImage sunset;
	PImage tree;
	
	public void setup() {
		background(255, 255, 0);
		
		sunset = loadImage("Images/sunset.jpg");
		sunset.resize(width, height);
		tree = loadImage("Images/palmtree.png");
		tree.resize(0, 500);
		image(sunset, 0, 0);
		
		hair(0, 0);
		face();
		sunglasses(100, 0);
		hat(255, 0, 0);
		mouth();
		
	}
	
	
	
	
	int speed = 1;
	int rate = 2;
	int sunglassesChange = 1;
	int colorChange;
	int hatRed = 255;
	int hatGreen = 0;
	int hatBlue = 0;
	
	/**
	 * changes the color of the hat in a gradient, starts at red
	 */
	public void hatColorChange() {
		hat(hatRed, hatGreen, hatBlue);
		if (hatRed == 255 && hatGreen < 255 && hatBlue == 0) 	
			hatGreen += 5;
		
		if (hatRed > 0 && hatGreen == 255 && hatBlue == 0) 
			hatRed -= 5;
		
		
		if (hatRed == 0 && hatGreen == 255 && hatBlue < 255) 
			hatBlue += 5;
		
		
		if (hatRed == 0 && hatGreen > 0 && hatBlue == 255) 
			hatGreen -= 5;
		
		
		if (hatRed < 255 && hatGreen == 0 && hatBlue == 255) 
			hatRed += 5;
		
		if (hatRed == 255 && hatGreen == 0 && hatBlue > 0)
			hatBlue -= 5;
	}
	

	
	
	public void draw() {
		
		
		frameRate(36);
		image(sunset, 0, 0);
		image(tree, 700, 100);
		for (int k = 0; k < 10; k++) {
			hair(speed, -speed);
			speed += rate;
			
			if (speed > 100 || speed < -300) {
				rate = -rate;
			}
		}
		
		face();
		sunglasses(100, sunglassesChange);
		if (frameCount%12 == 0)
			sunglassesChange++;
		
		hatColorChange();
		mouth();
		

		
	}
	
	
	

}
