package inheritance;

public class GradStudent extends Student {
	private Person advisor;
	
	public GradStudent(String name, int gradYear, Person advisor) {
		super(name, gradYear);
		this.advisor = advisor;
	}
	
	public int getGraduationYear() {
		return 2030;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("Advisor: " + advisor.getName());
		advisor.printInfo();
	}
	
	public Person getAdvisor() {
		return advisor;
	}
	
	// When would we actually do this? 
	// Collections, such as Lists 
	
	
}
