//This program is dependent on two separate .txt files to function correctly.
//Use MANPATH and FEMPATH to change the file paths, if necessary.
//Syntax is "<String>: <int> <int> <int> ..."
//Constraint: Names must not contain spaces.
//Constraint: Both files a.k.a. "groups" must contain the same amount of lines a.k.a. "people".
//Constraint: Each group member must rate every member of the target group in order of preference.

/* Data for FileMale.txt
Man1: 4 1 2 3
Man2: 2 3 1 4
Man3: 2 4 3 1
Man4: 3 1 4 2
*/

/* Data for FileFemale.txt
Woman1: 4 1 3 2
Woman2: 1 3 2 4
Woman3: 1 2 3 4
Woman4: 4 1 3 2
*/

package chapter11;

import java.util.*;
import java.io.*;

public class StableMarriage {

	// Insert your files here
	public static final String MANPATH = "./src/chapter11/FileMale.txt";
	public static final String FEMPATH = "./src/chapter11/FileFemale.txt";

	// Main
	public static void main(String[] args) throws FileNotFoundException {
		// Declarations
		ArrayList<ArrayList<String>> male = new ArrayList<ArrayList<String>>(); // Stores
																				// men
																				// and
																				// their
																				// preferences
		ArrayList<ArrayList<String>> female = new ArrayList<ArrayList<String>>(); // Stores
																					// women
																					// and
																					// their
																					// preferences
		ArrayList<String> maleName = new ArrayList<String>(); // Stores names of
																// males
		ArrayList<String> femaleName = new ArrayList<String>(); // Stores names
																// of females
		ArrayList<String> freeMale = new ArrayList<String>(); // Contains
																// unmarried men
		ArrayList<Integer> partnerIndex = new ArrayList<Integer>(); // Stores
																	// pairings
																	// based on
																	// index and
																	// value
		ArrayList<String> partnerName = new ArrayList<String>(); // Stores
																	// females'
																	// partner
																	// names
		File fileM = new File(MANPATH); // Accepts men from FileMale.txt
		File fileF = new File(FEMPATH); // Accepts women FileFemale.txt
		Scanner scannerM = new Scanner(fileM); // Scanner for FileMale.txt
		Scanner scannerF = new Scanner(fileF); // Scanner for FileFemale.txt

		// Read from male file and populate male
		while (scannerM.hasNextLine()) {
			ArrayList<String> temp = new ArrayList<String>();
			String str = new String(scannerM.nextLine());
			Scanner console = new Scanner(str);
			while (console.hasNext()) {
				String s = new String(console.next());
				temp.add(s);
			}
			console.close();
			male.add(temp);
		}

		// Read from female file and populate female
		while (scannerF.hasNextLine()) {
			ArrayList<String> temp = new ArrayList<String>();
			String str = new String(scannerF.nextLine());
			Scanner console = new Scanner(str);
			while (console.hasNext()) {
				String s = new String(console.next());
				temp.add(s);
			}
			console.close();
			female.add(temp);
		}

		// Initialize male, trim strings to remove the colon
		for (int x = 0; x < male.size(); x++) {
			String str = male.get(x).get(0).substring(0, male.get(x).get(0).length() - 1);
			maleName.add(str);
			freeMale.add(str);
			male.get(x).set(0, str);
		}
		// Initialize female, trim strings to remove the colon
		for (int x = 0; x < female.size(); x++) {
			String str = female.get(x).get(0).substring(0, female.get(x).get(0).length() - 1);
			femaleName.add(str);
			female.get(x).set(0, str);
			partnerIndex.add(-1); // This will indicate a woman is single
			partnerName.add(null); // Not married to anybody
		}

		/*
		 * Debug -- data validation //Prints names and preferences int chips =
		 * 0; System.out.println("Male: "); for(ArrayList<String> person : male)
		 * { System.out.print(maleName.get(chips) + " ");
		 * System.out.println(person); chips++; } chips = 0;
		 * System.out.println("Female: "); for(ArrayList<String> person :
		 * female) { System.out.print(femaleName.get(chips) + " ");
		 * System.out.println(person); chips++; } chips = 0;
		 * System.out.println();
		 */

		// More Declarations -- we need more
		Integer womanIndex = 0; // Index for female
		Integer manIndex = 0; // Index for male
		Integer currentIndex = 0; // Index for female's current partner
		int beans = 1; // Round counter
		int beef = 0; // Index counter

		// Matching Algorithm
		while (!freeMale.isEmpty()) {
			// Announce round, start
			System.out.println("Step " + beans + ":");

			// Check contents of freeMale
			// System.out.println("Free Men: " + freeMale);

			// Get the index of the first male in the freeMale pool
			// Store it in manIndex
			beef = 0;
			for (ArrayList<String> person : male) {
				String str = freeMale.get(0);
				int i = person.indexOf(str);
				if (i == 0) {
					manIndex = beef;
				}
				beef++;
			}

			// Get the index of this man's most preferred woman
			// Store it in womanIndex
			womanIndex = (Integer.valueOf(male.get(manIndex).get(1))) - 1;

			/*
			 * Debug -- peek under the hood System.out.println("manIndex: " +
			 * manIndex); System.out.println("womanIndex: " + womanIndex);
			 */

			// Get names using indexes
			String matchingMale = maleName.get(manIndex);
			String matchingWoman = femaleName.get(womanIndex);

			// Male proposes
			System.out.println(matchingMale + " proposes to " + matchingWoman + ".");
			if (partnerIndex.get(womanIndex) == -1) { // If target woman is
														// single
				// Congratulations, you are now married
				System.out.println(matchingWoman + " is single. She accepts.");
				partnerName.set(womanIndex, matchingMale);
				partnerIndex.set(womanIndex, manIndex);
				freeMale.remove(0);
				System.out.println(matchingMale + " marries " + matchingWoman + ".");
			} else { // Target woman is married
						// Declarations
				String currentPartner = partnerName.get(womanIndex);

				// Get the index of the woman's current partner
				beef = 0;
				for (ArrayList<String> person : male) {
					String str = currentPartner;
					int i = person.indexOf(str);
					if (i == 0) {
						currentIndex = beef + 1;
					}
					beef++;
				}

				// Report marriage
				System.out.println(matchingWoman + " is currently married to " + partnerName.get(womanIndex) + ".");

				// Adjust manIndex to account for names at index 0
				// Get rankings of each man on woman's preference list
				manIndex++;
				Integer manRank = female.get(womanIndex).indexOf(manIndex.toString());
				manIndex--;
				Integer currentRank = female.get(womanIndex).indexOf(currentIndex.toString());
				System.out.print(matchingWoman + " ranks " + matchingMale + " as " + manRank + ". ");
				System.out.println(matchingWoman + " ranks " + currentPartner + " as " + currentRank + ".");

				// Check woman's preferences
				if (manRank < currentRank) { // Woman values proposer more than
												// current partner
					System.out.println(matchingWoman + " leaves " + currentPartner + " for " + matchingMale + ".");
					System.out.println(currentPartner + " is now single.");
					partnerName.set(womanIndex, male.get(manIndex).get(0));
					partnerIndex.set(womanIndex, manIndex);
					male.get(currentIndex - 1).remove(1);
					freeMale.remove(0);
					freeMale.add(currentPartner);
				} else { // Woman prefers current partner
					System.out.print(matchingWoman + " prefers her current partner. ");
					System.out.println(matchingMale + " moves on.");
					male.get(manIndex).remove(1);
				}
			}

			// Print stored partner indexes
			// System.out.println("Women Partner: " + womenPartner);

			// End of round, increment, formatting
			System.out.println();
			beans++;
		}

		// Print results
		System.out.println("*** SYSTEM ***");
		System.out.println("Matching finished in " + (beans - 1) + " steps. Printing results...");
		for (int y = 0; y < male.size(); y++) {
			System.out.println(maleName.get(y) + " is married to " + femaleName.get(partnerIndex.get(y)) + ".");
		}
		for (int z = 0; z < female.size(); z++) {
			System.out.println(femaleName.get(z) + " is married to " + maleName.get(partnerIndex.get(z)) + ".");
		}

		/*
		 * Debug -- peek under the hood System.out.println();
		 * System.out.println("*** DEBUG ***"); System.out.println("male: " +
		 * male); System.out.println("female: " + female);
		 * System.out.println("maleName: " + maleName);
		 * System.out.println("femaleName: " + femaleName);
		 * System.out.println("partnerIndex: " + partnerIndex);
		 * System.out.println("partnerName: " + partnerName);
		 */

		// Close scanners
		scannerM.close();
		scannerF.close();

		// Program finished
		System.out.println();
		System.out.println("*** SYSTEM ***");
		System.out.println("End of program.");

	}

}
