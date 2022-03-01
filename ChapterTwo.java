package chapter02;

public class ChapterTwo {
	private static final int STAIRS = 4;
	private static final int WIDTH = 5;

	public static void main(String[] args) {
		// Build a number of stairs based on the value stored in STAIRS.
		for (int x = 1; x <= STAIRS; x++) {
			// Line 1 Output
			for (int spaces = 1; spaces <= STAIRS * WIDTH - WIDTH * x; spaces++) {
				System.out.print(" ");
			}
			System.out.print("  O  ******");
			for (int spaces = 1; spaces <= x * WIDTH - WIDTH; spaces++) {
				System.out.print(" ");
			}
			System.out.println("$");
			// Line 2 Output
			for (int spaces = 1; spaces <= STAIRS * WIDTH - WIDTH * x; spaces++) {
				System.out.print(" ");
			}
			System.out.print(" /|\\ *");
			for (int spaces = 1; spaces <= x * WIDTH; spaces++) {
				System.out.print(" ");
			}
			System.out.println("$");
			// Line 3 Output
			for (int spaces = 1; spaces <= STAIRS * WIDTH - WIDTH * x; spaces++) {
				System.out.print(" ");
			}
			System.out.print(" / \\ *");
			for (int spaces = 1; spaces <= x * WIDTH; spaces++) {
				System.out.print(" ");
			}
			System.out.println("$");
		}
		// Print a row of % as the base of the staircase.
		for (int base = 1; base <= STAIRS * WIDTH + 7; base++) {
			System.out.print("%");
		}
	}
}
