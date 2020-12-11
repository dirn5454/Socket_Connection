import java.io.IOException;
import java.net.Socket;

public class MainClient {

	public static void main(String[] args) {
	
		
		try {
		Socket client_socket = new Socket("192.168.56.1", 8888);
		
		ReceiveThread receive_thread = new ReceiveThread();
		receive_thread.setSocket(client_socket);
		
		SendThread send_thread = new SendThread();
		send_thread.setSocket(client_socket);
		
		receive_thread.start();
		send_thread.start();
		
		}catch(IOException e) {
			e.getStackTrace();
			
		}

	}

}
