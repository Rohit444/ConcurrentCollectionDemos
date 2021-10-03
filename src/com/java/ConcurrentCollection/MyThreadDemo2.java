package com.java.ConcurrentCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// In this program we will get concurrent modification exception if we use normal ArrayList.
// Because while one thread  is iterating the list other thread (Child thread)is doing modification on the same List
// If we replace Normal ArrayList with CopyOnWriteArrayList (a concurrent collection) then we will never get this exception again.

public class MyThreadDemo2 {
	
    static List<String> l = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {

		l.add("A");
		l.add("B");
		l.add("C");
		DemoChildThread mythread = new DemoChildThread(l);
		mythread.start(); 
		 Iterator<String> itr = l.iterator();
         while(itr.hasNext()) {
      	   String s = (String) itr.next();
      	   System.out.println("Main method is iterating the list and current Objet is "+s);
      	   Thread.sleep(2000);
      	   
      	   System.out.println(s);
         }
	}

}

class DemoChildThread extends Thread{
	
	List<String> l = new ArrayList<>();
	DemoChildThread(List<String> l){
		this.l = l;
	}
	
	public void run() {
		
		System.out.println("executing chiled thread ..... ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Child thread is modifying ArrayList");
		l.add("D");
	}
}