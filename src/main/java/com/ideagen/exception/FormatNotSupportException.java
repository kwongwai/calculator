package com.ideagen.exception;

/**
 * The exception class defined if there is wrong format of equation passed in. 
 * 
 * @author Michael Chan
 *
 */
public class FormatNotSupportException extends Exception {

	private static final long serialVersionUID = -5485317690255359035L;

	@Override
	public String getMessage() {
		return "Format not support, please make sure operator separate by space and numbers!";
	}

}
