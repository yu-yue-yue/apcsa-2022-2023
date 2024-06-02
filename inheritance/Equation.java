package inheritance;

import java.util.ArrayList;

public class Equation {
	
	Function f;
	Function g;
	
	public Equation(Function f,  Function g) {
		this.f = f;
		this.g = g;
	}


	public ArrayList<Integer> solve() {
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		for (int i = -100; i < 101; i++) {
			if (f.getValue(i) == g.getValue(i)) solutions.add(i);
		}
		
		return solutions;
	}
	
}
