package inheritance;

public class Haiku extends Poem {

	public Haiku() {
		
	}
	@Override
	public int getNumLines() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getNumSyllables(int k) {
		// TODO Auto-generated method stub
		if (k == 0) return 3;
		if (k == 2) return 7;
		else return 3;
	}

}
