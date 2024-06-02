package arrays2D;

public class Square {
	private int row;
	private int column;
	private int score;
	
	/**
	 * Constructs a Square with given row, column, and score.
	 * @param row the row
	 * @param column the column
	 * @param sc the score
	 */
	public Square(int row, int column, int sc) {
		this.row = row;
		this.column = column;
		this.score = sc;
	}

	/**
	 * Returns the row of this Square
	 * @return the row of this Square
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Returns the column of this Square
	 * @return the column of this Square
	 */
	public int getColumn() {
		return column;
	}
	
	/**
	 * Returns the score of this Square
	 * @return the score of this Square
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Sets the score of this Square to s
	 * @param s the score of this Square
	 */
	public void setScore(int s) {
		score = s;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "row: " + row + " column: " + column + " score: " + score;
	}	
	
	/** 
	 * Returns true if this Square and x have the same row and the same column.
	 * Otherwise, returns false.
	 */
	public boolean equals(Object x) {
		if (x == null || ! (x instanceof Square))
			return false;
		
		Square compare = (Square) x;
		
		return compare.getRow() == row && compare.getColumn() == column && compare.getScore() == score;
	}
}
