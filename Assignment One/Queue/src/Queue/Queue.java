package Queue;

public class Queue {
	
	final int DEFAULT_SIZE = 10;
	private int tail = -1;
	private Object [] list;
	
	Queue () {
		create( DEFAULT_SIZE );
	}
	
	public void create ( int maxNum ) {
		list = new Object[ maxNum ];
		tail = -1;
	}
	
	public int maxSize () {
		return list.length;
	}
	
	public void add ( Object newObj ) {
		if ( tail + 1 < maxSize() ) {
			tail++;
			
			list[ tail ] = newObj;
		} else {
			System.out.print( "Queue is full!" );
		}
		
	}
	
	public Object remove () {
		
		if ( !isEmpty() ) {
			Object current = list[ 0 ];
			for ( int i = 0; i < tail ; i++ ) {
				list[ i ] = list[ i + 1 ];
			}
			
			tail--;
			
			return current;
		}
		
		System.out.print("Queue was empty!");
		
		
		return null;
		
	}
	
	public int howMany () {
		return tail + 1;
	}
	
	public Boolean isEmpty () {
		
		if ( howMany() == 0	 ) {
			
			return true;
			
		}
		return false;
	}
	
}
