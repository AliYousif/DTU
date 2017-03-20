package ks_algorithms_and_datastructures.data_structures_iI;

import java.lang.reflect.InvocationTargetException;

import ks_algorithms_and_datastructures.data_structures_i.Datastructures;

public class Heap {

	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		
		int arr[] = {90, 15, 10, 7, 12, 2, 7, 3};
	    int n = arr.length-1;
	 
	    boolean res = isHeap(arr, n);
	    System.out.println(res);
		
	}
	
	// Returns true if arr[i..n-1] represents a
	// max-heap
	public static boolean isHeap(int arr[],  int n)
	{
	    // Start from root and go till the last internal
	    // node
	    for (int i=0; i<=(n-2)/2; i++)
	    {
	        // If left child is greater, return false
	        if (arr[2*i+1] > arr[i])
	                return false;
	 
	        // If right child is greater, return false
	        if (arr[2*i+2] > arr[i])
	                return false;
	    }
	    return true;
	}
	
}
