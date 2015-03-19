
public class ProducerConsumer {
	private Producer producer = null;
	private Consumer consumer = null;
	
	ProducerConsumer() {
		producer = new Producer();
		consumer = new Consumer();
		
	}
	
	public void startMessageXfer() {
		Thread pt = new Thread(producer);
		Thread ct = new Thread(consumer);
		pt.start();
		ct.start();
//		try {
//			pt.join();
//			ct.interrupt();
//			ct.notifyAll();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
