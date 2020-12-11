import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) {
		
		try {
		ServerSocket server_socket = new ServerSocket(8888);
		Socket client_socket = server_socket.accept();
		
		//수신스레드 생성, 소켄전달
		ReceiveThread receive_thread = new ReceiveThread();
		receive_thread.setSocket(client_socket);
		
		//송신스레드 생성, 소켓전달
		SendThread send_thread = new SendThread();
		send_thread.setSocket(client_socket);
		
		//스레드 실행
		receive_thread.start();
		send_thread.start();
		
		}catch(IOException e) {
			e.getStackTrace();
			
		}
	}

}
