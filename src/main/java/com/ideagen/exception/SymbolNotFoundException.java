package com.ideagen.exception;

/**
 * The class to define if the operation is not found in the class. For example
 * Plus, Minus, Divide or Times
 * 
 * @author Michael Chan
 *
 */
public class SymbolNotFoundException extends Exception {

	private static final long serialVersionUID = 2222722180677706646L;
	private String val;

	public SymbolNotFoundException(String val) {
		this.val = val;
	}

	@Override
	public String getMessage() {
		return "Operator symbol '" + val + "' is not defined by the system!";
	}

}
