package searchingAndSorting;

import java.util.Arrays;

public class dataCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = generateRandomNumbers(10);
//		Sorter s = new Sorter(a);
//		s.quickSort(3);
//		s.printArray();
		
		compareIntroSorts();
		
	}
	
	public static int[] generateRandomNumbers(int n) {
		int[] a = new int[n];
		for (int i = 0; i <n; i++)
			a[i] = (int) (Math.random()*n*3);
		return a;
	}
	
	public static void compareFastSorts() {
		long QCS = 0;
		long QSS = 0;
		long MCS = 0;
		
		long MSS = 0;
		long HCS = 0;
		long HSS = 0;

		double QTT = 0;
		double MTT = 0;
		double HTT = 0;
		int numTrials = 10;
		
		for(int n = 0; n < 500000; n += 10000) {
			for (int i = 0; i < numTrials; i++) {
				int[] a = generateRandomNumbers(n);
				int[] copyA = Arrays.copyOf(a, a.length);
				Sorter s = new Sorter(a);
				
				long startTimeA = System.nanoTime();
				s.quickSort(1, 0);
				double elapsedTimeA = ((System.nanoTime() - startTimeA)/Math.pow(10, 9));
				QSS += s.getNumSwaps();
				QCS += s.getNumComparisons();
				QTT += elapsedTimeA;
				
				int[] b = Arrays.copyOf(copyA, a.length);
				Sorter t = new Sorter(b);
				long startTimeB = System.nanoTime();
				t.mergeSort();
				double elapsedTimeB = ((System.nanoTime() - startTimeB)/Math.pow(10, 9));
				MSS += t.getNumSwaps();
				MCS += t.getNumComparisons();
				MTT += elapsedTimeB;
				
				int[] c = Arrays.copyOf(copyA, a.length);
				Sorter u = new Sorter(c);
				long startTimeC = System.nanoTime();
				u.heapSort();
				double elapsedTimeC = ((System.nanoTime() - startTimeC)/Math.pow(10, 9));

				HSS += u.getNumSwaps();
				HCS += u.getNumComparisons();
				HTT += elapsedTimeC;
				
			}
			
			
			System.out.print(n + "\t");
			
			System.out.print(QCS/numTrials + "\t");
			System.out.print(MCS/numTrials + "\t");
			System.out.print(HCS/numTrials + "\t");
			
			System.out.print(QSS/numTrials + "\t");
			System.out.print(MSS/numTrials + "\t");
			System.out.print(HSS/numTrials + "\t");

			System.out.print(QTT/numTrials + "\t");
			System.out.print(MTT/numTrials + "\t");
			System.out.println(HTT/numTrials + "\t");
			
		}
	}
	
	public static void compareQuickSorts() {
		int numTrials = 10;
		
		long C1 = 0;
		long C2 = 0;
		
		long S1 = 0;
		long S2 = 0;
		
		double T1 = 0;
		double T2 = 0;
		
		for(int n = 0; n < 1000000; n += 20000) {
			for (int i = 0; i < numTrials; i++) {
		
				int[] a = generateRandomNumbers(n);
				int[] copyA = Arrays.copyOf(a, a.length);
				Sorter s = new Sorter(a);
				
				long startTimeA = System.nanoTime();
				s.quickSort(1, 0);
				double elapsedTimeA = ((System.nanoTime() - startTimeA)/Math.pow(10, 9));
				S1 += s.getNumSwaps();
				C1 += s.getNumComparisons();
				T1 += elapsedTimeA;
				
				int[] b = Arrays.copyOf(copyA, a.length);
				Sorter t = new Sorter(b);
				long startTimeB = System.nanoTime();
				t.quickSort(2, 0);
				double elapsedTimeB = ((System.nanoTime() - startTimeB)/Math.pow(10, 9));
				S2 += t.getNumSwaps();
				C2 += t.getNumComparisons();
				T2 += elapsedTimeB;
			}
			
			System.out.print(n + "\t");
			
			System.out.print(C1/numTrials + "\t");
			System.out.print(C2/numTrials + "\t \t" );
			
			System.out.print(n + "\t");
			
			System.out.print(S1/numTrials + "\t");
			System.out.print(S2/numTrials + "\t \t");

			System.out.print(n + "\t");
			
			System.out.print(T1/numTrials + "\t");
			System.out.println(T2/numTrials + "\t");
		}
		
	}
	
	public static void compareIntroSorts() {
		
		int numTrials = 10;
		
		
		for(int n = 0; n < 1000000; n += 20000) {
			System.out.print(n + "\t");
			for(int j = 3; j < 10; j++) {
			
//				long comps = 0;
//				long swaps = 0;
				double time = 0;
				
				for (int i = 0; i < numTrials; i++) {
					int[] a = generateRandomNumbers(n);
					Sorter s = new Sorter(a);
					
					long startTimeA = System.nanoTime();
					s.quickSort(1, j);
					double elapsedTimeA = ((System.nanoTime() - startTimeA)/Math.pow(10, 9));
//					swaps += s.getNumSwaps();
//					comps += s.getNumComparisons();
					time += elapsedTimeA;
					
				}
				

//				System.out.print(comps/numTrials + "\t");
//				System.out.print(swaps/numTrials + "\t");
				System.out.print(time/numTrials + "\t");
			}
			
			System.out.println();
		
		}
	}
	

}
