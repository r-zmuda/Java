package chapter14;

import java.util.*;

public class Ch14e5 {

	public static void main(String[] args) {

		Stack<Integer> t1 = new Stack<Integer>();
		Stack<Integer> t2 = new Stack<Integer>();

		t1.push(10);
		t1.push(20);
		t1.push(30);

		t2.push(10);
		t2.push(20);
		t2.push(30);

		System.out.println(equals(t1, t2));

	}

	public static boolean equals(Stack<Integer> s1, Stack<Integer> s2) {

		// If different size stacks, return false
		if (s1.size() != s2.size()) {
			return false;
		}

		// Stack Auxiliary Storage, declarations
		Stack<Integer> backup = new Stack<Integer>();
		int[] s1ary = new int[s1.size()];
		int[] s2ary = new int[s2.size()];
		int count = 0;

		// Get all elements off first stack into array
		while (!s1.isEmpty()) {
			int next = s1.pop();
			backup.push(next);
			s1ary[count] = next;
			count++;
		}

		// Refill original stack
		while (!backup.isEmpty()) {
			s1.push(backup.pop());
		}

		// Reset index for array
		count = 0;

		// Get all elements off second stack into array
		while (!s2.isEmpty()) {
			int next = s2.pop();
			backup.push(next);
			s2ary[count] = next;
			count++;
		}

		// Refill original stack
		while (!backup.isEmpty()) {
			s2.push(backup.pop());
		}

		return Arrays.equals(s1ary, s2ary);
	}

}
