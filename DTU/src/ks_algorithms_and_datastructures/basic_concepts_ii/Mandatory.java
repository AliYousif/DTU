package ks_algorithms_and_datastructures.basic_concepts_ii;

import java.util.ArrayList;

public class Mandatory {
	
static int [] A = {2,7,1,8};

static int [] A1 = {2,7,8,14};
static int [] A2 = {1,6,9,18}; 

static int[] tempMergArr;
	
	public static void main(String[] args) {
		Mandatory m = new Mandatory();
		//int res = m.giveMeLowestMissingInt(A, A.length-1);
		//System.out.println(res);
		
		//int[] resArray = m.merge(A1, A2);
		//m.printMyArray(resArray);
		
		//int lowest  = m.giveMeBackLowest(A);
		//System.out.println("other mandatory: " + lowest);
		
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 10, 12};
		int heeeej = m.findSmallestMissingIntv2(A);
		
		System.out.println("ali's lorte kode: " + heeeej);
		
		//tempMergArr = new int[A.length];
		//m.hasListADublicate(A,0,A.length);
		//m.printMyArray(tempMergArr);
	}
	
	
	public boolean hasListADublicate(int[] numbers, int high_idx, int low_idx){
		if(high_idx < low_idx){
			int middle = (low_idx+high_idx)/2;
			hasListADublicate(numbers,high_idx,middle);
			hasListADublicate(numbers,middle+1,low_idx);
			flet(numbers, low_idx, high_idx, middle);
		}
		
		return false;
	}
	
	public void flet(int[] numbers, int high_idx, int low_idx, int middle){
		
		
		for (int i = low_idx; i <= high_idx-1; i++) {
            tempMergArr[i] = numbers[i];
        }
        int i = low_idx;
        int j = middle + 1;
        int k = low_idx;
        while (i <= middle && j <= high_idx) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                numbers[k] = tempMergArr[i];
                i++;
            } else {
                numbers[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = tempMergArr[i];
            k++;
            i++;
        }
	}
	
	
	//other possible mandatory O(n);
	public int giveMeBackLowest(int a[]){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int j = a[0];
		for (int i=0;i<a.length;i++)
		{
		    if (j==a[i])
		    {
		        j++;
		        continue;
		    }
		    else
		    {
		    	if(arr.isEmpty()){ arr.add(j);}
		    	else if(arr.get(0) > j){ arr.set(0, j);}
		    }
		}
		
		return arr.get(0);
	}
	
	
	//Mandatory 
	public int giveMeLowestMissingInt(int[] numbers, int size){
		int[] temp = numbers;
		boolean swaped = true;
		int lowestIntMissing = 0;
		
			for(int i = 1; i < size; i++){
				int j=i;
				while(j > 0 && numbers[j-1] > numbers[j]){
					lowestIntMissing = reOrder(numbers,j,j-1,lowestIntMissing);
					j = j-1;
				}
			}
		return lowestIntMissing+1;
	}
	
	private int reOrder(int[] numbers, int idx_lowVal, int idx_highVal, int lowestIntMissing){
		int tempVal = numbers[idx_highVal];
		numbers[idx_highVal]= numbers[idx_lowVal];
		numbers[idx_lowVal] = tempVal;
		
		if(numbers[idx_highVal] > lowestIntMissing && numbers[idx_highVal] == lowestIntMissing+1){
			lowestIntMissing = numbers[idx_highVal];
		} else if(numbers[idx_lowVal] > lowestIntMissing && numbers[idx_lowVal] == lowestIntMissing+1){lowestIntMissing = numbers[idx_lowVal];}
		
		return lowestIntMissing;
	}
	
	
	//codeJugde
	private int[] merge(int[] A1, int[] A2) {
		int[] mergedarray = new int[A1.length+A2.length];
		
		// we need tree holder to know where we are in the lists
		
		int a1_idx = 0;
		int a2_idx = 0;
		int mergedarray_idx = 0;
		
		for(int i = 0; i < mergedarray.length; i++){
			if(mergedarray_idx > mergedarray.length-1){ return mergedarray; }
			else if(a1_idx > A1.length-1){ mergedarray[mergedarray_idx] = A2[a2_idx]; a2_idx++; mergedarray_idx++; }
			else if(a2_idx > A2.length-1){ mergedarray[mergedarray_idx] = A1[a1_idx]; a1_idx++; mergedarray_idx++; }
			else if(A1[a1_idx] <= A2[a2_idx]){ mergedarray[mergedarray_idx] = A1[a1_idx]; a1_idx++; mergedarray_idx++;}
			else if(A1[a1_idx] >= A2[a2_idx]){ mergedarray[mergedarray_idx] = A2[a2_idx]; a2_idx++; mergedarray_idx++;}
		}
		
		return mergedarray;
	}
	
	private void printMyArray(int[] resArray){
		String printThis = "{";
		for(int i = 0; i < resArray.length; i++){
			if(i > resArray.length-1){printThis = printThis + "}";}
			printThis = printThis +resArray[i]+",";
		}
		System.out.println(printThis);
	}
	
	public int findSmallestMissingIntv2(int[] integers) {
        int j = integers[0];
        ArrayList<Integer> tempSmallestInts = new ArrayList<>();
        int smallestNo = 0;
        
        for(int i = 0; i < integers.length; i++) {
            if(j == integers[i]) {
                j++;
                continue;
            } else {
                tempSmallestInts.add(j);
                if(j < integers[i] ){
                	j++;
                	i--;
                }
                }
        }
        
        for(int k = 0; k < tempSmallestInts.size(); k++) {
            smallestNo = tempSmallestInts.get(0);
            if(tempSmallestInts.size() == 1) {
                return smallestNo;
            } else if (smallestNo > tempSmallestInts.get(k)) {
                smallestNo = tempSmallestInts.get(k);
            }
        }
        
            return smallestNo;
        } 
	
}
