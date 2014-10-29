import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.omg.CORBA.Request;


public class webserver {
	private static BlockingQueue<Socket> queue =
		      new LinkedBlockingQueue<Socket>(1);
	
	ServerSocket serversocket = null;
	
	public static void accept(Socket socket)
	{
		queue.add(socket);
	}
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		
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
			//accept(s.accept());
			remote = s.accept();
			}
			catch (Exception e) { 
		        System.out.println("Error: " + e);
			}
			HttpRequest request = new HttpRequest(remote);
			Thread thread = new Thread(request);
			thread.start();
		}
		
	}

}
