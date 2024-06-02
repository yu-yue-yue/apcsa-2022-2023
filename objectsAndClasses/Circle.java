package objectsAndClasses;

public class Circle extends java.lang.Object {

	private int width, height;
	private float x, y, vx, vy, size;
	private Color color;
	
	public Circle(int w,  int h) {
		width = w;
		height = h;
		size = (float) Math.random()*70 + 10;
		respawn();
		
	}
	
	public Circle(int w, int h, float x, float y, 
			float vx, float vy, float s, Color c) {
		width = w;
		height = h;
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		size = s;
		color = c;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getSize() {
		return size;
	}

	public Color getColor() {
		return color;
	}
	
	public void move() {
		x += vx;
		y += vy;
	}
	
	public void update() {
		move();
		checkBoundary();
	}
	
	
	
	public void checkBoundary() {
		if (x < -size/2 || y < -size/2 || x > width + size/2 || y > height + size/2) {
			respawn();
		}
	}
	
	public void bounce() {
		if (x < -size/2 || x > width + size/2) {
			vx *= -1;
		}
		
		if (y < -size/2 || y > height + size/2) {
			vy *= -1;
		}
	}
	
	public void respawn() {
		vx = (float) (Math.random()*2 + 1);
		vy = (float) (Math.random()*2 + 1);
		
		int side = (int) (Math.random()*4);
		
		if (side == 0) {
			x = 0 - size/2;
			y = (float) Math.random()*height;	
			int random = (int) (Math.random()*2);
			if (random == 1) 
				vy *= -1;
		}
		
		if (side == 1) {
			x = width + size/2;
			y = (float) Math.random()*height;
			vx *= -1;
			int random = (int) (Math.random()*2);
			if (random == 1) 
				vy *= -1;
		}
		
		if (side == 2) {
			y = 0 - size/2;
			x = (float) Math.random()*width;
			
			int random = (int) (Math.random()*2);
			if (random == 1) 
				vx *= -1;
			
		}
		
		if (side == 3) {
			y = height + size/2;
			x = (float) Math.random()*width;
			vy *= -1;
			int random = (int) (Math.random()*2);
			if (random == 1) 
				vx *= -1;
			
		}
		
		color = new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255));
	}
	
	public void respawn(float playerSize) {
		respawn();
		size = (float) (Math.random()*playerSize + playerSize/2);
	}
	
	
	public void changeSize() {
		int sizeChange = (int) (Math.random()*2 - 1);
		size += sizeChange;
	}

	
	
}
