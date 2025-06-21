package Codes;


import java.sql.Array;
import java.util.Comparator;
import java.util.List;

public class code2504 {
	public static void print(int n,int y) {
		//.reduce(0,Integer::sum)
		//.sorted(Comparator.reverseOrder())
		//.sorted(Comparator.comparing(inside we can give lambda of our required)
		// sorted, map, filter-> intermediate operatiosn -> return type stream 
		// for each , tolist -> terminal operation -> void
		// reduce also terminal as its returing somethign otherthan stream
		System.out.println(n+y);
	}
	public static void main(String[] args) {
		List<Integer> numberList = List.of(1,222,2,33,3,4);
//		System.out.println(numberList.stream()
//				.filter(n->n%2==0)
//		.map(n->n*n)
//		.reduce(0,Integer::sum));
//		numberList.stream().map(n->n.toString()).sorted(Comparator.comparing(n->n.length())).forEach(System.out::println);;
		numberList.stream().map(n->n*n).toList();
	}
}

