import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;


public class HttpRequest implements Runnable {

	Socket socket;
	public HttpRequest(Socket remote) {
		
		this.socket=remote;
	}
	

	@Override
	public void run() {
		try
		{
			String str=".";
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			while(!str.equals(""))
				{str=br.readLine();}
			output.write(("request recieved").getBytes());
			
	        
			output.close();
			socket.close();
		}
		catch(Exception e)
		{
			System.out.println("error"+e);
		}
	}

}
