package chapter12;

public class repeatRun {
	public static void main(String[] args) {
		System.out.print(repeat("hello", 3));
		System.out.println();
		System.out.print(repeat("this is fun", 1));
		System.out.println();
		System.out.print(repeat("wow", 0));
		System.out.println();
		System.out.print(repeat("hi ho! ", 5));
		System.out.println();
	}

	public static String repeat(String s, int n) throws IllegalArgumentException {
		if (n > 0) {
			return s + repeat(s, n - 1);
		} else if (n == 0) {
			return "";
		} else {
			throw new IllegalArgumentException("n must be positive.");
		}
	}
}
