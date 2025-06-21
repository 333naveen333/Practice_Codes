package codes_new;

public class PrintCharsAndLettersUsingThreads
{
	
	static boolean isPrintLetter ;//= true;
	 static Object lock = new Object();
	
 Runnable numberPrint = () ->{
		
		synchronized(lock) {
			for(int i=1;i<=26; i++) {
				if(isPrintLetter) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.print(i +" ");
				lock.notify();
				isPrintLetter = true;
			}
			
			
		}
}	
		
	;
	
	 Runnable letterPrint = () ->{
		
		synchronized(lock) {
		for(char i='A';i<='Z'; i++) {
			if(!isPrintLetter) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.print(i +" ");
			lock.notify();
			isPrintLetter = false;
		}
		
		
	}
	}
	
	
;
	
public  static void main(String[] args) {
	// TODO Auto-generated method stub

	PrintCharsAndLettersUsingThreads pr = new PrintCharsAndLettersUsingThreads();
	// or make these 2 methods static for without object
	 Thread t1 = new Thread(pr.letterPrint);
	 Thread t2 = new Thread(pr.numberPrint);
	 t1.start();
	 t2.start();
	 
	 try {
		 t1.join();
		 t2.join();
	 }catch(Exception e) {
		 System.out.println(e);
	 }
	 
	
	

	
	
	

}
}



