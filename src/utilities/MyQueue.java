package utilities;
/**
 * 
 * @author Group
 *
 * @param <E>
 */
public class MyQueue<E> implements QueueADT<E> {
	int size;
	E[] array;
	int count = 0;
	int front = 0;
	int rear = -1;

	public MyQueue(int size) {
		super();
		this.size = size;
		array = (E[]) new Object[this.size];
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public boolean isFull() {
		return count == size;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void dequeueAll() {
		for (E i : array) {
			i = null;
		}
		count = 0;
		front = 0;
		rear = -1;
	}

	@Override
	public E[] toArray() {
		return array;
	}

	@Override
	public boolean enqueue(E data) throws IndexOutOfBoundsException {
		if (!isFull()) {
			if (rear == size - 1) {
				rear = -1;
			}
			array[++rear] = data;
			count++;
			return true;
		}
		return false;
	}

	@Override
	public E dequeue() throws NullPointerException {
		E data = array[front];
		array[front] = null;
		front++;

		if (front == size) {
			front = 0;
		}
		if (count > 0) {
			count--;
		}
		return data;
	}

	@Override
	public E peek() throws NullPointerException {
		return array[front];
	}

	@Override
	public Iterator<E> iterator() {
		ArrayIterator<E> iter = new ArrayIterator<E>(toArray());

		return iter;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold.length < array.length) {
			toHold = (E[]) new Object[array.length];
		}
		for (int i = 0; i < array.length; i++) {
			toHold[i] = array[i];
		}
		return toHold;

	}

}
