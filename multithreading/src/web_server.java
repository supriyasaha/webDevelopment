import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class web_server {
	
	public static void main(String args[])throws IOException
	{
		BlockingQueue<HttpRequest> queue = new ArrayBlockingQueue<HttpRequest>(2);
		Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
		
	}

}
