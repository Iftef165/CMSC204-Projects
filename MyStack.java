/*
 * Class: CMSC204 
 * Instructor:Farnaz Eivazi
 * Description: represents storing data by last in first out procedure
 * Due: 2/28/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ifte Maksud
*/
import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	private T[] items;
	private int top;
	private int capacity;

	@SuppressWarnings("unchecked")
	public MyStack() {
		items = (T[]) new Object[5];
		top = 0;
	}

	@SuppressWarnings("unchecked")
	public MyStack(int capacity) {
		items = (T[]) new Object[capacity];
		this.capacity = capacity;
		top = 0;
	}

	public boolean isEmpty() {
		if (top == 0) {
			return true;
		}

		return false;
	}

	// if the number of items in the array is equal to the max capacity, then its
	// full
	public boolean isFull() {
		if (top == capacity) {
			return true;
		}

		return false;
	}

	public boolean push(T e) throws StackOverflowException {
		if (isFull() == true) {
			throw new StackOverflowException();
		}

		// adds the item to the top
		items[top] = e;

		// increase the top for the next entry
		top++;

		return true;
	}

	// deletes the top of the stack and returns the item that was on top
	public T pop() throws StackUnderflowException {
		// check if the stack is empty
		if (isEmpty() == true) {
			throw new StackUnderflowException();
		}

		// decreases the top to the recently added element
		top--;
		// retrieves the data before it's deleted
		T topPopped = items[top];

		items[top] = null;

		return topPopped;
	}

	public T top() throws StackUnderflowException {
		if (isEmpty() == true) {
			throw new StackUnderflowException();
		}

		// the recently added element instead of the waiting entry
		return items[top - 1];
	}

	public int size() {
		return top;
	}

	// stack representation from bottom to top
	public String toString() {
		String stackBottomTop = "";

		for (int i = 0; i < top; i++) {
			stackBottomTop += items[i];
		}

		return stackBottomTop;
	}

	// stack representation with delimiter in between
	public String toString(String delimiter) {
		String stackBottomTop = "";

		for (int i = 0; i < top; i++) {
			stackBottomTop += items[i] + delimiter;
		}

		return stackBottomTop;
	}

	public void fill(ArrayList<T> list) throws StackOverflowException {
		// if the size of the list is greater than the capacity of the stack
		if (list.size() > capacity) {
			throw new StackOverflowException();
		}

		//represents the deep copy of the list
		ArrayList<T> newList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			// when the stack reaches capacity if the top doesn't start at 0 index
			if (isFull() == true) {
				throw new StackOverflowException();
			}
			// retrieves the elements from the original list
			newList.add(list.get(i));

			items[top] = newList.get(i);
			top++;
		}

	}

}
