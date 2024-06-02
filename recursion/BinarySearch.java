package recursion;

import java.util.Arrays;

public class BinarySearch {
	
	static int count = 0;

	public static void main(String[] args) {
		System.out.println(nrBinarySearch(new int[] {1, 2, 3, 4, 5, 6, 7}, 4));
		System.out.println();
		
		// TODO Auto-generated method stub

	}
	
	// Linear search - run time efficiency of O(n)
	public static int linearSearch(int[] list, int key) {
		for(int i = 0; i < list.length; i++) {
			count++;
			if (list[i] == key)
				return i;
		}
		
		return -1; // - 1 is returned by default (not found)
	}
	
	// iterative: non-recursive
	public static int nrBinarySearch(int[] list, int key) {
		Arrays.sort(list);
		int first = 0;
		int last = list.length - 1;
		
		while (first <= last) {
			int middle = (first + last)/2;
			 if (list[middle] == key) {
				 count++;
				 return middle;
			 }
			 else if (list[middle] < key) {
				 count++;
				 first = middle + 1; 
			 }
			 else {
				 count++;
				 last = middle - 1;	 
			 }
		}
		
		return -1;
	}
	
	public static int rBinarySearch(int[] list, int key) {
		// helper method - used to simplify the intial call to the function
		return rBinaryHelper(list, key, 0, list.length - 1);
	}
	
	private static int rBinaryHelper(int[] list, int key, int left, int right) {
		count++;
		int middle = (left + right)/2;
		if (left > right) return -1;
		if (list[middle] == key) return middle;
		
		if (list[middle] > key) return rBinaryHelper(list, key, left, middle - 1);
		
		else return rBinaryHelper(list, key, middle + 1, right);
	}
	
	
	
	
}
