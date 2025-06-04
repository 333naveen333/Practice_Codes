package JavaEight;

import javax.tools.Diagnostic;

public class DiamondProblem implements A , B {
	
	//@Override
	public void run() {
		System.out.println(" jahj");
	}

	public static void main(String[] args) {
		DiamondProblem dp = new DiamondProblem();
		
		dp.run();
	}
}
// if u do extend A , B - > diamond problem -> u will get suntax error


//class A{
//	void run() {
//		System.out.println("running A");
//	}
//	
//}
//
//
//class B{
//	void run() {
//		System.out.println("running B");
//	}
//	
//}

interface A{
	
	static void run() {
		System.out.println("running A");
	}
}

interface B{
	
	static void run() {
		System.out.println("running B");
	}
}