package turtleGraphics;

public class recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerfulTurtle evelyn = new PowerfulTurtle();
		evelyn.penUp();
		evelyn.turnLeft(180);
		evelyn.move(290);
		evelyn.turnLeft(90);
		evelyn.move(290);
		evelyn.turnRight(90);
		evelyn.turnRight(180);
		evelyn.penDown();
		evelyn.drawSierpinskiTriangle(10, 600);
				
	}

}
