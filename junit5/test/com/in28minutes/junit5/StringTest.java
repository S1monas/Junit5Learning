package com.in28minutes.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
	@RepeatedTest(5) //test runs 5 times. New feature in Junit5
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
	@DisplayName("When string is null, throw an exception")
	void lenght_exception() { //In Junit5 does not need to be public
		String str = "NotNull";
		assertThrows(NullPointerException.class,
				() -> {
					//code that throws exception
					str.length();
				}
				
				);

	}
	
	@Test
	void length_greater_than_zero() {
		assertTrue("ABCD".length()>0);
		assertTrue("D".length()>0);
		assertTrue("FHD".length()>0);	
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"ABCD","ABC","A"})
	void length_greater_than_zero_parameterized_test(String str) {
		assertTrue(str.length()>0);
		assertTrue(str.length()>0);
		assertTrue(str.length()>0);
	}
	
	@ParameterizedTest
	@DisplayName("CVS test")
	@CsvSource(value= {"abcd, ABCD", "abc, ABC","'',''", "klm, KLM"})
	void uppercase(String word, String capitalizedWord) {
		assertEquals(capitalizedWord, word.toUpperCase());
	}
	
	@ParameterizedTest(name = "{0} length is {1}") // names can be added here (for clarity)
	@DisplayName("CVS test for lenght")
	@CsvSource(value= {"abcd, 4", "abc, 3","'', 15", "klm, 3"})
	void length(String word, int expectedLength) {
		assertEquals(expectedLength, word.length());
	}
	
}
 