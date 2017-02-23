package ks_algorithms_and_datastructures.basic_concepts_ii;

public class MergeSort {

	static int [] A = {2,7,1,8};
	static int [] A1 = {2,7,1,8,377,12,23,114,2};
	static int[] helper;

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		int resultat = sort.insertionSort(A);
		System.out.println("insertion with sort first: " + resultat);
		
		helper = new int[A1.length];
		int[] resArray = sort.sort(A1, 0, A1.length-1);
		sort.print(resArray);
		
	}
	
	
	public int insertionSort(int[] a){
		for(int i = 0; i < a.length-1 ; i++){
			if(a[i] > a[i+1]){
				int high_temp = a[i];
				int low_temp = a[i+1];
				a[i] = low_temp;
				a[i+1] = high_temp;
				
				i=-1;
			}
		}
		int j = a[0];
		for(int i = 0; i < a.length; i++){
			if(j == a[i]){
				j++;
				continue;
			} else {
				return j;
			}
		}
		
		return 0;
	}
	
	public int[] sort(int[] a, int low_idx, int high_idx){
		if(low_idx < high_idx){
			int middle = (low_idx + high_idx)/2;
			sort(a,low_idx,middle);
			sort(a,middle+1,high_idx);
			merge(a,middle, low_idx, high_idx);
		}
		return a;
	}
	
	/*
	public int[] merge(int[] a, int middle, int low_idx, int high_idx){
		return a;
	}
	*/
	
	private void merge(int[] numbers,int middle,int low, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
                helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
                if (helper[i] <= helper[j]) {
                        numbers[k] = helper[i];
                        i++;
                } else {
                        numbers[k] = helper[j];
                        j++;
                }
                k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
                numbers[k] = helper[i];
                k++;
                i++;
        }
	}
	
	
	public void print(int[]a){
		String toPrint = "";
		for(int i=0; i<a.length;i++){
			toPrint = toPrint + a[i]+"-";
		}
		System.out.println(toPrint);
	}
	
}
