package utilities;

import java.io.Serializable;
/**
 * 
 * @author Group
 *
 * @param <E>
 */
public interface QueueADT<E> extends Serializable{
	/**
	 * Checks if the list is empty.
	 * @return True if it is empty.
	 */
	public boolean isEmpty();
	/**
	 * Checks if the list is is full.
	 *
	 * @return The true if it is full or false if it isn't full.
	 *
	 */
	public boolean isFull() ;
	/**
	 * The size method will return the current element count contained in the list.
	 *
	 * @return The current element count.
	 */
	public int size() ;
	/**
	 * The dequeAll method will clear all elements in the Queue.
	 */
	public void dequeueAll();
	/**
	 * The toArray method will return the whole Queue data in an Array form.
	 *
	 * @return An Array of elements.
	 */
	public E[] toArray();
	/**
	 * The enqueue method will add the data element to the Queue.
	 *
	 * @return An a true value if the data succcesfully added to the Queue.
	 *  @throws IndexOutOfBoundsException if an element is outside of range or does not exist.
	 */
	public boolean enqueue(E data) throws IndexOutOfBoundsException;
	/**
	 * The dequeue method will takeout and return the data element from the Queue.
	 *
	 * @return An the object element and take it out from the structure.
	 */
	public E dequeue()  throws NullPointerException;
	/**
	 * The peek method will look at the next item inline ready to dequeue in priority..
	 *
	 * @return An the object element.
	 */
	public E peek() throws NullPointerException;
	/**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 *
	 * @return An iterator over the elements in this list, in proper sequence. NB:
	 *         The return is of type <code>linearUtilities.Iterator<E></code>, not
	 *         <code>java.util.Iterator</code>.
	 */
	public Iterator<E> iterator();
	/**
	 * The toArray method will return the whole Queue data in an Array form.
	 *
	 * @return An Array of elements.
	 */
	public E[] toArray( E[] toHold ) throws NullPointerException;
	
}
