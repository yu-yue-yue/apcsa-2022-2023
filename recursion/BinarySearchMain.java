package recursion;

import java.util.ArrayList;

import processing.core.PApplet;

public class BinarySearchMain extends PApplet{

	public static void main(String[] args) {
		PApplet.main("recursion.BinarySearchMain");
	}
	
	public void settings() {
		size(1000, 400);
		
	}
	
	float circleSize;
	BinarySearchTree bst = new BinarySearchTree();
	
	public void setup() {
		// creates the tree with root node 50 and random integers
		bst.setRoot(new Node(100, null, null));
		for (int i = 0; i < 150; i++) 
			bst.insert((int) (Math.random()*200));
		
		base();
		
	}
	
	public void base() {
		// draws the background and the tree
		background(0);
		
		fill(255);
		stroke(255);
		rect(10, 10, 100, 50);
		
		textSize(12);
		text("Press up for balance. \nPress down for linked list.", 10, 80);
		
		fill(0);
		textSize(20);
		text(newNumber, 20, 50);
		
		circleSize = 40;
		
		drawTree(bst);
		
	}
	
	public void draw() {
		
		if (drawingTree >= 0) {
			
			if (drawingTree < ellipses.size())	{
				fill(100, 10, 10);
				stroke(100, 10, 10);
				ellipse(ellipses.get(drawingTree)[0], ellipses.get(drawingTree)[1], ellipses.get(drawingTree)[2], ellipses.get(drawingTree)[3]);
				fill(255);
				textSize(ellipses.get(drawingTree)[7]);
				text((int) ellipses.get(drawingTree)[4], ellipses.get(drawingTree)[5], ellipses.get(drawingTree)[6]);
				delay(500);
			}
			
			if (drawingTree == ellipses.size()) {
				delay(500);
				drawingTree = -1;
				base();
				ellipses.clear();
			}
			
			drawingTree++;
		
		}
		
		else base();
		
				
	}
	
	public void drawTree(BinarySearchTree tree) {
		recursiveDrawTree(tree.getRoot(), width/2, circleSize, width/2, circleSize);
	}
	
	public void recursiveDrawTree(Node n, float x, float y, float length, float size) {
		
		if (n.getLeftChild() != null) {
			// draws a line extending to the next node
			stroke(10, 100, 10);
			line(x, y, x - length/2, y + size*1.5f);
			recursiveDrawTree(n.getLeftChild(), x - length/2, y + size*1.5f, length/2, size/1.2f);
		}
		
		if (n.getRightChild() != null) {
			// draws a line extending to the next node
			stroke(10, 100, 10);
			line(x, y, x + length/2, y + size*1.5f);
			recursiveDrawTree(n.getRightChild(), x + length/2, y + size*1.5f, length/2, size/1.2f);
		}
		
		textSize(size*.65f);
		// draws a circle for the node
		fill(10, 100, 10);
		stroke(10, 100, 10);
		
		ellipse(x, y, size, size);
		fill(255);
		float lengthOfNumber = log10(n.getKey()) + 1;
		if (n.getKey() == 0) lengthOfNumber = 1;
		text(n.getKey(), x - lengthOfNumber/2*size*.4f, y + size*.3f);
		
	}
	
	

	private int log10(int x) {
		// TODO Auto-generated method stub
		return (int) (log(x)/log(10));
	}

	int newNumber = 0;
	
	public void keyPressed() {
		// draws and creates a new number to add to the tree, stored in new number
		fill(255);
		stroke(255);
		rect(10, 10, 100, 50);
		
		if (key == '0'|| key == '1' || key == '2' || key == '3' || key == '4' || key == '5' ||
				key == '6' || key == '7' || key == '8' || key == '9') {
			fill(0);
			newNumber = newNumber*10 + (int) Character.getNumericValue(key);
			textSize(20);
			text(newNumber, 20, 50);
		}
			
	
		if (key == BACKSPACE) {
			newNumber /= 10;

			fill(0);
			textSize(20);
			text(newNumber, 20, 50);
		}	
		
		if (key == ENTER) {
			drawInsert();
			fill(255);
			rect(10, 10, 100, 50);
			newNumber = 0;
			
		}
		
		if (key == CODED) {
			if (keyCode == UP) 
				bst = bst.balancedTree();
			
			if (keyCode == DOWN)
				bst = bst.linkedList();
			
			base();
		}
	}
	
	int drawingTree = -1;
	
	public void drawInsert() {
		recursiveDrawInsert(bst, bst.getRoot(), width/2, circleSize, width/2, circleSize);
		
		drawingTree = 0;
	}

	ArrayList<float[]> ellipses = new ArrayList<float[]>();
	
	public void recursiveDrawInsert(BinarySearchTree tree, Node n, float x, float y, float length, float size) {
		// draws the new number as a red circle
		float newX = x;
		if (newNumber < n.getKey()) newX -= size;
		else if (newNumber > n.getKey()) newX += size;
		
		fill(255);
		float lengthOfNumber = log10(newNumber) + 1;
		if (newNumber == 0) lengthOfNumber = 1;
		ellipses.add(new float[] {newX, y, size, size, newNumber,
				newX - lengthOfNumber/2*size*.38f, y + size*.3f, size*.65f});
		
		// compares it to the other numbers
		if (newNumber < n.getKey()) {
			if (n.getLeftChild() == null) {
				n.setLeftChild(new Node(newNumber, null, null));
			}
			else recursiveDrawInsert(bst, n.getLeftChild(), x - length/2, y + size*1.5f, length/2, size/1.2f);
		}
		
		else if (newNumber > n.getKey()) {
			if (n.getRightChild() == null) {
				n.setRightChild(new Node(newNumber, null, null));
			}
			else recursiveDrawInsert(bst, n.getRightChild(), x + length/2, y + size*1.5f, length/2, size/1.2f);
		}
		
	}
	
	
}

	

 