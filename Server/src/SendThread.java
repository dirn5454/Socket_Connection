import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread {

	private Socket main_socket;
	
	@Override
	public void run() {
		super.run();
	
		try {
			BufferedReader tempbf = new BufferedReader(new InputStreamReader(System.in));
			// Ű������ �Է����κ��� �����͸� �޾� tempbf���ۿ� ����
			PrintWriter sendWriter = new PrintWriter(main_socket.getOutputStream());
			//���ϰ� ����� Ŭ���̾�Ʈ���� OutputStream�� ����� �����͸� ����
			String sendString;
			
			while(true) {
				sendString = tempbf.readLine();
				//tempbf���� �����͸� �� ���ξ� �о��
				sendWriter.println(sendString);
				sendWriter.flush();
				
			}
			
		}catch(IOException e) {
			e.getStackTrace();
		}
	
	}
	public void setSocket(Socket socket) {
		main_socket = socket;
	}
	

}