package codes_new;

public class OverideTesting implements someInterface{

	//without ovveride annotation also works
	// this will work incase of interface but with classes it wont see AnotherOverrideTesting class
	public void getCall() {
		// TODO Auto-generated method stub
		System.out.println("something");
		
	}

	public static void main(String[] args) {
		OverideTesting ot = new OverideTesting();
		ot.getCall();

	}
	
	
}



 interface someInterface {
	
	void getCall();
}
