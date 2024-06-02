package recursion;

public class pascalsTriangle {

	public static void main(String[] args) {
		print(5);
	}
	
	
	public static void print(int n) {
		System.out.print("*");
		if (n > 0) print(n - 1);
		System.out.print("!");

		}
}
