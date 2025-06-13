package JavaEight;

import java.util.*;
import java.util.stream.Stream;

public class StriversStrings {

	public static void main(String[] args) {
		
		//Reverse Words in a String
		//Input: s="this is an amazing program"
        //Output: “siht si na gnizama margorp "
		reverseEachWordsInSequence();
		System.out.println();
		
		//Reverse Words in a String
		//Input: s="this is an amazing program"
		//Output: “program amazing an is this "
		reverseWords();
		System.out.println();
		
		//Longest Palindromic Substring
		//Input: s = "forgeeksskeegfor" 
        //Output: "geeksskeeg"
		System.out.println(longestPalindrome());
		System.out.println();
		
		//Roman to int
		//input: s = "XL"
		//Output: 40
        //Input: s = "MCMIV"
        //Output: 1904
		romanToInt();
		System.out.println();
		
		intToRoman();
		System.out.println();
		
		//Longest Common Prefix
		System.out.println(longestCommonPrefix());
		System.out.println();
		
		//Given two strings, one is a text string, text, and the other is a pattern string, pattern.
		//Print the indexes of all occurrences of the pattern string in the text string
		
		printOccuranceIndes();
		System.out.println();
		
		compareTwoVersions();
		System.out.println();
		
		// will check later
		longestSubStringWithoutRepChars();
	}

	private static void longestSubStringWithoutRepChars() {
		String s = "bbbbb";
		int max = 0;
		int n= s.length();
		int start=0, end=0;
		for(int i=0;i<n;i++) {
			
			for(int j=i+1;j<n;j++) {
				String ss = s.substring(i, j+1);
				System.out.println(ss + " "+isStringHavingUniqueChars(ss) );
				if(isStringHavingUniqueChars(ss)) {
				//	max = Math.max(max, j-i+1);
					
					//if u also want indexes
					 
					 if(j - i + 1> max){
					 max = j-i+1;
					 start = i;
					 end = j;
					 }
		 
				}
			}
		}
		System.out.println(max+" rep "+ start+" "+end);
	}

	private static boolean isStringHavingUniqueChars(String s) {
		Set<Character> set = new HashSet<>();
		set.add(s.charAt(0));
		for(int i=1;i<s.length();i++){
			if(!set.add(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static void compareTwoVersions() {
		String v1 = "1.2.31";
		String v2 = "1.3.23";
		
		String[] arr1= v1.split("\\."); // "." wont work as its a special char
		String[] arr2= v2.split("\\.");
		
		String s1="";
		String s2="";
		for(String i :arr1) {
			s1+=i;
		}
		for(String i :arr2) {
			s2+=i;
		}
		
		if(Integer.valueOf(s1)<Integer.valueOf(s2)) {
			System.out.println(v2);
		}else {
			System.out.println(v1);
		}
		
	}

	private static void printOccuranceIndes() {
		//Input: input = "xyzabxyzabxyz", pattern = "xyz"
        //Output: 0 5 10
		String input= "xyzabxyzabxyz", pattern = "xyz";
		
		for(int i=0;i< input.length() - pattern.length() +1 ; i++) {
			if(input.substring(i, i+pattern.length()).equals(pattern)) {
				System.out.print(i+" ");
			}
		}
		
	}

	private static String longestCommonPrefix() {
		
		String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
		
		Arrays.sort(arr);
		
	    String first = arr[0];
	    String last = arr[arr.length-1];
	    
	    int minLength = Math.min(first.length(), last.length());
	    int i=0;
	    while(i<minLength && first.charAt(i) == last.charAt(i) ) {
	    	i++;
	    }
	    
	    if(i!=0) {
	    	return first.substring(0, i);
	    }
	    return "";
		
		
	}

	private static void intToRoman() {
		
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
		
		int n = 3949;
		System.out.println(getRomanValue(n, map));
		
		
		
	}

	private static String getRomanValue(int n, TreeMap<Integer, String> map) {
		
		int l = map.floorKey(n);
		
		if(l == n){
			return map.get(l);
		}
		return map.get(l) + getRomanValue(n-l, map);
		
		
	}

	private static void romanToInt() {
		String s="MMMCMXLIX";
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int res=0;
		
		for(int i=0;i<s.length()-1;i++) {//IV -> 5-1
			if(map.get(s.charAt(i+1)) - map.get(s.charAt(i)) >0) {
				res+= (map.get(s.charAt(i+1)) - map.get(s.charAt(i)));
				i++; // skip next element as V - I done
				// geeks for geeks roman to int example 
//				If a smaller value symbol comes before, we subtract. Otherwise, we add.
//				In IV, I comes before V and V has a larger value 5. So our result is 5 - 1 = 4.
//				In VI, V comes before I and I has a smaller value 1. So our result is 5 + 1 = 6.
//				In II, we have same values, so we add and get 1 + 1 = 2
//				In case of more than 2 characters, we traverse from left to right and
//				group only when we see a greater value character after a smaller value character.
//				For example MXVII is 1000 + 10 + 5 + 1 + 1 = 1017. And XLVII is
//				(50 - 10) + 5 + 1 + 1 = 47. Note that L is larger and comes after X.
			}
			
			else {
				res+= map.get(s.charAt(i));
			}
		}
		System.out.print(res);
		
	}

	private static String longestPalindrome() {
		String s= "forgeeksskeegfor"; 
		int left=0, right=s.length();
		while(left<right) {
			String ss = s.substring(left, right);
			
			if(isPalindrome(ss)) {
				return ss;
			}
			
			ss = s.substring(left+1, right);
			if(isPalindrome(ss)) {
				return ss;
			}
			
			ss = s.substring(left, right-1);
			if(isPalindrome(ss)) {
				return ss;
			}
			left++;
			right--;
		}
		return "not found";
	}
	
	private static boolean isPalindrome(String s) {
		String reverse = new StringBuilder(s).reverse().toString();
		if(s.equals(reverse)){
			return true;
		}
		return false;
	}

	private static void reverseWords() {
        String s = "this is an amazing program";
		
		String[] arr = s.split(" ");
		
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
		
	}

	private static void reverseEachWordsInSequence() {
		String s = "this is an amazing program";
		
		String[] arr = s.split(" ");
		
		Object[] out = Arrays.stream(arr).map(word -> new StringBuilder(word).reverse().toString())
				.toArray();
		
		for(Object i : out) {
			System.out.print(i.toString()+" ");
		}
		
	}
}
