package objectsAndClasses;

public class Triangle {
	private double side1, side2, side3;
	
	public Triangle(double side1, double side2, double side3) {
		if (side1 <= 0 || side2 <= 0 || side3 <= 0) 
			throw new IllegalArgumentException();
		if(side1 >= side2 + side3 || 
			side2 >= side1 + side3 || 
			side3 >= side2 + side1)
			throw new IllegalArgumentException();
		
			
		
		
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
	public boolean isAnIsoscelesTriangle() {
		return (side1 == side2 || side2 == side3 || side1 == side3);
	}
	
	public boolean isARightTriangle() {
		return (side1*side1 == side2*side2 + side3*side3 || 
				side2*side2 == side1*side1 + side3*side3 ||
				side3*side3 == side2*side2 + side1*side1);
	}
	
	public double getArea() {
		// half perimeter
		double s = (side1 + side2 + side3)/2;
		
		return (Math.sqrt(s*(s - side1)*(s - side2)*(s - side3)));
		
	}
	
	public boolean isCongruent(Triangle compare) {
		
		if (this.side1 == compare.side1 && this.side2 == compare.side2 &&
			this.side3 == compare.side3)
			return true;
		if (this.side1 == compare.side1 && this.side2 == compare.side3 &&
				this.side3 == compare.side2)
			return true;
		if (this.side1 == compare.side2 && this.side2 == compare.side3 &&
				this.side3 == compare.side1)
			return true;
		if (this.side1 == compare.side2 && this.side2 == compare.side1 &&
				this.side3 == compare.side3)
			return true;
		if (this.side1 == compare.side3 && this.side2 == compare.side1 &&
				this.side3 == compare.side2)
			return true;
		if (this.side1 == compare.side3 && this.side2 == compare.side2 &&
				this.side3 == compare.side1)
			return true;
		
		else 
			return false;
	}
	
	public boolean equals(Triangle compare) {
		if (compare == null) 
			return false;
		
		return this.isCongruent(compare);
	}
}
