package com.github.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		//Un autre commentaire
		Calculator calc = new Calculator();
		assertEquals(4, calc.add(2, 2), 0);
	}

}
