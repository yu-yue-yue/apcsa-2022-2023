package inheritance;

public class Limerick extends Poem {

	public Limerick() {
		
	}
	
	@Override
	public int getNumLines() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getNumSyllables(int k) {
		// TODO Auto-generated method stub
		if (k == 0 || k == 1 || k == 4) return 9;
		else return 6;
	}

	
}
