/*
 * Class: CMSC204 
 * Instructor:Farnaz Eivazi
 * Description: represents the different types of conversions using stack and queue
 * Due: 2/28/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Ifte Maksud
*/
public class Notation {
	public Notation() {

	}

	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		MyQueue<Character> solution = new MyQueue<>(infix.length());
		MyStack<Character> stack = new MyStack<>(10);

		// goes through the entire infix
		for (int i = 0; i < infix.length(); i++) {
			// turn each item into a character
			char item = infix.charAt(i);

			// if the item is a space, skip it
			if (item == ' ') {
				continue;
			}

			else if (Character.isDigit(item)) {
				// if the item inside the infix is a digit, store it in the queue
				solution.enqueue(item);
			} else if (item == '(') {
				stack.push(item);
			}

			else if (item == '+') {
				// the top of the stack has same precedence
				// or higher precedence, pop it

				if (stack.isEmpty() == true) {
					stack.push(item);
				} else if (stack.top().equals(item) || stack.top().equals('-') || stack.top().equals('*')
						|| stack.top().equals('/') || stack.top().equals('^')) {
					char itemPopped = stack.pop();
					solution.enqueue(itemPopped);
					stack.push(item);
				}

				else {
					// most likely the stack will have an open parenthesis
					stack.push(item);
				}
			}

			else if (item == '-') {
				// when there is nothing in the stack, add it
				if (stack.isEmpty() == true) {
					stack.push(item);
				}
				// the top of the stack has same precedence
				// or higher precedence, pop it
				else if (stack.top().equals(item) || stack.top().equals('+') || stack.top().equals('*')
						|| stack.top().equals('/') || stack.top().equals('^')) {
					char itemPopped = stack.pop();
					solution.enqueue(itemPopped);
					stack.push(item);
				}

				else {
					stack.push(item);
				}

			}

			else if (item == '*') {
				// the top of the stack has same precedence
				// or higher precedence, pop it
				if (stack.isEmpty() == true) {
					stack.push(item);
				} else if (stack.top().equals(item) || stack.top().equals('*') || stack.top().equals('/')
						|| stack.top().equals('^')) {
					char itemPopped = stack.pop();
					solution.enqueue(itemPopped);
					stack.push(item);
				}

				else {
					stack.push(item);
				}
			}

			else if (item == '/') {
				// the top of the stack has same precedence
				// or higher precedence, pop it

				if (stack.isEmpty() == true) {
					stack.push(item);
				}

				else if (stack.top().equals(item) || stack.top().equals('*') || stack.top().equals('/')
						|| stack.top().equals('^')) {
					char itemPopped = stack.pop();
					solution.enqueue(itemPopped);
					stack.push(item);
				}

				else {
					stack.push(item);
				}
			}

			else if (item == ')') {
				// to make sure there is a signal that an open
				// parenthesis was found
				boolean hadOpenParenthesis = false;
				while (stack.isEmpty() == false) {
					char itemPopped = stack.pop();

					if (itemPopped == '(') {
						// lets the client know the open parenthesis was found
						hadOpenParenthesis = true;
						break;
					}

					solution.enqueue(itemPopped);
				}

				// in case the open parenthesis was not found
				if (hadOpenParenthesis == false) {
					throw new InvalidNotationFormatException();
				}

			}

			// come back to this method to understand it
			else if (item == '^') {
				if (stack.isEmpty() == true) {
					stack.push(item);
				}

				else if (stack.top().equals(item)) {
					char itemPopped = stack.pop();
					solution.enqueue(itemPopped);
					stack.push(item);
				}

				else {
					stack.push(item);
				}

			}
		}
		// adds any remaining items from the stack into the queue
		// until it is empty
		while (stack.isEmpty() == false) {
			char itemPopped = stack.pop();
			solution.enqueue(itemPopped);
		}

		return solution.toString();

	}

	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		MyStack<String> stack = new MyStack<>(10);

		for (int i = 0; i < postfix.length(); i++) {
			// turn each item into a character
			char item = postfix.charAt(i);

			if (item == ' ') {
				continue;
			} else if (Character.isDigit(item) == true) {
				// turns the character into a string
				stack.push(Character.toString(item));
			}

			else if (item == '+' || item == '-' || item == '*' || item == '/' || item == '^') {
				// when there is no 2 operands in the stack to pop
				if (stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}

				String firstPop = stack.pop();
				String secondPop = stack.pop();

				String combinedOperand = "(" + secondPop + item + firstPop + ")";

				stack.push(combinedOperand);
			}

		}

		// checks if there is any left over operands

		// if the remaining value has a length of 1, than it's guaranteed to be a
		// operand
		if (stack.top().length() == 1) {
			String lastPopped = stack.pop();

			// if the next item in the stack happens to have a length of 1, it will throw an
			// exception
			// as there cannot be 2 operands at the end without a operator in-between
			if (stack.top().length() == 1) {
				throw new InvalidNotationFormatException();
			}

			// if the length happens to have more than 1, than it's likely that the last
			// item
			// was only 1 operand

			// if that's the case, push the popped item back into the stack
			stack.push(lastPopped);
		}

		return stack.toString();

	}

	
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		MyStack<Double> stack = new MyStack<>(10);

		for (int i = 0; i < postfixExpr.length(); i++) {
			char item = postfixExpr.charAt(i);
			if (item == ' ') {
				continue;
			} else if (Character.isDigit(item) == true) {
				// turns the character into a double and then push it on the stack
				stack.push(Double.parseDouble(Character.toString(item)));
			}

			// if the item is an additon sign, add it with the second item popped + the
			// first item popped
			else if (item == '+') {
				// when there is no 2 operands in the stack to pop
				if (stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}

				Double firstPop = stack.pop();
				Double secondPop = stack.pop();

				Double combinedOperand = secondPop + firstPop;

				stack.push(combinedOperand);
			}

			else if (item == '-') {
				if (stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}

				Double firstPop = stack.pop();
				Double secondPop = stack.pop();

				Double combinedOperand = secondPop - firstPop;

				stack.push(combinedOperand);
			}

			else if (item == '*') {
				if (stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}

				Double firstPop = stack.pop();
				Double secondPop = stack.pop();

				Double combinedOperand = secondPop * firstPop;

				stack.push(combinedOperand);
			}

			else if (item == '/') {
				if (stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}

				Double firstPop = stack.pop();
				Double secondPop = stack.pop();

				Double combinedOperand = secondPop / firstPop;

				stack.push(combinedOperand);
			}

			else if (item == '^') {
				if (stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}

				Double firstPop = stack.pop();
				Double secondPop = stack.pop();

				Double combinedOperand = Math.pow(secondPop, firstPop);

				stack.push(combinedOperand);
			}

		}

		// in case there are more operands in the stack, other than a single output
		if (stack.size() > 1) {
			throw new InvalidNotationFormatException();

		}
		
		return stack.pop();

	}

}
