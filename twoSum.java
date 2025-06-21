package codes_new;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class twoSum {

	private static int[] isTwosum(int[] arr, int target) {

		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int sum = arr[start] + arr[end];
			if (sum == target) {
				return new int[] { start, end };
			} else if (sum < target) {
				start += 1;
			} else {
				end -= 1;
			}
		}
		return new int[] { -1, -1 };

	}

	public static int[] swap2Numbers(int a, int b) { // 2 3
		a = a + b; // 5
		b = a - b; // 2
		a = a - b; // 3
		return new int[] { a, b };
	}

	private static StringBuilder getBinaryOfNumber(int a) {
		String s = "";
		while (a > 0) {
			s += (a % 2);
			a = a / 2;

		}
		StringBuilder rs = new StringBuilder();
		rs.append(s);
		return rs.reverse();
		// or // Using StringBuilder's reverse method
		// String reversed = new StringBuilder(str).reverse().toString();
		// no need of return type as stringbuilder
	}

	private static int[] fibo(int a) {

		int aa = 0;
		int bb = 1;
		int cc;
		int[] arr = new int[a];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < a; i++) {
			cc = aa + bb;
			aa = bb;
			bb = cc;
			arr[i] = cc;
		}

		return arr;
	}

	private static void starPattern(int a) {// 1 3 5 7
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= a - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= (2 * i) - 1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}

//	    *
//	   ***
//	  *****
//	 *******

	}

	private static void anoterPattern(int n) {// 10 8 6 4 2 0

//          1 
//        2 1 2 
//      3 2 1 2 3 
//    4 3 2 1 2 3 4 
//  5 4 3 2 1 2 3 4 5 
//6 5 4 3 2 1 2 3 4 5 6 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 2 * (n - i); j++) {
				System.out.print(" ");
			}
			for (int k = i; k > 1; k--) {
				System.out.print(k + " ");
			}
			for (int l = 1; l <= i; l++) {
				System.out.print(l + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int[] arr = { 0, -1, 0, -1, 12, -3, 1 }; // -3 -1 0 1 2
		int target = -1;
		Arrays.sort(arr);
		// as arr is getting sorted -> indexes which are returning
		// from above method are not same as original array
		// System.out.println(Arrays.toString(fibo(10)));
//starPattern(4);
//anoterPattern(6);
		findEvensUsingStream(arr);
	}

	private static void findEvensUsingStream(int[] arr) {
		// int arr[] = {20, 10, 20, 4, 100};

		// Java Stream and max to find the
		// max element in array

//	 myList.stream()
//     .map(s -> s + "") //another way to Convert integer to String
//     .filter(s -> s.startsWith("1"))
//     .forEach(System.out::println);

		// Arrays.stream(arr).filter(n->
		// Integer.toString(n).startsWith("1")).forEach(n->System.out.print(n+" "));
		Set<Integer> s = new HashSet<>();
// to get duplicates ones
		Arrays.stream(arr).filter(n -> !s.add(n)).forEach(n -> System.out.print(n + " "));

//to get distinct ones
		// Arrays.stream(arr).distinct().forEach(n->System.out.print(n+" "));

//or 
		Set<Integer> ss = new HashSet<>(Arrays.stream(arr).boxed().toList());

		ss.stream().toList().forEach(n -> System.out.print(n + " "));

	}

}
