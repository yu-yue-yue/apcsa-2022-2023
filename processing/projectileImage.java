package processing;

import processing.core.PImage;
import processing.core.PApplet;

public class projectileImage extends PApplet {

	
	public static void main(String[] args) {
		PApplet.main("processing.projectileImage");
	}
	
	public void settings() {
		size(900, 500);
	}
	
	PImage img;
	float x, y;
	final float GRAVITY = 1.0f; //final keyword makes it constant
	float vx, vy;
	
	float launchSpeed; 
	float angle;
	
	
	public void setup() {
		img = loadImage("Images/bananaOnFire.jpg");
		img.resize(100, 0);
		x = 0;
		y = height - img.height;
		launchSpeed = 25;
		angle = 45;
		reset();
	}
	
	
	
	public void draw() {
		background(0, 255, 100);
		x += vx;
		y += vy;
		
		if (x < 0 || x > (width - img.width)) {
//			vx *= -1;
			vx = 0;
		}
		
		if (y > (height - img.height)) {
//			vy *= -1;	
			vy = 0;
		}
		
		else {
			vy += GRAVITY;
		}
			
		
		image(img, x, y);
		// try and draw the angle and launch speed
		// display on screen
		
	}
	
	public void reset() {
		x = 0;
		y = height/2; 
		vx = (float) (launchSpeed*Math.cos(Math.toRadians(angle))); 
		vy = (float) (-launchSpeed*Math.sin(angle));
		
	}
	
	public void mouseClicked() {
		reset(); 
	}
	
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) {
				angle += 1;
				if (angle > 90)
					angle = 90;
			}
			else if (keyCode == DOWN) {
				angle -= 1;
				if (angle < 0)
					angle = 0; 
			}
			else if (keyCode == RIGHT) {
				launchSpeed += 5;
				if (launchSpeed > 100) 
					launchSpeed = 100;
			}
			else if (keyCode == LEFT) {
				launchSpeed -= 5;
				if (launchSpeed > 100) 
					launchSpeed = 100;
			}
		}
		
		reset(); 
	}
}
