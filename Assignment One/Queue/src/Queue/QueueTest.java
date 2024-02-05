package Queue;

import static org.junit.jupiter.api.Assertions.*;

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
		
		assertThrows( ArrayIndexOutOfBoundsException.class, () -> {
			Object obj = new Object();
			queue.add( obj );
		});
	
	}
	
	@Test
	void addToList () {
		queue.create( 5 );
		Object obj = new Object();
		queue.add( obj );
		
	
	}

	@AfterEach
	void tearDown () {
		queue = null;
	}

}
