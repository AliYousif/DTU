package ks_algorithms_and_datastructures.basic_concepts_i;

import java.util.ArrayList;

public class FindPeaks {
	
	static int [] A = {1,2,3,4,5,6,7,8,9,10,10,10,9,8,7,6,5,4,3,2,1}; 

	public static void main(String[] args) {
		FindPeaks findPeaks = new FindPeaks();
		findPeaks.peeks(A).size();
		
		int top1 = findPeaks.toppoint1(A);
		System.out.println(top1);
		
		int top2 = findPeaks.toppoint2(A);
		System.out.println("toppoint2: " +  top2);
		
		int top3 = findPeaks.toppoint3(A, 0, A.length-1);
		System.out.println("toppoint3: " +  top3);
	}
	
	
	private ArrayList<Integer> peeks(int[] listOfPeeks) {
		
		ArrayList<Integer> foundPeeks = new ArrayList<>(); 
		
		for (int i = 0; i < listOfPeeks.length; i++) {
			
			int mainCompared = listOfPeeks[i];
			int rightCompared = 0;
			int leftCompared = 0;
			
			//Sikkerhed mod indexOfOFBounds
			if(i >= 1) {
				leftCompared = listOfPeeks[i-1];
			} if(listOfPeeks.length-1 > i) {
				rightCompared = listOfPeeks[i+1];
			}
			
			if(mainCompared > leftCompared && mainCompared > rightCompared) {
				foundPeeks.add(mainCompared);
			}
		
		}
		printList(foundPeeks);
		return foundPeeks;
	}
	
	private int toppoint1(int[] a) {
		int toppunkt = 0;
		for (int i = 0; i < a.length; i++) {
			
			int mainCompared = a[i];
			int rightCompared = 0;
			int leftCompared = 0;
			
			//Sikkerhed mod indexOfOFBounds
			if(i >= 1) {
				leftCompared = a[i-1];
			} if(a.length-1 > i) {
				rightCompared = a[i+1];
			}
			
			if(mainCompared > leftCompared && mainCompared >= rightCompared) {
				toppunkt = i;
			}
		}
		return toppunkt;
	}
	
	private int toppoint2(int[] a) {
		
		ArrayList<Integer> foundPeeks = new ArrayList<>();
		int indexAt = 0;
		
		for (int i = 0; i < a.length; i++) {
			
			int mainCompared = a[i];
		
			if(mainCompared > a[indexAt]) {
				indexAt = i;
			}
		}
		return indexAt;
	}
	
	
	private int toppoint3(int[] a, int i, int j) {
		//i buttom = 0 , and j upper, max-1
		double res= (double)(i+j)/(double)2;
		boolean runMore = true;
		
		int middleIndex = (int) res;
		int indexAt = 0;
		
		int rs = 0;
		int ls = 0;
		
		if(i != 0 || i != a.length){
			rs = a[middleIndex+1];
			ls = a[middleIndex-1];
		}
		
		if(rs <= a[middleIndex] && a[middleIndex+1] >= ls){ 
			return middleIndex;
		}
		if(rs > a[middleIndex] && rs > ls && rs == a[a.length-1]){ 
			return middleIndex+1;
		}
		if( ls > a[middleIndex] && rs < ls && ls == a[0] ){
			return middleIndex-1;
		}
		
		else if(rs > ls){return toppoint3(a,middleIndex,j);}
		else if(rs < ls)
			return toppoint3(a,i,middleIndex);
		return 0;
	}
	
	private String printList(ArrayList<Integer> arrayList) {
		
		String peeksAre = "";
		
		for(Integer i : arrayList) {
			peeksAre = peeksAre+i+" ";	
		}
		
		System.out.println(peeksAre);
		return peeksAre;
	}

}
