package other;

import java.util.*;

public class Stackassignment {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
    	String original = "";
    	original = string.toLowerCase().replaceAll("\\s|\\?|\\.|\\!|\\,|\\'", "");
    	Stack<Character> stack = new Stack<Character>();
    	for(int x = 0; x < original.length(); x++) {
    		stack.push(original.charAt(x));
    	}
    	String reversed = "";
    	while(!stack.isEmpty()) {
    		reversed += stack.pop();
    	}
    	if(original.equals(reversed)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
