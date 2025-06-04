package JavaEight;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
	// *** means i took some time

	public static void main(String[] args) {

		List<Integer> list = List.of(0, 1, 1, 15, 2, 3, 4, 5, 8, 65, 12, 45); // Arrays.asList(1,2,3);

//		Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
		System.out.println(list.stream().filter(n -> (n > 0 && n % 2 == 0)).collect(Collectors.toList()));

//		Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		System.out.println(list.stream().map(i -> Integer.toString(i)).filter(x -> x.startsWith("1"))
				.collect(Collectors.toList()));

//		How to find duplicate elements in a given integers list in Java using Stream functions?
		System.out.println(list.stream().map(i -> Integer.toString(i)).filter(x -> x.startsWith("1")).distinct()
				.collect(Collectors.toList()));

//		Given the list of integers, find the first element of the list using Stream functions?
		System.out.println(list.stream().findFirst().get());

//		Given a list of integers, find the total number of elements present in the list using Stream functions?
		System.out.println(list.stream().count());

//	Given a list of integers, find the maximum value element present in it using Stream functions?

		System.out.println(list.stream().max((a, b) -> a - b).get());

//***	Given a String, find the first non-repeated character in it using Stream functions?
		String input = "abccba";
		// Best way for this and below question is to find count using hashmap

		// map to obj make IntStream to a Stream<Integer> or we can use .boxed() and
		// after all (char)
		System.out.println(input.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1L).map(x -> x.getKey()).findFirst().orElse(' '));
		// stores values in long so 1L

//	Given a String, find the first repeated character in it using Stream functions?
//	Set<Integer> set = new LinkedHashSet<>(); // for abccba as input this one will give c as o/p and below on will give a
//	System.out.println((char)input.chars().filter(x->!set.add(x)).findFirst().getAsInt());

		System.out.println(input.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).findFirst().orElse((' ')));

		// for given string "elephant" count frequency of letter 'e'

		String s = "Elephant";
		System.out.println(s.chars().mapToObj(x -> Character.toLowerCase(x)).filter(x -> x == 'e').count());

//	Given a list of integers, sort all the values present in it using Stream functions?
		List<Integer> list1 = List.of(5, 4, 1, 2, 3);
		System.out.println(list1.stream().sorted().toList());
//	Given a list of integers, sort all the values present in it in descending order using Stream functions?
		System.out.println(list1.stream().sorted((a, b) -> b - a).toList());

//	Given an integer array nums, return true if any value appears at least twice in the array,
		// and return false if every element is distinct.

		int[] nums = { 1, 2, 3, 4, 5, 3 }; // or we can intialize as new int[5] and nums[0]=1....

		long c = Arrays.stream(nums).boxed()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).count(); // before count .peek(x->sysout(x)) to see
																			// that particular map combina
		if (c >= 1) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		// or

		Set<Integer> ss = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		if (ss.size() != nums.length) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

//***			Write a Java 8 program to concatenate two Streams?

		Stream<Integer> s1 = Stream.of(1, 2);
		Stream<Integer> s2 = Stream.of(3, 4);
		Stream<Integer> s3 = Stream.of(5, 6);
		Stream<String> s7 = Stream.of("hi", "hj");

		Stream<Integer> s4 = Stream.concat(s1, s2); // to add 2 streams
		// commenting out below lines becasue -> we need to comment out existing streams
		// to get output form s6 or
		// will get some stream open or close error

		// Stream<Integer> s5 = Stream.concat(Stream.concat(s1,s2),s3); //to add 3
		// ....to n

		// using flatmaps -> easy if streams are more but stream elements should be <32
		// else perf downs
		// Stream<Integer > s6= Stream.of(s1, s2,
		// s3).flatMap(Function.identity());//Stream.of(s1,s2).flatMap(s->s);

		// concating 2 diff datatyped streams
		// s8 will work but good practice is below s9
		// Stream<Object> s8 = Stream.concat(s1.map(Integer::valueOf),
		// s7.map(String::valueOf));
		// Stream<Object> s9 = Stream.concat(s1.map(i-> (Object)i),
		// s7.map(i->(Object)i));
		// s6.forEach(System.out::println);

