package com.practice.junit.test1;

/**
 * This class is having arithmetic operations to test in JUnit test cases.
 * 
 * @author 
 */
public class Arithmetic 
{
	public int add(int arg1, int arg2)
	{
		int result = 0;
		
		result = arg1 + arg2;
		
		return result;
	}
	
	public int multiply(int arg1, int arg2)
	{
		int result = 0;
		
		result = arg1 * arg2;
		
		return result;
	}
	
	public int subtract(int arg1, int arg2)
	{
		int result = 0;
		
		result = arg1 - arg2;
		
		return result;
	}
	
	public float devide(int arg1, int arg2)
	{
		float result = 0;
		
		result = arg1 / arg2;
		
		return result;
	}

}
