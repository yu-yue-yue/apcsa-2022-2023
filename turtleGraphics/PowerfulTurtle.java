package turtleGraphics;

public class PowerfulTurtle extends NinjaTurtle {
	public PowerfulTurtle() {
		super(800, 800);
	}
	
	public PowerfulTurtle(int width, int height) {
		super(width, height);
	}
	
	/**
	 * draws a regular polygon
	 * @param sides
	 * @param sideLength
	 */
	
	public void drawRegularPolygon(double sides, double sideLength) {
			
			double angle = 180 - ((sides - 2)*180)/sides;
					
			for (int j = 0; j < sides; j++) {
				this.move(sideLength);
				this.turnLeft(angle);
			}
		}
	
	/**
	 * draws a rectangle
	 * @param width
	 * @param height
	 */
	
	public void drawRectangle(double width, double height) {
		for (int i = 0; i < 2; i++) {
			this.move(width);
			this.turnLeft(90);
			this.move(height);
			this.turnLeft(90);
		}
		
	}
	
	
	public void drawSierpinskiTriangle(int depth, double sideLength) {
		
		// base case (every recursion needs a base case)
		
		if (depth == 0 ) {
			drawRegularPolygon(3, sideLength);
			return;
		}
		
		drawSierpinskiTriangle((depth-1), (sideLength/2));
		turnLeft(60);
		move(sideLength/2);	
		turnRight(60);
		drawSierpinskiTriangle((depth-1), (sideLength/2));
		turnRight(60);
		move(sideLength/2);
		turnLeft(60);
		drawSierpinskiTriangle((depth-1), (sideLength/2));
		turnLeft(180);
		move(sideLength/2);
		turnLeft(180);
	
		
	}
	
	/**
	 * draws a koch snowflake, depth of 1 = the six sided star
	 * @param depth
	 * @param sideLength
	 */
	
	public void kochSnowflake(int depth, double sideLength) {
		if (depth == 0 ) {
			return;
			}
		drawRegularPolygon(3, sideLength);
		
		for (int i = 0; i < 3; i++) {
			turnLeft(60);
			move(sideLength/3);
			drawRegularPolygon(3, (sideLength/3));
			move(2*sideLength/3);
			turnRight(180);	
			//randomColor(); 
			}
		
		for (int i = 0; i < 3; i++) {
			kochSnowflake((depth - 1), (sideLength/3));
			turnLeft(60);
			move(sideLength/3);
			kochSnowflake((depth - 1), (sideLength/3));
			move(2*sideLength/3);
			turnRight(180);
		}
		
	}
	
	/**
	 * draws a tSquare fractal, depth of 0 = one square
	 * @param depth
	 * @param sideLength
	 */
	
	public void tSquare(int depth, double sideLength) {
	
		if (depth == 0) {
			drawRegularPolygon(4, sideLength);
			return;
		}
		
		tSquare((depth-1), (sideLength/2));
		move(sideLength/4);
		turnLeft(90);
		move(sideLength);
		turnLeft(90);
		move(sideLength/4);
		flip();
		
		for (int j = 0; j < 3; j++) {
			randomColor();
			tSquare((depth-1), (sideLength/2));
			move(sideLength/4);
			turnLeft(90);
			move(sideLength/4);
			turnRight(90);
			move(3*sideLength/4);
			turnLeft(90);
			move(sideLength/4);
			flip();
		}

		randomColor();
		tSquare((depth-1), (sideLength/2));
		move(sideLength/4);
		turnLeft(90);
		move(sideLength/4);
		turnRight(90);
		move(sideLength);
		flip();
			
	}
	
	/**
	 * draws two diamonds, then two diamonds between the diamonds 
	 * 3/4 as big as the diamonds before it
	 * @param depth
	 * @param size: side length of the rhombus
	 * @param angle: the angle of the rhombus
	 */
	
