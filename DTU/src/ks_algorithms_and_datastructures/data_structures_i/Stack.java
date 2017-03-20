package ks_algorithms_and_datastructures.data_structures_i;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Stack {
	
	int[] stacklist = new int[10];
	int pointer = -1;

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		Stack ds = new Stack();
		ds.push(3);
		ds.push(5);
		ds.push(1);
		ds.push(2);
		ds.push(3);
		ds.push(4);
		ds.push(5);
		ds.push(6);
		ds.push(7);
		ds.push(8);
		ds.push(9);
		ds.push(19);
		ds.pop();
	}
	
	public int pop (){
		if(pointer >= 0 && pointer <= stacklist.length-1 ){return stacklist[pointer--];}
		else if (pointer <= 0){System.out.println("the stack is empty: " + stacklist.length);}
		return -1;
	}
	
	public void push (int number){
		if(pointer < stacklist.length-1){stacklist[++pointer] = number; System.out.println(stacklist[pointer]);}
		else if (pointer >= stacklist.length-1){
			System.out.println("no more room, making list bigger!");
			int[] tempstacklist = new int[stacklist.length * 2]; 
			for(int i = 0; i < stacklist.length; i++ ){
				tempstacklist[i] = stacklist[i];
			}
			stacklist = tempstacklist;
			stacklist[++pointer] = number;
			System.out.println(stacklist[pointer]);
		}
	}
	
}
