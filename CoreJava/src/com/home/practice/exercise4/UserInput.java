package com.home.practice.exercise4;

import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		System.out.println("Taking input with help of Scanner");

		Scanner in = new Scanner(System.in);
		System.out.println("Enter a no For which you want table: ");
		int data = in.nextInt();
		for (int i = 1; i <= 10; i++) {
			int result = (data * i);
			System.out.println(data + " * " + i + " = " + result);
		}
		in.close();
	}
}
