package inheritance;
import java.util.ArrayList;

import processing.core.PApplet;

public class Snake extends GameParts {
	
	// first value is x second value is y
	private int[] head;
	private int[] neck;
	private int[] tail;
	private ArrayList<int[]> snake;
	private Board board;
	private boolean moveAllowed;
	
	/**
	 * creates a new snake in the board b of length 3 and a default 
	 * starting lovation of the middle vertically and the head four squares to the right 
	 * @param b
	 */
	public Snake(Board b) {
		snake = new ArrayList<int[]>();
		head = new int[] {4, 8};
		neck = new int[] {3, 8};
		tail = new int[] {2, 8};
		snake.add(tail);
		snake.add(neck);
		snake.add(head);
		
		board = b;
		for (int i = 0; i < snake.size(); i ++)
			board.setSquare(snake.get(i)[0], snake.get(i)[1], SNAKE);
		moveAllowed = true;
		
	}
	/**
	 * draws the snake in p 
	 */
	@Override
	public void draw(PApplet p) {
		p.noStroke();
		// TODO Auto-generated method stub
		for (int i = 0; i < snake.size(); i ++) {
			if (i == snake.size() - 1) p.fill(0, 0, 175);
			else p.fill(0, 0, 255);
			float xc = (float) p.width/board.getBoard().length*snake.get(i)[0];
			float yc = (float) p.height/board.getBoard().length*snake.get(i)[1];
			float squareSize = (float) p.width/board.getBoard().length;
			p.rect(xc, yc, squareSize, squareSize);
		}
		
	}
	
	/**
	 * allows the snake to move in some direction depending on num
	 * @param num
	 */
	public void move(int num) {
		// 0 = default 
		// 1 = up
		// 2 = down
		// -1 = right
		// -2 = left
		
		if (gameOver) {
			return;
		}
		
		
		if (moveAllowed) {
			if(num == 1) moveUp();
			else if (num == 2) moveDown();
			else if (num == -1) moveRight();
			else if (num == -2) moveLeft();
			else if (num == 0) moveDefault();
		}
		else {
			moveDefault();
			moveAllowed = true;
		}
		
		
	}
	
	/**
	 * how the snake should move if there's no user input
	 */
	private void moveDefault() {
		// move to the right if the head is right of the body
		// move to the left if the the head is left of the body
		// move up if the head is above the body
		// move down if the head is below the body
		int x = 2*head[0] - neck[0];
		int y = 2*head[1] - neck[1];
		checkSquare(x, y);
	}
	
	/**
	 * moves the snake down (if the user presses down)
	 */
	private void moveDown() {
		if (head[1] - neck[1] == -1) moveAllowed = false;// snake head is NOT above snake body 
		else {
			int x = head[0];
			int y = head[1] + 1;
			checkSquare(x, y);
		}
	}
	
	/**
	 * moves the snake up (if the user presses up)
	 */
	private void moveUp() {
		if (head[1] - neck[1] == 1) moveAllowed = false;// snake head is NOT below snake body
		else {
			int x = head[0];
			int y = head[1] - 1;
			checkSquare(x, y);
		}
	}
	
	/**
	 * moves the snake left (if the user presses left)
	 */
	private void moveLeft() {
		if (head[0] - neck[0] == 1) moveAllowed = false;// snake head is NOT right of snake body
		else {
			int x = head[0] - 1;
			int y = head[1];
			checkSquare(x, y);
		}
	}
	
	/**
	 * moves the snake right (if the user presses right)
	 */
	private void moveRight() {
		if (head[0] - neck[0] == -1) moveAllowed = false;// snake head is NOT left of snake body
		else {
			int x = head[0] + 1;
			int y = head[1];
			checkSquare(x, y);
		}
		
	}
	
	/**
	 * checks to see if this square is either food or an open square
	 * if it doesn't fit these qualities: game over
	 * @param x
	 * @param y
	 */
	public void checkSquare(int x, int y) {
		if (board.getBoard()[x][y] == OPEN) {
			snake.add(new int[] {x, y});

			neck = head; // new neck 
			head = snake.get(snake.size() - 1);  // new head
			board.setSquare(head[0], head[1], SNAKE); // make new head square snake
			snake.remove(tail); // remove tail 
			board.setSquare(tail[0], tail[1], OPEN); // make new parts open squares
			tail = snake.get(0); // new tail
		}
		else if (board.getBoard()[x][y] == FOOD) {
			snake.add(new int[] {x, y});
			neck = head; // new neck 
			head = snake.get(snake.size() - 1);  // new head
			board.setSquare(head[0], head[1], SNAKE); // make new head square snake
			// DO NOT remove tail
			
			// create new food 
			board.setFood(new Food(board));
			
		}
		else {
			gameOver = true;
		}
		
	}
	
	
	
	


}
