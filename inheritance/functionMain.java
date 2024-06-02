	package inheritance;

public class functionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2, b = 0, c = -6;
		 Function fun1 = new LinearFunction(a, b);
		 Function fun2 = new QuadraticFunction(a, b, c);
		 System.out.println(fun1 + "\n" + fun2);
		 
		 Function fun3 = new LinearFunction(0, 1);
		 Function fun4 = new QuadraticFunction(1, 0, 0);
		 Equation e =  new Equation(fun3, fun4); 
		 
		 for (int i: e.solve()) System.out.println(i);
	}

}
