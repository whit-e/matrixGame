package server.old;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.old.database.DatabaseConnection;
import server.old.database.DatabaseConnectionMock;

public class Server {
	
	public static int serverPort = 1337;
	private ServerSocket server;
	private DatabaseConnection databaseConnection;
	private Socket socket;
	
	public DatabaseConnection getDatabase() { return this.databaseConnection; }
	public Socket getSocket() { return this.socket; }
	
	public Server() {
		
		//checks if connection to database was succesfull
		this.databaseConnection = new DatabaseConnection();
		this.databaseConnection.connect();
		if(!this.databaseConnection.isSuccessfully()) {
			this.databaseConnection = new DatabaseConnectionMock();
		}
		
	}
	
	
	public void start() {
		try {
			this.server = new ServerSocket(serverPort);
			System.out.println("Server gestartet");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Verbindung zum Server konnte nicht hergestellt werden.");
		}
	}
	
	public void waitForClient() {
		while(true) {
			try {
				System.out.println("Warte auf Client...");
				
				socket = server.accept();
				new ServerSocketThread(this).start();
				
				System.out.println("Neuer Client:" + socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
		}
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
		server.waitForClient();
	}
	
}
