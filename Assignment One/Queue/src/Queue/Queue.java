package Queue;

public class Queue {
	
	private int maxSize;
	int tail = -1;
	Object [] list;
	
	public void create ( int maxNum ) {
		maxSize = maxNum;
		list = new Object[ maxNum ];
		tail = -1;
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
