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
			// InputStream값을 사용하기 편하게 하기 위해 BufferedReader로 변경
			String receiveString;
			
			while(true) {
				
				receiveString = tempbf.readLine();
				
				if(receiveString == null) {
					System.out.println("상대방 연결이 끊겼습니다.");
					break;
				}
				else {
					System.out.println("상대방: " + receiveString);
				}
			}
			
		}catch(IOException e) {
			e.getStackTrace();
			
		}
	}
	public void setSocket(Socket socket) {
		main_socket = socket;
	}
	
	

}
