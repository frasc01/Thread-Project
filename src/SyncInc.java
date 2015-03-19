
public class SyncInc {
	// volatile make the object accessible by other threads without memory consistancy errors
	// However you still need to synchronize access for multi-threaded access
	private volatile int m_counter;
	
	public SyncInc() {
		m_counter=0;
	}
	
	synchronized int inc() {
		m_counter++;
		return m_counter;
	}

	synchronized int dec() {
		m_counter--;
		return m_counter;
	}

	synchronized int get() {
		return m_counter;
	}

}
