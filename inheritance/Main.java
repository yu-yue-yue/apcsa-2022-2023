package inheritance;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("Bill");
		Person p2 = new Person("Bob");
		p.printInfo();
		p2.printInfo();
		
		Student s = new GradStudent("Alice", 2023, p);
		s.printInfo();
		// Example of polymorphism
		// 's' is a vriable representing a Student (compile time)
		// but at runtime it always runs GradStudent printInfo
		
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(p);
		people.add(p2);
		people.add(s);
		
		people.sort(null);
		
		System.out.println();
		for (Person person : people) {
			person.printInfo();
			System.out.println();
		}
		
	}
	
	

}
