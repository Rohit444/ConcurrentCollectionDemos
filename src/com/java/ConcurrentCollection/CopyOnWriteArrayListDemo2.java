package com.java.ConcurrentCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo2 {

	public static void main(String[] args) {
		
		List<String> l = new ArrayList<>();
		l.add("A");
		l.add("B");
		
		CopyOnWriteArrayList<String> l1 = new CopyOnWriteArrayList<String>();
		l1.add("A");
		l1.add("C");
		
		System.out.println(l1);
		
		l1.addAll(l);
		
		System.out.println(l1);
		
		List<String> l2 = new ArrayList<>();
		l2.add("A");
		l2.add("D");
		
		l1.addAllAbsent(l2);
		System.out.println(l1);
		
	}

}
