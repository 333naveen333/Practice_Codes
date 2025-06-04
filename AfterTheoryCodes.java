package JavaEight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AfterTheoryCodes {
	
	public static void main(String[] args) {
		String input = "reverse this this sentence";
		System.out.println(stringReversal(input));
		
		System.out.println(stringReversalUsingStringBuilder(input));
		
		int a=10, b=20;
		//swap(a,b); // this method wont work
		
		// or do these swappings directly in main
		// without using 3rd var
//		a=a+b;//30
//		b=a-b;//10
//		a=a-b;
		
		//with 3rd var
//		int c=a;
//		a=b;
//		b=c;
		
		
		// int[] arr = {a,b};
		// pass this as param in method and do swap and return that
		System.out.println("swapped " + a + "  " + b);
		
		// count word freq in given string usign streams
		String[] arr = input.split(" ");
		Map<String, Long> map=Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
	    map.forEach((k,v)-> System.out.println(k + " " + v));
	    
	    // again count using directly hashmap
	    HashMap<String, Integer> map1 = new HashMap<String, Integer>();
	    
	    for(String i : arr) {
	    	if(map1.containsKey(i)) {
	    		map1.put(i, map1.get(i)+1);
	    	}
	    	else {
	    		map1.put(i, 1);
	    	}
	    }
	    map1.forEach((k,v)-> System.out.println(k + " " + v));
	    
	    
	    System.out.println(isPalindrome("12321"));
	    System.out.println(isPalindrome("12331"));
	    System.out.println(isPalindrome(String.valueOf(12345))); // if input is int
	    
	    fibonacciPrint(10);
	    System.out.println();
	    duplicateCharsInString("qwertyyyt");
	    
	    int[] arr1= {1,4,5,6,9};
	    int[] arr2= {2,4,6,8};
	    System.out.println();
	    // without any built in fucntions
	    mergeTwoSortedArrays(arr1, arr2);
	    System.out.println();
	    
	    //with built in funtions
	    mergeTwoSortedArraysUsingBuilts(arr1,arr2);
	    
	    
	}

	private static void mergeTwoSortedArraysUsingBuilts(int[] arr1, int[] arr2) {
		
		int[] arr = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
		
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//or add 2 arrays usign arraycopy and then do sort()
		
		int[] dest = new int[arr1.length+ arr2.length];
		
		System.arraycopy(arr1, 0, dest, 0, arr1.length);
		System.arraycopy(arr2, 0, dest, arr1.length, arr2.length);
		
		Arrays.sort(dest);
		for(int i : dest) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(isPrime(7));
		// similarly we can print n prime numbers
		System.out.println();
		printNPrimes(10);
		
		System.out.println();
		String s1 = "Silent ";
		String s2 = "Listen";
		checkTwoStringsAreAnagrams(s1,s2);
		
		
		System.out.println();

        //Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
        //Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]

		List<String> list = List.of("Silent", "listen", "map", "apm","pam","ap" );
		
	    System.out.println();
		System.out.println(getFirstNonRepChar());
		
		
		//need to check this
		//listAllAnagrams(list);
		
		
	}

	private static Character getFirstNonRepChar() {
		String s = "aaeerffd";
		char[] arrr = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		
		for(char i : arrr) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		
		for(Map.Entry<Character, Integer> m : map.entrySet()) {
			if(m.getValue()==1) {
				return m.getKey();
			}
		}
		return null;
	}
	
	

	private static void listAllAnagrams(List<String> list) {
		List<String> outList = new ArrayList<>();
		
		for(String word : list) {
			word = word.replace(" ", "").toLowerCase();
			char[] arr = word.toCharArray();
			Arrays.sort(arr);
			word = String.valueOf(arr); 
			outList.add(word);
		}
		Map<String, List<String>> map = new LinkedHashMap<>();
		//Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
        //Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]
		for(String word: outList) {
			List<String> l = map.getOrDefault(word, new ArrayList<>());
			//map.put(word, );
		}
//		map = outList.stream().
//		collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
//		
//		
//		for(String word : outList) {
//			map.computeIfAbsent(word, k-> new ArrayList<>().add(word));
//		}
		
		
	}

	private static boolean checkTwoStringsAreAnagrams(String s1, String s2) {
		
		// use replace white spaces one if needed
		char[] arr1= s1.replace(" ", "").toLowerCase().toCharArray();
		char[] arr2 = s2.toLowerCase().toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		// here faced an issue when i didnt used .tolowercase
		// arrays used to sort with captial L and S which makes order not as expcted
		// so must use .touppoer or lower before sort
		
		if (Arrays.equals(arr1, arr2)) {
			return true;
		}
		
			return false;
		
	}

	private static void printNPrimes(int n) {
		int i=2;
		while(n>0) {
			
			if(isPrime(i)) {
				n--;
				System.out.print(i+" ");
			}
			i++;
		}
		
		
	}

	private static boolean isPrime(int n) {
		
		if(n<=1) {
			return false;
		}
		
		for(int i=2;i<= Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}

	private static void mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		
		int[] arr= new int[arr1.length + arr2.length];
		int i=0,j=0,k=0;
		while(i<arr1.length && j<arr2.length) {
			
			if(arr1[i]<arr2[j]) {
				arr[k]= arr1[i];
				i++;
				k++;
			}
			else {
				arr[k]=arr2[j];
				j++;
				k++;
			}
		}
		
		while(i<arr1.length) {
			arr[k]=arr1[i];
			i++;
			k++;
		}
		while (j<arr2.length) {
			arr[k]=arr2[j];
			j++;
			k++;
		}
		
		for(int ii : arr) {
			System.out.print(ii+" ");
		}
		
	}

	private static void duplicateCharsInString(String input) {
	
		List<Character> list = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		
		for(char i : input.toCharArray()) {
			list.add(i);
			// below logic will add count of dupes i mean extra dupes 
			// here got map output as t 1 and y 2 (but in strign its 2 and 3 times)
			// but as we are doing this check in inside list.contains getting all extra ones
			// we can play accourdingly
//			if(list.contains(i)) {
//				if(map.containsKey(i)) {
//					map.put(i, map.get(i)+1);
//				}
//				else {
//					map.put(i,  1);
//				}
//				
//			}
			
		}
		
		map.forEach((k,v)-> System.out.println(k+ " "+ v));
		
		Set<Character> set = new LinkedHashSet<>(list);
		// remove dups
		set.forEach(x->System.out.print(x+" "));
		
		
		// armstrong number check == sum of its cube of digits
		System.out.println();
		System.out.println(armstrong(153)); // true
		System.out.println(armstrong(372)); // false
		
		
	}

	private static boolean armstrong(int i) {
		
		List<Integer> list = new ArrayList<>();
		int rem;
		int temp=i;
		while (i>0) {
			rem = i%10;
			i=i/10;
			list.add(rem);
		}
		
//		System.out.println(list.toString());
//		System.out.println(list.size());
		int res=0;
		for(int n : list) {
			res = res+ (n*n*n);
		}
		
	//	System.out.println(res);
		if(temp==res) {
			return true;
		}
		return false;
		
	}

	private static void fibonacciPrint(int i) {
		
		int a=0, b=1,c;
		System.out.print(a+" "+b);
		while(i-2>0) {
			i--;
			c=a+b;
			a=b;
			b=c;
			System.out.print(" "+c);
		}
		
	}

	private static boolean isPalindrome(String input) {
	
		StringBuilder sb = new StringBuilder(input);
		return sb.reverse().toString().equals(input);
		// or without builder also we can do as in below string reversal example
		
	}

	// this method wont work - because java maintain copies in this method not altered main one
	//as it pass by value
	private static void swap(int a, int b) {
		a=a+b;//30
		b=a-b;//10
		a=a-b;
	}
	
	//to

	private static String stringReversalUsingStringBuilder(String input) {
		StringBuilder sb = new StringBuilder(input);
		return sb.reverse().toString();
	}

	private static String stringReversal(String input) {
		
		if(input==null || input.length()==0) {
			return "can't do";
		}
		String output ="";
		for(int i=input.length()-1 ; i>=0;i--) {
			output+=input.charAt(i);
		}
		return output;
	}

}
