package recursion;

import java.util.ArrayList;

public class BinarySearchTree {

	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(Node root) {
		this.root = root;
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	
	/**
	 * Insert a new node with the given 'key' into the tree.
	 * @param key
	 */
	public void insert(int key) {
		if (root == null)
			root = new Node (key, null, null);
		
		recursiveInsert(key, root);
	}
	
	/**
	 * Insert a new node with the given 'key' into the subtree in the proper position.
	 * @param key
	 * @param n
	 */
	private void recursiveInsert(int key, Node n) {
		//TODO: Implement this recursive method.
		if (key < n.getKey()) {
			if (n.getLeftChild() == null) n.setLeftChild(new Node(key, null, null));
			else recursiveInsert(key, n.getLeftChild());
		}
		
		else if (key > n.getKey()) {
			if (n.getRightChild() == null) n.setRightChild(new Node(key, null, null));
			else recursiveInsert(key, n.getRightChild());
		}
		
		
		
	}
	
	/**
	 * Searches the tree and returns the Node which the 'key' value.
	 * @param key
	 * @return the node with the value 'key', or null if no node is found
	 */
	public Node search(int key) {
		return recursiveSearch(key, root);
	}
	/**
	 * Searches the subtree starting at node n. Returns the Node which the 'key' value.
	 * @param key
	 * @param n
	 * @return the node with the value 'key', or null if no node is found
	 */
	private Node recursiveSearch(int key, Node n){
		//TODO: Implement this recursive method.
		if (key > n.getKey()) {
			if (n.getRightChild() == null) return null;
			else return recursiveSearch(key, n.getRightChild());
		}
		
		else if (key < n.getKey()) {
			if (n.getLeftChild() == null) return null;
			else return recursiveSearch(key, n.getLeftChild());
		}
		
		else return n;
		
		
	}
	
	/**
	 * Print the 'key' values in order. See the assignment description for more details.
	 */
	public void inOrderTraversal() {
		recursiveInOrderTraversal(root);
		System.out.println();
	}
	
	/**
	 * Prints the 'key' values from the subtree rooted at 'n' in order.
	 * @param n
	 */
	private void recursiveInOrderTraversal(Node n) {
		//TODO: Implement this recursive method.
		if (n.getLeftChild() != null) recursiveInOrderTraversal(n.getLeftChild());
		System.out.print(n.getKey() + " ");
		
		if (n.getRightChild() != null) recursiveInOrderTraversal(n.getRightChild());

	}
	
	/**
	 * Returns the minimum value of the tree.
	 * @return
	 */
	public int min() {
		return recursiveMin(root);
	}
	/**
	 * Recursive method, returns the minimum value of the subtree rooted at n.
	 * @param n
	 * @return
	 */
	private int recursiveMin(Node n) {
		//TODO: Implement this recursive method.
		if (n.getLeftChild() != null) return recursiveMin(n.getLeftChild());
		else return n.getKey();
	}
	
	/**
	 * Returns the maximum value of the tree
	 * @return
	 */
	public int max() {
		return recursiveMax(root);
	}
	/**
	 * Recursive method, returns the maximum value of the subtree rooted at n.
	 * @param n
	 * @return
	 */
	private int recursiveMax(Node n) {
		//TODO: Implement this recursive method.
		if (n.getRightChild() != null) return recursiveMax(n.getRightChild());
		else return n.getKey();
		
	}
	
		
	
	public void preOrderTraversal() {
		recursivePreOrderTraversal(root);
		System.out.println();
	}
	
	private void recursivePreOrderTraversal(Node n) {
		System.out.print(n.getKey() + " ");
		
		if (n.getLeftChild() != null) recursivePreOrderTraversal(n.getLeftChild());
		
		if (n.getRightChild() != null) recursivePreOrderTraversal(n.getRightChild());
	}
	
	
	public void postOrderTraversal() {
		recursivePostOrderTraversal(root);
		System.out.println();
	}

	private void recursivePostOrderTraversal(Node n) {
		if (n.getLeftChild() != null) recursivePostOrderTraversal(n.getLeftChild());
		
		if (n.getRightChild() != null) recursivePostOrderTraversal(n.getRightChild());
		
		System.out.print(n.getKey() + " ");
		
	}
	
	private ArrayList<Integer> nodes;
	BinarySearchTree ordered;
	
	public BinarySearchTree linkedList() {
		nodes  = new ArrayList<Integer>();
		orderNodes(root);
		ordered = new BinarySearchTree(new Node(nodes.get(nodes.size()/2), null, null));
		
		return recursiveLinkedList();
	}
	
	private BinarySearchTree recursiveLinkedList() {
		ordered.insert(nodes.get(nodes.size()/2));
		nodes.remove(nodes.size()/2);
		
		if (nodes.size() > 0) recursiveLinkedList();
		
		return ordered;
	}
	
	private void orderNodes(Node n) {
		if (n.getLeftChild() != null) orderNodes(n.getLeftChild());
		nodes.add(n.getKey());
		if (n.getRightChild() != null) orderNodes(n.getRightChild());
	}
	
	public BinarySearchTree balancedTree() {
		nodes  = new ArrayList<Integer>();
		orderNodes(root);
		BinarySearchTree balanced = new BinarySearchTree();
		
		return recursiveBalancedTree(balanced, 0, nodes.size());
	}
	
	private BinarySearchTree recursiveBalancedTree(BinarySearchTree tree, int left, int right) {
		int middle = (right + left)/2;
		tree.insert(nodes.get(middle));
		if(right > middle && middle > left) {
			recursiveBalancedTree(tree, left, middle);
			recursiveBalancedTree(tree, middle, right);
		}
		
		return tree;
	}
}
