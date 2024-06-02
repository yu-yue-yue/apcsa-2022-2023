package turtleGraphics;

public class methods {
	static NinjaTurtle eve = new NinjaTurtle();
	
//	public static void drawHexagon(Turtle turtle) {
//		
//		for (int j = 0; j < 6; j++) {
//			
//			turtle.move(50);
//			turtle.turnLeft(60);
//		}
//	}
//	public static void drawCubes(Turtle turtle) {
//		for (int i = 0; i <6; i++) {
//			drawHexagon(turtle);
//			turtle.turnLeft(60);
//		}
//	}
	
	public static void drawShape() {
		for (int i = 0; i < 4; i++) {	
			eve.setDelay(20);
			eve.drawCubes();
			eve.randomColor();
			eve.turnLeft(15);
			
		}
	}
	
	public static void main(String args[]) {
		
		for (int i = 0; i < 20; i++) {
			drawShape();
			eve.penUp();
			
			int angle = (int) (Math.random()*180 + 90);
			eve.turnLeft(angle);
			
			int distance = (int) (Math.random()*100 + 100);
			eve.move(distance);
			eve.penDown();
			
			
			
			
			
			
			
		}
		
		
			
		
		
			
		
		
	}

}


