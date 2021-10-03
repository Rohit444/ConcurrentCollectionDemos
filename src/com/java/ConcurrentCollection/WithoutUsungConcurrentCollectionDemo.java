package com.java.ConcurrentCollection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class WithoutUsungConcurrentCollectionDemo extends Thread{

  static CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<>();
	
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Chiled thread is updating the list");
		l.add("D");
	}
	public static void main(String[] args) throws InterruptedException {
            l.add("A");
            l.add("B");
            l.add("C");
            WithoutUsungConcurrentCollectionDemo myThread = new WithoutUsungConcurrentCollectionDemo();
            myThread.start();
            
           Iterator<String> itr = l.iterator();
           while(itr.hasNext()) {
        	   String s = (String) itr.next();
        	   System.out.println("Main method is iterating the list and current Objet is "+s);
        	   Thread.sleep(2000);
        	   
        	   System.out.println(s);
           }
           
	}

}

class Mythread extends Thread{
	
	
	
	
}