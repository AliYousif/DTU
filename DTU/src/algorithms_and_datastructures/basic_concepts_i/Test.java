package algorithms_and_datastructures.basic_concepts_i;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Test test = new Test();
		test.INTEGERANALYZER();
	}

	public void INTEGERANALYZER() {

		int[] A = INTARRAY(READINT());
		for (int i = 0; i < A.length; i++) {
			A[i] = READINT();
		}
		Arrays.sort(A);
		int n = A.length;
		for (int i = 0; i <= (n - 1) / 2; i++) {
			int s = 0;

			for (int j = 0; j <= i; j++) {
				s = s + A[j] + A[n - j - 1];
			}
			PRINTINT(s);
		}
	}

	private void PRINTINT(int s) {
		System.out.println(s);

	}

	private int[] INTARRAY(int readint) {
		// TODO Auto-generated method stub
		int[] myIntArray = new int[readint];
		return myIntArray;
	}

	private int READINT() {

		while (in.hasNext()) {
			if (in.hasNextInt()) {
				return in.nextInt();
			} else
				return Integer.parseInt(in.next());
		}
		return 0;
	}

}
