package com.changwon.junit.ch3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

public class HamcrestTest {
	
	private List<String> values;
	
	@Before
	public void setUpList(){
		values = new ArrayList<String>();
		values.add("x");
		values.add("y");
		values.add("z");
	}
	
	
}
