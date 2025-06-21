package codes_new;

//import java.util.HashMap;
import java.util.*;

public class SetsAndMaps {

	
	
	
	
	
	
	
	public static void main(String[] args) {
		Map<Integer, String> hm1 = new LinkedHashMap<>();
		Set<Integer> set1 = new LinkedHashSet<>();
		
		
		hm1.put(1 , "one");
		hm1.put(2, "two");
		hm1.put(3, "three");
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		hm1.forEach((i,j)->System.out.print(i+j));
		set1.forEach((i)->System.out.print(i));
		
		Map<Integer, String> hm = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		
		
		hm.put(1 , "one");
		hm.put(2, "two");
		hm.put(3, "three");
		
		set.add(1);
		set.add(2);
		set.add(3);
		
		System.out.println(set.contains(1));
		
		System.out.println(hm.containsKey(1));
		System.out.println(hm.containsValue("one"));
		
		hm.forEach((i,j)->System.out.print(i+j));
		set.forEach((i)->System.out.print(i));
	}
}
