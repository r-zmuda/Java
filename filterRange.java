public static void filterRange(ArrayList<Integer> numbers, int min, int max) {
	for(int i = 0; i < numbers.size(); i++) {
		if(numbers.get(i).intValue() >= min && numbers.get(i).intValue() <= max) {
			numbers.remove(i);
			i--;
		}
	}
}
