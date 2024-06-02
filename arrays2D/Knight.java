package arrays2D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Knight {
	private Square currentSquare;
	private Square startingSquare;
	private boolean[][] board;


	/**
	 * Creates a Knight with board of size rows x columns.
	 * Sets the value of board to true in the Square represented
	 * by s. Sets all other board values to false.
	 * Sets currentSquare and startingSquare to s.
	 * @param s the starting Square for this Knight
	 * @param rows the number of rows in this Knight's board
	 * @param cols the number of columns in this Knight's board
	 */
	public Knight(Square s, int rows, int cols) {
		board = new boolean[rows][cols];
		
		// set all values to false
		for (int r = 0; r < rows; r++) 
			for (int c = 0; c < cols; c++)
				board[r][c] = false;
		
		// set current square to true
		board[s.getRow()][s.getColumn()] = true;
		
		currentSquare = s;
		startingSquare = s;
		
		
	}
	
	/**
	 * Returns this Knight's current Square.
	 * @return this Knight's current Square.
	 */
	public Square getCurrentSquare() {
		return currentSquare;
	}

	/**
	 * Returns this Knight's starting Square.
	 * @return this Knight's starting Square.
	 */
	public Square getStartingSquare() {
		return startingSquare;
	}

	/**
	 * Returns this Knight's board.
	 * @return this Knight's board.
	 */
	public boolean[][] getBoard() {
		return board;
	}

	/**
	 * Returns a list of Squares representing a clsoed Knights Tour for this Knight.
	 * closed knight's tour
	 * 
	 * if closed knight's tour is impossible (5x5 square); loops infinitely
	 * @return a list of Squares representing a closed Knights Tour for this Knight
	 */
	public ArrayList<Square> solveClosed() {
		ArrayList<Square> sequence = new ArrayList<Square>();
		
		int pos = 1;
		sequence.add(currentSquare);
		do {
			board[currentSquare.getRow()][currentSquare.getColumn()] = true;
			ArrayList<Square> possible = getPossibleSquares();
			if (possible.isEmpty()) {
				sequence.clear();
				sequence.add(startingSquare);
				pos = 1;
				currentSquare = startingSquare;
				clearBoard();
			}
			else {
				Square best = getBestSquare(possible);
				sequence.add(best);
				currentSquare = best;
				pos++;
			}	
		
			
		} while (pos < board.length*board[0].length || !startIsReachableFromCurrent());		
		
		return sequence;
	}

	/**
	 * finds a knight's tour loop (open or closed, no specifications)
	 * uses the same bestSquare function as solveClosed, but doesn't take 
	 * into account isReachableFromStart
	 * @return a list of squares the represent at knight's tour for this knight
	 */
	public ArrayList<Square> solve() {
		ArrayList<Square> sequence = new ArrayList<Square>();
		
		int pos = 1;
		sequence.add(currentSquare);
		do {
			board[currentSquare.getRow()][currentSquare.getColumn()] = true;
			ArrayList<Square> possible = getPossibleSquares();
			if (possible.isEmpty()) {
				sequence.clear();
				sequence.add(startingSquare);
				pos = 1;
				currentSquare = startingSquare;
				clearBoard();
			}
			else {
				Square best = getBestSquare(possible);
				sequence.add(best);
				currentSquare = best;
				pos++;
			}			
		} while (pos < board.length*board[0].length);		
		
		return sequence;
	}
	
	/**
	 * Determines if starting Square is reachable from current Square.
	 * @return true if starting Square is reachable from current Square, false otherwise
	 */
	public boolean startIsReachableFromCurrent() {
		int[][] rowsAndColumns = {
				{currentSquare.getRow() - 1, currentSquare.getColumn() - 2},
				{currentSquare.getRow() - 1, currentSquare.getColumn() + 2},
				{currentSquare.getRow() + 1, currentSquare.getColumn() - 2},
				{currentSquare.getRow() + 1, currentSquare.getColumn() + 2},
				{currentSquare.getRow() - 2, currentSquare.getColumn() - 1},
				{currentSquare.getRow() - 2, currentSquare.getColumn() + 1},
				{currentSquare.getRow() + 2, currentSquare.getColumn() - 1},
				{currentSquare.getRow() + 2, currentSquare.getColumn() + 1}
		};
		
		for (int[] coordinates: rowsAndColumns) 
			if (coordinates[0] == startingSquare.getRow() && 
			coordinates[1] == startingSquare.getColumn())
				return true;
				
		
		return false;
	}
	
	/**
	 * Returns a Square with the smallest score in possible.
	 * If several Squares in possible have the same lowest score,
	 * one of these Squares is selected at random and returned.
	 * @param possible the list of Squares
	 * @return a Square with the smallest score in possible
	 */
	public Square getBestSquare(ArrayList<Square> possible) {
				
		int minScore = possible.get(0).getScore();
		
		// setting minimum score
		for (Square s: possible) 
			if (s.getScore() < minScore)
				minScore = s.getScore();
		
		double maxDistanceFromStart = 0; 
		// squares with lowest scores
		ArrayList<Square> minSquares = new ArrayList<Square>();
		// squares furthest from the starting square
		ArrayList<Square> bestSquares = new ArrayList<Square>();
		
		// adding minimum score squares to minimum score list
		for (Square s: possible) 
			if (s.getScore() == minScore) 
				minSquares.add(s);
		
		// setting the maximum distance from the starting square
		for (Square s: minSquares) 
			if (distanceFromStart(s) > maxDistanceFromStart)
				maxDistanceFromStart = distanceFromStart(s);
		
		// adding maximum distance squares to the max squares list
		for (Square s: minSquares) 
			if (maxDistanceFromStart - distanceFromStart(s) < 1)
				bestSquares.add(s);
		
		
		return bestSquares.get((int) (Math.random()*bestSquares.size()));
		
	}
	
	
	
	public double distanceFromStart(Square s) {
		return Math.sqrt((s.getRow() - startingSquare.getRow())*(s.getRow() - startingSquare.getRow()) + 
				(s.getColumn() - startingSquare.getColumn())*(s.getColumn() - startingSquare.getColumn()));
	}

	/**
	 * Sets all values in this Knight's board to false.
	 */
	public void clearBoard() {
		for (int r = 0; r < board.length; r++) 
			for (int c = 0; c < board[r].length; c++)
				board[r][c] = false;
	}

	/**
	 * Returns a list of all Squares that are within one knight move of
	 * this Knight's current Square.
	 * Each Square in the returned list has been given a score representing
	 * the number of unvisited Squares that can be reached (with a knight move) from that Square.
	 * @return a list of all Squares that are within one knight move of
	 * this Knight's current Square
	 */
	public ArrayList<Square> getPossibleSquares() {
		ArrayList<Square> possibleSquares =  new ArrayList<Square>();
		
		// i know this is probably the dumbest way to do it but tbh it works and there's not that 
		// many so like do i really care? no not really
		// all eight possible moves a knight can make
		int[][] rowsAndColumns = {
				{currentSquare.getRow() - 1, currentSquare.getColumn() - 2},
				{currentSquare.getRow() - 1, currentSquare.getColumn() + 2},
				{currentSquare.getRow() + 1, currentSquare.getColumn() - 2},
				{currentSquare.getRow() + 1, currentSquare.getColumn() + 2},
				{currentSquare.getRow() - 2, currentSquare.getColumn() - 1},
				{currentSquare.getRow() - 2, currentSquare.getColumn() + 1},
				{currentSquare.getRow() + 2, currentSquare.getColumn() - 1},
				{currentSquare.getRow() + 2, currentSquare.getColumn() + 1}
		};
		
		// checking if moves are valid
		for (int r = 0; r < rowsAndColumns.length; r++) {
			int rowIndex = rowsAndColumns[r][0];
			int columnIndex = rowsAndColumns[r][1];
			
			// if move is valid, make a new square and add it to the list
			if (isValid(rowIndex, columnIndex))
				possibleSquares.add(new Square(rowIndex, columnIndex, getScoreOfSquare(rowIndex, columnIndex)));
		}
		
		return possibleSquares;
		
	}

	/**
	 * Returns the number of unvisited Squares that can be reached (with a knight move) from the Square at row, col.
	 * @param row the row
	 * @param col the column
	 * @return the number of unvisited Squares that can be reached (with a knight move) from the Square at row, col
	 */
	public int getScoreOfSquare(int row, int col) {
		int score = 0;
		
		Square temp = new Square(row, col, 0);
		
		// all the possible moves
		// again i know this is dumb but oh well
		// look its a unit on 2d arrays... might as well use an extra array
		int[][] rowsAndColumns = {
				{temp.getRow() - 1, temp.getColumn() - 2},
				{temp.getRow() - 1, temp.getColumn() + 2},
				{temp.getRow() + 1, temp.getColumn() - 2},
				{temp.getRow() + 1, temp.getColumn() + 2},
				{temp.getRow() - 2, temp.getColumn() - 1},
				{temp.getRow() - 2, temp.getColumn() + 1},
				{temp.getRow() + 2, temp.getColumn() - 1},
				{temp.getRow() + 2, temp.getColumn() + 1}
		};
		
		// checking if the squares are valid
		for (int r = 0; r < rowsAndColumns.length; r++) {
			int rowIndex = rowsAndColumns[r][0];
			int columnIndex = rowsAndColumns[r][1];
			
			// adding valid squares to score
			if (isValid(rowIndex, columnIndex)) 
				score++; 
			}
		
		return score;
	}

	/**
	 * Returns true if the square at row r, column c is in this Knight's board; returns false otherwise.
	 * @param r the row
	 * @param c the column
	 * @return true if the square at row r, column c is in this Knight's board; false otherwise
	 */
	public boolean isValid(int r, int c) {
		return (r >= 0 && r < board.length && c >= 0 && c < board[r].length && ! board[r][c]);

	}	
}
