
public class MessageBox {
	static volatile private MessageBox instance = null;
	private volatile String m_message;
	private volatile boolean m_messageReady=false;
	
	synchronized public String takeMessage() {
		String message="";
		while (!isMessageReady()) {	
			try {
				System.out.println("Waiting to take a message");
				wait();
			}
			catch (InterruptedException e) {}
		}
		message=m_message;
		m_messageReady = false;
		notifyAll();
		return message;
	}

	synchronized public void putMessage(String message) {
		while (isMessageReady()) {	
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		m_message = message;
		m_messageReady = true;
		notifyAll();
	}
	
	boolean isMessageReady()
	{
		return m_messageReady;
	}
	static MessageBox getInstance() {
		if (instance == null) {
			instance = new MessageBox();
		}
		return instance;
	}

}
