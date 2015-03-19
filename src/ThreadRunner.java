import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadRunner {
	
	
	public void threaderTest() {
		System.out.println("THREADER TEST");
		ArrayList<Threader> list = new ArrayList<Threader>();
		try {
			list.add(new Threader("Scott", 1));
			Thread.sleep(250);
			list.add(new Threader("Ellen", 2));
			Thread.sleep(250);
			list.add(new Threader("Andrew", 3));
			Thread.sleep(250);
			list.add(new Threader("David", 2));
			/* Start them up */
			for (Thread t : list) {
				t.start();
			}
			while(Thread.activeCount() > 1) {
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void runnerTest() {
		System.out.println("RUNNER TEST");
		ArrayList<Thread> list = new ArrayList<Thread>();
		try {
			list.add(new Thread(new Runner("Scott", 1)));
			list.add(new Thread(new Runner("Ellen", 2)));
			list.add(new Thread(new Runner("Andrew", 3)));
			list.add(new Thread(new Runner("David", 2)));
			/* Start them up */
			for (Thread t : list) {
				t.start();
				Thread.sleep(250);
			}
			while(Thread.activeCount() > 1) {
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void producerConsumerTest() {
		ProducerConsumer pc = new ProducerConsumer();
		pc.startMessageXfer();
	}

	
	public static void main(String[] args) {
		ThreadRunner tr = new ThreadRunner();
//		tr.runnerTest();
//		tr.threaderTest();
		tr.producerConsumerTest();
	}

}
