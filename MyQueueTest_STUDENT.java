/*
 * Class: CMSC204 
 * Instructor:Farnaz Eivazi
 * Description: Test cases for the queue class
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

class MyQueueTest_STUDENT {
	MyQueue<String> test1;

	@BeforeEach
	void setUp() throws Exception {
		test1 = new MyQueue<>(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = null;
	}

	@Test
	void testEnqueue() {
		assertTrue(test1.enqueue("glory"));
		test1.enqueue("spart");
		test1.enqueue("sin");
		test1.enqueue("store");
		test1.enqueue("h");
		assertThrows(QueueOverflowException.class, () -> test1.enqueue("should fail"));
	}

	@Test
	void testDequeue() {
		assertThrows(QueueUnderflowException.class, () -> test1.dequeue());
		test1.enqueue("angel");
		test1.enqueue("thum");
		test1.enqueue("laund");
		assertTrue(test1.dequeue().equals("angel"));
	}

	@Test
	void testIsFull() {
		test1.enqueue("spart");
		test1.enqueue("sin");
		test1.enqueue("store");
		test1.enqueue("h");
		test1.enqueue("gas");
		assertTrue(test1.isFull());
	}

	@Test
	void testIsEmpty() {
		assertTrue(test1.isEmpty());
		test1.enqueue("athen");
		test1.enqueue("lord");
		assertFalse(test1.isEmpty());
	}

	@Test
	void testSize() {
		test1.enqueue("doll");
		test1.enqueue("car");
		test1.enqueue("tower");
		test1.dequeue();

		assertEquals(test1.size(), 2);
	}

	@Test
	void testToString() {
		test1.enqueue("mone");
		test1.enqueue("caoo");
		test1.enqueue("teee");

		String StringFormat = "monecaooteee";

		assertTrue(test1.toString().equals(StringFormat));
	}

	@Test
	void testToStringDelimeter() {
		test1.enqueue("pi");
		test1.enqueue("math");
		test1.enqueue("num");
		test1.enqueue("dig");
		test1.enqueue("letter");
		String StringFormat = "pi^math^num^dig^letter^";

		assertTrue(test1.toString("^").equals(StringFormat));
	}

	@Test
	void testFill() {
		ArrayList<String> value = new ArrayList<>();

		value.add("eye");

		value.add("cam");

		value.add("surg");

		value.add("care");

		value.add("not");

		test1.fill(value);

		String stackRep = "eyecamsurgcarenot";

		assertTrue(test1.toString().equals(stackRep));

		ArrayList<String> newValues = new ArrayList<>();

		newValues.add("clutch");

		newValues.add("bus");

		newValues.add("skurt");

		newValues.add("frown");

		newValues.add("face");

		MyQueue<String> test2 = new MyQueue<>(3);

		assertThrows(QueueOverflowException.class, () -> test2.fill(newValues));
	}

}
