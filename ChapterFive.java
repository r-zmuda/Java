package chapter05;

import java.util.*;
import java.math.*;

public class ChapterFive {
	public static void main(String[] args) {
		// Initializations
		Scanner console = new Scanner(System.in);
		Random n = new Random();
		boolean main = true, play = true;
		String again = "";
		// Range: [0,99] + 1 = [1,100]
		int number = n.nextInt(100) + 1; // Stores the computer's pick
		int guess = 0; // Stores user guesses
		int wins = 0; // Stores total win count
		int score = 0; // Stores amount of rounds per game
		int record = Integer.MAX_VALUE; // Stores user's best score (fastest
										// win)
		int guessTotal = 0; // Stores overall guess count
		double guessAve = 0.0; // Stores average guesses

		// Intro message
		System.out.println(" *** WELCOME TO GUESSING GAME ***");
		System.out.println();

		// Guessing game main loop
		while (main) {
			// Gameplay loop (set and test variable guess)
			while (play) {
				// Set guess
				System.out.println(" *** GUESS ***");
				System.out.print("Enter a number between 1 and 100: ");
				if (console.hasNextInt()) {
					guess = console.nextInt();
				}
				// Handle InputMismatchException
				else {
					System.out.println(" *** ERROR ***");
					System.out.println("I don't know what that is, but it's certainly not a number.");
					System.out.println();
					console.next();
					continue;
				}

				// Reject numeric inputs outside range 1-100
				if (guess <= 0 || guess > 100) {
					System.out.println(" *** ERROR ***");
					System.out.println("That's not a number between 1 and 100.");
					System.out.println();
					guess = 0;
					continue;
				}

				// Guessing logic
				if (guess > number) {
					score++;
					System.out.println(" --- INCORRECT ---");
					System.out.println("My number is lower.");
				} else if (guess < number) {
					score++;
					System.out.println(" +++ INCORRECT +++");
					System.out.println("My number is higher.");
				} else {
					wins++;
					score++;
					System.out.println(" *** CORRECT ***");
					if (score < record) {
						record = score;
						System.out.println(" *** NEW RECORD! ***");
					}

					// Special case for winning on first guess (score == 1),
					// pluralize
					if (score == 1) {
						System.out.println("My number was " + number + ". It took you " + score + " guess to win.");
						System.out.println("It took you " + score + " guess to win.");
						System.out.println("What luck! Now go play the lottery.");
					} else {
						System.out.println("My number was " + number + ". It took you " + score + " guesses to win.");
					}

					// Prepare a new game, collect stats
					play = false;
					number = n.nextInt(100) + 1;
					guessTotal += score;
					guessAve = (double) guessTotal / wins;
					guess = 0;
					score = 0;
				}
				// Formatting
				System.out.println();
			}

			// Post-game menu
			System.out.println(" *** OPTIONS ***");
			System.out.println("(1) Challenge again");
			System.out.println("(2) View statistics");
			System.out.println("(3) Exit program");
			System.out.print("Input selection: ");
			again = console.next();
			if (again.equals("3")) {
				main = false;
			} else if (again.equals("1")) {
				play = true;
			} else if (again.equals("2")) {
				printStats(wins, record, guessTotal, guessAve);
			}
			// Handle InputMismatchException
			else {
				System.out.println(" *** ERROR ***");
				System.out.println("I don't know what that is, but it certainly isn't 1, 2, or 3...");
			}
			// Formatting
			System.out.println();
		}

		// Exit main loop
		System.out.println(" *** SYSTEM ***");
		System.out.println("Program finished.");
		console.close();
	}

	public static void printStats(int wins, int record, int total, double average) {
		System.out.println();
		System.out.println(" *** STATISTICS ***");
		System.out.println("Games Won: " + wins);
		System.out.println("Total Guesses: " + total + " guesses");
		BigDecimal bigAverage = new BigDecimal(average);
		bigAverage = BigDecimal.valueOf(average);
		bigAverage.setScale(2, RoundingMode.HALF_UP);
		System.out.println("Average Guesses: " + bigAverage + " guesses per game");

		// Pluralize guess(es)
		if (record == 1) {
			System.out.println("Fastest Round: " + record + " guess");
		} else {
			System.out.println("Fastest Round: " + record + " guesses");
		}
	}
}
