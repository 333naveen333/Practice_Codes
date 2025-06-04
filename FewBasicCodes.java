package JavaEight;

public class FewBasicCodes {
	
	public static void main(String[] args) {
		
		String input = "ehijhe";
		System.out.println(isPalindrome(input));
	}

	private static boolean isPalindrome(String input) {
		return input.equals(new StringBuilder(input).reverse().toString()) ? true:false;
	}

}
