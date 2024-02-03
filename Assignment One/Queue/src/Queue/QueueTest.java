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
	}
	
	@Test
	// TODO
	void testNullList () {
		queue.create( 0 );
	}
	
	@AfterEach
	void tearDown () {
		queue = null;
	}

}
