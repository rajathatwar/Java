package com.home.practice.exercise5;

public class CommandLineArgumentForMultiplicationTable {

	public static void main(String[] args) {

		for (int i = 1; i <= Integer.parseInt(args[1]); i++) {
			int result = (Integer.parseInt(args[0]) * i);
			System.out.println(args[0] + " * " + i + " = " + result);
		}

	}

}
