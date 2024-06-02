package stringsAndThings;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class iBeforeEMain {
	
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> words = new ArrayList<String>();
		Scanner sc = new Scanner(new File("test2.txt"));
		int numWords = 0;
		while(sc.hasNext()) {
			numWords++;
			words.add(sc.next());
		}
		
  //?ei - doesn't follow
  //cei - follows
  //?ie - follows
  //cie - doesn't follow
		
		int numApplicable = 0;
		int doubleCounted = 0;
		ArrayList<String> applicable = new ArrayList<String>();
		for (String word: words) {
			if (word.contains("ie") || word.contains("ei")) {
				applicable.add(word);
				numApplicable++;
			}
			
			if (word.contains("ie") && word.contains("ei"))
				doubleCounted++;
		}
		
		int numFollow = 0;
		for (String word: applicable) {
			if (word.contains("ie") && !word.contains("cie")) {
				numFollow++;
			}
			
			else if (word.contains("cei"))
				numFollow++;
			
		}
		
		int numNotFollow = 0;
		for (String word: applicable) {
			if (word.contains("ei") && ! word.contains("cei")) {
				numNotFollow++;
			}
			
			else if (word.contains("cie"))
				numNotFollow++;
		}
		
		System.out.println("total words: " + numWords);
		System.out.println("total applicable: " + numApplicable);
		System.out.println("total follow: " + numFollow);
		System.out.println("total not follow: " + numNotFollow);
		System.out.println("total double counted: " + doubleCounted);
		System.out.println(numFollow + numNotFollow - doubleCounted);
		System.out.println("percentage: " + (double) 100*numFollow/numApplicable);
		
  	
 }
}
 