public static void removeDuplicates(ArrayList<String> words) {
	for(int i = 0; i < words.size() - 1; i++) {
		if(words.get(i).equals(words.get(i+1))) {
			words.remove(i+1);
            i--;
		}
	}
}
