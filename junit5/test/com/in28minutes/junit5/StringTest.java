package com.in28minutes.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {
	
	@BeforeAll
	static void beforeAll() { //must be static
		System.out.println("Connect to DB");
	}
	
	@AfterAll
	static void afterAll() { //must be static
		System.out.println("Close Connection to DB");
	}
	
	@BeforeEach //@Before ( in Junit4)
	void beforeEachTest(TestInfo info) { // (only Junit5 feature (TestInfo info)
		System.out.println("Print this before each test named " + info.getDisplayName());
	}
	
	@AfterEach //@After ( in Junit4)
	void AfterEachTest() {
		System.out.println("Clean up Test Data after it");
	}
	
	

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
	
	@Test //same as before, but inline
	void contains_basic_inline() {
		assertTrue("abcdefgh".contains("cd"));
	}

	@Test
	void split_basic() {
		String str = "abc def ghi";
		String actualResult[] = str.split(" ");
		String[] expectedResult = new String[] {"abc", "def", "ghi"};
		
		assertArrayEquals(expectedResult,actualResult);	
	}
	
	@Test
	void lenght_exception() {
		String str = "NotNull";
		assertThrows(NullPointerException.class,
				() -> {
					//code that throws exception
					str.length();
				}
				
				);

	}
}
 