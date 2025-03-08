/*
 * Class: CMSC204 
 * Instructor:Farnaz Eivazi
 * Description: testcases for the notation class
 * Due: 2/28/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ifte Maksud
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationTest_STUDENT {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvertInfixToPostfix() {
		assertTrue(Notation.convertInfixToPostfix("(3*4)+5").equals("34*5+"));
		assertTrue(Notation.convertInfixToPostfix("3+4*8^1").equals("3481^*+"));
		
		assertTrue(Notation.convertInfixToPostfix("3+9+1-0").equals("39+1+0-"));
		
		assertThrows(InvalidNotationFormatException.class, () -> Notation.convertInfixToPostfix("6+1*5)"));		
		
		//come back to this and test the exceptions
	}
	
	@Test
	void testConvertPostfixToInfix() {
		//come back to this and test the exceptions
		
		assertTrue(Notation.convertPostfixToInfix("34+8*9").equals("((3+4)*8)9"));
		assertTrue(Notation.convertPostfixToInfix("67+3*2-1").equals("(((6+7)*3)-2)1"));
		assertThrows(InvalidNotationFormatException.class, () -> Notation.convertPostfixToInfix("15+9-*"));		
		assertThrows(InvalidNotationFormatException.class, () -> Notation.convertPostfixToInfix("15+9-74"));		
	}
	
	
	@Test
	void testEvaluatePostfixExpression() {
		assertTrue(Notation.evaluatePostfixExpression("354+*2+") == 29.0);
		assertTrue(Notation.evaluatePostfixExpression("910^5-+") == 5.0);
		assertThrows(InvalidNotationFormatException.class, () -> Notation.evaluatePostfixExpression("9+9-"));	
		assertThrows(InvalidNotationFormatException.class, () -> Notation.evaluatePostfixExpression("48+3"));		




	}

}
