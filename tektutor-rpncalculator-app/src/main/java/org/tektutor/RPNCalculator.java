package org.tektutor;

import java.util.Stack;

public class RPNCalculator {

	private Stack<Double> numberStack;
	private double firstNumber,secondNumber, result;
	
	public RPNCalculator() {
		numberStack = new Stack<Double>();
		firstNumber = secondNumber = result = 0.0;
	}
	
	public double evaluate(String rpnMathExpression) {
		String[] rpnTokens = rpnMathExpression.split(" ");
		
		IMathOperation mathOperation = null;
		
		for ( String token : rpnTokens ) {
			
			if ( isMathOperator( token ) ) {
				extractInputs();
				mathOperation = MathFactory.getObject( token );
				result = mathOperation.evaluate ( firstNumber, secondNumber );
				numberStack.push( result );
			}
			else
				numberStack.push( Double.parseDouble(token) );
		}
		
		return numberStack.pop();
	}

	private boolean isMathOperator(String token) {
		String mathOperators = "+-*/";
		return mathOperators.contains(token);
	}

	private void extractInputs() {
		secondNumber = numberStack.pop();
		firstNumber = numberStack.pop();
	}

}