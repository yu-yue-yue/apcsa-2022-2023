package stringsAndThings;

public class quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.pow(2, 31));
		
		double num = (double) (2/4) + 3;
		System.out.println(num);
		
		String str = "abcdef";
		for (int rep = 0; rep < str.length() - 1; rep++) {
			System.out.print(str.substring(rep, rep + 2));
		}
		
		System.out.println(what("evelyn", "e"));
		System.out.println(mystery("noon"));
		
		String[] testOne = {"first", "day", "of", "spring"};

		String[] resultOne = strArrMethod(testOne);
		for(int i = 0; i < resultOne.length; i++) {
			System.out.println(resultOne[i]);
			
		}
		
		int x = 8; 
		int y = (x & 4) >> 2;
		System.out.println(y);
		
		System.out.println(countA("AAAppleA"));
	
	}
	
	public static int what(String str, String check) {
		int num = -1; 
		int len = check.length();
		for (int k = 0; k + len <= str.length(); k++) {
			String a = str.substring(k, k + len);
			if (a.equals(check)) {
				num = k;
			}
		}
		
		return num;
	}
	
	public static boolean mystery(String str) {
		String temp = "";
		for (int k = str.length(); k > 0; k--) {
			temp = temp + str.substring(k - 1, k);
		}
		
		return temp.equals(str);
	}
	
	public static String[] strArrMethod(String[] arr) {
		String[] result = new String[arr.length];
		for (int j = 0; j < arr.length; j++) {
			String sm = arr[j];
			for (int k = j + 1; k < arr.length; k++) {
				if(arr[k].length() < sm.length()) sm = arr[k];
			}
			result[j] = sm;
		}
		
		return result;
	}
	
	public static int countA(String str) {
		int count = 0;
		while(str.length() > 0) {
			int pos = str.indexOf("A");
			if (pos >= 0) {
				count++; 
				str = str.substring(pos + 1);

			}
			
			else return count;
		}
		return count;
	}
	
	
}
