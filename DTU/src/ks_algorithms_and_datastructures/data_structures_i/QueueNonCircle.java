package ks_algorithms_and_datastructures.data_structures_i;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class QueueNonCircle {
	
	int[] queuelist = new int[10];
	int pointer = 0;
	int firstIndex = 0;

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		QueueNonCircle ds = new QueueNonCircle();
		ds.enqueue(3);
		ds.enqueue(5);
		ds.enqueue(1);
		ds.enqueue(2);
		ds.enqueue(3);
		ds.enqueue(4);
		ds.enqueue(5);
		ds.enqueue(6);
		ds.enqueue(7);
		ds.enqueue(8);
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		
		ds.enqueue(3);
		ds.enqueue(5);
		ds.enqueue(1);
		ds.enqueue(2);
		ds.enqueue(3);
		ds.enqueue(4);
		ds.enqueue(5);
		ds.enqueue(6);
		ds.enqueue(7);
		ds.enqueue(8);
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		System.out.println(ds.dequeue());
		
	}
	
	public int dequeue (){
		if(pointer != 0){
			return queuelist[firstIndex++];
		}
		return -1;
	}
	
	public void enqueue (int e){
		if(pointer < queuelist.length){queuelist[pointer++] = e; }
		else if (pointer >= queuelist.length){
			System.out.println("no more room, making list bigger!");
			int[] tempqueuelist = new int[queuelist.length * 2];
			int t=0;
			for(int i = firstIndex; i < queuelist.length; i++ ){
				tempqueuelist[t++] = queuelist[i];
			}
			queuelist = tempqueuelist;
			pointer = t;
			queuelist[pointer++] = e;
			firstIndex = 0;
		}
	}
	
}
