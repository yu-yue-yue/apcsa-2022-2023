package processing;
import processing.core.PApplet;

public class LSystems extends PApplet {

	public static void main(String[] args) {
		PApplet.main("processing.LSystems");
	}
	
	public void settings()  {
		size(1000, 600);
	}
	
	public void setup() {
		//print(generateDCString(5, "F"));
	}
	
	public void draw() {
		drawDragonCurve(300,300, 10, 3);
	}
	
	public void drawDragonCurve(float x, float y, int depth, int length) {
		String s = generateDCString(depth, "F");
		float direction = 0;
		for (int i = 0; i < s.length(); i++) {
			String letter = s.substring(i, i+1);
			if (letter.equals("+")) {
				direction += 90;
			}
			
			else if (letter.equals("-")) {
				direction -= 90;
			}
			
			else { //F and G both mean move forward
				float x2 = x + length*cos(radians(direction));
				float y2 = y + length*sin(radians(direction));
				
				line(x, y, x2, y2);
				x = x2;
				y = y2;
			}
		}
	}
	
	/**
	 * variables: F and G
	 * constants: + and -
	 * start: F
	 * rules: (F -> F+G), (G -> F-G)
	 * angle: 90 degrees
	 * 
	 */

	public String generateDCString(int depth, String s) {
		// Go through each letter in the string: 
		// if the letter is "F", replace it with "F+G"
		// if the letter is "G", replace it with "F-G"
		// if the letter is "-" or "+", replace it with itself
		
		// s = "F"; // Strings are immutable
		if (depth == 0)
			return s;
		
		String newS = ""; 
		
 		for (int i = 0; i < s.length(); i++) {
 			// String letter = "" + s.charAt(i); 
 			String letter = s.substring(i, i+1);
 			
 			if (letter.equals("F")) {
 				newS += "F+G";
 			}
 			
 			else if (letter.equals("G")) {
 				newS += "F-G";
 			}
 			
 			else {
 				newS += letter;
 			}
 		}
 		
 		return generateDCString(depth - 1, newS);
	}
}
