package inheritance;

public class LinearFunction implements Function {
	
	private int a, b;

	public LinearFunction(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int getValue(int x) {
		// TODO Auto-generated method stub
		return a*x + b;
	}
	
	@Override 
	public String toString() {
		if (b >= 0) return a + "x + " + b;
		else return a + "x - " + -1*b;
		
			
	}
	
	

}
