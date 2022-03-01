package other;

import java.util.*;
import java.io.*;

public class Reverse {

	public static void main(String[] args) throws FileNotFoundException {
		//Set up ArrayList to hold ArrayLists
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		//Set up text file and file scanner
		File file = new File("src/other/reverse_me.txt");
		Scanner fileScan = new Scanner(file);
		
		//Read each line and word, reverse, then store into an ArrayList
		while(fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			Scanner lineScan = new Scanner(line);
			ArrayList<String> readLine = new ArrayList<String>();
			while(lineScan.hasNext()) {
				String str = lineScan.next();
				readLine.add(str);
			}
			lineScan.close();
			Collections.reverse(readLine);
			list.add(readLine);
		}
		
		//Done with file, close scanner, reverse sentence order
		fileScan.close();
		Collections.reverse(list);
		
		//Output all contents of list
		for(int x = 0; x < list.size(); x++) {
			for(int y = 0; y < list.get(x).size(); y++) {
				System.out.print(list.get(x).get(y) + " ");
			}
			System.out.println();
		}
	}
}