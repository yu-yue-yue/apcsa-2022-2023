package objectsAndClasses;

public class Character {

	private Color color;
	private float size; 
	private float x; 
	private float y;
	
	public Character(float x, float y, float size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;

	}
	
	
	public void moveCharacter(int mouseX, int mouseY) {
		x = mouseX;
		y = mouseY;
	}


	public Color getColor() {
		return color;
	}


	public float getSize() {
		return size;
	}


	public float getX() {
		return x;
	}


	public float getY() {
		return y;
	}
	
	public boolean collidingWith(Circle other) {
		float distance = (float) Math.sqrt((x - other.getX())*(x - other.getX()) + 
				(y - other.getY())*(y - other.getY()));
		
		if (distance <= (size/2 + other.getSize()/2)) 
			return true;
		
		return false;
		
	}
	
	public void grow() {
		size++;
	}
	
	
}
