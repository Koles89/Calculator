package com.octodemo.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
//TEST 3
	@Test
	public void testAdd() {
		//Un autre commentaire
		Calculator calc = new Calculator();
		assertEquals(4, calc.add(2, 2), 0);
	}

	@Test
	public void testDiv() {
		Calculator calc = new Calculator();
		assertEquals(1, calc.div(2, 2), 0);
	}



}
