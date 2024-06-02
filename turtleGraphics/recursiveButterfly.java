package turtleGraphics;

public class recursiveButterfly {

	public static void wings(PowerfulTurtle turtle) {
		turtle.move(10);
		
		
		turtle.diamonds(4, 150, 40);
		turtle.turnLeft(9);
		turtle.kochSnowflake(3, 70);
		turtle.turnRight(9);
		turtle.turnRight(140);
		turtle.move(360);
		turtle.turnRight(40);
		turtle.move(20);
		turtle.turnRight(80);
		
		turtle.diamonds(4, 150, 40);
		turtle.turnLeft(9);
		turtle.kochSnowflake(3, 70);
		turtle.turnRight(9);
		turtle.turnRight(140);
		turtle.move(360);
		turtle.turnRight(130);
		
		turtle.diamonds(4, 100, 40);
		turtle.turnLeft(9);
		turtle.tSquareNew(4, 50);
		turtle.turnRight(9);
		turtle.turnRight(140);
		turtle.move(240);
		turtle.turnRight(50);
		turtle.move(20);
		turtle.turnRight(90);
		
		turtle.diamonds(4, 100, 40);
		turtle.turnLeft(9);
		turtle.tSquareNew(4, 50);
		turtle.turnRight(9);

	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerfulTurtle jimmy = new PowerfulTurtle(1100, 650);
		
		jimmy.setDelay(0);
		
		jimmy.penUp();
		jimmy.turnRight(90);
		jimmy.move(150);
		jimmy.turnLeft(90);
		jimmy.penDown();
	
		jimmy.drawBody(25, 200);
		
		jimmy.penUp();
		jimmy.turnLeft(90);
		jimmy.move(60);
		jimmy.turnRight(90);
		jimmy.penDown();

		wings(jimmy);
		
		jimmy.penUp();
		jimmy.turnRight(140);
		jimmy.move(253);
		jimmy.turnRight(40);
		jimmy.move(15);
		jimmy.turnRight(90);
		jimmy.penDown();

		jimmy.drawHead(0.1, 0.8, 30);
		
		
		
	}

}
