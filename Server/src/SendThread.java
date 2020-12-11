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
			// 키보드의 입력으로부터 데이터를 받아 tempbf버퍼에 전달
			PrintWriter sendWriter = new PrintWriter(main_socket.getOutputStream());
			//소켓과 연결된 클라이언트에게 OutputStream을 사용해 데이터를 전달
			String sendString;
			
			while(true) {
				sendString = tempbf.readLine();
				//tempbf에서 데이터를 한 라인씩 읽어옴
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