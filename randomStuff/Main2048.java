package randomStuff;

import processing.core.PApplet;

public class Main2048 extends PApplet {
	
	public static void main(String[] args) {
		PApplet.main("randomStuff.Main2048");
	}
	
	public void settings() {
		size(600, 600);
		
	}
	
	twentyfortyeight greg = new twentyfortyeight();
	
	public void setup() {
		for(int r = 0; r < 4; r++) {
			for(int c = 0; c < 4; c++) {
				
				strokeWeight(20);
				if (greg.getBoard()[r][c] != 0) {
					int log = (int) (Math.log(greg.getBoard()[r][c])/Math.log(2)) - 1;
					int value = (log*25) % 750;
					int red = 250 - value;
					int green = value;
					int blue = 0;
					
					if (red <= 0) {
						red = 0;
						green = 250 - (value - 250);
						blue = value - 250;
					}
					
					if (green <= 0) {
						green = 0;
						blue = 250 - (value - 500);
						red = value - 500;
					}
					
					fill(red, green, blue);
				}
				
				else fill(50);
				rect(r*width/4, c*height/4, width/4, height/4);
				
			}
		}


	}
	
	public void draw() {
		for(int r = 0; r < 4; r++) {
			for(int c = 0; c < 4; c++) {
				
				strokeWeight(20);
				if (greg.getBoard()[r][c] != 0) {
					int log = (int) (Math.log(greg.getBoard()[r][c])/Math.log(2));
					int value = (log*25) % 750;
					int red = 250 - value;
					int green = value;
					int blue = 0;
					
					if (red < 0) {
						red = 0;
						green = 250 - (value - 250);
						blue = value - 250;
					}
					
					if (green < 0) {
						green = 0;
						blue = 250 - (value - 500);
						red = value - 500;
					}
					
					fill(red, green, blue);
				}
				
				else fill(50);
				rect(c*height/4, r*width/4, height/4, width/4);
				
				if (greg.getBoard()[r][c] != 0) {
					fill(255);
					
					int value = greg.getBoard()[r][c];
					int length = 0;
					int temp = value;
					
					while (temp > 0) {
						temp /= 10;
						length++;
					}
					
					int size = 40 - length*5;
					
					textSize(size);
					text(value, 
							(c + .5f)*height/4 - size/4*length, 
							(r + .5f)*width/4 + size/2);
				}
				
			}
		}

	}
	
	public void keyPressed() {
		if(key == CODED) {
			if (keyCode == UP) {
				greg.move(0);
			}
			
			if (keyCode == DOWN) {
				greg.move(1);
			}
			
			if (keyCode == RIGHT) {
				greg.move(2);
			}
			
			if (keyCode == LEFT) {
				greg.move(3);
			}
		}
		
		
	}

}
