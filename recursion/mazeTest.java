package recursion;

import java.util.ArrayList;

public class mazeTest {
	static int numRows = 50; //adjust for testing purposes
	static int numCols = 50; //adjust for testing purposes
	static double wallFactor = 0.25; //adjust for testing purposes
	static Position start;
	static Maze maze;
	static MazeSolver mazeSolver;
	
	public static ArrayList<Position> solve(int method) {
		ArrayList<Position> solution;
		solution = mazeSolver.findPath(start, method);
		return solution;	
	}
	
	static int DFSVisited = 0;
	static int BFSVisited = 0;
	static int sumDFS = 0;
	static int sumBFS = 0;
	
	public static void runDFS() {
		maze = new Maze(numRows, numCols, wallFactor);
		mazeSolver = new MazeSolver(maze);
		maze.resetGrid();
		maze.setGoalSquare();
		start = maze.getStartSquare();
		
		sumDFS += solve(0).size();
		DFSVisited += mazeSolver.totalVisited();
	}
	
	public static void runBFS() {
		maze = new Maze(numRows, numCols, wallFactor);
		mazeSolver = new MazeSolver(maze);
		maze.resetGrid();
		maze.setGoalSquare();
		start = maze.getStartSquare();
		
		sumBFS += solve(1).size();
		BFSVisited += mazeSolver.totalVisited();
	}
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 200; i++) {
			runDFS();
			runBFS();
		}
		System.out.println("50 x 50");
		System.out.println("DFS average path length: " + sumDFS/200);
		System.out.println("BFS average path length: " + sumBFS/200);
		System.out.println("DFS/BFS: " + (double) sumDFS/sumBFS);
		System.out.println("DFS average visited: " + DFSVisited/200);
		System.out.println("BFS average visited: " + BFSVisited/200);
		System.out.println();
		System.out.println("10 x 10");
		
		sumDFS = 0;
		sumBFS = 0;
		DFSVisited = 0;
		BFSVisited = 0;
		numRows = 10; //adjust for testing purposes
		numCols = 10;
		for (int j = 0; j < 200; j++) {
			runDFS();
			runBFS();
		}
		System.out.println("DFS average path length: " + sumDFS/200);
		System.out.println("BFS average path length: " + sumBFS/200);
		System.out.println("DFS/BFS: " + (double) sumDFS/sumBFS);
		System.out.println("DFS average visited: " + DFSVisited/200);
		System.out.println("BFS average visited: " + BFSVisited/200);
	}
}
