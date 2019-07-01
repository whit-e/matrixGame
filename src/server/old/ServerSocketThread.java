package server.old;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import server.old.utils.MessageProtocol;

public class ServerSocketThread extends Thread{

	//attributes
	private Server server;
	private Socket socket;
	private PrintWriter writer;
	private Scanner reader;
	private MessageProtocol protocol;
	private boolean running;
	
	//getter & setter
	public Server getServer() { return this.server; }
	public void setRunning(boolean running) { this.running = running; }
	
	public ServerSocketThread(Server server) {
		
		this.server = server;
		this.running = true;
		this.socket = server.getSocket();
		this.protocol = new MessageProtocol(this);
		
		try {
			this.writer = new PrintWriter(this.socket.getOutputStream(), true);
			this.reader = new Scanner(this.socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
		String incomingMessage, response;
		
		//wait for incoming messages and respond to them
		while(running) {
			
			while(this.reader.hasNextLine()) {
				incomingMessage = this.reader.nextLine();
				System.out.println(incomingMessage);
				response = this.protocol.handleMessage(incomingMessage);
				
				this.writer.println(response);
				this.writer.flush();
			}
			
		}
		
		System.out.println("Client " + socket + " hat Server verlassen.");
	}
	
}
