package com.home.practice.exercice2;

import java.util.Scanner;

public class Factorial {
	static int factorial(int n) {
		// Complete this function
		if (n > 0) {
			return (n * factorial(n - 1));
		}else
		{
			return 1;
		}
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int result = factorial(n);
		System.out.println(result);
	}
}
