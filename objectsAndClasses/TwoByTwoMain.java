package objectsAndClasses;

public class TwoByTwoMain {
    public static void main(String[] args) {
        TwoByTwoMatrix identity = new TwoByTwoMatrix();
        TwoByTwoMatrix A = new TwoByTwoMatrix(1, 2, 3, 4);
        System.out.println(A);
        System.out.println(A.multiply(identity));
    
    }
}
