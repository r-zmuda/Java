public static boolean isUnique(Map<String, String> mappa) {
	Set<String> uniK = new HashSet<String>();
	Set<String> uniV = new HashSet<String>();
	if(mappa.isEmpty()) {return true;}
	for(String s : mappa.keySet()) {uniK.add(s);}
	for(String s : mappa.values()) {uniV.add(s);}
	if(uniK.size() == uniV.size()) {return true;}
	else {return false;}
}
