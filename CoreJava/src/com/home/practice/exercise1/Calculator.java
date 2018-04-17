package com.home.practice.exercise1;

public class Calculator {

	public double add(int a, int b) {
		double result = a + b;
		return result;
	}

	public double sub(double a, double b) {
		double result = a - b;
		return result;
	}

	public double multiply(double a, double b) {
		double result = a * b;
		return result;
	}

	public double div(double a, double b) {
		double result = a / b;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new Calculator();
		double result1;
		result1 = cal.add(2, 3);
		System.out.println("Addition of two number is: " + result1);
		result1 = cal.sub(2, 3);
		System.out.println("Substraction of two number is: " + result1);
		result1 = cal.multiply(2, 3);
		System.out.println("Multiplication of two number is: " + result1);
		result1 = cal.div(2, 3);
		System.out.println("Division of two number is: " + result1);

	}

}
