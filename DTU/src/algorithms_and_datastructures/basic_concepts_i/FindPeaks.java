package algorithms_and_datastructures.basic_concepts_i;

import java.util.ArrayList;

public class FindPeaks {
	
	static int [] A = {2, 1, 3, 7, 3, 11, 1, 5, 7, 10}; 

	public static void main(String[] args) {
		FindPeaks findPeaks = new FindPeaks();
		findPeaks.peeks(A);
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
	
	
	private String printList(ArrayList<Integer> arrayList) {
		
		String peeksAre = "";
		
		for(Integer i : arrayList) {
			peeksAre = peeksAre+i+" ";	
		}
		
		System.out.println(peeksAre);
		return peeksAre;
		
	
	}

}
