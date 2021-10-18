package utilities;

import java.io.Serializable;
/**
 * A stack interface used to define the methods needed to make a Stack at 
 * an abstract level.
 * @author Group
 *
 * @param <E>
 */
public interface StackADT<E> extends Serializable{
	/**
	 * IsEmpty will tell us if the stack is empty. 
	 * 
	 * @return Boolean indication
	 */
	public boolean isEmpty();
	/**
	 * Is Full Method will tell us if the satack has reached entire capacity.
	 * @return
	 */
	public boolean isFull() ;
	/**
	 * Pop method will take an element out of the list and return it to the user. 
	 * @return The object data
	 * @throws NullPointerException
	 * Occurs if an element is null in object spot.
	 */
	public E pop() throws NullPointerException;
	/**
	 * Push method seeks data and stores it into the top of the stack.
	 * @param data
	 * @return Boolean indicating successful completion
	 * @throws IndexOutOfBoundsException
	 * Occurs when the we are out of space, therefore outOfBounds in terms of stack range space.
	 */
	public boolean push(E data) throws IndexOutOfBoundsException;
	/**
	 * Get the int size of the whole stack.
	 * @return A value in the form of an integer.
	 */
	public int size() ;
	/**
	 * Peek method will look at the top element
	 * @return Object Element Data
	 * @throws NullPointerException
	 */
	public E peek() throws NullPointerException;
	/**
	 * Clear method will clear the whole entire stack of any previous data. 
	 */
	public void clear(); 
	/**
	 * Contains method is used to check if such object exists in our existing stack.
	 * @param e
	 * @return Boolean true, meaning yes. False indicates that data copy isn't in the stack.
	 * @throws NullPointerException
	 */
	public boolean contains(E e) throws NullPointerException;
	/**
	 * To Array method changes overall data structure from Stack to an Array.
	 * @return Array Object containing data.
	 */
	public E[] toArray(); 
	/**
	 * Run through an interval by using an iterator. 
	 * @return
	 */
	public Iterator<E> iterator();
	/**
	 * Convert such argData into an Array.
	 * @param toHold
	 * @return
	 * @throws NullPointerException
	 */
	public E[] toArray( E[] toHold ) throws NullPointerException;
	/**
	 * Search the stack for object data
	 * @param e
	 * @return Returns the position of the item within the stack.
	 */
	public int search(E e);
	
	
}
