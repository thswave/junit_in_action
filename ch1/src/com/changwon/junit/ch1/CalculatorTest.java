package com.changwon.junit.ch1;

public class CalculatorTest {

	private int numberErrors = 0;

	public void testAdd() {
		Calculator calculator = new Calculator();
		double result = calculator.add(10, 50);
		if (result != 60) {
			throw new IllegalStateException("Bad result:" + result);
		}

	}

	public static void main(String[] args) {
		CalculatorTest test = new CalculatorTest();
		try {
			test.testAdd();
		} catch (Throwable e) {
			test.numberErrors++;
			e.printStackTrace();
		}
		if (test.numberErrors > 0) {
			throw new IllegalStateException("There were " + test.numberErrors
					+ " error(s)");
		}

	}
}
