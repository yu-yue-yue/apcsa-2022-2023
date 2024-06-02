package objectsAndClasses;

public class Cat {
	//fields - should be private generally
	private String name; 
	private int age;
	private boolean hasFur, isOwned, isAlive; 
	private double legs, furLength, height, weight;
	
	//constructors - no parameters
	
	public Cat() {
		//default values 
		//int, float, double, or other numerical - already is 0 
		//boolean - false 
		//for other object types (String) -> null 
		
		name = "Jeremiah";
		age = 10;
		legs = 4;
		isAlive = true;
		hasFur = true;
		height = 1;
		weight = 12;
		furLength = 3;
		
	}
	// overloading - multiple constructors or methods with the same name 
	// but a different parameter signature
	public Cat(String name, int age) {
		//defensive programming
			
		if (age < 0 || age > 20) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.age = age;
		legs = 4;
		isAlive = true;
		hasFur = true;
		height = 1;
		weight = 12;
		furLength = 3;
		
		
		
	}
	public Cat(String name, int age, boolean hasFur, boolean isOwned, double legs, double furLength, double height,
			double weight) {
		super();
		this.name = name;
		this.age = age;
		this.hasFur = hasFur;
		this.isOwned = isOwned;
		this.legs = legs;
		this.furLength = furLength;
		this.height = height;
		this.weight = weight;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getAge() {
		return this.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		if (age >= 0)
			this.age = age;
		else 
			System.out.println("Can't set age to a negative numeber.");
	}
	
	public void eatLasagna() {
		this.weight += 1;
	}

	public void eatLasagna(int amount) {
		for(int i = 0; i < amount; i++)
			eatLasagna();
	}
	
	public void eatLasagna(double weight) {
		this.weight += weight;
	}
	
	// toString returns the package and the class and the hexadecimal value
	
	@Override 
	public String toString() {
		return "Name: " + name + "\n" +
				"Age: " + age + " years old\n" +
				"Height: " + height + " feet\n" +
				"Number of legs: " + legs + "\n" +
				"Is fat? " + (weight > 25) + "\n";
				
	}
	
	public boolean equals(Object other) {
		if (other == null)
			return false; 
		if (!(other instanceof Cat))
			return false;
		
		Cat otherCat = (Cat) other;
		
		return this.isAlive == otherCat.isAlive && 
				this.name.equals(otherCat.name);
		
		//primitive values - boolean, car, and int use ==
		// double and float shouldn't use == 
		// objects - .equals()
		
		
	}
	
}
