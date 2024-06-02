package turtleGraphics;
import java.awt.Color;

public class turtleMain {

	public static void main(String[] args) {
		Turtle eve = new Turtle();
		eve.showTurtle(true);
		eve.setDelay(200);
		for (int i = 0; i < 6; i++) {	
			
			for (int j = 0; j < 6; j++) {
				
				eve.move(50);
				eve.turnLeft(60);
			
			 
			}
	
			eve.turnLeft(60);
		
		}
		
		

	}

}
