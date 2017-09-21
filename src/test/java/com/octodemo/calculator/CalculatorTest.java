package com.octodemo.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testAdd() {
		//This is the most complex operation for AXA TECH
		Calculator calc = new Calculator();
		assertEquals(4, calc.add(2, 2), 0);
	}

	@Test
	public void testDiv() {
		Calculator calc = new Calculator();
		assertEquals(1, calc.div(2, 2), 0);
	}
	
	@Test
	public void testSub() {
		Calculator calc = new Calculator();
		// 2 = 4 - 2 ??? 
		assertEquals(2, calc.sub(4, 2), 0);
	}



}
