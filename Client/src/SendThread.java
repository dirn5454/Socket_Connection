import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread {

	private Socket main_socket;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	
		try {
			BufferedReader tempbf = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter sendWriter = new PrintWriter(main_socket.getOutputStream());
			
			String sendString;
			
			while(true) {
				sendString = tempbf.readLine();
				
				//exit �Է½� ���� ������ ���� ���α׷� ����
				if(sendString.equals("exit")) 
					break;
			
				sendWriter.println(sendString);
				sendWriter.flush();
			}
			
			sendWriter.close();
			tempbf.close();
			main_socket.close();
			
		}catch(IOException e) {
			e.getStackTrace();
		}
	
	}
	public void setSocket(Socket socket) {
		main_socket = socket;
	}
	

}
