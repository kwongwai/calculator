package com.ideagen.bean;
import java.io.Serializable;

/**
 * A bean to accept the equation and send to server for calculation
 * 
 * @author Michael Chan
 *
 */
public class CalculateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2794556947477535343L;

	private String equation;

	/**
	 * 
	 * @return The equation value
	 */
	public String getEquation() {
		return equation;
	}

	/**
	 * Set the equation for calculation
	 * 
	 * @param equation
	 *            The equation that need to be performed
	 */
	public void setEquation(String equation) {
		this.equation = equation;
	}

}
