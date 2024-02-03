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
		tail++;
		
		list[ tail ] = newObj;
	}
	
	public Object remove () {
		
		Object current = list[ 0 ];
		for ( int i = 0; i < tail ; i++ ) {
			list[ i ] = list[ i + 1 ];
		}
		
		tail--;
		
		return current;
		
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
