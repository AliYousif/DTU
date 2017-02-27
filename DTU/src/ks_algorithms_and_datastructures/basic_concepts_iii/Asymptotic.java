package ks_algorithms_and_datastructures.basic_concepts_iii;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Asymptotic {
	
	public static void main (String args[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		Asymptotic asymptotic = new Asymptotic();
		asymptotic.CalculateRunTime(asymptotic, "CalculateAlgo1", 100000);
		asymptotic.CalculateRunTime(asymptotic, "CalculateAlgo2", 100000);
		asymptotic.CalculateRunTime(asymptotic, "CalculateAlgo3", 100000);
	}
	
	public void CalculateRunTime(Asymptotic asymptotic, String methodName, int n) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> c = asymptotic.getClass();
		Method  method = c.getDeclaredMethod (methodName, int.class);
		
		long startTime = System.currentTimeMillis();
		method.invoke (asymptotic, n);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("total time for " + methodName+"("+n+")"+": " + totalTime + " milliseconds");
	}
	
	public void CalculateAlgo1(int n) {
		for(int i=1; i < n; i++) {
			int j = 1;
			while(j <= n) {
				j=j+2;
			}
		}
	}
	
	public void CalculateAlgo2(int n) {
		for(int i=1; i < n; i++) {
			i = i+1;
		}
		int j = 1;
		while(j <= n) {
			j=j+1;
		}
	}
	
	public void CalculateAlgo3(int n) {
		for(int i=1; i < n; i++) {
			for(int j=1; j < n; j++) {
				int k = j;
				while(k <= n) {
					k=k*3;
				}
			}
		}
	}
	

}
