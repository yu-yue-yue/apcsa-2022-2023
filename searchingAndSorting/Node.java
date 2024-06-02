package searchingAndSorting;

public class Node {

	private int value; 
	private Node rc, lc;
	
	public Node(int value) {
		this.value = value;
		lc = null;
		rc = null;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getRc() {
		return rc;
	}
	public void setRc(Node rc) {
		this.rc = rc;
	}
	public Node getLc() {
		return lc;
	}
	public void setLc(Node lc) {
		this.lc = lc;
	}
}
