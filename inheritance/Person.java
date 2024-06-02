package inheritance;
	
public class Person implements Comparable<Person> {
	private String name;
	private String email;
	private int IDNum;
	private static int PERSON_COUNT = 0;
		
	public Person(String name) {
		super(); // Calling Object() constructor (implied)
		this.name = name;
		email = name + "@fake.edu";
		IDNum = PERSON_COUNT;
		PERSON_COUNT++;
	}
		
	public void printInfo() {
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("ID: " + IDNum);
	}
		
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.getName());
		// TODO Auto-generated method stub
	}
	
	}
