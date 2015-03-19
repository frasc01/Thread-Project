import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class PCExecutor {
	private ExecutorService pces=null;
	private List<MyCallable> tasklist;
	private List<Future<Status>> futurelist;
	
	public PCExecutor() {
		this(10);
	}

	
	public PCExecutor(int numThreads) {
		// Create a new thread pool
		pces = Executors.newFixedThreadPool(numThreads);
		tasklist = new ArrayList<MyCallable>();
		futurelist = new ArrayList<Future<Status>>();
//		BlockingQueue<Runnable> bq;
//		ThreadPoolExecutor tpe = new ThreadPoolExecutor(numThreads, numThreads, 60, TimeUnit.SECONDS, bq, null);
	}		
	
	
	
	public void initialize() {
		for (int i = 0; i < 15; i++)
			tasklist.add(new MyCallable());
		
		System.out.println("Added all tasks to the list");

	}

	
	public List<Future<Status>> startOneAtATime() {
		futurelist = new ArrayList<Future<Status>>();
		for (Callable<Status> task : tasklist) {
			Future<Status> future;
			future = pces.submit(task);
			futurelist.add(future);
		}
		System.out.println("Futures are submitted");
		pces.shutdown();
		return futurelist;
	}
	
	public List<Future<Status>> startAll() {
		try {
			futurelist = pces.invokeAll(tasklist);
			// When you come back... all the future tasks have been completed.
			System.out.println("Futures are submitted");
			boolean allDone=true;
			for (Future<Status> future : futurelist) {
				if (!future.isDone())
					allDone=false;
			}
			System.out.println("All Futures Complete ? : " + allDone);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return futurelist;		
	}
	
	public void simplesubmit() {
		Future<Status> f = submit(new MyCallable());
		Status s;
		try {
			s = f.get();
			System.out.println(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}		
	}
	

	
	public Future<Status> submit(Callable<Status> task) {
		Future<Status> f = pces.submit(task);
		return f;
	}
	
	public void processResults() {
		
		try {
			while (futurelist.size() > 0) {
				// Find the first one which is done
				boolean foundAny = false;
				for (Future<Status> future : futurelist) {
					if (future.isDone()) {
						System.out.println("About to get a future");
						Status s;
						s = future.get();
						System.out.println(s);
						futurelist.remove(future);
						foundAny=true;
						break;
					}
				}
				if (!foundAny)  // Nothing found, so sleep a little
					Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		PCExecutor pce = new PCExecutor(10);
		pce.initialize();

//		pce.startAll();
//		pce.simplesubmit();

		pce.startOneAtATime();
		pce.processResults();

		

	}
}
