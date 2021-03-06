import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable {

	
	protected BlockingQueue<HttpRequest> queue=null;
	public Producer(BlockingQueue<HttpRequest> queue) {
		this.queue=queue;
	}
	@SuppressWarnings("resource")
	@Override
	public void run() {
		ServerSocket s;

	    System.out.println("Webserver starting up on port 80");
	    System.out.println("(press ctrl-c to exit)");
	    try {
	      // create the main server socket
	      s = new ServerSocket(80);
	    } catch (Exception e) {
	      System.out.println("Error: " + e);
	      return;
	    }

		while(true)
		{
			Socket remote=null;
			try
			{
			
			remote= s.accept();
			
			}
			catch (Exception e) { 
		        System.out.println("Error: " + e);
			}
			HttpRequest request = new HttpRequest(remote);
			try {
				queue.put(request);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
