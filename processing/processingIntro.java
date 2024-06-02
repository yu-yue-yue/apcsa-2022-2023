package processing;

import processing.core.PApplet;

public class processingIntro extends PApplet{

	public static void main(String[] args) {
		//"packageName.ClassName
		PApplet.main("processing.processingIntro");

	}
	public void settings() {
		// 2 options : 
//		fullScreen();
		size(800, 600); // width = 800, height = 600
	}
	
	
	// runs once at the beginning
	// do not capitalize up
	public void setup() {
		background(255);
	}
	
	int x = 400, y = 300;
	int i = 0;
	int j = 0;
	
	public void randomColor() {
		int r = (int) (Math.random()*255);
		int b = (int) (Math.random()*255);
		int g = (int) (Math.random()*255);
		fill(r, g, b);
	}
	
	
	// runs once every frame 
	public void draw() {
		
			x = mouseX;
			y = mouseY;
			
			
			
			float waveY = (float) (10*Math.sin(j) + y);
			float waveX = (float) (10*Math.sin(j) + x);
			
			ellipse(x+i, waveY, 10, 10);
			randomColor();
			
			
			ellipse(x-i, waveY, 10, 10);
			randomColor();
			
			ellipse(waveX, y+i, 10, 10);
			randomColor();
			
			ellipse(waveX, y-i, 10, 10);
			randomColor();
			
			i += 10;
			i %= 200;
			
			j += 1;
			j %= 20;
			
			if (i == 0) {
				background(255);
			}

		
	}
}
