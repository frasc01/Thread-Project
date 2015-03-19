
public class Consumer implements Runnable {
	private MessageBox messageBox = null;
	
	public Consumer() {
		messageBox = MessageBox.getInstance();
	}

	@Override
	public void run() {
		while (true) {
			String message = messageBox.takeMessage();
			if (message == "Done")
				break;
			System.out.println(message);
			
		}
	}

}