	public void diamonds(int depth, double size, double angle) {
		if (depth == 0) {
			return;
		}
		//drawSierpinskiTriangle(depth, (size/2));
		
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 2; i++) {	
				move(size);
				turnLeft(angle);
				randomColor();

				drawSierpinskiTriangle(depth, (size/2));
				move(size);
				turnLeft(180-angle);
				randomColor();
			}
			randomColor();
			turnLeft(angle);
					}	
		turnRight(angle);
		move(size);
		turnRight(angle);
		randomColor();
		
		
		
		diamonds((depth-1), (2*size/3), angle);
	}
	
	/**
	 * draws a circle
	 * @param radius
	 * @param amount: tells you how much of the circle you want
	 * to draw, ex. 180 = 1 semicircle
	 */
		
	public void drawCircle(double radius, double amount) {
		double sides = 360;
		double sideLength = 2*Math.PI*radius/360;
		
		double angle = 180 - ((sides - 2)*180)/sides;
		
		for (int j = 0; j < (sides*amount); j++) {
			this.move(sideLength);
			this.turnLeft(angle);
		}
			
	
	}
	
	/**
	 * draws an Archimedean Spiral
	 * @param radius
	 * @param density: the distance between the spirals
	 */
	
	public void drawArchimedeanSpiral(double radius, double density) {
		
		if (radius <= 0) {
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			double sideLength = 2*Math.PI*radius/360;
			move(sideLength);
			turnLeft(1);
		}
		
		randomColor();
		drawArchimedeanSpiral((radius - density), density);
		
	}
	
	/**
	 * draws a Logarithmic Spiral, starting from the outside
	 * turns counterclockwise
	 * @param radius
	 * @param density: the amount of decrease
	 */
	
	public void drawLogarithmicSpiral(double radius, double density) {
		if (radius <= 1) {
			return;
		}
		
		for (int i = 0; i < 60; i++) {
			double sideLength = 2*Math.PI*radius/360;
			move(sideLength);
			turnLeft(1);
		}
		
		drawLogarithmicSpiral((radius*density), density);
	}
	
	/**
	 * same as logarithmic spiral but it draws clockwise
	 * @param radius
	 * @param density
	 */
	
	public void drawBackwardsLogarithmicSpiral(double radius, double density) {
		if (radius <= 1) {
			return;
		}
		
		for (int i = 0; i < 60; i++) {
			double sideLength = 2*Math.PI*radius/360;
			move(sideLength);
			turnRight(1);
		}
		
		drawBackwardsLogarithmicSpiral((radius*density), density);
	}
	
	/**
	 * draws the regular logarithmic spiral from the inside out
	 * @param radius
	 * @param density
	 */
	
	public void inverseLogarithmicSpiral(double radius, double density) {
		double size = 1;
			while (size <= radius) {
				
			for (int i = 0; i < 60; i++) {
				double sideLength = 2*Math.PI*size/360;
				move(sideLength);
				turnRight(1);
				
			}
			size /= density;
			
		}
	}
	
	/**
	 * draws the backwards logarithmic sprial from the inside out
	 * @param radius
	 * @param density
	 */
	
	public void invBackLogarithmicSpiral(double radius, double density) {
		double size = 1;
			while (size <= radius) {
				
			for (int i = 0; i < 60; i++) {
				double sideLength = 2*Math.PI*size/360;
				move(sideLength);
				turnLeft(1);
				
			}
			size /= density;
			
		}
	}

	/**
	 * draws one sixth of a circle connected to one sixth of another
	 * circle (sort of oval shape)
	 * does that over and over again, which each sort of oval smaller
	 * than the last
	 * @param depth
	 * @param radius
	 */
	
	public void drawBody(int depth, double radius) {
		if (depth == 0) {
			return;
		}
		
		turnLeft(60);
		drawCircle(radius, (1.0/6));
		turnLeft(120);
		drawCircle(radius, (1.0/6));
		penUp();
		turnLeft(60);
		turnLeft(90);
		move(9*radius/180);
		turnRight(90);
		penDown();
		randomColor();
		
		drawBody((depth-1), (9*radius/10));
	}
	
	/**
	 * archimedean spiral as the head
	 * two logarithmic spirals as the antenna
	 * @param density1
	 * @param density2
	 * @param radius
	 */
	
	public void drawHead(double density1, double density2, double radius) {
		drawArchimedeanSpiral(radius, density1);
		
		penUp();
		turnRight(20);
		move(radius/(1+density1));
		penDown();
		
		drawLogarithmicSpiral(radius, density2);
		flip();
		inverseLogarithmicSpiral(radius, density2);
		
		penUp();
		turnLeft(90);
		move(radius/2.5);
		turnLeft(70);
		penDown();
		
		drawBackwardsLogarithmicSpiral(radius, density2);
		flip();
		invBackLogarithmicSpiral(radius, density2);
		
	}
	
	/** 
	 * draws a square centered at the starting point, returns to center
	 * @param sideLength
	 */
	
	public void drawSquare(double sideLength) {
		penUp();
		turnRight(135);
		move(sideLength*Math.sqrt(2)/2);
		turnLeft(135);
		penDown();
		for (int i = 0; i < 4; i++) {
			move(sideLength);
			turnLeft(90);
		}
		
		penUp();
		turnLeft(45);
		move(sideLength*Math.sqrt(2)/2);
		turnRight(45);
		penDown();
		
	}
	
	/** 
	 * draws a tsquare fractal
	 * 
	 * @param depth
	 * @param size: side length of the biggest square
	 */
	
	public void tSquareNew(int depth, double size) {
		if (depth == 0) {
			return;
		}
		
		drawSquare(size);
		
		penUp();
		turnRight(135);
		move(size*Math.sqrt(2)/2);
		turnLeft(135);
		penDown();
		for (int i = 0; i < 4; i++) {
			tSquareNew((depth-1), (size/2));
			move(size);
			turnLeft(90);
			
		}
		
		penUp();
		turnLeft(45);
		move(size*Math.sqrt(2)/2);
		turnRight(45);
		penDown();
	}
}
