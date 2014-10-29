import java.util.concurrent.BlockingQueue;


public class Consumer implements Runnable{

	protected BlockingQueue<HttpRequest> queue;
	public Consumer(BlockingQueue<HttpRequest> queue) {
		
		this.queue=queue;
		
	}

	@Override
	public void run() {
		
		while(true)
		{
	
			try {
				HttpRequest request = queue.take();
				Thread thread = new Thread(request);
				thread.start();
				System.out.println(request.socket);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

}
