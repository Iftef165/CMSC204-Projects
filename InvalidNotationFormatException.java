
/*
 * Class: CMSC204 
 * Instructor:Farnaz Eivazi
 * Description: a custom exception whenever there is a problem with the notation class 
 * Due: 2/28/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ifte Maksud
*/

public class InvalidNotationFormatException extends RuntimeException{

	public InvalidNotationFormatException()
	{
		super("Notation format is incorrect");
	}
	
	public InvalidNotationFormatException(String msg)
	{
		super(msg);
	}
}
