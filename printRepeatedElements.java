package codes_new;

import java.util.HashMap;
import java.util.HashSet;

public class printRepeatedElements {
	
	private static HashSet<Integer> method(int[] arr) {
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i : arr) {
			if(!set.contains(i)) {
				set.add(i);
			}
		}
		return set;
		
	}
	
	private static HashMap<Integer, Integer> anotherMethod(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr) {
			
			if(!map.containsKey(i)) {
				map.put(i, 1);
			}
			else {
				map.put(i, map.get(i)+1);
			}
		}
		return map;
	}
	
public static void main (String[] args) {
	
	int[] arr = {1, 2,4,3,1, 3, 4, 3};
	HashSet<Integer> result = method(arr);
	//result.stream().forEach(i->System.out.println(i));
	HashMap<Integer, Integer> map = anotherMethod(arr);
	//map.entrySet().stream().forEach(i->System.out.println(i.getKey() + " " + i.getValue()));
	map.entrySet().stream().filter(i->i.getKey()%2==0).forEach(i->System.out.println(i.getKey() + "  "+ i.getValue()));
}
}
