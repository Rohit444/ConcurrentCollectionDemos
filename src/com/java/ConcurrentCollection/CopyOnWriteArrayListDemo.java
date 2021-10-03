package com.java.ConcurrentCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
	
	static CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {

		l.add("A");
		l.add("B");
		l.add("C");
		ChildThread mythread = new ChildThread(l);
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

class ChildThread extends Thread{
	
	List<String> l = new ArrayList<>();
	ChildThread(List<String> l){
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