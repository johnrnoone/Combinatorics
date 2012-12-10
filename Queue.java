package Combinatorics;

import java.util.Iterator;
import java.util.LinkedList;
public class Queue {

	private LinkedList<Integer> intList = new LinkedList<Integer>();
	
	public boolean isEmpty(){
		return intList.isEmpty();
	}

	public void enqueue(Integer item){
		intList.addLast(item);
	}

	public Integer dequeue() {
		return intList.removeFirst();
	}

	public void printList () {
		System.out.print ("it.next():         ");
		Iterator<Integer> it = intList.iterator();
		while (it.hasNext()) {
			System.out.print ( it.next() + " ");
		}
		System.out.println ();
		
		System.out.print ("Iterator i.next(): ");
		for (Iterator<Integer> i = intList.iterator(); i.hasNext();) {
			System.out.print ( i.next() + " ");
		}
		System.out.println ();         
		
		System.out.print ("i2 : intList,      ");
		for (Integer i2 : intList) {
			System.out.print (i2 + " ");
		}
		System.out.println ();

	}

}


