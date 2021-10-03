package com.java.ConcurrentCollection;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo extends Thread {

   static  ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
   
   public void run() {
	   try {
		System.out.println("Child Thread is executing ......");
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	   System.out.println("Child Thread is Modifying HashMap");
	   map.put(4, "Rohit");
  }
    
	public static void main(String[] args) throws InterruptedException {

		map.put(1, "Mayank");
		map.put(2, "Sumit");
		map.put(3, "Sameer");

		ConcurrentHashMapDemo mytherad = new ConcurrentHashMapDemo();
		mytherad.start();

		// Set<Integer> s = map.keySet();
		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
		// Iterator<Integer> itr = s.iterator();
		while (itr.hasNext()) {
			Entry<Integer, String> entry = itr.next();
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			Thread.sleep(2000);

			System.out.println(map);
		}

	}

}
