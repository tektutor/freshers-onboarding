package org.tektutor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {
	private SavingsAccount account;
	private SavingsAccount accountSpy;
	
	@Before
	public void setUp() {
		account = new SavingsAccount();

		//Partial mocking or spying
		accountSpy = spy ( account );
	}
	
	@After
	public void tearDown() {
		account = null;
		accountSpy = null;
	}

	@Test
	public void testWithdrawWhenCurrentBalanceIs5000INR() 
			throws InsufficientBalanceException {

		//Stubbing - hard coding the response of getBalance method
		doReturn ( 5000.00).when ( accountSpy ).getBalance();
		//Stubbing - hard coding the response of updateBalanceIntoDB method
		doNothing().when( accountSpy ).updateBalanceIntoDB( anyDouble() );
		
		//Code Under Test i.e we are testing withdraw method
		double updatedBalance = accountSpy.withdraw ( 1000.00 );
		double expectedBalance = 4000.00;
		
		assertEquals ( expectedBalance, updatedBalance, 0.0001 );
		
		//Check if getBalance method was invoked exactly 1 time within withdraw method
		verify( accountSpy, times(1) ).getBalance();
		//Check if updateBalanceIntoDB method was invoked exactly once within withdraw
		verify( accountSpy, times(1) ).updateBalanceIntoDB( anyDouble() );
		
	}

	@Test
	public void testWithdrawWhenCurrentBalanceIsInsufficient() {
		boolean exceptionThrown = false;
		
		//Stubbing - hard coding the response of getBalance method
		doReturn ( 500.00).when ( accountSpy ).getBalance();
		//Stubbing - hard coding the response of updateBalanceIntoDB method
		doNothing().when( accountSpy ).updateBalanceIntoDB( anyDouble() );
		
		//Code Under Test i.e we are testing withdraw method
		try {
			accountSpy.withdraw ( 10000.00 );
		}
		catch (InsufficientBalanceException e) {
			exceptionThrown = true;
		}
		
		boolean expectedResponse = true;
		//We are expecting InsufficientBalanceException thrown here if not
		//the test case result will be marked as failed.
		assertEquals ( expectedResponse, exceptionThrown );
		
		//Check if getBalance method was invoked exactly 1 time within withdraw method
		verify( accountSpy, times(1) ).getBalance();
		//Check if updateBalanceIntoDB method was never invoked within withdraw
		verify( accountSpy, times(0) ).updateBalanceIntoDB( anyDouble() );
	}

}
