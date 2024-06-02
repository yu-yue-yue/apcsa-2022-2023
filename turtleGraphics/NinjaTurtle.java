package turtleGraphics;

import java.awt.Color;

// Turtle is the 'super' class
// NinjaTurtle inherits all the behavior and functionality from Turtle
public class NinjaTurtle extends Turtle {
	public NinjaTurtle() {
		super(true, 800, 800);
	}
	
	public NinjaTurtle(int width, int height) {
		super(true, width, height);
		
	}
	
	// 'this' is a keyword that acts as a reference to the object 
	// that made the method call
	public void turnRight(double angle) {
		this.turnLeft(-angle);
	}
	
	public void drawHexagon() {	
		for (int j = 0; j < 6; j++) {
			this.move(50);
			this.turnLeft(60);
		}
	}
	
	public void drawCubes() {
		for (int i = 0; i <6; i++) {
			this.drawHexagon();
			this.turnLeft(60);
		}
	}
	
	//Overloading - when you name a method the same thing but with a 
	// different parameter signature.
	
	public void randomColor() {
		int r = (int) (Math.random()*255);
		int g = (int) (Math.random()*255);
		int b = (int) (Math.random()*255);
		// Calling a constructor <- something that creates an object
		Color c = new Color(r, g, b);
		this.switchTo(c);
		
	}
	
	public void flip() {
		turnLeft(180);
	}
	
	
	
	
	
}
