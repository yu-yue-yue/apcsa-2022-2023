package searchingAndSorting;

public class m3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] years = new int[] {12, 13, 14, 15, 16, 18, 20, 21, 22};
		int[] USBikes = new int[] {70, 159, 193, 130, 152, 369, 423, 416,750, 928};
		int[] ratio = new int[9];
		
		for (int i = 0; i < years.length; i++) {
			ratio[i] = USBikes[i]/years[i];
		}

	}

}
