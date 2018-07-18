package com.in28minutes.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void length_basic() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		assertEquals(expectedLength,actualLength);
	}
	
	@Test
	void toUpperCase_basic() {
		String str ="abcd";
		String result = str.toUpperCase();
		assertEquals("ABCD", result);
		//assertNotNull(result);
	}
	
	@Test
	void contains_basic() {
		String str = "abcdefgh";
		boolean result = str.contains("cd");
		//assertEquals(true, result);
		assertTrue(result);
	}


}
 