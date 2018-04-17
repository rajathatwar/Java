package com.home.practice.exercice2;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] argh) {
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			int phone = in.nextInt();
			// Write code here
			myMap.put(name, phone);
			myMap.values();
		}

		while (in.hasNext()) {
			String s = in.next();
			// Write code here
			if(myMap.containsKey(s)) {
				System.out.println(myMap.get(s));
			}
			else
			{
				System.out.println("Not found");
			}
			
		}
		in.close();
	}
}
