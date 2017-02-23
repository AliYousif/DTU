package ks_algorithms_and_datastructures.warmup;

import algorithms_and_datastructures.basic_concepts_i.FindPeaks;

public class Calculator {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		int res = c.sumOf(1, 2);
		System.out.println(""+res);
		
		int ress = c.calculateSum(1,2);
		System.out.println(""+ress);
	}
	
	public int sumOf(int a, int b){
		return Math.addExact(a, b);
	}
	
	private int calculateSum(int a, int b) {
		return a + b;
	}
	
}
