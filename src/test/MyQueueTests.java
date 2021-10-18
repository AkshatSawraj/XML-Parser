package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyQueue;

public class MyQueueTests {
	private MyQueue<String> queue;
	
	@BeforeEach
	public void setUp() throws Exception {
		queue = new MyQueue<String>(5);
	}

	@AfterEach
	public void tearDown() throws Exception {
		queue.dequeueAll();
	}
	
	@Test
	void testEnqueue() {
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");

		assertFalse(queue.isEmpty());
		assertEquals("a", queue.peek());
	}

	@Test
	void testDequeue() {
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");

		assertEquals("a", queue.dequeue());
	}

	@Test
	void testPeek() {
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");

		assertEquals("a", queue.peek());
	}

	@Test
	void isEmpty() {
		assertTrue(queue.isEmpty());

		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");

		assertFalse(queue.isEmpty());
	}

	@Test
	void isFull() {
		assertFalse(queue.isFull());
	}

	@Test
	void testDequeueAll() {
		// Test the stack is empty.
		assertTrue(queue.isEmpty());

		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");

		queue.dequeueAll();
		
		assertTrue(queue.isEmpty());
	}

	
	@Test
	void testToArrayElement() {
		String[] temp =new String[2];

		queue.enqueue("c");
		queue.enqueue("d");

		Object[] myArrayString = queue.toArray(temp);

		assertEquals("c", myArrayString[0]);
		assertEquals("d", myArrayString[1]);
	}
	
	@Test
	void testToArrayObject() {
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		
		Object[] temp = queue.toArray();
		
		assertEquals("c", temp[2]);
	}
	
}