package com.ideagen.operator;

/**
 * Act as '-' operator
 * 
 * @author Michael Chan
 *
 */
public class Minus implements Operator {

	@Override
	public Double calculate(Double valOri, Double valPassIn) {
		return valOri - valPassIn;
	}

}
