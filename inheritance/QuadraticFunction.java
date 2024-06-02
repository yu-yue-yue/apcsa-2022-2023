package inheritance;

public class QuadraticFunction implements Function {

	private int a, b, c;
	
	public QuadraticFunction(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public int getValue(int x) {
		// TODO Auto-generated method stub
		return a*x*x + b*x + c;
	}

	@Override 
	public String toString() {
		if (b >= 0 && c >= 0) return a + "x^2 + " + b + "x + " + c;
		else if (b >= 0) return a + "x^2 + " + b + "x - " + -1*c;
		else if (c >= 0) return a + "x^2 - " + -1*b + "x + " + c;
		else return a + "x^2 - " + -1*b + "x - " + -1*c;
		
			
	}
}
