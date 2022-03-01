public static String repeat(String s, int n) throws IllegalArgumentException {
	if(n > 0) {return s + repeat(s, n - 1);}
	else if (n == 0) {return "";}
	else {throw new IllegalArgumentException("n must be positive.");}
}
