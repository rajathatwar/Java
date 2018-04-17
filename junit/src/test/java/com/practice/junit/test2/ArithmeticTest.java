package com.practice.junit.test2;

import org.junit.Test;

import com.practice.junit.test2.Arithmetic;

import static org.junit.Assert.*;


/**
 * This class shows how to write JUnit test cases using annotations.
 * 
 * 
 *
 */
public class ArithmeticTest
{
	Arithmetic arith = new Arithmetic();
	int operand1 = 20;
	int operand2 = 10;
	 
	/**
	 * Test case for Arithmetic.add() method
	 */
	@Test
	public void testAdd()
	{
		System.out.println("testAdd() executed.");
		assertNotNull(arith);
		
		int result = arith.add(operand1, operand2);
		
		assertEquals(30, result);
	
	}
	
	@Test
	public void testMultiply()
	{
		System.out.println("testMultiply() executed.");
		assertNotNull(arith);
		
		int result = arith.multiply(operand1, operand2);
		
		assertEquals(200, result);
	}
	
	@Test
	public void testSubtract()
	{
		System.out.println("testSubtract() executed.");
		assertNotNull(arith);
		
		int result = arith.subtract(operand1, operand2);
		
		assertEquals(10, result);
	}
	
	@Test
	public void testDivide()
	{
		System.out.println("testdevide() executed.");
		assertNotNull(arith);
		
		float result = arith.devide(operand1, operand2);
		
		//assertEquals(2, result);
		assertEquals(2.0, result, 0.0);
	}

}
