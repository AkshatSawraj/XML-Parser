package utilities;


public class MyArrayList<E> implements ListADT<E> {

	/**
	 * MyArraList Class
	 */
	private static final long serialVersionUID = 1L;
	/**Amount of elements stored in MyArrayList object**/
	private final static int defaultsize = 10;
	 E[] arrayObjEs;
	 int capacity = 0;
	 int size = 0;


	@SuppressWarnings("unchecked")
	public MyArrayList() {
		capacity = defaultsize;
		arrayObjEs = (E[]) new Object[this.capacity];
	}

	@SuppressWarnings("unchecked")
	public MyArrayList(int n) {
        if (n <= 0) {
            System.out.println("The size must be greater than 0. Try again.");
            return;
        }
        else {
        	this.capacity = n;
        	arrayObjEs = (E[]) new Object[this.capacity];
		}

    }
	
	@Override
	public int size() {
		return this.size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		arrayObjEs = (E[]) new Object[this.capacity];
		 
	}    

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(size >= this.capacity) {
			reallocate();
		}
		
		for(int i = size; i > index; i--) {
			arrayObjEs[i] = arrayObjEs[i-1];
		}
		
		arrayObjEs[index] = toAdd;
		size++;
		
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(size < this.capacity) {
			arrayObjEs[size] = toAdd;
			size++;
			return true;
		}
		else {
			reallocate();
			arrayObjEs[size] = toAdd;
			return true;
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	private void reallocate() {
		this.capacity += 2;
		E[] temp = arrayObjEs.clone();
		arrayObjEs = (E[]) new Object[capacity];
		arrayObjEs = temp.clone();
			
	}

	@SuppressWarnings("unused")
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		boolean success = false;
		for (int i = 0; i < toAdd.size(); i++) {
			
			if(size < this.capacity) {
				arrayObjEs[size] = toAdd.get(i);
				size++;
				success = true; 
			}
			else {
				reallocate();
				arrayObjEs[size] = toAdd.get(i);
				success = true; 
			} 
		}
		return success;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return arrayObjEs[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {

		if(index < 0 | index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		E returnedItem = arrayObjEs[index];
		//shifting backwards
		for (int i = index; i < size; i++) {
			arrayObjEs[i - 1] = arrayObjEs[i];
			
		}
		size--;
		return returnedItem;  //Change to VOID?
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		E returnedItem = null;
		if(toRemove!= null) {
			for (int i = 0; i < size; i++) {
				if (arrayObjEs[i] == toRemove) {
					returnedItem = arrayObjEs[i];
					size--;
					for (int y = i; y < size; y++) {
						arrayObjEs[y - 1] = arrayObjEs[y];
						//Shift elements
					}
				}
			}
		}
		return returnedItem; //Change to VOID?
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException ();
		}
		E oldEntry = arrayObjEs[index];
		arrayObjEs[index] = toChange; 
		
		return oldEntry;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		for (int j = 0; j < arrayObjEs.length; j++){
			if (arrayObjEs[j] == null) {
				empty = true;
			}
			else {
				empty = false;
			}
		}
		return empty;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		boolean exists = false;
		if(toFind!= null) {
			for (int i = 0; i < size; i++) {
				if (arrayObjEs[i] == toFind) {
					exists = true;
				}
			}
		}
		return exists;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold.length<arrayObjEs.length) {
			toHold=(E[]) new Object[arrayObjEs.length];
		}
		for(int i=0;i<arrayObjEs.length;i++) {
			toHold[i]=arrayObjEs[i];
		}
		return toHold;
		
		
	}

	@Override
	public Object[] toArray() {
		return arrayObjEs;
	}

	@Override
	public Iterator<E> iterator() {
		ArrayIterator iter = new ArrayIterator(toArray());

		return iter;
	}

}
