package searchingAndSorting;

import java.util.Arrays;

public class SortingHat {

	static long numComparisons = 0;
	static long numSwaps = 0;
	
	public static void main(String[] args) {
		getDataSlow();
	}
	
	public static void getDataSlow() {
		System.out.print("data size" + "\t");
		System.out.print("BTT" + "\t");
		System.out.print("STT"+ "\t");
		System.out.print("ITT" + "\t");
		System.out.print("BCS" + "\t");
		System.out.print("SCS" + "\t");
		System.out.print("ICS" + "\t");
		System.out.print("BSS" + "\t");
		System.out.print("SSS" + "\t");
		System.out.println("ISS" + "\t");
		int numTrials = 10;
		long BCS = 0;
		long BSS = 0;
		long SCS = 0;
		long SSS = 0;
		long ICS = 0;
		long ISS = 0;
		double BTT = 0;
		double STT = 0;
		double ITT = 0;
		for(int n = 0; n < 75000; n += 5000) {
			for (int i = 0; i < numTrials; i++) {
				int[] a = generateRandomNumbers(n);
				int[] copyA = Arrays.copyOf(a, a.length);
				
				numComparisons = 0;
				numSwaps = 0;
				long startTimeA = System.nanoTime();
				bubbleSort(a);
				double elapsedTimeA = ((System.nanoTime() - startTimeA)/Math.pow(10, 9));
				BTT += elapsedTimeA;
				BCS += numComparisons;
				BSS += numSwaps;
				
				a = Arrays.copyOf(copyA, a.length);
				numComparisons = 0;
				numSwaps = 0;
				long startTimeB = System.nanoTime();
				selectionSort(a);
				double elapsedTimeB = ((System.nanoTime() - startTimeB)/Math.pow(10, 9));
				STT += elapsedTimeB;
				SCS += numComparisons;
				SSS += numSwaps;
				
				a = Arrays.copyOf(copyA, a.length);
				numComparisons = 0;
				numSwaps = 0;
				long startTimeC = System.nanoTime();
				insertionSort(a);
				double elapsedTimeC = ((System.nanoTime() - startTimeC)/Math.pow(10, 9));
				ITT += elapsedTimeC;
				ICS += numComparisons;
				ISS += numSwaps;
				
			}
			System.out.print(n + "\t");
			System.out.print(BTT/numTrials + "\t");
			System.out.print(STT/numTrials+ "\t");
			System.out.print(ITT/numTrials + "\t");
			System.out.print(BCS/numTrials + "\t");
			System.out.print(SCS/numTrials + "\t");
			System.out.print(ICS/numTrials+ "\t");
			System.out.print(BSS/numTrials + "\t");
			System.out.print(SSS/numTrials + "\t");
			System.out.println(ISS/numTrials + "\t");
			
			
			BTT = 0;
			STT = 0;
			ITT = 0;
		}
		
	}
		
	public static void getDataFast() {
		long QCS = 0;
		long QSS = 0;
		long MCS = 0;
		long MSS = 0;
		double QTT = 0;
		double MTT = 0;
		int numTrials = 10;
		
		for(int n = 1000; n < 1000000; n += 1000) {
			for (int i = 0; i < numTrials; i++) {
				int[] a = generateRandomNumbers(n);
				int[] copyA = Arrays.copyOf(a, a.length);
				
				numComparisons = 0;
				numSwaps = 0;
				long startTimeA = System.nanoTime();
				quickSort(a);
				double elapsedTimeA = ((System.nanoTime() - startTimeA)/Math.pow(10, 9));
				QCS += numComparisons;
				QSS += numSwaps;
				QTT += elapsedTimeA;
				
				a = Arrays.copyOf(copyA, a.length);
				numComparisons = 0;
				numSwaps = 0;
				long startTimeB = System.nanoTime();
				mergeSort(a);
				double elapsedTimeB = ((System.nanoTime() - startTimeB)/Math.pow(10, 9));
				MCS += numComparisons;
				MSS += numSwaps;
				MTT += elapsedTimeB;
				
			}
			
			
			System.out.print(n + "\t");
			System.out.print(QCS/numTrials + "\t");
			System.out.print(QSS/numTrials + "\t");
			System.out.print(QTT/numTrials + "\t");
			System.out.print(MCS/numTrials+ "\t");
			System.out.print(MSS/numTrials + "\t");
			System.out.println(MTT/numTrials + "\t");
			
		}
		
	
	}
	
