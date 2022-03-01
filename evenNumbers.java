public static void evenNumbers(Scanner x) {
	int sum = 0;
	int count = 0;
	int evens = 0;
	double percent = 0.0;
	while(x.hasNextInt()) {
		int n = x.nextInt();
		sum += n;
		count++;
		if (n % 2 == 0) {
			evens++;
		}
	}
	percent = (double) (evens * 100) / count;
	System.out.println(count + " numbers, sum = " + sum);
	System.out.println(evens + " evens (" + String.format("%.2f", percent) + "%)");
}
