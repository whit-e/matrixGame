package client.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import client.utils.MessageProtocol;
import server.Server;

public class ClientSocket {

	private Socket socket;
	private ClientSocketThread clientSocketThread;
	private MessageProtocol messageProtocol;
	private PrintWriter writer;
	
	
	public Socket getSocket() { return this.socket; }
	public MessageProtocol getMessageProtocol() { return this.messageProtocol; }
	
	public ClientSocket() {
		
		
		try {
			
			this.socket = new Socket("localhost", Server.serverPort);
			this.writer = new PrintWriter(this.socket.getOutputStream(), true);
			this.clientSocketThread = new ClientSocketThread(this);
			this.clientSocketThread.start();
			this.messageProtocol = new MessageProtocol(this);
			
			
			
			
			
			// "insertUsername~~~max~~username
			// " ".startsWith(insertUsername) -> insertUsername(string.split(~~))
			
			// isUserAvailable~~~max
			// startsWith.... -> sendeNachricht(users.contains("max"));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendMessage(String message) {
		this.writer.println(message);
		this.writer.flush();
	}
	
	
	
	
}
