package com.ideagen.operator;

/**
 * The interface to define the operator sign like '+','-' and so on
 * 
 * @author Michael Chan
 *
 */
public interface Operator {

	/**
	 * Method to calculate the value by the sign operator
	 * 
	 * @param valOri
	 * @param valPassIn
	 * @return
	 */
	public Double calculate(Double valOri, Double valPassIn);

}
