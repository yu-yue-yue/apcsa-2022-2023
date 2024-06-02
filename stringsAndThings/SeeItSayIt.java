package stringsAndThings;

import java.util.Collections;
import java.util.ArrayList;

public class SeeItSayIt {

	public static void main(String[] args) {
		//"1"
		String s = "445555511111133";	
		
		int n = 20; //repeats
		for(int i = 0; i < n; i++)
		{
			String out = "";
			for(String string : splitString(s))
			{
				out += say(string);
			}
			s = out;
			System.out.println(i + ": " + out);
		}
	}

	private static String say(String number) {
               //Ex: "111" -> "31" => count + 
		String result = "";
		char n = number.charAt(0); 
		int count = 0;
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) == n)
				count++;
			else {
				result += count;
				result += n;
				n = number.charAt(i);
				count = 1;
			}
			
			
		}
		
		result += count;
		result += n;
		
		return result;
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	private static ArrayList<String> splitString(String number)
	{
		ArrayList<String> strings = new ArrayList<String>();
		String s = "";
		
		char n = number.charAt(0);
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) != n)
			{
				strings.add(s);
				s = "";
				n = number.charAt(i);
			}
			
			s += n;
		}
		
		strings.add(s);
		
		return strings;
		//break number down into substrings each of one number only
		//1211 -> ["1", "2", "11"]
		//312211 -> ["3", "1", "22", "11"]
	}

	//return a string that is the number, n times in a row
	//repeatNumber("3", 4) -> "3333"
	private static String repeatNumber(String number, int n)
	{
		String s = "";
		for (int i = 0; i < n; i++) {
			s += number;
		}
	
		return s;

	}


}