package com.practice.junit.test1;

import com.practice.junit.test1.Arithmetic;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This class shows how to write JUnit test cases.
 * 
 *
 */
public class ArithmeticTest extends TestCase
{
	Arithmetic arith = new Arithmetic();
	int operand1 = 20;
	int operand2 = 10;
	
	public ArithmeticTest(String method) {
		super(method);
	}
	 
	/**
	 * Test case for Arithmetic.add() method
	 */
	public void testAdd()
	{
		System.out.println("testAdd() executed.");
		assertNotNull(arith);
		
		int result = arith.add(operand1, operand2);
		
		assertEquals(30, result);
	
	}
	
	public void testMultiply()
	{
		System.out.println("testMultiply() executed.");
		assertNotNull(arith);
		
		int result = arith.multiply(operand1, operand2);
		
		assertEquals(200, result);
	}
	
	public void testSubtract()
	{
		System.out.println("testSubtract() executed.");
		assertNotNull(arith);
		
		int result = arith.subtract(operand1, operand2);
		
		assertEquals(10, result);
	}
	
	public void testDevide()
	{
		System.out.println("testdevide() executed.");
		assertNotNull(arith);
		
		float result = arith.devide(operand1, operand2);
		
		//assertEquals(2, result);
		assertEquals(2.0f, result);
	}

}
