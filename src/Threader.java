
public class Threader extends Thread {
	String m_name;
	int m_delay;
	static SyncInc sync = new SyncInc();
	static Object lock = new Object();
	
	public Threader(String name, int delay) {
		m_name=name;
		m_delay=delay;
	};
		
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
		{
			try {
				synchronized(lock) {					
					System.out.println(m_name + ":" + sync.inc());			
					System.out.println(Thread.activeCount() + " Active threads");
				}
				Thread.sleep(m_delay*1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
