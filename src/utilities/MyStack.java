package utilities;

/**
 * 
 * @author Group
 *
 * @param <E>
 */
public class MyStack<E> implements StackADT<E> {
	int size;
	E[] array;
	public int top = -1;
	

	@SuppressWarnings("unchecked")
	public MyStack(int size) {
		this.size = size;
		array = (E[]) new Object[this.size];

	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top+1 == size();

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		for (E i : array) {
			i = null;
		}
		
		top = -1;
		
	}

	@Override
	public E pop() throws NullPointerException {
		E data = array[top];
		array[top]=null;
		top--;
		return data;
	
	}

	@Override
	public E peek() throws NullPointerException {
		if(top==-1) {
			throw new NullPointerException();
		}
		return array[top];
		
	}

	@Override
	public E[] toArray() {
		return array;
	}

	@Override
	public Iterator<E> iterator() {
		ArrayIterator iter = new ArrayIterator(toArray());

		return iter;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold.length==0) {
			throw new NullPointerException();
		}
		if(toHold.length<array.length) {
			toHold=(E[]) new Object[array.length];
		}
		for (int i = 0; i < array.length; i++) {
			toHold[i] = array[i];
		}
		return toHold;
	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		if (e == null) {
			throw new NullPointerException();
		}
		for (E i : array) {
			if (i.equals(e)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean push(E data) throws IndexOutOfBoundsException {
		if (!isFull()) {
			top ++;
			array[top] = data;
			
			
			return true;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int search(E e) {
		int counter = 0;
		for (E i : array) {
			if (i.equals(e)) {
				return counter;
			}
			counter++;
		}
		return -1;
	}
}
