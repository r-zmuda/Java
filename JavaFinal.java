package other;

public class JavaFinal {

	public static void main(String[] args) {
		int x = 7;
		int y = 3;
		printMultiples(x, y);
	}

	public static void printMultiples(int n, int m) {
		System.out.print("The first " + m + " multples of " + n + " are: " + n);
		for (int i = 2; i <= m; i++) {
			System.out.print(", " + n * i);
		}
		System.out.println();
	}

}
