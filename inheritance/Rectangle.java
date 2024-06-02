package inheritance;

import processing.core.PApplet;

public class Rectangle implements Drawable {
	private int x, y, width, height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}

	@Override
	public void draw(PApplet p) {
		// TODO Auto-generated method stub
		p.g.beginDraw();
		p.g.rect(x, y, width, height);
		p.g.endDraw();
	}

	
	
}
