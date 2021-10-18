package utilities;

/**
 * 
 * @author Group
 *
 * @param <E>
 */
public class MyDLL<E> implements ListADT<E> {
	private MyDLLNode<E> head, tail;
	public static int counter;

	public MyDLL() {
		this.head = null;
		this.tail = null;
	}

	@Override
	public int size() {
		return counter;
	}

	@Override
	public void clear() {
		head = tail = null;
		counter = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		MyDLLNode<E> current = head;
		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd);
		if (size() < index || index < 0) {
			// throws exception when index is greater then the size of the linked list
			throw new IndexOutOfBoundsException();
		} else if (current != null) {
			// move to the requested index
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
		}
		newNode.next = current.next;
		current.next = newNode;
		newNode.previous = current;
		counter++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null) {
			throw new NullPointerException();
		}

		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd);
		if (head == null) {
			head = tail = newNode;
			head.previous = null;
			tail.next = null;
			counter++;
			return true;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			tail.next = null;
			counter++;
			return true;
		}
	}

	@Override
	public boolean addAll(ListADT<? extends E > toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}

		Object[] arr= toAdd.toArray();
		System.out.println("hi");
		for(Object i:arr) {
			System.out.println(i);
			add((E)(i));
			counter++;
		}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		MyDLLNode<E> current = head;
		if (index > size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.element;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {

		MyDLLNode<E> current = head;
		if (size() < index || index < 0) {
			// throws exception when index is greater then the size of the linked list
			throw new IndexOutOfBoundsException();
		} else if (current != null) {
			// move to the requested index
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
		}
		MyDLLNode<E> toDelete = current.next;
		current.next = current.next.next;
		current.next.previous = current;
		counter--;
		return (E) toDelete.element;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException();
		}
		MyDLLNode<E> current = head;
		MyDLLNode<E> toDelete;

		while (current != null) {
			if (current.element.equals(toRemove)) {
				toDelete = current;
				current.previous.next = current.next;
				current.next.previous = current.previous;
				counter--;
				return toDelete.element;

			}
			current = current.next;
		}
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) {
			throw new NullPointerException();
		}

		MyDLLNode<E> current = head;
		if (size() < index || index < 0) {
			// throws exception when index is greater then the size of the linked list
			throw new IndexOutOfBoundsException();
		} else if (current != null) {
			// move to the requested index
			for (int i = 0; i < index ; i++) {
				current = current.next;
			}
		}
		E previousElement = current.element;
		current.element = toChange;

		return previousElement;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		MyDLLNode<E> current = head;
		while (current != null) {
			if (current.element.equals(toFind)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {

		if (toHold == null || toHold.length < size()) {
			throw new NullPointerException();
		}

		MyDLLNode<E> current = head;
		for (int i = 0; i < size(); i++) {
			toHold[i] = current.element;
			current = current.next;

		}
		return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];
		MyDLLNode<E> current = head;
		for (int i = 0; i < size(); i++) {
			array[i] = current.element;
			current = current.next;
		}
		return array;
	}

	@Override
	public Iterator<E> iterator() {
		
		ArrayIterator<E> iter = new ArrayIterator<E>(toArray());

		return iter;
	}

}