	private static void printArray(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) 
			System.out.print(a[i] + " ");
		System.out.println();
	}

	// in-place sorting algorithms: not making a new list
	// as opposed to returning a new list that is sorted 
	// and maintaining the original
	
	private static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length-1; i++) 
			if (a[i] > a[i + 1]) return false;
		return true;
	}
	
	public static int[] generateRandomNumbers(int n) {
		int[] a = new int[n];
		for (int i = 0; i <n; i++)
			a[i] = (int) (Math.random()*n*3);
		return a;
	}
	
	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			boolean didSwap = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				numComparisons++;
				if (a[j] > a[j + 1]) {
					
					swap(a, j, j + 1);
					didSwap = true;
				}

			} 
			if (!didSwap) break;
		}
	}

	private static void swap(int[] a, int j, int i) {
		// TODO Auto-generated method stub
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
		numSwaps++;
	}
	
	public static void selectionSort(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			
			for (int j = i + 1; j < a.length; j++) {
				numComparisons++;
				if(a[j] < a[minIndex])
					minIndex = j;
			}
			
			swap(a, i, minIndex);
		}
	}
	
	// FOR FUN! Implement selectionSort using recursion!
	
	public static void insertionSort(int[] a) {
		for(int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				numComparisons++;
				if (a[j] < a[j - 1]) swap(a, j, j - 1);
				else break;
			}
		}
	}
	
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
		
	}
	
	private static void quickSort(int[] a, int left, int right) {
		if (right - left < 1) return;
		if (right - left == 1)
			if (a[right] < a[left]) swap(a, right, left);
 		
		int p = partition(a, left, right);
		quickSort(a, left, p - 1);
		quickSort(a, p + 1, right);
	}
	
	private static int partition(int[] a, int left, int right) {
		int i = left;
		int j = right;
		int p = right;
		while(i != j) {
			while(i != j && a[i] < a[p]) {
				numComparisons++;
				i++;
			}
			while(i != j && a[j] >= a[p]) {
				numComparisons++;
				j--;
			}
			if(i != j) swap(a, i, j);
		}
		
		swap(a, i, p);
		return i;
	}
	
	public static void mergeSort(int[] a) {
		//Base case:
				if(a.length <= 1)
					return;
				
				//Subdivide array into two subarrays
				int[] left = new int[a.length/2];
				int[] right = new int[a.length - a.length/2];
				//right array gets the extra element
				
				//copy the values from a to left and right
				for(int i = 0; i < a.length; i++)
				{
					if(i < a.length/2)
						left[i] = a[i];
					else
						right[i-a.length/2] = a[i];
				}
				
				mergeSort(left);
				mergeSort(right);
						
				//merge left and right into a
				//left and right are sorted
				int l = 0; //index for left sublist
				int r = 0; //index for right sublist
				for(int i = 0; i < a.length; i++)
				{
					//if left or right list are depleted
					if(l == left.length) { //TODO: maybe change to while loop and use break
						a[i] = right[r];
						r++;
						continue; //go to the next iteration of the for loop
					}
					if(r == right.length) {
						a[i] = left[l];
						l++;
						continue;
					}
					
					//copy the values from 'left' and 'right' back into 'a'
					if(left[l] <= right[r])
					{	numComparisons++;
						a[i] = left[l];
						l++;
					}
					else 
					{	numComparisons++;
						a[i] = right[r];
						r++;
					}
				}
		
	}
	
	public static void heapSort(int[] a)
	{
		buildMaxHeap(a);
		int lastInd = a.length - 1;
		for(int i = 0; i < a.length-1; i++)
		{
			swap(a, 0, lastInd);
			lastInd -= 1;
			siftDown(a, 0, lastInd);
		}
	}
	
	private static void buildMaxHeap(int[] a)
	{
		//Assume starting unsorted list
		//start at the first node with children from the end
		//which is at index (length-2)/2
		for(int i = (a.length-2)/2; i >= 0; i--)
		{
			siftDown(a, i, a.length-1);
		}
	}
	
	private static void siftDown(int[] a, int i, int lastInd) {
		//compare i, with i's left and i's right child
		int leftInd = 2*i + 1;
		int rightInd = 2*i + 2;
			
		//finds the max between the 3 values
		int maxInd = i; //assume i is the max
		if(leftInd <= lastInd && a[maxInd] < a[leftInd])
			maxInd = leftInd;
		if(rightInd <= lastInd && a[maxInd] < a[rightInd])
			maxInd = rightInd;
		
		//stop swapping if maxInd is still i
		if(maxInd != i) {
			swap(a, i, maxInd);
			siftDown(a, maxInd, lastInd);
		}
		//the else is the base case
	}
	
	public static void treeSort(int [] a) {
		// build the tree 
		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0; i < a.length; i++) 
			bst.insert(a[i]);
		// call in order traversal, and then copy values back to a
		bst.inOrderTraversal(); // O(n)
		
		int[] sorted = bst.getSorted();
		for (int i = 0; i < a.length; i++)
			a[i] = sorted[i];
	}
	
	

}
