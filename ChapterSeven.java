package chapter07;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ChapterSeven {

	private static final int MAX_TRIES = 7; // Tries per round

	public static void main(String[] args) {
		// Initialization
		Scanner console = new Scanner(System.in);
		Random r = new Random();
		String guess = ""; // Store current guess for processing
		String menuSelect; // Store post-game menu selection
		StringBuffer hidden = new StringBuffer(); // Displayed to player every
													// turn
		int tries = MAX_TRIES; // Game is over when tries is 0
		int guessCount = 0; // Store number of player guesses
		int guessTotal = 0; // Stores total number of player guesses
		int rounds = 0; // Stores total number of games
		double average = 0.0; // Stores average number of guesses
		boolean hangman = true; // Runs program loop
		boolean menu = false; // Runs post-game menu loop
		boolean correct = false; // When false, removes a try

		// Word bank
		String[] words = { "prince", "computer", "basketball", "chemistry", "production", "terrace", "construction",
				"anomaly", "entrance", "harvester", "balance", "destruction", "physics", "mathematics", "supernova",
				"stalagmite", "necromancer", "palace", "motivation", "typewriter", "criticism", "dolphin", "elephant",
				"electronics", "logistics", "database", "massive", "spooky", "verbose" };

		//
		int rando = r.nextInt(words.length); // Get a random word from the bank
		String word = words[rando]; // Stores chosen word for the game

		// Mask the word
		for (int i = 0; i < word.length(); i++) {
			hidden.append('*');
		}

		// Introduction message
		System.out.println("*** WELCOME TO HANGMAN ***");
		System.out.println();

		// Main Loop
		while (hangman) {
			// Collect input until strings match
			while (!word.equals(String.valueOf(hidden.toString()))) {
				System.out.println("Word is: " + hidden);
				System.out.println("Tries left: " + tries);
				System.out.print("Guess any character: ");
				guess = console.next();

				// Invalidate guesses over 1 length, reimburse try
				if (guess.length() > 1) {
					System.out.println("Error: Enter a single character.");
					guess = "0";
					tries++;
				}

				// Formatting between guesses
				System.out.println();

				// Exchange hidden with guess if char matches word, set correct
				// flag
				for (int i = 0; i < word.length(); i++) {
					if (guess.charAt(0) == word.charAt(i)) {
						String guessLetter = String.valueOf(guess.charAt(0));
						hidden.replace(i, i + 1, guessLetter);
						correct = true;
					}
				}

				// Removes a try if not correct, resets correct to false
				if (!correct) {
					tries--;
				}
				correct = false;

				// Add 1 to guessCount counter
				guessCount++;

				// Print lose message, out of tries
				if (tries <= 0) {
					System.out.println("*** YOU LOSE ***");
					break;
				}
			}

			// Print win message
			if (word.equals(String.valueOf(hidden.toString()))) {
				System.out.println("*** YOU WIN ***");
			}

			// Display chosen word after game is over
			System.out.println("My word was: " + word);
			System.out.println("Guesses that round: " + guessCount);

			// Begin post-game menu, harvest stats
			menu = true;
			rounds++;
			guessTotal += guessCount;
			guessCount = 0;
			average = (double) guessTotal / rounds;

			// Post-game menu
			while (menu) {
				System.out.println();
				System.out.println("*** OPTIONS ***");
				System.out.println("1) Play again");
				System.out.println("2) Show statistics");
				System.out.println("3) Exit program");
				System.out.print("Input selection: ");
				menuSelect = console.next();
				// Process menu input 1
				if (menuSelect.equals("1")) {
					// Setup new game
					menu = false;
					guess = "";
					tries = MAX_TRIES;
					rando = r.nextInt(words.length);
					word = words[rando];
					// Empty hidden and repopulate it
					hidden.delete(0, hidden.length());
					for (int i = 0; i < word.length(); i++) {
						hidden.append('*');
					}
					// Print new game message
					System.out.println();
					System.out.println("*** NEW GAME ***");
				}
				// Process menu input 2
				else if (menuSelect.equals("2")) {
					System.out.println();
					System.out.println("*** STATISTICS ***");
					System.out.println("Games Played: " + rounds);
					System.out.println("Total Guesses: " + guessTotal + " guesses");
					BigDecimal bigAverage = new BigDecimal(average);
					bigAverage = BigDecimal.valueOf(average);
					bigAverage.setScale(2, RoundingMode.HALF_UP);
					System.out.println("Average Guesses: " + bigAverage + " per game");
				}
				// Process menu input 3
				else if (menuSelect.equals("3")) {
					menu = false;
					hangman = false;
				}
				// Process anything else (invalid)
				else {
					System.out.println();
					System.out.println("*** ERROR ***");
					System.out.println("Invalid selection.");
				}
			}
		}

		// End of program
		System.out.println();
		System.out.println("Program finished.");
		console.close();
	}

}
