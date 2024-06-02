package inheritance;

public abstract class Poem {
	
	
	public Poem() {
		
	}
	
	public abstract int getNumLines();
	
	public abstract int getNumSyllables(int k);
	
	public void printRhythm() {
		for (int i = 0; i < getNumLines(); i++) {
			for(int j = 0; j < getNumSyllables(j); j++) {
				if (j == getNumSyllables(j) - 1) System.out.print("la");
				else System.out.print("la-");
			}
			System.out.println();
		}
	}
}
