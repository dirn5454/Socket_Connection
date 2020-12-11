import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {

	private Socket main_socket;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			
			BufferedReader tempbf = new BufferedReader(new InputStreamReader(main_socket.getInputStream()));
			String receiveString;
			
			while(true) {
				
				receiveString = tempbf.readLine();
				System.out.println("»ó´ë¹æ: " + receiveString);
				
			}
			
		}catch(IOException e) {
			e.getStackTrace();
			
		}
	}
	public void setSocket(Socket socket) {
		main_socket = socket;
	}
	
	

}
