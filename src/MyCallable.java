import java.util.Random;
import java.util.concurrent.Callable;


public class MyCallable implements Callable<Status> {

	Random rnd = new Random();
	
	@Override
	public Status call() throws Exception {
		Status s = new Status(rnd.nextInt(60), rnd.nextInt(100)+100, "StatusObject_"+rnd.nextInt(100));
		int r=rnd.nextInt(60);
		System.out.println(s.getName() + " is sleeping " + r + " seconds");
		Thread.sleep(r*1000);
		System.out.println(s.getName() + " Has completed");
		return s;
	}


	public static void main(String[] args) throws Exception {
		MyCallable c = new MyCallable();
		Status s = c.call();
		System.out.println(s);
	}

}
