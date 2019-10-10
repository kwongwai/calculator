package com.ideagen.model;

import com.ideagen.operator.Divide;
import com.ideagen.operator.Minus;
import com.ideagen.operator.Operator;
import com.ideagen.operator.Plus;
import com.ideagen.operator.Times;

/**
 * The class to extend the Calculator class as the simple calculator that having
 * the operator sign as '+','-','*','/' Developer might use this as an example
 * to implement complex calculator for example ScienCalculator that having the
 * operator sign like 'SIN','CON','MOD' ..
 * 
 * @author USER
 *
 */
public class SimpleCalculator extends Calculator {

	@Override
	protected String[] getAcceptOperator() {
		String[] acceptOperator = { "+", "-", "*", "/" };
		return acceptOperator;
	}

	@Override
	protected Operator getOperator(String str) {
		Operator op = null;
		if (str.equalsIgnoreCase("+"))
			op = new Plus();
		else if (str.equalsIgnoreCase("-"))
			op = new Minus();
		else if (str.equalsIgnoreCase("*"))
			op = new Times();
		else if (str.equalsIgnoreCase("/"))
			op = new Divide();
		return op;
	}
}
