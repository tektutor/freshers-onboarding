package org.tektutor;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestRPNCalcutor {
	
	private RPNCalculator rpnCalculator;
	private double actualResult, expectedResult;
	
	@AfterClass
	public static void tearDown() {
		System.out.println("After Class method");
	}
	
	@BeforeClass
	public static void initOnce() {
		System.out.println("Before Class method");
	}
	
	@Before
	public void init() {
		rpnCalculator = new RPNCalculator();
		actualResult = expectedResult = 0.0;
		System.out.println("Before method");
	}
	
	@After
	public void cleanUp() {
		rpnCalculator = null;
		System.out.println("After method");
	}
	

	
	@Test
	public void testSimpleAddition() {
		System.out.println("Test addition");
		actualResult   = rpnCalculator.evaluate ( "10 15 +" );
		expectedResult = 25.0;
		assertEquals ( expectedResult, actualResult, 0.0001 );
		
		actualResult   = rpnCalculator.evaluate ( "10 115 +" );
		expectedResult = 125.0;
		assertEquals ( expectedResult, actualResult, 0.0001 );
		
	}

	@Category(SmokeTest.class)
	@Test
	public void testSimpleSubtraction() {
		System.out.println("Test subtraction");

		actualResult   = rpnCalculator.evaluate ( "100 15 -" );
		expectedResult = 85.0;
		assertEquals ( expectedResult, actualResult, 0.0001 );
		
		actualResult   = rpnCalculator.evaluate ( "10 5 -" );
		expectedResult = 5.0;
		assertEquals ( expectedResult, actualResult, 0.0001 );
		
	}	

	@Test
	public void testSimpleMultiplication() {
		System.out.println("Test multiplication");

		actualResult   = rpnCalculator.evaluate ( "100 15 *" );
		expectedResult = 1500.0;
		assertEquals ( expectedResult, actualResult, 0.0001 );
		
		actualResult   = rpnCalculator.evaluate ( "10 5 *" );
		expectedResult = 50.0;
		assertEquals ( expectedResult, actualResult, 0.0001 );
		
	}	
	
	@Test
	public void testSimpleDivision() {
		System.out.println("Test division");

		actualResult   = rpnCalculator.evaluate ( "100 10 /" );
		expectedResult = 10.0;
		assertEquals ( expectedResult, actualResult, 0.0001 );
		
		actualResult   = rpnCalculator.evaluate ( "10 5 /" );
		expectedResult = 2.0;
		assertEquals ( expectedResult, actualResult, 0.0001 );
		
	}	

	@Test
	public void testComplexRPNMathExpression() {
		System.out.println("Test complex expression");

		actualResult   = rpnCalculator.evaluate ( "10 10 + 100 20 / *" );
		expectedResult = 100.0;
		assertEquals ( expectedResult, actualResult, 0.0001 );
		
	}	

}
