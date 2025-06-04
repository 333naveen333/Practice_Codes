package JavaEight;

import java.util.*;

public class ProducerConsumerThreads {
	// check in google as well for quick recap
	
	public static void main(String[] args) {
		
		
		Thread t1 = new Thread( new Runnable()
		{
			 @Override
	           public void run() {
	            
				
				 Resource cc = new Resource();
				 cc.produce();
			}
		});
	
	
	Thread t2 = new Thread ( new Runnable () {
		
		 @Override
         public void run()
         {
			 Resource cc = new Resource();
			 cc.consume();
         }
            
	}
		);

t1.start();
t2.start();

try {
	t1.join();
	t2.join();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
	
}
}
	
	class Resource{
		
		List<Integer> list = new ArrayList<>();
		int a=1;
		int capacity = 3;
		void produce() {
			
			while(true) {
			synchronized(list) {
				
				
				if(list.size()==capacity) {
					System.out.println("list is full ");
					try {
						list.notify();
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("adding "+ a);
				list.add(a);
				a++;
				list.notify();
				
			}
			}
			
		}
		
		void consume() {
			while(true) {
			synchronized(list) {
				
				if(list.isEmpty()) {
					System.out.println("consumer is waiting");
				
					try {
						list.notify();
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("remvoing  "+ list.get(0));
				list.remove(list.get(0));
				list.notify();
			}
			}
			
		}
	}
	
	
	
	
//
//static class CustomClass {
//		static List<Integer> list =new ArrayList<>();
//		static int capacity = 3;
//		static int a=1;
//		
//		public static void produce() {
//			
//			synchronized(list) {
//				
//				if(list.size()==capacity) {
//					
//					try {
//						System.out.println("waiting prodcuer");
//						list.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					
//					}
//					
//				System.out.println("adding " +a);
//				list.add(a);
//				a++;
//				list.notify();
//			
//				
//			}
//				
//			}
//		
//			
//			public static void consume() {
//				
//				synchronized(list) {
//					
//					if(!list.isEmpty()) {
//						System.out.println("remvoing 1");
//						list.remove(list.get(0));
//						list.notify();
//						
//						}
//						
//					
//				
//					try {
//						System.out.println("waitin consumer");
//						list.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//			}
//			}
//	}
//
//}
