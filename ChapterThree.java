package chapter03;

import java.math.*;

public class Programming_Project_C3_2 {
	public static void main(String[] args) {
		// Variables
		double interestRate = 0.065, balance = 5000, deposit = 500;

		// Initializations
		double monthly = 0;
		BigDecimal bigBalance = new BigDecimal(balance);
		BigDecimal bigMonthly = new BigDecimal(monthly);
		BigDecimal bigEndBalance = new BigDecimal(balance);

		// Monthly deposit is a constant
		BigDecimal bigDeposit = new BigDecimal(deposit);
		bigDeposit = bigDeposit.setScale(2);

		// Build table
		System.out.println("\tStarting\t\t\t\t\t\tEnding");
		System.out.println("Year\tBalance\t\t\tInterest\tDeposit\t\tBalance");
		System.out.println();

		// 25 year projection
		for (int year = 1; year <= 25; year++) {
			// Year column
			System.out.print(year + "\t");

			// Balance column (starting balance)
			bigBalance = BigDecimal.valueOf(balance);
			bigBalance = bigBalance.setScale(2, RoundingMode.HALF_UP);
			System.out.print(bigBalance + "  \t\t");

			// Interest column (calculate interest here, skip first year of
			// deposits)
			if (year > 1) {
				balance += deposit;
			}
			monthly = balance * interestRate;
			bigMonthly = BigDecimal.valueOf(monthly);
			bigMonthly = bigMonthly.setScale(2, RoundingMode.HALF_UP);
			System.out.print(bigMonthly + "\t\t");

			// Deposit column (skip first year)
			if (year > 1) {
				System.out.print(bigDeposit + "\t\t");
			} else {
				System.out.print("  0.00\t\t");
			}

			// Total column (total balance)
			balance += monthly;
			bigEndBalance = BigDecimal.valueOf(balance);
			bigEndBalance = bigEndBalance.setScale(2, RoundingMode.HALF_UP);
			System.out.print(bigEndBalance);

			// End of row
			System.out.println();
		}
	}
}