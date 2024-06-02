package objectsAndClasses;

public class Color extends java.lang.Object {

	private int blue;
	private int green;
	private int red;
	
	public Color(int r, int g, int b) {
		red = r; 
		green = g;
		blue = b;
	}
	
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	
	public boolean equals(java.lang.Object other) {
		if (other == null || ! (other instanceof Color))
			return false;
		
		Color comp = (Color) other;
		
		return (comp.red == red && comp.blue == blue && comp.green == green);
	
	}
	
}
