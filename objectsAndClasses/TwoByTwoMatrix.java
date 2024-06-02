package objectsAndClasses;

public class TwoByTwoMatrix {
	//Fields
	private double a, b, c, d;
	//constructors
	public TwoByTwoMatrix(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;

	}
	// No parameters, creates the Identity Matrix
	public TwoByTwoMatrix() {
		a = 1;
		d = 1; 
		// b, c default values are 0.0
	}

	public TwoByTwoMatrix(double a) {
		this.a = a;
		this.b = a;
		this.c = a;
		this.d = a;
	}

	public String toString() {
		return "[" + a + " " + b + "]\n" + "[" + c + " " + d + "]\n";
	}

	public TwoByTwoMatrix add(TwoByTwoMatrix other) {
		return new TwoByTwoMatrix(this.a + other.a, this.b + other.b, this.c + other.c, this.d + other.d);
	}	
	public TwoByTwoMatrix multiply(double scalar) {
		return new TwoByTwoMatrix(scalar*this.a, scalar*this.b, scalar*this.b, scalar*this.d);
	}

	public TwoByTwoMatrix multiply(TwoByTwoMatrix other) {
		return new TwoByTwoMatrix(this.a*other.a + this.b*other.c, 
		this.a*other.b + this.b*other.d,
		this.c*other.a + this.d*other.c,
		this.c*other.b + this.d*other.d);
	}

	public double getDeterminant() {
		return a*d - b*c;
	}

	public TwoByTwoMatrix getInverse() {
		double det = getDeterminant();
		if (det == 0) {
			System.out.println("No inverse exists.");
		}

		return new TwoByTwoMatrix(d, -b, -c, a).multiply(1/det);
	}

	public boolean equals(Object other) {
		
		if (other == null || !(other instanceof TwoByTwoMatrix))
			return false;

		TwoByTwoMatrix mat = (TwoByTwoMatrix) other;

		if (Math.abs(a - mat.a) == 0 &&
		Math.abs(b - mat.b) == 0 &&
		Math.abs(c - mat.c) == 0 &&
		Math.abs(d - mat.d) == 0
		)
			return true;

		return false;
		// null check 
		// instanceof check 
		// |a-other.a| < 0.000000001, same for b c and d
	}
}
