public static int[] vowelCount(String stuff) {
    int[] vowels = new int[5];
	for(int x = 0; x < stuff.length(); x++) {
		char letter = stuff.charAt(x);
		if(letter == 'a') { vowels[0]++; }
		if(letter == 'e') { vowels[1]++; }
		if(letter == 'i') { vowels[2]++; }
		if(letter == 'o') { vowels[3]++; }
		if(letter == 'u') { vowels[4]++; }
	}
	for(int x = 0; x < vowels.length; x++) {
		System.out.println(vowels[x]);
	}
	return vowels;
}
