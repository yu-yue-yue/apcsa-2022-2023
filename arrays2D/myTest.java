package arrays2D;

import java.util.ArrayList;

public class myTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knight arthur = new Knight(new Square(3, 3, 0), 6, 6);
		
		ArrayList<Square> answer = arthur.solveClosed();
		
		for (Square s: answer)
			System.out.println(s);
	}

}
