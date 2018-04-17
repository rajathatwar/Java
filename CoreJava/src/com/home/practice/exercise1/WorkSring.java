package com.home.practice.exercise1;

import java.util.Scanner;

public class WorkSring {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.next();

		}

		for (int i = 0; i < arr.length; i++) {			for (int j = 0; j < arr[i].length(); j++) {
				if (j % 2 == 0) {
					System.out.print(arr[i].charAt(j));
				}
			}
			System.out.print(" ");
			for (int j = 0; j < arr[i].length(); j++) {
				if (j % 2 != 0) {
					System.out.print(arr[i].charAt(j));
				}
			}

			System.out.println();
		}
	}
}
