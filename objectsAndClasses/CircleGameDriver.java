package objectsAndClasses;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * The dri`ver for the circle game.
 * @author sharicke
 *
 */
public class CircleGameDriver extends PApplet{
	private Character c;
	private ArrayList<Circle> enemies;
	private static int NUM_ENEMIES = 100;
	private boolean gameOver = false;
	private float playerSize = 45;
	private int score;
	private Circle bigBad;
	private boolean win = false;
	
	public static void main(String[] args) {
		PApplet.main("objectsAndClasses.CircleGameDriver");
	}
	public void settings()
	{
		fullScreen();
		//size(600, 600);
	}
	/**
	 * Sets up the initial game state. Spawns in the character in the middle
	 * of the screen and spawns a list of enemies based on NUM_ENEMIES constant.
	 */
	public void setup()
	{
		noLoop();
		background(255);
		noCursor();
		frameRate(30);
		c = new Character(width/2, height/2, playerSize, new Color(200, 125, 80));
		enemies = new ArrayList<Circle>();
		for(int i = 0; i < NUM_ENEMIES; i++)
		{
			Circle e = new Circle(width, height);
			enemies.add(e);
		}
		
		bigBad = new Circle(width, height, 0, 0,
				(float) (Math.random()*5 + 5), (float) (Math.random()*5 + 5), 
				playerSize*2, new Color(0, 0, 0));		
		
		drawCharacter();
		drawEnemies();
		drawBigBad();
		
	}
	

	/**
	 * The main loop for the game. Redraws the background and updates and redraws
	 * the player character and enemies.
	 */
	public void draw()
	{
		
		if (gameOver) {
			background(0);
			text("GAME OVER. You didn't eat the big bad.\nScore: " + score, 120, 150);
			fill(240, 0, 0);
			text("Click to start again.", 120, 250);
			textSize(30);
			
		}
		
		else if (win) {
			background(0);
			text("YOU WIN! \nScore: " + score, 120, 150);
			fill(240, 0, 0);
			text("Click to start again.", 120, 250);
			textSize(30);
		}
		
		else {
				background(255);
				updateCharacter();
				updateEnemies();
				updateBigBad();
				drawCharacter();
				drawEnemies();
				drawBigBad();
				
		}
	}
	
	/**
	 * Click the mouse to start over.
	 */
	public void mousePressed()
	{
		setup();
		loop();
		gameOver = false;
		score = 0;
	}
	
	/**
	 * Updates the character by moving it to the mouse location then
	 * checking to see if it is colliding with each of the enemies. If
	 * it is colliding with a smaller enemy, it consumes the enemy, grows,
	 * and causes the enemy to respawn. If it is colliding with a larger enemy,
	 * the game ends.
	 */
	public void updateCharacter()
	{
		c.moveCharacter(mouseX, mouseY);
		for(int i = enemies.size()-1; i >= 0; i--)
		{
			Circle e = enemies.get(i);
			if(c.collidingWith(e))
			{
				if(c.getSize() > e.getSize())
				{
					c.grow();
					e.respawn(c.getSize()); //respawn enemy
					//enemies.remove(i); //remove from board
					
					score++;
				}
				else
				{
					gameOver = true;
				}
			}
			
			if(c.collidingWith(bigBad)) {
				if(c.getSize() > bigBad.getSize()) {
					win = true;
				}
				
				else {
					gameOver = true;
				}
			}
		}
	}
	
	/**
	 * Draws the character with an ellipse.
	 */
	public void drawCharacter()
	{
		Color color = c.getColor();
		fill(color.getRed(), color.getBlue(), color.getGreen());
		ellipse(c.getX(), c.getY(), c.getSize(), c.getSize());
	}
	
	/**
	 * Updates the position of all enemies
	 */
	public void updateEnemies()
	{
		for(Circle e : enemies)
		{
			e.update();
		}
	}
	
	/**
	 * Draws an ellipse for each enemy
	 */
	public void drawEnemies()
	{
		for(Circle e : enemies)
		{
			Color color = e.getColor();
			fill(color.getRed(), color.getGreen(), color.getBlue());
			ellipse(e.getX(), e.getY(), e.getSize(), e.getSize());
			
		}
	}
	
	public void drawBigBad() {
		Color color =  bigBad.getColor();
		fill(color.getRed(), color.getGreen(), color.getBlue());
		ellipse(bigBad.getX(), bigBad.getY(), bigBad.getSize(), bigBad.getSize());
		
	}
	
	public void updateBigBad() {
		bigBad.move();
		bigBad.bounce();
	}


}
