package com.test.ideagen;

import org.junit.Test;

import com.ideagen.Calculate;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
/**
 * Unit test for simple App.
 */
public class AppTest {
	DecimalFormat f = new DecimalFormat("##.00");
	
	@Test
	public void testSimpleCalculation() {
		try {
			assertTrue(f.format(Calculate.calculate("1 + 2 + 3")).equals("6.00"));
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	public void testBracketCalculation(){
		try {
			assertTrue(f.format(Calculate.calculate("23 - ( 29.3 - 12.5 )")).equals("6.20"));
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	public void testWrongFormatCalculation(){
		boolean error = false;
		try {
			Calculate.calculate("1+ 2 + 3");
		} catch (Exception e) {
			error = true;
		}
		assertTrue(error);
			
	}
}
