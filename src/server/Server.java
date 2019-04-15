package server;

import java.io.IOException;
import java.net.ServerSocket;

import server.database.DatabaseConnection;
import server.database.DatabaseConnectionMock;

public class Server {
	
	public static int serverPort = 1337;
	private ServerSocket server;
	private DatabaseConnection databaseConnection;
	
	public DatabaseConnection getDatabase() { return this.databaseConnection; }
	
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
				new SocketThread(server.accept()).start();
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
