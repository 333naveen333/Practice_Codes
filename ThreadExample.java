package JavaEight;

public class ThreadExample {
	public  static void main(String[] args) {
	// TODO Auto-generated method stub
	//Some s = new Some();
		Runnable r = () -> System.out.println("hello");// without using sep impl class for runnable
	Thread thread = new Thread(r);
	thread.start();
	try {
		thread.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	
	
	//thread.start();
}

//class Some implements Runnable{
//	
//	@Override
//	public void run() {
//		System.out.println("hello");
//	}
//}

