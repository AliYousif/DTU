package algorithms_and_datastructures.basic_concepts_i;

import java.util.Scanner;

public class Test2 {



	public static void main(String[] args) {
		Test2 test2 = new Test2();
		

		System.out.println(test2.Recursion(5));
	}

	public int Recursion(int i) {
		
		Scanner in = new Scanner(System.in);
		int temp = Integer.parseInt(in.next());
		
		if (temp <= 2)
			return temp;

		return 2 * Recursion(temp - 1) + Recursion(temp - 2) - Recursion(temp - 3);
	}

}
