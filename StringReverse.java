package Codes;

public class StringReverse {
	 public static void main(String[] args) 
	    { 
		 String input = "Hi, Reverse this sentence ";
		 String output ="";
		 StringBuilder st = new StringBuilder();
	     for(int i=input.length()-1;i>=0;i--) {
	    	 output+=input.charAt(i);
	     }
	     System.out.println(output);
	     System.out.println(st.append(input).reverse());
	     
	     
	     int a=5, b=10;
	     a=a+b; //a=15 
	     b=a-b; //b=5
	     a=a-b;
	     
	     System.out.println(a);
	     System.out.println(b);
	     
	     String word = "mjhm";
	     int m=0;
	    for(char c : word.toCharArray()) {
	    	if(c=='a' || c=='e' || c=='i'|| c=='o'|| c=='u') {
	    		
	    		}else {
	    	m+=1;
	    		}
	    }
	    if(m==word.length()) {
	    	System.out.println("not");
	    }else {
	    	System.out.println("vowel");
	    }
	    }
}
