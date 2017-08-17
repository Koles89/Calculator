package com.octodemo.calculator;

public class Calculator {

	// tag::addition[]
	public double add(double a, double b) {
	// Implementing some kickass code for a new pull request for RAC
		return (a+b);
	}
	// end::addition[]

	//This is the checkin implementation
	public double sub(double a, double b) {
		// This is the way it should be !!!!!
		return a-b;
	}


	public double multiply(double a, double b) {
		//Change alimentation!!!!
		return a*b;
	}

	// Division
	public double div(double a, double b) {
		return a/b;
	}



}
