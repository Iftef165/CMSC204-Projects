/*
 * Class: CMSC204 
 * Instructor:Farnaz Eivazi
 * Description: a custom exception whenever the stack is full and unable to insert any new data
 * Due: 2/28/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ifte Maksud
*/
public class StackOverflowException extends RuntimeException{
	
	public StackOverflowException()
	{
		super("Stack is full");
	}
	
	public StackOverflowException(String msg)
	{
		super(msg);
	}
	

}
