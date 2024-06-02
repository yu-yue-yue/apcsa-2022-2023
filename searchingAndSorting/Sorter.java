                     package searchingAndSorting;

public class Sorter {
	
	private int numComparisons = 0;
	private int numSwaps = 0;
	private int[] a;
	
	public Sorter(int[] a) {
		this.a = a;
	}
	
	public void bubbleSort() {
		numComparisons = 0;
		numSwaps = 0;
		
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

	
	
	public void selectionSort() {
		numComparisons = 0;
		numSwaps = 0;
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
	
	public void insertionSort() {
		numComparisons = 0;
		numSwaps = 0;
		for(int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				numComparisons++;
				if (a[j] < a[j - 1]) swap(a, j, j - 1);
				else break;
			}
		}
	}
	
	public void quickSort(int pivots, int v) {
		numComparisons = 0;
		numSwaps = 0;
		if (pivots == 1) quickSort(a, 0, a.length - 1, v);
		if (pivots == 2) twoPivotQS(a, 0, a.length - 1);
		if (pivots == 3) threePivotQS(a, 0, a.length - 1);
		
	}
	
	
	private void twoPivotQS(int[] a, int left, int right) {
		if (right - left < 1) return;
		if (right - left == 1) {
			if (a[right] < a[left])
				swap(a, right, left);
			return;
		}
		
		int[] p = partition2(a, left, right);
		
		int lp = p[0];
		int rp = p[1];
		
		twoPivotQS(a, left, lp - 1);
		twoPivotQS(a, lp + 1, rp - 1);
		twoPivotQS(a, rp + 1, right);
			
	}
	
	private int[] partition2(int[] a, int left, int right) {
		if (a[left] > a[right]) swap(a, left, right);
		
		int i = left;
		int j = right;
		int k = left;
		int lp = left;
		int rp = right;
		
		while (i <= k && k <= j) {
			while (i <= k && k <= j && a[i] <= a[lp] ) {
				numComparisons++;
				i++;
				k++;
			}
			
			while (i <= k && k <= j && a[k] < a[rp] && a[k] > a[lp] ) {
				numComparisons++;
				k++;
			}
			
			while (i <= k && k <= j && a[j] >= a[rp]) {
				numComparisons++;
				j--;
				
			}
			
			if (i <= k && k <= j && a[k] >= a[rp]) {
				numComparisons++;
				swap(a, k, j);
			}
			
			else if (i <= k && k <= j && a[k] <= a[lp]) {
				numComparisons++;
				swap(a, k, i);
			}
			
			
		}
		if (i != lp && j != rp) {
			swap(a, i - 1, lp);
			swap(a, j + 1, rp);
		}
		
		return new int[] {i - 1, j + 1};
	}

	private void quickSort(int[] a, int left, int right, int v) {
		if (right - left < 1) return;
		if (right - left == 1) {
			if (a[right] < a[left])
				swap(a, right, left);
			return;
		}
		
		if(a.length < v) {
			insertionSort();
			return;
		}
 		
		int p = partition1(a, left, right);
		quickSort(a, left, p - 1, v);
		quickSort(a, p + 1, right, v);
	}
	
	private int partition1(int[] a, int left, int right) {
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
	
	public void mergeSort() {
		numComparisons = 0;
		numSwaps = 0;
		mergeSort(a);
	}
	
	private void mergeSort(int[] a) {
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
					{	numComparisons = getNumComparisons() + 1;
						a[i] = left[l];
						l++;
						numSwaps++;
					}
					else 
					{	numComparisons = getNumComparisons() + 1;
						a[i] = right[r];
						r++;
						numSwaps++;
					}
				}
		
	}
	
	public void treeSort() {
		numComparisons = 0;
		numSwaps = 0;
		// build the tree 
		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0; i < a.length; i++) 
			bst.insert(a[i]);
		// call in order traversal, and then copy values back to a
		bst.inOrderTraversal(); // O(n)
		
		int[] sorted = bst.getSorted();
		for (int i = 0; i < a.length; i++)
			a[i] = sorted[i];
		
		numComparisons += bst.getComparisons();
		numSwaps += bst.getSwaps();
	}
	
	
	private void swap(int[] a, int j, int i) {
		// TODO Auto-generated method stub
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
		numSwaps++;
	}



	public int getNumComparisons() {
		return numComparisons;
	}



	public int getNumSwaps() {
		return numSwaps;
	}

	public void printArray() {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) 
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public boolean isSorted() {
		for (int i = 0; i < a.length-1; i++) 
			if (a[i] > a[i + 1]) return false;
		return true;
	}
	
	
	public void heapSort()
	{	numSwaps = 0;
		numComparisons = 0;
		buildMaxHeap();
		int lastInd = a.length - 1;
		for(int i = 0; i < a.length-1; i++)
		{
			swap(a, 0, lastInd);
			lastInd -= 1;
			siftDown(0, lastInd);
		}
	}
	
	private void buildMaxHeap()
	{
		//Assume starting unsorted list
		//start at the first node with children from the end
		//which is at index (length-2)/2
		for(int i = (a.length-2)/2; i >= 0; i--)
		{
			siftDown(i, a.length-1);
		}
	}
	
	private void siftDown(int i, int lastInd) {
		//compare i, with i's left and i's right child
		int leftInd = 2*i + 1;
		int rightInd = 2*i + 2;
			
		//finds the max between the 3 values
		int maxInd = i; //assume i is the max
		if(leftInd <= lastInd && a[maxInd] < a[leftInd]) {
			numComparisons++;
			maxInd = leftInd;
		}
		if(rightInd <= lastInd && a[maxInd] < a[rightInd]) {
			numComparisons++;
			maxInd = rightInd;
		}
		
		//stop swapping if maxInd is still i
		if(maxInd != i) {
			swap(a, i, maxInd);
			siftDown(maxInd, lastInd);
		}
		//the else is the base case
	}
	
	private void threePivotQS(int[] a, int left, int right) {
		if (right - left < 1) return;
		if (right - left == 1) {
			if (a[right] < a[left])
				swap(a, right, left);
			return;
		}
		
		int[] p = partition3(a, left, right);
		
		int lp = p[0];
		int mp = p[1];
		int rp = p[2];
		
		threePivotQS(a, left, lp - 1);
		threePivotQS(a, lp + 1, mp - 1);
		threePivotQS(a, mp + 1, rp - 1);
		threePivotQS(a, rp + 1, right);
			
	}
	
	private int[] partition3(int[] a, int left, int right) {
		return null;
	}

}
