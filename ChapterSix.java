package chapter06;

import java.util.*;
import java.io.*;

public class ChapterSix {

	public static void main(String[] args) throws FileNotFoundException {
		// Initialization
		Scanner console = new Scanner(System.in);
		boolean check1 = false; // If file1 exists
		boolean check2 = false; // If file2 exists
		File file1 = null; // Store first file
		File file2 = null; // Store second file
		String compare1 = ""; // Accepts tokens from first file
		String compare2 = ""; // Accepts tokens from second file
		int line = 0; // Line count

		// Receive file1, check if exists
		while (check1 == false) {
			System.out.print("Path to first file: ");
			file1 = new File("src/chapter06/" + console.next());
			if (file1.exists()) {
				check1 = true;
			} else {
				System.out.println("File not found.");
			}
		}

		// Receive file2, check if exists
		while (check2 == false) {
			System.out.print("Path to second file: ");
			file2 = new File("src/chapter06/" + console.next());
			if (file2.exists()) {
				check2 = true;
			} else {
				System.out.println("File not found.");
			}
		}

		// Initialize file scanners, print names of files
		Scanner file1s = new Scanner(file1);
		Scanner file2s = new Scanner(file2);
		String file1n = file1.getName();
		String file2n = file2.getName();
		System.out.println();
		System.out.println("Comparing " + file1n + " and " + file2n + ":");
		System.out.println();

		// Compare logic, show differences
		while (file1s.hasNextLine() && file2s.hasNextLine()) {
			line++;
			compare1 = file1s.nextLine();
			compare2 = file2s.nextLine();
			if (!compare1.equals(compare2)) {
				System.out.println("Line " + line + ": ");
				System.out.println(compare1 + " != " + compare2);
				System.out.println();
			}
		}

		// If one file has more lines, fill remaining lines until end of file
		while (file1s.hasNextLine()) {
			line++;
			compare1 = file1s.nextLine();
			System.out.println("Line " + line + ": ");
			System.out.println(compare1 + " != " + "EOF");
			System.out.println();
		}
		while (file2s.hasNextLine()) {
			line++;
			compare2 = file2s.nextLine();
			System.out.println("Line " + line + ": ");
			System.out.println("EOF != " + compare2);
			System.out.println();
		}

		// End of program, close scanners
		System.out.println("Program finished.");
		console.close();
		file1s.close();
		file2s.close();
	}

}
