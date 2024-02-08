package Queue;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

class QueueTest {
	Queue queue;

	@BeforeEach
	void setUp () {
		queue = new Queue();
	}

	@Test
	void testInitialisation() {
		assertTrue(  queue.maxSize() == 10, "Length is equal to default size" );

		assertTrue( queue.remove() == null, "Make sure there is null returned with remove function" );

		assertTrue( queue.howMany() == 0, "Make sure there is nothing in the list" );

		assertTrue( queue.isEmpty(), "Make sure list returns empty" );

	}

	// This test sets the list max num to 0
	@Test
	void testNullList () {
		queue.create( 0 );

		assertTrue(  queue.maxSize() == 0, "Length is equal to 0" );

		assertTrue( queue.remove() == null, "Make sure there is null returned with remove function" );

		assertTrue( queue.howMany() == 0, "Make sure there is nothing in the list" );

		assertTrue( queue.isEmpty(), "Make sure list returns empty" );

	}

	@Test
	void addToNullList () {
		queue.create( 0 );

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Object obj = new Object();
		queue.add( obj );
		
		String expectedOutput  = "Queue is full!" ;

		// Do the actual assertion.
		assertEquals(expectedOutput, outContent.toString());

	}

	@Test
	void addToDefaultList () {

		Object obj = new Object();
		queue.add( obj );

		assertTrue( queue.remove() == obj, "ensure object added is same as object removed");

	}

	@Test
	void testLengthValues () {

		assertThrows( NegativeArraySizeException.class, () -> {
			queue.create( -1 );
		});

		assertThrows( OutOfMemoryError.class, () -> {
			queue.create( Integer.MAX_VALUE );
		});

		queue.create( 20 );

		assertTrue(  queue.maxSize() == 20, "Length is equal to 20" );

		assertTrue( queue.remove() == null, "Make sure there is null returned with remove function" );

		assertTrue( queue.howMany() == 0, "Make sure there is nothing in the list" );

		assertTrue( queue.isEmpty(), "Make sure list returns empty" );
	}

	@Test
	void testAdding () {
		queue.create( 5 );

		for (int i = 0; i < 5; i++ ) {
			Object obj = new Object();
			queue.add( obj );
			System.out.println("hello");
			assertTrue( queue.howMany() == i + 1, "Make sure list returns correct number of elements" );
		}

		assertTrue( !queue.isEmpty(), "Make sure queue does not return empty" );

		Object obj = new Object();
		queue.add( obj );
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		queue.add( obj );
		
		String expectedOutput  = "Queue is full!" ;

		// Do the actual assertion.
		assertEquals(expectedOutput, outContent.toString());
	}

	@Test
	void testRemoving () {
		queue.create( 3 );
		
		queue.add("1");
		queue.add("2");
		queue.add("3");
		
		assertTrue( queue.remove() == "1", "Make sure first object is removed" );
		assertTrue( queue.howMany() == 2, "make sure correct number in queue" );
		assertTrue( queue.remove() == "2", "Make sure first object is removed" );
		assertTrue( queue.howMany() == 1, "make sure correct number in queue" );
		assertTrue( queue.remove() == "3", "Make sure first object is removed" );
		assertTrue( queue.howMany() == 0, "make sure correct number in queue" );
		assertTrue( queue.isEmpty(), "Make sure queue is empty" );
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		queue.remove();
		
		String expectedOutput  = "Queue was empty!" ;

		assertEquals(expectedOutput, outContent.toString());
		
		
	}


	@AfterEach
	void tearDown () {
		queue = null;
	}

}
