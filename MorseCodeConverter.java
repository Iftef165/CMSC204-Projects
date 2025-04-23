import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MorseCodeConverter {
	public MorseCodeConverter() {

	}

	public static String convertToEnglish(String code) {
		String wordBuilder = "";

		String[] cleanerCode = code.split(" ");

		MorseCodeTree data = new MorseCodeTree();

		// first create the tree
		data.buildTree();

		// iterates through the code until it reaches the end
		for (int i = 0; i < cleanerCode.length; i++) {
			// retrieves each section of the code
			String retrieveCode = cleanerCode[i];

			// makes a space for the next word to be read
			if (retrieveCode.equals("/")) {
				wordBuilder += " ";
			}

			else {
				// retrieves each letter;
				String retrieveletter = data.fetchLetter(data.getRoot(), retrieveCode);

				// adds it to the word to be returned for later
				wordBuilder += retrieveletter;
			}
		}

		return wordBuilder;
	}

	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(codeFile));

			// stores the line of code
			String lineCode;
			
			lineCode = reader.readLine();
			
			reader.close();
			
			return convertToEnglish(lineCode);
		}

		// when the file has not been
		catch (FileNotFoundException e) {
			return null;
		}

		//when the line couldn't be read
		catch (IOException e) {
			
			return null;

		}
	}
}
