package com.ideagen;

import java.text.DecimalFormat;

import com.ideagen.model.SimpleCalculator;

/**
 * A calculator class to perform the math equation calculation
 * 
 * @author Michael Chan
 *
 */
public class Calculate {

	/**
	 * Method to perfom math equation calculation
	 * @param num The math equation
	 * @return The result from the calculation
	 * @throws Exception
	 */
	public static double calculate(String num) throws Exception {
		String[] v = num.trim().split(" ");
		SimpleCalculator cal = new SimpleCalculator();
		SimpleCalculator calSub = new SimpleCalculator();
		boolean isOpenOperator = false;
		boolean isCloseOperator = false;
		for (String str : v) {
			if (str.equalsIgnoreCase(SimpleCalculator.subOperationOpen)) {
				isOpenOperator = true;
				continue;
			}
			if (str.equalsIgnoreCase(SimpleCalculator.subOperatonClose)) {
				isCloseOperator = true;
				cal.addValue(calSub.calculateValue() + "");
				calSub = new SimpleCalculator();
				isCloseOperator = false;
				isOpenOperator = false;
				continue;
			}
			if (isOpenOperator) {
				calSub.addValue(str);
			}

			if (!isCloseOperator && !isOpenOperator)
				cal.addValue(str);

		}
		cal.printListValue();
		return cal.calculateValue();
	}
	
	
}
