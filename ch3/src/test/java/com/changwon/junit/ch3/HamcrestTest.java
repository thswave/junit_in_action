package com.changwon.junit.ch3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HamcrestTest {
	
	private List<String> values;
	
	@Before
	public void setUpList(){
		values = new ArrayList<String>();
		values.add("x");
		values.add("y");
		values.add("z");
	}
	
	@Test
	public void testWithtoutHamcrest(){
		assertFalse(values.contains("one"));
	}
	
}
