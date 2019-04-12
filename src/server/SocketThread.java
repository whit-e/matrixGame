package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketThread extends Thread{

	private Socket socket;
	private PrintWriter writer;
	private Scanner reader;
	
	public SocketThread(Socket socket) {
		
		this.socket = socket;
		
		
		try {
			this.writer = new PrintWriter(this.socket.getOutputStream(), true);
			this.reader = new Scanner(this.socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
