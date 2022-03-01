package other;

import java.util.*;

public class DoublyLinkedList {
	
	public static void main(String[] args) {
		//Creating linked list
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		//Adding/setting elements to linked list
		list.add(3);
		list.add(7);
		list.add(11);
		list.addFirst(15);
		list.addLast(18);
		list.add(2, 22);
		list.set(5, 25);
		list.set(2, 5);
		list.set(0, 1);
		
		//Linked list status 1
		System.out.println("list: " + list);
		System.out.println("list.size(): " + list.size());
		
		//Get element in list
		System.out.println("list.get(4): " + list.get(4));
		
		//Find element in linked list
		boolean found = list.contains(3);
		if(found) {
			System.out.println("list.contains(3): true");
		}
		else {
			System.out.println("list.contains(3): false");
		}
		
		//Get first and last
		System.out.println("list.getFirst(): " + list.getFirst());
		System.out.println("list.getLast(): " + list.getLast());
		
		//Pop and push
		System.out.println("list.pop(): " + list.pop());
		System.out.println("list.pop(): " + list.pop());
		list.push(2);
		
		//Linked list status 2
		System.out.println();
		System.out.println("list: " + list);
		System.out.println("list.size(): " + list.size());
		
	}
}