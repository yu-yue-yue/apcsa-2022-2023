package stringsAndThings;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageEncoder extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("stringsAndThings.ImageEncoder");
		
	}
	
	public void settings() {
		size(800, 800);
	}
	
	public void setup() {
		encodeImage("Images/moon2.png", "My name is Evelyn and I "
				+ "think that coding can be very challenging, "
				+ "but it is often also rewarding.");
		println(decodeImage("Images/encoded_moon2.png"));
		
	}
	
	public void draw() {
		
	}
	
	public String decodeImage(String imagePath) {
		String message = "";
		
		PImage img = loadImage(imagePath);
		image(img, img.width, 0);
		img.loadPixels();
		
		int messLen = 0;
		byte n = 0; 
		for (int j = 0; j < 8; j ++) {
			int pixel = img.pixels[j];
			byte alpha = (byte) (pixel >> 24);
			byte red = (byte) (pixel >> 16 & 255);
			byte green = (byte) (pixel >> 8 & 0xFF);
			byte blue = (byte) (pixel & 0b11111111);
			
			println(alpha + ", " + red + ", " + green + ", " + blue);
			
			n = (byte) ((n << 1) | (alpha & 1));
			n = (byte) ((n << 1) | (red & 1));
			n = (byte) ((n << 1) | (green & 1));
			n = (byte) ((n << 1) | (blue & 1));
			
			messLen = (messLen << 4) | (n);
			
		}
		
		println(messLen);
		
		byte b = 0;
		for (int i = 0; i < messLen; i++) {
			for (int j = 0; j < 2; j ++) {
				int pixel = img.pixels[8 + 2*i + j];
				byte alpha = (byte) (pixel >> 24);
				byte red = (byte) (pixel >> 16 & 255);
				byte green = (byte) (pixel >> 8 & 0xFF);
				byte blue = (byte) (pixel & 0b11111111);
				
				println(alpha + ", " + red + ", " + green + ", " + blue);
				
				b = (byte) ((b << 1)| (alpha & 1));
				b = (byte) ((b << 1) | (red & 1));
				b = (byte) ((b << 1) | (green & 1));
				b = (byte) ((b << 1) | (blue & 1));
			}
			message += (char) b;
		}
		
		
		return message;
	}
	
	public void encodeImage(String imagePath, String message) {
		byte[] bytesToHide = encodeMessage(message);
		PImage img = loadImage(imagePath);
		image(img, 0, 0);
		
		img.loadPixels();
		for (int i = 0; i < bytesToHide.length; i++) {
			byte b = bytesToHide[i]; // 8 bits = 2 pixels
			for (int j = 0; j < 2; j ++) // 2 pixels per bit 
			{
				int pixel = img.pixels[2*i + j];
				byte alpha = (byte) (pixel >> 24);
				byte red = (byte) (pixel >> 16 & 255);
				byte green = (byte) (pixel >> 8 & 0xFF);
				byte blue = (byte) (pixel & 0b11111111);
				
				alpha = (byte) (alpha & 0b11111110 | (b >> (7 - j*4) & 1));
				red = (byte) (red & 0b11111110 | (b >> (6 - j*4) & 1));
				green = (byte) (green & 0b11111110 | (b >> (5 - j*4) & 1));
				blue = (byte) (blue & 0b11111110 | (b >> (4 - j*4) & 1));
			
				img.pixels[2*i + j] = color(red & 0xFF, green & 0xFF, blue & 0xFF, alpha & 0xFF);
			}
			
		}
		
		img.updatePixels();
		
		String outputPath = null;
		int lastSlash = imagePath.lastIndexOf('/');
		if (lastSlash >= 0) {
			outputPath = imagePath.substring(0, lastSlash + 1) + 
				"encoded_" + 
				imagePath.substring(lastSlash + 1); 
			}
		else {
			outputPath = "encoded_" + imagePath;
		}
		
		System.out.println(outputPath);
		img.save(savePath(outputPath));
			
	}
	
	/**
	 * Encode a string message into a byte array. The first four bytes of the array 
	 * will respresent the length of the message.  The other characters in the message 
	 * will each by represented with one byte based on their ASCII values.
	 * @param message
	 * @return
	 * 
	 */
	public byte[] encodeMessage(String message) {
		byte[] b = new byte[4 + message.length()];
		int x = message.length(); // save x in the first 4 bytes
		b[0] = (byte) (x >> 24);
		b[1] = (byte) (x >> 16);
		b[2] = (byte) (x >> 8);
		b[3] = (byte) (x);
		
		for(int i = 0; i < message.length(); i++) {
			b[i + 4] = (byte) message.charAt(i);
		}
		
		println(b);
		
		return b;
	}

}
