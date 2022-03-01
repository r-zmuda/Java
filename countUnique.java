public static int countUnique(List<Integer> list) {
	Set<Integer> store = new HashSet<Integer>();
	for(int i : list) {
		store.add(i);
	}
	return store.size();
}
