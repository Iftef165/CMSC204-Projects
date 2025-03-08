/*
 * Class: CMSC204 
 * Instructor:Farnaz Eivazi
 * Description: a custom exception whenever the queue is full and unable to insert new elements
 * Due: 2/28/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ifte Maksud
*/
public class QueueOverflowException extends RuntimeException{
	public QueueOverflowException()
	{
		super("Queue is full");
	}
	
	public QueueOverflowException(String msg)
	{
		super(msg);
	}
}
