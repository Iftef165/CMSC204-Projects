/*
 * Class: CMSC204 
 * Instructor:Farnaz Eivazi
 * Description: test cases for the stack class
 * Due: 2/28/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ifte Maksud
*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest_STUDENT {
	MyStack<String> test1;

	@BeforeEach
	void setUp() throws Exception {
		test1 = new MyStack<>(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = null;
	}

	@Test
	void testIsEmpty() {
		assertTrue(test1.isEmpty());
		
		test1.push("gecko");	
		
		test1.push("fil");
		
		assertFalse(test1.isEmpty());
		
	}
	
	@Test
	void testIsFull() {
		assertFalse(test1.isFull());
		
		test1.push("li");
		test1.push("fli");
		test1.push("isr");
		test1.push("ixcv");
		test1.push("ieoqp");
		
		assertTrue(test1.isFull());
	}
	
	@Test
	void testIsPush() {
		assertTrue(test1.push("test"));
		assertTrue(test1.push("tes2"));
		assertTrue(test1.push("tes3"));
		assertTrue(test1.push("test4"));
		assertTrue(test1.push("test5"));
		assertThrows(StackOverflowException.class, () -> test1.push("should fail"));		
	
	}
	
	@Test
	void testPop() {
		
		assertThrows(StackUnderflowException.class, () -> test1.pop());		
		
		test1.push("kascn");
		test1.push("kvxzcn");
		test1.push("01cg");
		
		assertEquals(test1.pop(),"01cg");

	}
	
	@Test
	void testTop() {
		
		assertThrows(StackUnderflowException.class, () -> test1.top());		
		
		test1.push("gift");
		test1.push("toy");
		
		assertEquals(test1.top(),"toy");
	}
	
	@Test
	void testSize() {
		
		assertEquals(test1.size(),0);
		
		test1.push("shell");
		test1.push("bell");
		
		assertEquals(test1.size(),2);
	}
	
	@Test
	void testToString() {
		
		test1.push("glass");
		test1.push("wine");
		test1.push("pip");
		test1.push("sound");
		
		String stackFormat = "glasswinepipsound";
		
		assertTrue(test1.toString().equals(stackFormat));
	}
	
	@Test
	void testToStringDelimiter() {
		test1.push("glass");
		test1.push("wine");
		test1.push("pip");
		test1.push("sound");
		test1.push("poof");

		
		String stackFormat = "glass*wine*pip*sound*poof*";
		
		assertTrue(test1.toString("*").equals(stackFormat));
	}
	
	@Test
	void testFill() {
		ArrayList<String> value = new ArrayList<>();
		
		value.add("laser");
		
		value.add("face");
		
		value.add("kang");
		
		value.add("tiger");
		
		value.add("clown");
		
		test1.fill(value);
		
		String stackRep = "laserfacekangtigerclown";
		
		assertTrue(test1.toString().equals(stackRep));
		
		ArrayList<String> newValues = new ArrayList<>();
		
		
		
		newValues.add("stich");
		
		newValues.add("81923");
		
		newValues.add("bair");
		
		newValues.add("crown");
		
		newValues.add("fun");
		
		
				
		MyStack<String> test2 = new MyStack<>(2);
		
		assertThrows(StackOverflowException.class, () -> test2.fill(newValues));		

	}

}
