/*
 * Class: CMSC204 
 * Instructor:Farnaz Eivazi
 * Description: a custom exception whenever the stack is empty and unable to remove any elements
 * Due: 2/28/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ifte Maksud
*/

public class StackUnderflowException extends RuntimeException{
	public StackUnderflowException()
	{
		super("Stack is empty");
	}
	
	public StackUnderflowException(String msg)
	{
		super(msg);
	}
}
