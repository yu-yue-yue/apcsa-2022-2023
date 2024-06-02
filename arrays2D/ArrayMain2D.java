package arrays2D;

public class ArrayMain2D {
	
	public static void main(String[] args) {
		int[][] a = new int[2][4]; // 2 x 4 matrix/array 
		// row is always first when discussing 2d arrays/matrices
		
		
		// Jagged arrays - rows have an uneven number of columns 
		
		int[][] jagged = { {1}, {2, 3}, {4}, {5, 6, 7} };
		
		int[][] jagged2 = new int[4][];
		jagged2[0] = new int[1];
		jagged2[1] = new int[] {2, 3};
		
		
		print2DArrayColumnOrder(a);
	}
	
	public static void print2DArray(int [][] a) {
		// we want to print this 
		// a[0][0] a[0][1] a[0][2] a[0][3]
		// a[1][0] a[1][1] a[1][2] a[1][3]
		
		// a row order traversal:
		
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				System.out.print(a[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	// using for each
	
	// still a row order traversal 
	public static void print2DArray2(int[][] a) {
		for (int[] r : a) {
			for (int c : r) {
				System.out.print(c + " ");
			}
			
			System.out.println();
		}
	}
	
	public static int multiplyAllValuesInColumn (int[][] a, int c) {
		int product = 1;
		
		for (int[] row: a) {
			product *= row[c];
		}
		
		return product;
	}
	
	public static int[] sumColumns (int [][] a) {
		int[] sums = new int[a[0].length];
		
		for (int c = 0; c < sums.length; c++) {
			int sum = 0; 
			for (int[] row : a) {
				sum += row[c];
			}
			
			sums[c] = sum;
		}
		
		return sums;
			
	}
	
	public static void print2DArrayColumnOrder(int[][] a) {
		for (int c = 0; c < a[0].length; c++) {
			for (int r = 0; r < a.length; r++) {
				System.out.print(a[r][c] + " ");
			}
		}
	}
	
	public static int sumAllValuesExceptColumnC(int[][]a, int c) {
		int sum = 0;
		for (int[] row: a) {
			for (int value: row) {
				sum += value;
			}
			
			sum -= row[c];
		}
		
		return sum;
	
	}
	
	public boolean contains(String[][] a, String s) {
		for (String[] row: a) {
			for (String c: row) {
				if (s.equals(c)) 
					return true;
			}
		}
		
		return false;
	}

}
