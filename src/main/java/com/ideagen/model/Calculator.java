package com.ideagen.model;

import java.util.ArrayList;
import java.util.List;

import com.ideagen.exception.FormatNotSupportException;
import com.ideagen.exception.SymbolNotFoundException;
import com.ideagen.operator.Operator;

/**
 * This is abstract class main for math equation calculation. If extend this
 * class, developer need to define what are the valid operators and what are the
 * operation class defined
 * 
 * @author Michael Chan
 *
 */
public abstract class Calculator {
	private List<String> valueList = new ArrayList<String>();
	public static String subOperationOpen = "(";
	public static String subOperatonClose = ")";

	/**
	 * 
	 * @return The valid operation sign. For example '+', '-', '*', '/'
	 */
	protected String[] getAcceptOperator() {
		return null;
	}

	/**
	 * The method to add the attribute from the equation to the array. For
	 * example if the equation is 1 + 1, then the array will contain [1, '+', 1]
	 * 
	 * @param val
	 *            Attribute to be added in the array
	 */
	public void addValue(String val) {
		valueList.add(val);
	}

	/**
	 * Print the attributes values from the list
	 */
	public void printListValue() {
		for (String str : valueList) {
			System.out.println(str);
		}
	}

	/**
	 * Method to check if it is a valid operator sign
	 * 
	 * @param val
	 * @return
	 */
	private boolean isOperator(String val) {
		for (String str : getAcceptOperator()) {
			if (str.equalsIgnoreCase(val))
				return true;
		}

		return false;
	}

	/**
	 * Method to return the correct Operation class that based on the operator
	 * sign
	 * 
	 * @param str The operator sign
	 * @return The Operator object
	 */
	protected Operator getOperator(String str) {
		return null;
	}

	/**
	 * Method to calculate the values from the equation
	 * @return
	 * @throws Exception
	 */
	public Double calculateValue() throws Exception {
		Double total = null;
		Operator op = null;
		Double d = null;
		for (String str : valueList) {
			if (isOperator(str)) {
				op = getOperator(str);
			} else {
				try {
					d = new Double(str);
				} catch (NumberFormatException e) {
					throw new Exception(new SymbolNotFoundException(str));
				}
				if (total == null && op == null)
					total = d;
				if (op != null) {
					try {
						total = op.calculate(total, d);
					} catch (Exception e) {
						throw new Exception(new FormatNotSupportException());
					}
				}
			}
		}
		return total;
	}

}
