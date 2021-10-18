package utilities;

import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator<E> {

	private E[] array;
	private static int position = 0;

	@SuppressWarnings("unchecked")
	public ArrayIterator(Object[] array) {
		this.array = (E[]) array;
	}

	@Override
	public boolean hasNext() {
		return (ArrayIterator.position < this.array.length - 1);
	}

	@Override
	public E next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		

		E item = this.array[this.position];
		this.position++;
		return item;

	}

}
