
public class Runner implements Runnable {

	String m_name;
	int m_delay;
	
	public Runner(String name, int delay) {
		m_name=name;
		m_delay=delay;
	};
		
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
		{
			try {
				System.out.println(m_name + ":" + i);			
				System.out.println(Thread.activeCount() + " Active threads");
				Thread.sleep(m_delay*1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
