package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import utilities.*;

public class MyArrayListTests {

	private MyArrayList<String> arrayList;

	@BeforeEach
	public void setUp() throws Exception {
		arrayList = new MyArrayList<String>();
	}

	@AfterEach
	public void tearDown() throws Exception {
		arrayList.clear();
	}

	@Test
	public void testAppend() {
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		arrayList.add("e");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d -> e
			 */

			assertFalse(this.arrayList.isEmpty());
			assertEquals(5, arrayList.size());
			
			assertEquals("a", arrayList.get(0));
			assertEquals("b", arrayList.get(1));
			assertEquals("c", arrayList.get(2));
			assertEquals("d", arrayList.get(3));
			assertEquals("e", arrayList.get(4));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testAdd() {
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");

		try {

			arrayList.add(2, "e");
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> e -> c -> d
			 */

			assertFalse(arrayList.isEmpty());
			assertEquals(5, arrayList.size());

			assertEquals("a", arrayList.get(0));
			assertEquals("b", arrayList.get(1));
			assertEquals("e", arrayList.get(2));
			assertEquals("c", arrayList.get(3));
			assertEquals("d", arrayList.get(4));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testReplace() {
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */

			assertEquals("c", arrayList.set(2, "e"));
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> e -> d
			 */

			// Test the array list is not empty.
			assertFalse(this.arrayList.isEmpty());

			// Test the size is 4
			assertEquals(4, arrayList.size());

			// Test the values as per index
			assertEquals("a", arrayList.get(0));
			assertEquals("b", arrayList.get(1));
			assertEquals("e", arrayList.get(2));
			assertEquals("d", arrayList.get(3));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testAddAll() {

		MyArrayList<String> toAdd = new MyArrayList<>();

		arrayList.add("a");
		arrayList.add("b");

		toAdd.add("c");
		toAdd.add("d");

		arrayList.addAll(toAdd);

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */

			assertFalse(this.arrayList.isEmpty());
			assertEquals(4, arrayList.size());

			assertEquals("a", arrayList.get(0));
			assertEquals("b", arrayList.get(1));
			assertEquals("c", arrayList.get(2));
			assertEquals("d", arrayList.get(3));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testGet() {
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */
			assertFalse(this.arrayList.isEmpty());
			assertEquals(4, arrayList.size());

			assertEquals("a", arrayList.get(0));
			assertEquals("b", arrayList.get(1));
			assertEquals("c", arrayList.get(2));
			assertEquals("d", arrayList.get(3));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testFind() {
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */
			assertFalse(this.arrayList.isEmpty());
			assertEquals(4, arrayList.size());

			assertEquals("a", arrayList.get(0));
			assertEquals("b", arrayList.get(1));
			assertEquals("c", arrayList.get(2));
			assertEquals("d", arrayList.get(3));

			assertEquals(true, arrayList.contains("a"));
			assertEquals(true, arrayList.contains("b"));
			assertEquals(true, arrayList.contains("c"));
			assertEquals(true, arrayList.contains("d"));
			assertEquals(false, arrayList.contains("e"));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testRemoveIndex() {
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */
			assertFalse(arrayList.isEmpty());
			assertEquals(4, arrayList.size());

			assertEquals("a", arrayList.get(0));
			assertEquals("b", arrayList.get(1));
			assertEquals("c", arrayList.get(2));
			assertEquals("d", arrayList.get(3));

			arrayList.remove(2);
			/**
			 * Array list should   be:
			 * 
			 * a -> b -> d
			 */

			assertEquals(3, arrayList.size());
			assertEquals("a", arrayList.get(0));
			assertEquals("b", arrayList.get(1));
			assertEquals("d", arrayList.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testRemoveElement() {
		this.arrayList.add("a");
		this.arrayList.add("b");
		this.arrayList.add("c");
		this.arrayList.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */
			assertFalse(this.arrayList.isEmpty());
			assertEquals(4, arrayList.size());

			assertEquals("a", arrayList.get(0));
			assertEquals("b", arrayList.get(1));
			assertEquals("c", arrayList.get(2));
			assertEquals("d", arrayList.get(3));
			arrayList.remove("c");

			/**
			 * Array list should  be:
			 * 
			 * a -> b -> d
			 */

			assertEquals(3, arrayList.size());

			assertEquals("a", arrayList.get(0));
			assertEquals("b", arrayList.get(1));
			assertEquals("d", arrayList.get(2));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testClear() {
		this.arrayList.add("a");
		this.arrayList.add("b");
		this.arrayList.add("c");
		this.arrayList.add("d");

		try {
			/**
			 * Array list should  be:
			 * 
			 * a -> b -> c -> d
			 */
			assertFalse(this.arrayList.isEmpty());
			assertEquals(4, arrayList.size());
			arrayList.clear();

			assertTrue(this.arrayList.isEmpty());
			assertEquals(0, arrayList.size());

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testToArrayElement() {
		String[] temp = { "a", "b" };

		this.arrayList.add("c");
		this.arrayList.add("d");

		Object[] myArrayString = arrayList.toArray(temp);

		assertEquals("a", myArrayString[0]);
		assertEquals("b", myArrayString[1]);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testToArrayObject() {
		this.arrayList.add("a");
		this.arrayList.add("b");

		Object[] temp = arrayList.toArray();

		assertEquals("a", temp[0]);
		assertEquals("b", temp[1]);
	}
}
