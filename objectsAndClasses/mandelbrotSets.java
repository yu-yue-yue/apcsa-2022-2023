package objectsAndClasses;

import java.util.ArrayList;

public class mandelbrotSets {
    //fields - set of ComplexNumbers that are in the mandelbrot set
    //ArrayList - allows us to store any object, and as many as we want
    //<> - represent a 'generic'
    private ArrayList<ComplexNumber> set;
    
    
    public ArrayList<ComplexNumber> getSet() {
		return set;
	}

	public void setSet(ArrayList<ComplexNumber> set) {
		this.set = set;
	}

	//Constructor
    public mandelbrotSets(double lowR, double highR, double incR,
            double lowI, double highI, double incI) {
        set = new ArrayList<ComplexNumber>(); //calling the ArrayList constructor
        //creates an empty list that can store ComplexNumber objects
        generateSet(lowR, highR, incR, lowI, highI, incI);
    }
    
    public void generateSet(double lowR, double highR, double incR,
                            double lowI, double highI, double incI) {
        //write two for loops, use 'r' and 'i' as the variables
        for(double r = lowR; r <= highR; r += incR)
            for(double i = lowI; i <= highI; i += incI) {
                ComplexNumber c = new ComplexNumber(r, i);
                if(isInSet(c))
                    set.add(c); 
                //ArrayList method 'add' - puts 'c' into the list at the end
            }
    }
    
    public boolean isInSet(ComplexNumber c) {
        ComplexNumber z_n = new ComplexNumber(0, 0);
        for(int i = 0; i < 100; i++)
        {
            ComplexNumber z_n_1 = z_n.times(z_n).plus(c);
            z_n = z_n_1;
        }
        
        if (z_n.getModulus() <= 2)
        	return true;
        return false;
        //Start here modulus
    }

    public static void main(String[] args) {
       
    }
    
}


