package recursion;
import java.util.ArrayList;

/**
 * A maze solver class. Given a Maze, determine a path from start to goal via a
 * DFS or a BFS.
 * 
 * @author
 *
 */
public class MazeSolver {

	private int[][] grid;
	final static int DFS_MODE = 0;
	final static int BFS_MODE = 1;

	/**
	 * Takes a maze and sets the grid field to the maze of the grid.
	 * 
	 * @param m
	 */
	public MazeSolver(Maze m) {
		this.grid = m.getGrid();
	}

	/**
	 * Check if the coordinates (r, c) are in the bounds of the grid.
	 * 
	 * @param r
	 * @param c
	 * @return true if it is in bounds; false otherwise
	 */
	public boolean inBounds(int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length) return true;
		
		// TODO
		return false;
	}

	/**
	 * Check if the given position is the goal square of the maze (Maze.GOAL).
	 * 
	 * @param pos
	 * @return true if position is the goal; false otherwise.
	 */
	public boolean isGoal(Position pos) {
		if (!inBounds(pos.getRow(), pos.getCol())) return false;
		return (grid[pos.getRow()][pos.getCol()] == Maze.GOAL);
		// TODO
	}

	/**
	 * Check if the given position is an open square of the maze (Maze.OPEN).
	 * 
	 * @param pos
	 * @return true if position is open; false otherwise.
	 */
	public boolean isOpen(Position pos) {
		if (!inBounds(pos.getRow(), pos.getCol())) return false;
		if (grid[pos.getRow()][pos.getCol()] == Maze.OPEN) return true;
		// TODO
		return false;
	}

	/**
	 * Sets the given position in the maze to visited (Maze.VISITED).
	 * 
	 * @param pos
	 */
	public void setVisited(Position pos) {
		grid[pos.getRow()][pos.getCol()] = Maze.VISITED;
		//TODO
	}

	public boolean isVisited(Position pos) {
		if (grid[pos.getRow()][pos.getCol()] == Maze.VISITED) return true;
		// TODO
		return false;
	}
	
	public int totalVisited() {
		int total = 0;
		for (int[] row: grid) 
			for (int square: row) 
				if (square == Maze.VISITED)
					total++;
		return total;
			
	}
	/**
	 * Get the next positions that are 1 valid move from the current position. A
	 * move is valid if it is one square right, left, up or down, and that square is
	 * in bounds, is open or the goal square. It is invalid if it is out of bounds,
	 * is a wall square or a visited square.
	 * 
	 * Remember to set the 'previous' field of the position to the field 'current' so
	 * the positions remember a path back to the start.
	 * @param current
	 * @return an ArrayList of valid next positions
	 */
	public ArrayList<Position> getNextPositions(Position current) {
		ArrayList<Position> possiblePositions = new ArrayList<Position>();
		
		possiblePositions.add(new Position(current.getRow() - 1, current.getCol(), current));
		possiblePositions.add(new Position(current.getRow() + 1, current.getCol(), current));
		possiblePositions.add(new Position(current.getRow(), current.getCol() - 1, current));
		possiblePositions.add(new Position(current.getRow(), current.getCol() + 1, current));
		
		ArrayList<Position> nextPositions = new ArrayList<Position>();
		
		for (int i = 0; i < possiblePositions.size(); i++) {
			if (isOpen(possiblePositions.get(i)) || isGoal(possiblePositions.get(i))) 
				nextPositions.add(possiblePositions.get(i)); 
					
		}
		//TODO
		return nextPositions;
	}

	/**
	 * Finds a valid path from the starting positions 'start' to the goal. Calls
	 * either the DFS or BFS depending on the parameter 'method'. Then uses the
	 * backtracking mechanism of position to retrace its steps back to the start.
	 * 
	 * @param start  - the starting node
	 * @param method - 0 for DFS, 1 for BFS
	 * @return the path from the start to the end.
	 */
	public ArrayList<Position> findPath(Position start, int method) {
		ArrayList<Position> nodesToVisit = new ArrayList<Position>();
		nodesToVisit.add(start);
		
		Position end = null;
		if (method == DFS_MODE)
			end = DFSForGoal(nodesToVisit);
		else if (method == BFS_MODE)
			end = BFSForGoal(nodesToVisit);
		
		ArrayList<Position> path = new ArrayList<Position>();
		while (end != null) {
			path.add(0, end); //Backtrack from end back to start to create a path
			end = end.getPrevious();
		}
		return path;
	}

	/**
	 * Uses a depth-first search to perform an exhaustive search for the goal
	 * square.
	 * 
	 * @param nodesToVisit - an ArrayList of positions to visit. They should be
	 *                     visited in a LIFO (last-in, first-out) manner (i.e.
	 *                     Stack).
	 * @return the final position of the goal; or null if there is no solution found
	 */
	private Position DFSForGoal(ArrayList<Position> nodesToVisit) {
		
		//TODO: Be sure to call the appropriate helper methods where applicable
		//Base case 1 - If there are no more nodes to visit, the path is exhausted; return null
		if (nodesToVisit.isEmpty()) return null;
		if (nodesToVisit.size() > grid.length*grid.length) return null;
		
		// DFS follows the rule: Last-in, first-out (LIFO) -> Stack data structure.
		// The next Position to explore is the last one in the ArrayList. This is considered
		// to be the top of the stack. Start by getting that position and removing it from the 
		// ArrayList.
		Position p = nodesToVisit.get(nodesToVisit.size() - 1);
		
		//Base case 2 - If that position (top of the stack) is the goal, the goal is found; return that position.

		if (isGoal(p)) return p;
		//Recursion:
		//1 - If the position is open (not the goal), set the current position to visited 
		
		setVisited(p);
		//2 - Get the next positions from the current positions (1 valid move away in each direction)

		ArrayList<Position> newPos = getNextPositions(p);
		
		//3 - If these positions are not already in the list, add them to the end of the 'nodesToVisit' 
		//ArrayList. This is considered top of the stack. 
		for (int i = 0; i < newPos.size(); i++)
			if (!isVisited(newPos.get(i)) && !nodesToVisit.contains(newPos.get(i)))
				nodesToVisit.add(newPos.get(i));

		
		//4 - Recursively call the DFSForGoal method. Save the resulting position from the recursive call
		//in a variable.
		nodesToVisit.remove(p);

		
		
		//5 - If the resulting Position from the recursive call is not null and it is the goal position, 
		// return the resulting Position. Otherwise, return null; there is not a solution.
		return DFSForGoal(nodesToVisit);
		
		
		
	}
	
	
	

	/**
	 * Uses a breadth-first search to perform an exhaustive search for the goal
	 * square.
	 * 
	 * @param nodesToVisit - an ArrayList of positions to visit. They should be
	 *                     visited in a FIFO (first-in, first-out) manner (i.e.
	 *                     Queue).
	 * @return the final position of the goal; or null if there is no solution found
	 */
	
	private Position BFSForGoal(ArrayList<Position> nodesToVisit) {
		//TODO: Be sure to call the appropriate helper methods where applicable
		
		//Base case 1 - If there are no more nodes to visit, the path is exhausted; return null
		if (nodesToVisit.isEmpty()) return null;
		// BFS follows the rule: First-in, first-out (FIFO) -> Queue data structure.
		// The next Position to explore is the first one in the ArrayList. This is considered
		// to be the front of the queue. Start by getting that position and removing it from the 
		// ArrayList.
		Position p = nodesToVisit.get(0);
		//Base case 2 - If that position (front of the queue) is the goal, the goal is found; return that position.
		if (isGoal(p)) 
			return p;
		if (nodesToVisit.size() > grid.length*grid.length) return null;
		
		
		//Recursion:
		//1 - If the position is open (not the goal), set the current position to visited 
		setVisited(p);
		//2 - Get the next positions from the current positions (1 valid move away in each direction)
		ArrayList<Position> newPos = getNextPositions(p);
		//3 - If these positions are not already in the list, add them to the end of the 'nodesToVisit' 
		//ArrayList. This is considered end of the queue.
		for (int i = 0; i < newPos.size(); i++)
			if (!isVisited(newPos.get(i)) && !nodesToVisit.contains(newPos.get(i)))
				nodesToVisit.add(newPos.get(i));
		//4 - Recursively call the BFSForGoal method. Save the resulting position from the recursive call
		//in a variable.
		nodesToVisit.remove(0);
		//5 - If the resulting Position from the recursive call is not null and it is the goal position, 
		// return the resulting Position. Otherwise, return null; there is not a solution.
		return BFSForGoal(nodesToVisit); 
	}
}
