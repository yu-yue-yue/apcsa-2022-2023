package inheritance;

public class Student extends Person {
	// Error is coming from the fact that Person does not have a // 0 parameter constrcutor (default constructor)
	private int graduationYear;
	
	public Student(String name, int gYear) {
		super(name); //Good idea 
		// Bad Idea: super("name");
		graduationYear = gYear;
	}
	
	public int getGraduationYear() {
		return graduationYear;
	}
	
	@Override 
	public void printInfo() {
		super.printInfo();
		System.out.println("Graduation Year: " + getGraduationYear());
		
	}
}
