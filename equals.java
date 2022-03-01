public static boolean equals(Stack<Integer> s1, Stack<Integer> s2) {
	if(s1.size() != s2.size()) {
		return false;
	}
    
	Stack<Integer> backup = new Stack<Integer>();
	int[] a1 = new int[s1.size()];
	int[] a2 = new int[s2.size()];
	int i = 0;
	
	while(!s1.isEmpty()) {
		int next = s1.pop();
		backup.push(next);
		a1[i] = next;
		i++;
	}
	
	while(!backup.isEmpty()) {s1.push(backup.pop());}
	
	i = 0;
	
	while(!s2.isEmpty()) {
		int next = s2.pop();
		backup.push(next);
		a2[i] = next;
		i++;
	}
	
	while(!backup.isEmpty()) {s2.push(backup.pop());}
	
	return Arrays.equals(a1, a2);
}
