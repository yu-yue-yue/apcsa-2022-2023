package objectsAndClasses;
/**
 * complex numbers of the form a + bi
 * can perform addition with another complex number
 * multiplication with doubles and other complex numbers
 * can raise complex nums to real powers
 * can do division by complex numbers
 * can find conjugates and moduluses
 * 
 * @author Evelyn Yu
 *
 */
public class ComplexNumber {
	
	private double real, imaginary;
	
	/**
	 * creates a complex number of value 0 + 0i
	 */
	public ComplexNumber() {
		real = 0;
		imaginary = 0;
	}
	
	/**
	 * creates a complex number
	 * @param r = real component
	 * @param i = imaginary component
	 */
	public ComplexNumber(double r, double i) {
		real = r;
		imaginary = i;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginary() {
		return imaginary;
	}

	public void setImaginary(double imaginary) {
		this.imaginary = imaginary;
	}
	
	/** 
	 * complex number addition	
	 * @param other: the complex number which you want to add
	 * @return the sum of the two complex numbers
	 */
	public ComplexNumber plus (ComplexNumber other) {
		return new ComplexNumber(real + other.real, imaginary + other.imaginary);
	}
	
	/**
	 * complex x real number multiplication
	 * @param other: the real number which you want to multiply the complex
	 * number by
	 * @return the product of the complex number and a real number
	 */
	public ComplexNumber times (double other) {
		return new ComplexNumber(real*other, imaginary*other);
	}
	
	
	/** 
	 * complex x complex number multiplication
	 * @param other: the complex number by which you are multiplying
	 * @return the product of the two complex numbers
	 */
	public ComplexNumber times (ComplexNumber other) {
		return new ComplexNumber(real*other.real - imaginary*other.imaginary,
				real*other.imaginary + imaginary*other.real);
	}
	
	/**
	 * complex / complex division
	 * @param other : the complex number by which you are dividing (divisor)
	 * @return the quotient of the two complex numbers
	 */
	public ComplexNumber dividedBy(ComplexNumber other) {
		if (other.real == 0 && other.imaginary == 0) 
			throw new IllegalArgumentException();
		double a = this.real;
		double b = this.imaginary;
		double c = other.real;
		double d = other.imaginary;
		
		return new ComplexNumber((a*c + b*d)/(c*c + d*d), (b*c - a*d)/(c*c + d*d));
	}
	
	/**
	 * raises the complex number to an integer exponent
	 * @param x = the integer exponent
	 * @return the complex number which results from the exponentiation
	 */
	public ComplexNumber pow(int x) {
		if (x <= 0) 
			throw new IllegalArgumentException();
		
		ComplexNumber result = new ComplexNumber(real, imaginary);
		
		for (int i = 1; i < x; i++) {
			result = result.times(this);
		}
		
		return result;
		
	}
	
	/**
	 * finds the modulus (square root of magnitude of the two components)
	 * @return the modulus
	 */
	public double getModulus() {
		return Math.sqrt(real*real + imaginary*imaginary);
	}
	
	/**
	 * finds the conjugate (a - bi) of a complex number (a + bi)
	 * @return the conjugate
	 */
	public ComplexNumber getConjugate() {
		return new ComplexNumber(real, -imaginary);
	}
	
	
	@Override
	public String toString() {
		
		double a = real*100;
		double b = imaginary*100;
		 
		a = Math.round(a);
		b = Math.round(b);
		
		a /= 100;
		b /= 100;
		
		if (imaginary < 0) 
			return a + "-" + Math.abs(b) + "i";
		
		else return a + "+" + b + "i";
		// still have to round them i'll do that later
	}
	
	public boolean equals(Object other) {
		if (other == null || ! (other instanceof ComplexNumber))
			return false;
		ComplexNumber comp = (ComplexNumber) other;
		return (real == comp.real && imaginary == comp.imaginary);
	}
	
	
	
	
}
