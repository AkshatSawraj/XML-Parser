package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyStack;

public class MyStackTests {
	private MyStack<String> stack;
	
	@BeforeEach
	public void setUp() throws Exception {
		stack = new MyStack<String>(5);
	}

	@AfterEach
	public void tearDown() throws Exception {
		stack.clear();
	}

	@Test
	public void testPush() {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		
		try {
			assertFalse(stack.isEmpty());
			assertEquals(5, stack.size());

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testPop() {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		try {
			assertFalse(stack.isEmpty());
			assertEquals(5, stack.size());

			assertEquals("d", stack.pop());
			assertEquals("c", stack.pop());
			assertEquals("b", stack.pop());
			assertEquals("a", stack.pop());

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testPeek() {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		try {
			assertFalse(stack.isEmpty());
			assertEquals(5, stack.size());
			
			assertEquals("d", stack.peek());
			stack.pop();
			assertEquals("c", stack.peek());
			stack.pop();
			assertEquals("b", stack.peek());
			stack.pop();
			assertEquals("a", stack.peek());
			stack.pop();
			
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testContains() {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		try {
			assertFalse(stack.isEmpty());
			assertEquals(5, stack.size());
			
			assertEquals(true, stack.contains("a"));
			assertEquals(true, stack.contains("b"));
			assertEquals(true, stack.contains("c"));
			assertEquals(true, stack.contains("d"));
			assertEquals(false, stack.contains("e"));

			
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testFull() {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		
		
		try {
			assertFalse(stack.isEmpty());
			assertEquals(5, stack.size());
			
			assertEquals(true, stack.isFull());
			
	
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testClear() {
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		

		try {
			
			assertFalse(stack.isEmpty());
			assertEquals(4, stack.top+1);
			stack.clear();

			assertEquals(true,stack.isEmpty());
			
			assertEquals(0, stack.top+1);

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testToArrayElement() {
		String[] temp =new String[2];
		
		stack.push("c");
		stack.push("d");

		Object[] myArrayString = stack.toArray(temp);

		assertEquals("c", myArrayString[0]);
		assertEquals("d", myArrayString[1]);
	}

	
	@Test
	public void testToArrayObject() {
		stack.push("a");
		stack.push("b");
		
		Object[] temp = stack.toArray();

		assertEquals("a", temp[0]);
		assertEquals("b", temp[1]);
	}

}
