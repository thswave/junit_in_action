package com.changwon.junit.ch2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class ParameterizedTest {
	
	private double expected;
	private double valueOne;
	private double valueTwo;
	
	@Parameters
	public static Collection<Integer[]> getTestParameters(){
		return Arrays.asList(new Integer[][]{
			{2, 1, 1},
			{3, 2, 1},
			{4, 3, 1}
		});
	}

	
	public ParameterizedTest(double expected, double valueOne, double valueTwo){
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}
	
	@Test
	public void testSum(){
		Calculator calculator = new Calculator();
		assertEquals(expected, calculator.add(valueOne, valueTwo), 0);
	}
}
