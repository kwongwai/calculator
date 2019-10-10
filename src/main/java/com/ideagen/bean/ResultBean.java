package com.ideagen.bean;

import java.io.Serializable;

/**
 * A class to store the result from the calculation and return to the frontend
 * as Json
 * 
 * @author Michael Chan
 *
 */
public class ResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5552167160969747244L;

	private String result;

	private String status;

	private String message;

	/**
	 * 
	 * @return Result value from the calculation
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Set the result from the calculation
	 * 
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 
	 * @return The status from the calculation
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status from the calcuation Status will be 'Success' and 'Fail'
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The message from the calculation
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the message for the calculation
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
