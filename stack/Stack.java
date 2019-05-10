import java.util.ArrayList;
import java.util.Iterator;

//using the stack class to store the data
public class Stack<T> {

	// define a initial size of stack
	private final int DEFAULT_CAPACITY = 100;

	private int top;

	private T[] stack;

	// initialize the stack with null
	public Stack() {
		top = 0;
		stack = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	// initialize the stack with a given capacity
	public Stack(int initialCapacity) {
		top = 0;
		stack = (T[]) (new Object[initialCapacity]);
	}

	// add a element to the stack
	public void push(T element) {
		if (size() == stack.length)
			expandCapacity();
		stack[top] = element;
		top++;
	}

	// delete the element at the top
	// return the element deleted
	// if the stack is empty, return null
	public T pop() {
		if (isEmpty())
			return null;
		top--;
		T result = stack[top];
		stack[top] = null;
		return result;
	}

	// return the element at the top
	// return null, if the stack is empty
	public T peek() {
		if (isEmpty())
			return null;
		return stack[top - 1];
	}

	// return true, if the stack is empty
	// otherwise, return false
	public boolean isEmpty() {
		return (top == 0);
	}

	// return the amount of elements in the stack
	public int size() {
		return top;
	}

	// print out the stack with all the elements
	public String toString() {
		String result = "";
		for (int scan = 0; scan < top; scan++)
			result = result + stack[scan].toString() + "\n";
		return result;
	}

	// expand the capacity of the stack
	private void expandCapacity() {
		T[] larger = (T[]) (new Object[stack.length * 2]);
		for (int index = 0; index < stack.length; index++)
			larger[index] = stack[index];
		stack = larger;
	}

	// return a iterator that contain all the elements in the stack
	public Iterator<T> iterator() {
		ArrayList<T> list = new ArrayList<T>();
		for (int i = 0; i < top; i++) {
			list.add(stack[i]);
		}
		return list.iterator();
	}
}
