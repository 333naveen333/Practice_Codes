package Codes;

import java.util.Stack;

public class Brackets {
	
   static String s = "[()]{}{[()()]()}";
	public static void main (String args[]) {
		System.out.print(valid(s));
	}
	
	private static boolean valid(String s) {
		
		Stack<Character> s1 = new Stack<>();
		
		for(int i =0;i<s.length();i++){
			Character c = s.charAt(i);
			if(c== '[' || c=='{'|| c=='(' ) {
				s1.push(c);
			}
			else {
				if(s1.isEmpty()) {
					return false;
				}
				Character top = s1.peek();

				if ((c == '}' && top == '{') || (c == ']' && top == '[') || (c == ')' && top == '(')) {
					s1.pop();
				} else {
					return false;
				}

			}
		}
		
		if(s1.isEmpty()) {
			return true;
		}
		return false;
		
	}
}
	


