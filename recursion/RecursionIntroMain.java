package recursion;

public class RecursionIntroMain {
	public static void main(String[] args) {
		System.out.println(goodFib(40));
		System.out.println(countCalls);
		countCalls = 0;
		System.out.println(goodFib(35));
		System.out.println(countCalls);
		countCalls = 0;
		System.out.println(goodFib(45));
		System.out.println(countCalls);
	}
	
	static long countCalls = 0;
	
	static int[] fibs = new int[1000];
	public static int goodFib(int n) {
		countCalls++;
		if (fibs[n] != 0) return fibs[n];
		
		if(n == 0 || n == 1) {
			fibs[1] = 1;
			return n;
		}
		
		int firstResult = goodFib(n-1);
		fibs[n-1] = firstResult;
		fibs[n] = firstResult + fibs[n-2];
		return fibs[n];
			
		
		
	}
	
	
}
