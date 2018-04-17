package com.home.practice.day1;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter a small no to find the table...");
		int n = in.nextInt();

		for (int i = 1; i <= 10; i++) {
			int result = n * i;
			System.out.println(n + " * " + i + " = " + result);
		}

		int j = 0;
		while (j < 5) {
			System.out.println("hahah.........");
			j++;
		}
	}
}
