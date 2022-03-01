package other;

import java.util.*;

public class SieveOfEratosthenes {
	
	//Set upper bound here
	private static final int UPPER_BOUND = 32;
	
	public static void main(String[] args) {
		//Make stack, from 2 to UPPER_BOUND inclusive
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		LinkedList<Integer> primes = new LinkedList<Integer>();
		for(int x = 2; x < UPPER_BOUND + 1; x++) {
			numbers.add(x);
		}
		//Process numbers in queue, find primes
		int prime = numbers.pop();
		while(prime < Math.sqrt(UPPER_BOUND)) {
			for(int x = 0; x < numbers.size(); x++) {
				if(numbers.get(x) % prime == 0) {
					numbers.remove(x);
				}
			}
			primes.add(prime);
			prime = numbers.pop();
		}
		primes.add(prime);
		//Transfer remaining numbers to primes
		while(!numbers.isEmpty()) {
			int n = numbers.pop();
			primes.add(n);
		}
		System.out.println("Primes:");
		System.out.println(primes);
		System.out.println();
		System.out.println("Number of Primes: " + primes.size());
	}
}
