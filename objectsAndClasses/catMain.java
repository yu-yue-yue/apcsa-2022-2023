package objectsAndClasses;

public class catMain {
	public static void main(String[] args) {
		Cat jeremiah = new Cat();
		
		Cat cat = new Cat("Garfield", 5);
		cat.eatLasagna();
		cat.eatLasagna(3);
		cat.eatLasagna(5.0);
		System.out.println(jeremiah);
		System.out.println(cat);
	}
}
