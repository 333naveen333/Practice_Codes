package JavaEight;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SomeJavaQuestions {

	public static class Employee {
		private int id;
		private int salary;
		private String name;

		public Employee(int id, int salary, String name) {
			super();
			this.id = id;
			this.salary = salary;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + "]";
		}

	}

	public static Double calculateAverage(List<Employee> list) {
		Double averageSalary = list.stream().filter(emp -> emp.getSalary() > 90000).mapToInt(emp -> emp.getSalary())
				.average().getAsDouble();
		return averageSalary;

	}

	public static String maxSalary(List<Employee> list) {
		String maxSalary = list.stream().max((e1, e2) -> e1.getSalary() - e2.getSalary()).get().getName();
		return maxSalary; // similarly getSalary for max salary
	}

	public static List<Employee> sortedList(List<Employee> list) {
		return list.stream().sorted((e1, e2) -> e1.getSalary() - e2.getSalary()).toList(); // asc
	} // similarly e2-e1 for desc

	// ---------------------------------
	static class Product {
		private String name;
		private int quantity;
		private double price;

		Product(String name, double price, int quantity) {
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}

		public String getName() {
			return name;
		}

		public double getPrice() {
			return price;
		}

		public int getQuantity() {
			return quantity;
		}
	}

	public static Double getTotalStockPrice(List<Product> list) {
		Double value = list.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
		return value;
	}

	// -------------------------------------------------------
	static class Transaction {
		private String payer;
		private String payee;
		private double amount;

		public Transaction(String payer, String payee, double amount) {
			this.payer = payer;
			this.payee = payee;
			this.amount = amount;
		}

		public String getPayer() {
			return payer;
		}

		public String getPayee() {
			return payee;
		}

		public double getAmount() {
			return amount;
		}

		@Override
		public String toString() {
			return "Transaction [payer=" + payer + ", payee=" + payee + ", amount=" + amount + "]";
		}

	}

	public static Map<Object, Object> getSumOfPayee(List<Transaction> list) {
		return list.stream()
				.collect(Collectors.groupingBy(Transaction::getPayee, Collectors.summingDouble(Transaction::getAmount)))
				.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

	}

	private static boolean isPrime(Integer n) {
		if (n <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		Employee e1 = new Employee(1, 100000, "person A");
		Employee e2 = new Employee(2, 130000, "person B");
		Employee e3 = new Employee(3, 110000, "person C");
		Employee e4 = new Employee(4, 90000, "person D");
		Collections.addAll(list, e1, e2, e3, e4);

		// sortedList(list).forEach(x -> System.out.println(x.toString()));
		// ----------------------------------------------

		List<Product> products = new ArrayList<>();
		products.add(new Product("radio", 99.0, 0));
		products.add(new Product("television", 82.0, 3));
		products.add(new Product("earbud", 82.5, 5));
		products.add(new Product("charger", 88.5, 0));
		products.add(new Product("mobile", 99.5, 2));

		// System.out.println(getTotalStockPrice(products));

		// ------------------------------------------------
		// ***
		List<Transaction> transactions = Arrays.asList(new Transaction("Dom", "Mona", 120.0),
				new Transaction("Jhon", "Charlie", 150.0), new Transaction("Bob", "Reha", 210.0),
				new Transaction("Jhon", "Mona", 150.0));

		Map<Object, Object> objs = getSumOfPayee(transactions);

		// objs.forEach((x,y)-> System.out.println(x + " "+ y));

		// ---------------------------------------------

		// use instream when in question gives range
		System.out.println(IntStream.range(1, 100).boxed().filter(x -> isPrime(x)).toList());

		// reverse an array
		// if i use .toList directly as its creates immutable list
		// it will return exception on collections.reverse
		// so used to Collect(Collectors.toList)

		int[] arr = { 1, 5, 4, 3 };
		List<Integer> ll = Arrays.stream(arr).mapToObj(x -> Integer.valueOf(x)).collect(Collectors.toList());
		Collections.reverse(ll);

		// System.out.println(ll.toString());

		// rotate an input list by k times
		// { 1, 4,3, 2,5,6} k=3 -> 2 , 5, 6, 1, ,4,3

		List<Integer> ls1 = Arrays.asList(1, 4, 7, 8, 9); // if i use List.of() // will get unsupportedope exacpetion as
															// immutable
		int n = ls1.size();
		int k = 3; // no of rotations
		reverse(ls1, 0, n - 1);
		reverse(ls1, 0, k - 1);
		reverse(ls1, k, n - 1);
		System.out.println(ls1);

		// now will do same but with array

		int[] arr1 = { 1, 4, 7, 8, 9 };

		int k1 = 3;

		reverseArray(arr1, 0, n - 1);
		reverseArray(arr1, 0, k - 1);
		reverseArray(arr1, k1, n - 1);
		System.out.println(Arrays.toString(arr1));

		
		

		// flatmap examples
		List<List<Integer>> list1 = List.of(List.of(1, 2, 3), List.of(4, 5, 6));

		System.out.println(list1.stream().flatMap(List::stream).toList());

		List<String> words = Arrays.asList("Hello world", "Java 8", "Streams API");
		System.out.println(words.stream().flatMap(x -> Arrays.stream(x.split(" "))).toList());

	}

	private static void reverseArray(int[] arr, int start, int end) {

		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

	}

	private static void reverse(List<Integer> ls1, int start, int end) {

		while (start < end) {
			int temp = ls1.get(start); // temp = a; a=b; b=temp;
			ls1.set(start, ls1.get(end));
			ls1.set(end, temp);

			start++;
			end--;

		}

	}

}
