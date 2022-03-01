/* WordList.txt
leaf
corn
ordinary
door
piano
aardvark
quick
icicle
rope
great
steam
hat
tornado
jelly
under
move
victory
beard
white
night
x-ray
floor
yawn
eager
zipper
kitchen
*/

package chapter13;

import java.util.*;
import java.io.*;

public class RZmuda_Chapter13 {
	
	public static void main(String[] args) throws FileNotFoundException {
		// Populate ArrayList with words from file
		File file = new File("./src/chapter13/WordList.txt");
		Scanner lineScan = new Scanner(file); // Counts lines
		Scanner wordScan = new Scanner(file); // Populates array

		// Count number of lines and create array
		int lines = 0; // Line counter
		while (lineScan.hasNextLine()) {
			lineScan.nextLine();
			lines++;
		}
		System.out.println("# of Words: " + lines);
		String[] words = new String[lines - 1];
		lineScan.close();

		// Populate array
		for (int i = 0; i < words.length; i++) {
			String str = wordScan.nextLine();
			words[i] = str;
		}
		System.out.println();
		wordScan.close();

		// Sort words
		mergeSort(words);

		// Print result
		for (int i = 0; i < words.length; i++) {
			String str = words[i];
			System.out.println(str);
		}
	}
	
	// Places elements of given array into sorted order using the merge sort
	// algorithm.
	public static void mergeSort(String[] array) {
		// Split array into two halves.
		if (array.length > 1) {
			String[] left = leftHalf(array);
			String[] right = rightHalf(array);
			// Recursively sort the halves.
			mergeSort(left);
			mergeSort(right);
			// Merge the sorted halves.
			merge(array, left, right);
		}
	}

	// Return the first half of an array.
	public static String[] leftHalf(String[] array) {
		int size1 = array.length / 2;
		String[] left = new String[size1];
		for (int i = 0; i < size1; i++) {
			left[i] = array[i];
		}
		return left;
	}

	// Return the second half of an array.
	public static String[] rightHalf(String[] array) {
		int size1 = array.length / 2;
		int size2 = array.length - size1;
		String[] right = new String[size2];
		for (int i = 0; i < size2; i++) {
			right[i] = array[i + size1];
		}
		return right;
	}

	// Merge left and right into result.
	public static void merge(String[] result, String[] left, String[] right) {
		int index1 = 0; // Index into left array.
		int index2 = 0; // Index into right array.
		for (int i = 0; i < result.length; i++) {
			if (index2 >= right.length
					|| (index1 < left.length && left[index1].compareToIgnoreCase(right[index2]) < 0)) {
				// Take from left.
				result[i] = left[index1];
				index1++;
			} else {
				// Take from right.
				result[i] = right[index2];
				index2++;
			}
		}
	}
}
