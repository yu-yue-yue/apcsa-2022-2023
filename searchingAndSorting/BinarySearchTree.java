package searchingAndSorting;

import java.util.ArrayList;

public class BinarySearchTree {
	
	private Node root;
	private int numNodes;
	private int comparisons;
	private int swaps;
	
	public int getNumNodes() {
		return numNodes;
	}
	
	public int[] getSorted() {
		return sorted;
	}

	private int[] sorted;
	
	public BinarySearchTree(Node r) {
		comparisons = 0;
		swaps = 0;
		root = r;
		numNodes = 1;
	}
	
	public BinarySearchTree() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}
	
	public void insert(int value) {
		numNodes++;
		if(root == null)// tree is empty
		{
			root = new Node(value);
			return;
		}
		
		Node n = root;
		Node prev = root;
		while(n != null) {
			if(value < n.getValue()) {
				prev = n;
				n = n.getLc();
			}
			
			else {
				prev = n;
				n = n.getRc();
			}
			
			comparisons++;
		}
		// n is null and prev is childless on the correct side 
		
		if(value < prev.getValue()) prev.setLc(new Node(value));
		else prev.setRc(new Node(value));
		swaps++;
		
	}
	
	public int getComparisons() {
		return comparisons;
	}

	public int getSwaps() {
		return swaps;
	}

	public void inOrderTraversal() {
		sorted = new int[numNodes];
		ArrayList<Node> stack = new ArrayList<Node>();
		Node n = root;
		int i = 0;
		while(n!= null || stack.size() > 0) {
			// exploring the left subtree
			while(n != null) {
				stack.add(n);
				n = n.getLc();
			}
			
			n = stack.remove(stack.size() - 1);
			sorted[i] = n.getValue();
			swaps++;
			
			i++;
			
			n = n.getRc();
		}
	}

}
