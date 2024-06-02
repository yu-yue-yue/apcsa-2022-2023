package searchingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;

public class quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 5, 2, 4, 1, 8, 6, 9};
		int[] nums2 = {7, 3, 5, 2, 6, 9};
		ArrayList<Integer> nums3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)) ;
		
		bubbleSort(nums);
		insertionSort(nums2);
		insertionSort(nums3);
		int[] arr = {3, 9, 7, 6, 8, 4, 1};

		selectionSort(arr);
		
		String[] a = {"Ann", "Mike",	"Walt",	"Lisa",	"Shari",	"Jose",	"Mary", "Bill"};
		sort(a);
	
		
	}
	
	
	public static void bubbleSort(int[] nums) {
		int count = 0;
		for (int j = 0; j < nums.length; j++)
		{	
			for(int i = 0; i < nums.length - 1 - j; i++) {
				if (nums[i] < nums[i+1]) {
					swap(nums, i, i+1);
					if (j == 1) count++; //line 6 - swap
				}
			}
			
            if (j == 2) printArray(nums);            //line 9 - after a  pass through the list
		}
		System.out.println(count);
	}
	
	private static void swap(int[] a, int j, int i) {
		// TODO Auto-generated method stub
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	public static void printArray(int[] a) {
		for (int i: a)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void printArray(String[] a) {
		for (String i: a)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void insertionSort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			for(int j = i; j >= 1; j--) {
				if(nums[j] < nums[j-1]){
					swap(nums, j, j-1);
				}
				else break;
			}
	        if (i == 2) printArray(nums);        /* End of outer loop */
		}
	}

	
	public static void insertionSort(ArrayList<Integer> data)
	
	{
		int s1 = 0;
		int s2 = 0;
		
	for (int j = 1; j < data.size(); j++)

	{

	int v = data.get(j);

	int k = j;

	while (k > 0 && v < data.get(k - 1))

	{

	data.set(k, data.get(k - 1));
	s1++; /* Statement 1 */

	k--;

	}

	data.set(k, v);
	s2++; /* Statement 2 */

	 
	if (j == 3) {
		int[] d = new int[data.size()];
		for (int i = 0; i < data.size(); i++) d[i] = data.get(i);
		printArray(d);
	}
	/* End of outer loop */
	
	
	}

	System.out.println(s1);
	System.out.println(s2);
	}


	public static void selectionSort(int[] elements)
	
	{
		int count = 0;
	for (int j = 0; j < elements.length - 1; j++)

	{

	int minIndex = j;

	 

	for (int k = j + 1; k < elements.length; k++)

	{

	if (elements[k] < elements[minIndex])

	{

	minIndex = k;

	}

	}

	 

	if (j != minIndex)

	{

	int temp = elements[j];

	elements[j] = elements[minIndex];

	elements[minIndex] = temp; 
	count++; // Line 19

	}

	}

	System.out.println(count);
	}
	
	
	public static void sort(String[] arr)

	{

	  for (int pass = arr.length - 1; pass >= 1; pass--)
		  
	  {
		  if (pass == arr.length - 3) printArray(arr);

	    String large = arr[0];

	    int index = 0;

	    for (int k = 0; k <= pass; k++)

	    {

	      if ((arr[k].compareTo(large)) > 0)

	      {

	        large = arr[k];

	        index = k;

	      }

	    }

	    arr[index] = arr[pass];

	    arr[pass] = large;

	  }

	}
}
