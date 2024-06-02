package inheritance;

public class Tetronimoe {
	/**
	 * tetrominoes: 
	 * 1. square: (x, y) (x, y + 1) (x + 1, y) (x + 1, y + 1)
	 * 2. long: (x, y) (x, y + 1) (x, y + 2) (x, y + 3) 
	 * 3. t: (x, y) (x, y + 1) (x, y + 2) (x + 1, y + 1)
	 * 4. L1: (x, y) (x, y + 1) (x, y + 2) (x + 1, y + 2)
	 * 5. L2: (x, y) (x, y + 1) (x, y + 2) (x - 1, y + 2)
	 * 6. S: (x, y) (x + 1, y) (x, y + 1) (x - 1, y + 1)
	 * 7. Z: (x, y) (x - 1, y) (x, y + 1) (x + 1, y + 1)
	 * 
	 * 
	 * 
	 * first you set x and y and then you have x and y + 1 and then you can choose between
	 * extending downwards or expanding along the sides 
	 */
	
	private int[][] coordinates;
	
	public Tetronimoe(int type, int x, int y) {
		coordinates = new int[4][2];
		
		
		if (type == 0) { // square
			coordinates[0][0] = x;
			coordinates[0][1] = y;
			coordinates[1][0] = x;
			coordinates[1][1] = y + 1;
			coordinates[2][0] = x + 1;
			coordinates[2][1] = y;
			coordinates[3][0] = x + 1;
			coordinates[3][1] = y + 1;
		}
		
		if (type == 1) { // long
			coordinates[0][0] = x - 1;
			coordinates[0][1] = y;
			coordinates[1][0] = x;
			coordinates[1][1] = y;
			coordinates[2][0] = x + 1;
			coordinates[2][1] = y;
			coordinates[3][0] = x + 2;
			coordinates[3][1] = y;
		}
		
		if (type == 2) { // long
			coordinates[0][0] = x - 1;
			coordinates[0][1] = y;
			coordinates[1][0] = x;
			coordinates[1][1] = y;
			coordinates[2][0] = x + 1;
			coordinates[2][1] = y;
			coordinates[3][0] = x + 2;
			coordinates[3][1] = y;
		}
	}
		

}
