package processing;
import processing.core.PApplet;
import processing.core.PImage;

public class Slideshow extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("processing.Slideshow");
	}

	public void settings() {
		size(1000, 600);
	}
	
	
	
	int index = 0, numPics = 10;
	PImage[] images; // an array of PImage
	// Note: Error - NullPointerException -> 'new' keyword
	
	public void setup() {
		//frameRate(3);
		images = new PImage[numPics];
		
		for(int i = 0; i < numPics; i++) {
			images[i] = loadImage("Images/pic" + i + ".jpg");
			
			if (images[i].height/images[i].width >= height/width)
				images[i].resize(0, height);
			else if (images[i].height/images[i].width < height/width)
				images[i].resize(width, 0);
			
			
			applyFilters(images[i]);	
			
		}
		
	}
	
	

	public void draw() {
		image(images[index], width/2 - images[index].width/2, 
				height/2 - images[index].height/2);
		
		
	
		//index++;
		
		
	}
	
	public void applyFilters(PImage img) {
		img.loadPixels();
		
		for(int i = 0; i < img.pixels.length; i++) {
			
			int pixel = img.pixels[i]; // 32 bits -> r, g, b, alpha (8 bits each)
			int r = pixel >> 16 & 0xFF;
			int g = pixel >> 8 & 0xFF;
			int b = pixel & 0xFF;
			
			int grayscale = color((r+g+b)/3);
			int inverse = color(225-r, 225-g, 225-b);
			int blueLight = color(0, 0, b);
			int brightness = color(r+10, g+10, b+10);
			
			img.pixels[i] = color(r, g, b);
			
			
			
;		}
	}
	
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == RIGHT) {
				index++;
				if (index == numPics)
					index = 0;
			}
			
			else if(keyCode == LEFT) {
				index--;
				if (index == 0)
					index = numPics-1;
			}
			
			background(255);
			
			
		}
		
		if(key == ' ') {
			index = (int) (Math.random()*numPics);
			loop();
			
			background(255);
		}
	}

}
