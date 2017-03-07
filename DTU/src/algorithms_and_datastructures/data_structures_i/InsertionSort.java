package algorithms_and_datastructures.data_structures_i;

import java.io.IOException;

public class InsertionSort {
	
	public static void main(String[] args) {
		// new SearchingAndSorting().run();
		int[] numbers = { 9, 8, 7,6,5,4,3};
		System.out.println(insertionSort(numbers));
	}
	
	
	private static int[] insertionSort (int[] array) {
	    for(int i = 1; i < array.length;) {
	        int j = i;
	        while(j > 0 && array[j-1] > array[j]) {
	        	int temp = array[j];
	            array[j] = array[j - 1];
	            array[j - 1] = temp;
	            j--;
	        }
	    }
	    return array;
	}

}
