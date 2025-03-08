/*
 * Class: CMSC204 
 * Instructor:Farnaz Eivazi
 * Description: represents a queue for storing data types for a certain way
 * Due: 2/28/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ifte Maksud
*/
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{
	
	private int capacity;
	private T[] items;
	private int front;
	private int rear;
	
	@SuppressWarnings("unchecked")
	public MyQueue()
	{
		items = (T[])new Object[5];
		capacity = 5;
		front = 0;
		rear = 0;
	}
	
	@SuppressWarnings("unchecked")
	public MyQueue(int capacity)
	{
		items = (T[])new Object[capacity];
		this.capacity = capacity;
		front = 0;
		rear = 0;
	}
	
	public boolean enqueue(T e)throws QueueOverflowException
	{
		if(isFull() == true)
		{
			throw new QueueOverflowException();
		}
		
		items[rear] = e;
		
		rear++;
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public T dequeue() throws QueueUnderflowException
	{
		if(isEmpty() == true)
		{
			throw new QueueUnderflowException();
		}
		
		T[]newItems = (T[])new Object[capacity];
		
		//retrieves the item that is going to be removed and returned 
		T itemRemoved = items[front];
		
		//decrement the rear before shifting the elements
		rear--;
		
		for(int i=front+1;i<capacity;i++)
		{
			//retrieve items to the new queue except for the first item
			newItems[i-1] =items[i]; 
		}
		
		items = newItems;
		
		return itemRemoved;

	}
	
	public boolean isFull()
	{
		if(rear == capacity)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isEmpty()
	{
		if(rear == front)
		{
			return true;
		}
		
		return false;
	}
	
	public int size()
	{
		return rear;
	}
	
	public String toString()
	{
		String queueRep = "";
		
		for(int i=0;i<rear;i++)
		{
			queueRep += items[i];
		}
		
		return queueRep;
	}
	
	public String toString(String delimiter)
	{
		String queueRep = "";
		
		for(int i=0;i<rear;i++)
		{
			queueRep += items[i] + delimiter;
		}
		
		return queueRep;
	}
	
	public void fill(ArrayList<T> list) throws QueueOverflowException
	{
		// if the size of the list is greater than the capacity of the queue
		if(isFull()== true)
		{
			throw new QueueOverflowException();
		}
		
		if(list.size() > capacity)
		{
			throw new QueueOverflowException();
		}
		
		//represents the deep copy of the list 
		ArrayList<T> newList = new ArrayList<>();
		
		
		for(int i=0;i<list.size();i++)
		{
			// when the queue reaches capacity if the rear doesn't start at 0 index
			if(isFull() == true)
			{
				throw new QueueOverflowException();
			}
			
			// retrieves the elements from the original list
			newList.add(list.get(i));
			items[rear] = newList.get(i);
			rear++;
		}
	}
}
