package algorithms_and_datastructures.basic_concepts_ii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SearchingAndSorting {

	// This method takes an array of integers as input parameters
	// and a value val. It should return the index of val in the array.
	// If val does not occur it should return -1.
	private int find(int[] numbers, int val) {
		// TODO: Implement this

		return val;

	}

	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################

	public static void main(String[] args) throws IOException {
		// new SearchingAndSorting().run();
		int[] numbers = { 9, 8, 7,6,5,4,3};
		System.out.println(insertionSort(numbers));
		//System.out.println(findSmallestMissingIntv2(numbers));
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = readIntArray(in);
		int[] queries = readIntArray(in);

		for (int i = 0; i < queries.length; i++) {
			int solution = find(numbers, queries[i]);
			System.out.println(solution);
		}
	}

	private int[] readIntArray(BufferedReader in) throws IOException {
		int length = Integer.parseInt(in.readLine());
		int[] array = new int[length];
		StringTokenizer st = new StringTokenizer(in.readLine());

		for (int i = 0; i < length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		return array;
	}
	
	private static int[] insertionSort (int[] array) {
	    for(int i = 1; i < array.length ;){
	        if(array[i] < array[i-1]){
	            int temp = array[i];
	            array[i] = array[i - 1];
	            array[i - 1] = temp;
	            i--;
	        } else {
	        	i++;
	        }
	    }
	    return array;
	}
	
	// Week 2, Mandatory ass. 1
		public static int findSmallestMissingInt(int[] integers) {
			

			return 0;
		}
	
	

	// Week 2, Mandatory ass. 2
	public static int findSmallestMissingIntv2(int[] integers) {
		int j = integers[0];
		ArrayList<Integer> tempSmallestInts = new ArrayList<>();
		int smallestNo = 0;

		for (int i = 0; i < integers.length; i++) {
			if (j == integers[i]) {
				j++;
				continue;
			} else {
				tempSmallestInts.add(j);
				if (j < integers[i]) {
					j++;
					i--;
				}
			}
		}

		for (int k = 0; k < tempSmallestInts.size(); k++) {
			smallestNo = tempSmallestInts.get(0);
			if (tempSmallestInts.size() == 1) {
				return smallestNo;
			} else if (smallestNo > tempSmallestInts.get(k)) {
				smallestNo = tempSmallestInts.get(k);
			}
		}

		return smallestNo;
	}

	// Week 2, Mandatory ass. 3
	public static int findSmallestMissingIntv3(int[] integers) {
		int j = integers[0];
		ArrayList<Integer> tempSmallestInts = new ArrayList<>();

		for (int i = 0; i < integers.length; i++) {
			if (j == integers[i]) {
				j++;
				continue;
			} else {
				if (tempSmallestInts.isEmpty()) {
					tempSmallestInts.add(j);
				} else {
					if (tempSmallestInts.get(0) > j) {
						tempSmallestInts.remove(0);
						tempSmallestInts.add(j);
					}
				}
			}
		}
		return tempSmallestInts.get(0);
	}

}
