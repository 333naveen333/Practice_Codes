package JavaEight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class ReverseOrderList {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(3);
		list.add(9);
		list.add(9);
		
//		Collections.sort(list); // to get asc order or (list, (a, b) -> a-b);
//		System.out.println(list);
//		
//		Collections.sort(list, (a,b)->b-a); //desc order
//		System.out.println(list);
		
		
		Set<Integer> set = new HashSet<>(list); // remove duplicates but cannot assure order will be sorted
		System.out.println(set);
		
		Set<Integer> set1 = new TreeSet<>(list); // removes dupliacets and can assure order will be soretd
		System.out.println(set1);
		
		Set<Integer> set2 = new LinkedHashSet<>(list); // removes dups and order will be as its inserted so 5 3 9
		System.out.println(set2); 
		
		
		Emp emp1 = new Emp(1, "one");
		Emp emp3 = new Emp(3, "three");
		Emp emp2 = new Emp(2, "two");
		
		List<Emp> list1 = new ArrayList<>();
		list1.add(emp1);
		list1.add(emp3);
		list1.add(emp2);
		
		//Collections.sort(list1); // we cant give like this compartor needs to be given as compiler wont know 
		Collections.sort(list1, (a, b)->a.id-b.id);
		Collections.sort(list1, (a,b)->b.id-a.id); // for desc order
	System.out.println(list1.toString());
	}
}

class Emp {
	 int id;
	 String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		//return this.id+ " "+ this.name;
	return "Emp [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
