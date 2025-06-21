package Codes;

import java.util.ArrayList;

public class Lamdas {

	public static void main(String args[])
	{
		ArrayList<Integer> a= new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.forEach(i->System.out.println(i));
		a.stream().map(x-> x*2).forEach(i-> System.out.println(i));
		
	}
}
