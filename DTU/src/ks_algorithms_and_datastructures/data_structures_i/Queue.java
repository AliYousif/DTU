package ks_algorithms_and_datastructures.data_structures_i;

import java.lang.reflect.InvocationTargetException;

public class Queue {

	int[] queuelist = new int[10];
	int pointer = 0;
	int firstIndex = -1;
	int lastIndex = 0;
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		Queue q = new Queue();
		
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(2);
		q.enqueue(2);
		q.enqueue(22);
		q.enqueue(26);
		q.enqueue(2898);
		q.enqueue(211);
		System.out.println(q.dequeue());
		q.enqueue(22222);
		q.enqueue(25);
		q.enqueue(22);
		System.out.println(q.dequeue());
		q.enqueue(26);
		q.enqueue(27);
		q.enqueue(1);
		q.enqueue(232);
		q.enqueue(34);
		q.enqueue(66);
		q.enqueue(787);
		q.enqueue(781);
		System.out.println(q.dequeue());
	}
	
	public void enqueue(int e) {
		if(pointer <= queuelist.length-1 && lastIndex != queuelist.length){
			if(pointer == 0 && firstIndex == -1 && lastIndex == 0){firstIndex++;}
			queuelist[pointer++] = e;
			lastIndex++;
			
		}
		
		else if (pointer >= queuelist.length-1 && firstIndex == 0){
			System.out.println("no more room, making list bigger!");
			int[] tempqueuelist = new int[queuelist.length * 2]; 
			for(int i = 0; i < queuelist.length; i++ ){
				tempqueuelist[i] = queuelist[i];
			}
			queuelist = tempqueuelist;
			queuelist[++pointer] = e;
		}
		
		else if (firstIndex != 0 && pointer != firstIndex && pointer >= queuelist.length-1){
			pointer = 0;
			queuelist[pointer++] = e;
		}
	}

	public int dequeue() {
		if(lastIndex > 0 ){ if(firstIndex >= queuelist.length-1 ){firstIndex = 0;}lastIndex--;return queuelist[firstIndex++];}
		//System.out.println(" Queue is empty");
		return -1;
		
	}
	
}
