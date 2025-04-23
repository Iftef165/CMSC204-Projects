import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterTest_STUDENT {
	MorseCodeConverter test1;

	@BeforeEach
	void setUp() throws Exception {
		test1 = new MorseCodeConverter();
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = null;
	}

	@Test
	void testConvertToEnglish() {
		assertEquals(MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."), "hello world");
		assertEquals(MorseCodeConverter.convertToEnglish(".... .."), "hi");
		assertEquals(MorseCodeConverter.convertToEnglish("-- --- .-. ... ."), "morse");

		assertEquals(MorseCodeConverter.convertToEnglish("- .... .. ... / .. ... / .- / - . ... -"), "this is a test");
	}

	@Test
	public void testHowDoILoveTheeFile() throws FileNotFoundException {
		try {
			File text = new File("C:\\Users\\lenovo\\eclipse-AdvancedWorkplace\\project5\\src\\howDoILoveThee.txt");
			assertEquals(MorseCodeConverter.convertToEnglish(text), "how do i love thee let me count the ways");
		}

		catch (FileNotFoundException e) {
			// when the file was not found
			fail("file was not found");
		}

	}

	@Test
	public void testDaisyDaisyFile() {
		try {
			File text = new File("C:\\Users\\lenovo\\eclipse-AdvancedWorkplace\\project5\\src\\DaisyDaisy.txt");
			assertEquals(MorseCodeConverter.convertToEnglish(text), "im half crazy all for the love of you");
		}

		catch (FileNotFoundException e) {
			// when the file was not found
			fail("file was not found");
		}
	}

	@Test
	public void testDaisyFile() {
		try {
			File text = new File("C:\\Users\\lenovo\\eclipse-AdvancedWorkplace\\project5\\src\\Daisy.txt");
			assertEquals(MorseCodeConverter.convertToEnglish(text), "give me your answer do");
		}

		catch (FileNotFoundException e) {
			// when the file was not found
			fail("file was not found");
		}
	}


	@Test
	public void testLoveLooksNotFile() {
		try {
			File text = new File("C:\\Users\\lenovo\\eclipse-AdvancedWorkplace\\project5\\src\\LoveLooksNot.txt");
			assertEquals(MorseCodeConverter.convertToEnglish(text), "love looks not with the eyes but with the mind");
		}

		catch (FileNotFoundException e) {
			// when the file was not found
			fail("file was not found");
		}
	}

	@Test
	public void testStudentFiles() {
		try {
			File text = new File("C:\\Users\\lenovo\\eclipse-AdvancedWorkplace\\project5\\src\\codeTest.txt");
			assertEquals(MorseCodeConverter.convertToEnglish(text), "i love lifting weights");
		}

		catch (FileNotFoundException e) {
			// when the file was not found
			fail("file was not found");
		}
	}

}
