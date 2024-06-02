package objectsAndClasses;

import java.util.ArrayList;

import processing.core.PApplet;

public class DrawMandelBrotSet extends PApplet {
	public static void main(String[] args) {
		PApplet.main("objectsAndClasses.DrawMandelBrotSet");
		
	}
	int w = 800;
	int h = 600;
	public void settings() {
		
		size(w, h);
		
		}
	
	ArrayList<ComplexNumber> set;
	
	double lowR, highR, incR, lowI, highI, incI;
	
	public void setup() {
		
		lowR = -2;
		highR = 1;
		incR= 0.02;
		lowI = -1;
		highI = 1;
		incI = 0.02;
		
		
	}
	
	public void draw() {
		background(255);
		
		mandelbrotSets ms = new mandelbrotSets(lowR, highR, incR, lowI, highI, incI);
		set = ms.getSet();
		
		for (ComplexNumber c : set) {
			// draw an ellipse at the appropriate coordinate
			ellipse((float) realToX(c.getReal()), (float) imagToY(c.getImaginary()), 3, 3);
		}
		
		
		noLoop();
		keyPressed();
		
		
	}
	
	public void keyPressed() {
		if (key == '=') // Increase Resolution
		{
			incR /= 2;
			incI /= 2;
		}
		
		else if (key == '-') // Decrease Resolution)
		{
			incR *= 2;
			incI *= 2;
		}
		
		redraw();
			
	}

	
	public void mousePressed() {
		if (mouseButton == LEFT)
		{
			// zoom in around (mouseX, mouseY)
			double r = XToReal(mouseX);
			double i = YToImag(mouseY);
			double oldRangeR = highR - lowR;
			double oldRangeI = highI - lowI;
			highR = r + oldRangeR/4;
			lowR = r - oldRangeR/4;
			incR /= 2;
			highI = i + oldRangeI/4;
			lowI = i - oldRangeI/4;
			incI /= 2;
		}
		
		else if (mouseButton == RIGHT)
		{
			// zoom in around (mouseX, mouseY)
			double r = XToReal(mouseX);
			double i = YToImag(mouseY);
			double oldRangeR = highR - lowR;
			double oldRangeI = highI - lowI;
			highR = r + oldRangeR;
			lowR = r - oldRangeR;
			incR *= 2;
			highI = i + oldRangeI;
			lowI = i - oldRangeI;
			incI *= 2;
		}
		
		
		loop();
	}
	
		
	public double realToX(double r) {
		return (r - lowR)*w/(highR - lowR);
	}
	
	public double imagToY(double i) {
		return (h - (i - lowI)*h/(highI - lowI));
	}
	
	public double XToReal(double x) {
		return (x*(highR - lowR)/w) + lowR;
	}
	
	public double YToImag(double y) {
		return (h - y)*(highI - lowI)/w + lowI ;
	}
}
