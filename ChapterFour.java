package chapter04;

import java.util.*;
import java.math.*;

public class ChapterFour {
	public static void main(String[] args) {
		// Initialization
		Scanner console = new Scanner(System.in);
		System.out.print("Input income: ");
		double tax = 0, income = console.nextDouble();
		BigDecimal bigIncome = new BigDecimal(income);
		bigIncome = bigIncome.setScale(2, RoundingMode.HALF_UP);

		// Calculation
		if (income > 51000) {
			tax = (income - 51000) * .30 + 7500;
		} else if (income > 21000) {
			tax = (income - 21000) * .20 + 1500;
		} else if (income > 6000) {
			tax = (income - 6000) * .10;
		} else {
			tax = 0;
		}
		BigDecimal bigTax = new BigDecimal(tax);
		bigTax = bigTax.setScale(2, RoundingMode.HALF_UP);

		// End of program
		System.out.println("Your income is: $" + bigIncome);
		System.out.println("Your tax is: $" + bigTax);
		console.close();
	}
}