
public class Producer implements Runnable {

	private MessageBox messageBox = null;
	
    String ma[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
    };
	
	public Producer() {
		messageBox = MessageBox.getInstance();

	}
	
	@Override
	public void run() {
		// Add a message to the messageBox
		for (String message : ma) {
			System.out.println("Putting in a new Message");
			messageBox.putMessage(message);
		}
		messageBox.putMessage("Done");
	}
}
