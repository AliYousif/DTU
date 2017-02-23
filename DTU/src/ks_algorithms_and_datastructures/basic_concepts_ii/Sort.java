package ks_algorithms_and_datastructures.basic_concepts_ii;

import algorithms_and_datastructures.basic_concepts_i.FindPeaks;

public class Sort {

	static int [] A = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10}; 
	
	public static void main(String[] args) {
		Sort sort = new Sort();
		
		int find = sort.find(A,11);
		System.out.println(find);
		
		int indexof1 = indexOf(A,11);
		
		int indexof2 = indexOf(A,3);
		System.out.println(indexof1);
	}
	
	private int find(int[] numbers, int val) {
		
		 int lo = 0;
	        int hi = numbers.length - 1;
	        while (lo <= hi) {
	            // Key is in a[lo..hi] or not present.
	            int mid = lo + (hi - lo) / 2;
	            if      (val < numbers[mid]) hi = mid - 1;
	            else if (val > numbers[mid]) lo = mid + 1;
	            else return mid;
	        }
	        return -1;
	}
	
	public int findVal(int i, int j, int[] numbers, int val) {
		
		if(j<=i || i == numbers.length-1){return -1;}
		int res = (i+j)/2;
		if(numbers[res] == val){return res;}
		else if(numbers[res] < val){return findVal(res,j,numbers,val);}
		else if(numbers[res] > val){return findVal(i,res,numbers,val);}
		else return -1;
	}
	
	public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
