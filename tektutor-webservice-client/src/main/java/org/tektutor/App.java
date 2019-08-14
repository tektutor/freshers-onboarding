package org.tektutor;

import org.tempuri.*;

public class App {

	public static void main(String[] args) {
		
		System.setProperty( "java.net.useSystemProxies","true" );

		Calculator calculator = new Calculator();
		CalculatorSoap service = calculator.getCalculatorSoap();
		
		int x = 100;
		int y = 200;
		int result = service.add(x, y);
		
		System.out.println("The sum of " + x + " and " + y + " is " + result);
			
	}

}