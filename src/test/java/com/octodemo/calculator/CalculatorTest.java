package com.github.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		assertEquals(4, calc.add(2, 2), 0);
	}
	
	@Test
	public void testSub() {
		Calculator calc = new Calculator();
		assertEquals(4, calc.sub(6, 2), 0);
	}

}
