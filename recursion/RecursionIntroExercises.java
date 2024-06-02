package recursion;

public class RecursionIntroExercises {
	
	public static void main(String[] args) {
		printFiftyNatural(50);
		System.out.println(sumToN(5));
		int[] n = new int[] {1, 2, 3};
		
		System.out.println(sumDigits(254));
		
		System.out.println(firstCapital("mymOm"));
		hailstone(27);
		printArray(n);
	}
	
	
	public static void printFiftyNatural(int n) {
		System.out.println(50 - n + 1);
		if (n == 1);
		
		else {
			printFiftyNatural(n - 1);
		}
		
	}
	
	
	public static int sumToN(int n) {
		if (n == 1) return n;
		
		return n + sumToN(n - 1);
	}
	
	public static void printArray(int[] n) {
		printArrayHelper(n, 0);
	}
	
	
	private static void printArrayHelper(int[] n, int index) {
		System.out.print(n[index] + " ");
		if (index == n.length - 1);
		else printArrayHelper(n, index + 1);
	}
	
	public static int sumDigits(int n) {
		if (n == 0) return 0;
		
		return(n%10 + sumDigits(n/10));
	}
	
	
	public static int firstCapital(String s) {
		return firstCapitalHelper(s, 0);
	}
	
	private static int firstCapitalHelper(String s, int startIndex) {
		char[] c = s.toCharArray();
		if (startIndex == c.length) return -1;
		else if (Character.isUpperCase(c[startIndex])) return startIndex;
		else {
			return (firstCapitalHelper(s, startIndex + 1));
		}
		
	}	
	
	
	public static void hailstone(int n) {
		System.out.println(n + " ");
		if (n == 1);
		else if (n%2 == 0) hailstone(n/2);
		else hailstone(3*n + 1);
		
	}
	
}