//			Java 8 program to perform cube on list elements and filter numbers greater than 50.
		List<Integer> lll = List.of(1, 54, 244, 69, 49);
		System.out.println(lll.stream().filter(i -> i > 50).map(i -> i * i * i).toList());

//***			Write a Java 8 program to sort an array and then convert the sorted array into Stream?
		int[] arr = { 1, 4, 2 };
		Arrays.sort(arr);
		IntStream sss = Arrays.stream(arr);
		sss.forEach(System.out::println);

//		How to use map to convert object into Uppercase in Java 8?

		String in = "ajdskHdj";
		System.out.println(in.toUpperCase().toString()); // in java 8

		System.out.println(in.chars().mapToObj(x -> (char) x) // using stream
				.map(x -> Character.toUpperCase(x)).map(String::valueOf).collect(Collectors.joining()));

//	///***	How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?				
		List<Integer> li = List.of(1, 1, 2, 4, 3, 2, 1);
		Map<Integer, Long> map = li.stream()
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		map.forEach((a, b) -> System.out.println(a + " " + b)); // sorted by key

		Map<Integer, Long> map1 = li.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		// tomap takes keymapper and valuemapper as params see on line 216 for example
		// there keymapper is its string and value mapper is string length
		map1.forEach((a, b) -> System.out.println(a + " this " + b)); // sorted by value or freq

//				How to count each element/word from the String ArrayList in Java 8?
		String input11 = "hello hi his";
		String[] ss1 = input11.split(" ");
		List<String> ssss = List.of(ss1);
		System.out.println(ssss.toString());

		// list to map
		List<String> dup = List.of("hi", "hi", "hello");
		Map<String, Long> output = dup.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		Map<String, Long> outputt = dup.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));// see below 3rd line
		System.out.println("this " + outputt); // hi 2 hello 1

		// if we use this def will be hashmap -> no order of insertion

//	***	How to find only duplicate elements with its count from the String ArrayList in Java 8?
		List<String> dup1 = List.of("hi", "hi", "hello", "hello");
		Map<String, Long> output1 = dup1.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(output1); // hi 2 hello 2

// *** similar to this but high freq one as output
		List<String> inputHigh = List.of("Hi", "Hi", "Hello", "Hello", "k", "k", "k");

		Entry<String, Long> outputHigh = inputHigh.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(outputHigh); // k 3

//		How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
// use Optional.ofNullable(list).
		// max in array - sim//y min b-a or Arrays.sort(arr) now return
		int[] arrr = { 1, 4, 5, 6 };
		System.out.println(Arrays.stream(arrr).boxed().max((a, b) -> a - b).get());

		Arrays.sort(arrr);
		System.out.println(arrr[arrr.length - 1]);// min -> [0]
		System.out.println(arrr[0]);

		// How to count occurrences of each character of a String in Java 8?
		String each = "each as sentence";
		Map<Object, Object> outputeach = each.chars().mapToObj(x -> (char) x)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(x -> !x.getKey().equals(' ')) // not counting spaces
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		System.out.println("jahsjasj" + outputeach);

		// Write a Java program using Stream to create a map from a
		// list of strings where the key is the string and the value is its length?
		// if to ignore dups
		List<String> lastList = List.of("Hi", "Hi", "Hello", "Hello", "k", "k", "k");
		Set<String> sets = new HashSet<>(lastList);
		System.out.println("ajsjqas" + sets);
		sets.stream().collect(Collectors.toMap(Function.identity(), String::length)).entrySet().stream()
				.forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
		// if not // because above code with .tomap() giving exception as dups
		// so added (a,b)->a so duplicates ignored
		lastList.stream().collect(Collectors.toMap(Function.identity(), String::length, (a, b) -> a)).entrySet()
				.stream().forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
		// in streams forEach takes single param like x and then will do x.getKey..
		// but for direct maps we need to pass map.forEach((x,y) -> sysout x+y));

		// How to sort a list of strings by length using Lambda expressions?
		lastList.stream().sorted((a,b)->a.length()-b.length()).forEach(x->System.out.println(x));
		
		List<Integer> thisTimeLastList = List.of(1,5,4,2);
		System.out.println(thisTimeLastList.stream().max(Integer::compare).get());
		//	How will you get the current date and time using Java 8 Date and Time API?
	}

}
