package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyDLL;

public class MyDLLTests {
	private MyDLL<String> list;
    @BeforeEach
	public void setUp() throws Exception {
		list = new MyDLL<String>();
	}

	@AfterEach
	public void tearDown() throws Exception {
		list.clear();
	}
	
	@Test
	public void testAppend() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d -> e
			 */

			assertFalse(list.isEmpty());
			assertEquals(5, list.size());

			assertEquals("a", list.get(0));
			assertEquals("b", list.get(1));
			assertEquals("c", list.get(2));
			assertEquals("d", list.get(3));
			assertEquals("e", list.get(4));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testAdd() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		try {

			list.add(2, "e");
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> e -> c -> d
			 */

			assertFalse(list.isEmpty());
			assertEquals(5, list.size());

			assertEquals("a", list.get(0));
			assertEquals("b", list.get(1));
			assertEquals("e", list.get(2));
			assertEquals("c", list.get(3));
			assertEquals("d", list.get(4));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testReplace() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */

			assertEquals("c", list.set(2, "e"));
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> e -> d
			 */

			// Test the array list is not empty.
			assertFalse(this.list.isEmpty());

			// Test the size is 4
			assertEquals(4, list.size());

			// Test the values as per index
			assertEquals("a", list.get(0));
			assertEquals("b", list.get(1));
			assertEquals("e", list.get(2));
			assertEquals("d", list.get(3));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testGet() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */
			assertFalse(this.list.isEmpty());
			assertEquals(4, list.size());

			assertEquals("a", list.get(0));
			assertEquals("b", list.get(1));
			assertEquals("c", list.get(2));
			assertEquals("d", list.get(3));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testFind() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */
			assertFalse(this.list.isEmpty());
			assertEquals(4, list.size());

			assertEquals("a", list.get(0));
			assertEquals("b", list.get(1));
			assertEquals("c", list.get(2));
			assertEquals("d", list.get(3));

			assertEquals(true, list.contains("a"));
			assertEquals(true, list.contains("b"));
			assertEquals(true, list.contains("c"));
			assertEquals(true, list.contains("d"));
			assertEquals(false, list.contains("e"));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testRemoveIndex() {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */
			assertFalse(list.isEmpty());
			assertEquals(4, list.size());

			assertEquals("a", list.get(0));
			assertEquals("b", list.get(1));
			assertEquals("c", list.get(2));
			assertEquals("d", list.get(3));

			list.remove(2);
			/**
			 * Array list should   be:
			 * 
			 * a -> b -> d
			 */

			assertEquals(3, list.size());
			assertEquals("a", list.get(0));
			assertEquals("b", list.get(1));
			assertEquals("d", list.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testRemoveElement() {
		this.list.add("a");
		this.list.add("b");
		this.list.add("c");
		this.list.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */
			assertFalse(this.list.isEmpty());
			assertEquals(4, list.size());

			assertEquals("a", list.get(0));
			assertEquals("b", list.get(1));
			assertEquals("c", list.get(2));
			assertEquals("d", list.get(3));
			list.remove("c");

			/**
			 * Array list should  be:
			 * 
			 * a -> b -> d
			 */

			assertEquals(3, list.size());

			assertEquals("a", list.get(0));
			assertEquals("b", list.get(1));
			assertEquals("d", list.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testClear() {
		this.list.add("a");
		this.list.add("b");
		this.list.add("c");
		this.list.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */
			assertFalse(this.list.isEmpty());
			assertEquals(4, list.size());
			list.clear();

			assertTrue(this.list.isEmpty());
			assertEquals(0, list.size());

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testToArrayElement() {
		String[] temp = new String[2];

		this.list.add("c");
		this.list.add("d");

		Object[] myArrayString = list.toArray(temp);

		assertEquals("c", myArrayString[0]);
		assertEquals("d", myArrayString[1]);
	}


	@Test
	public void testToArrayObject() {
		this.list.add("a");
		this.list.add("b");

		Object[] temp = list.toArray();

		assertEquals("a", temp[0]);
		assertEquals("b", temp[1]);
	}
}
