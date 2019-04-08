package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import server.database.DatabaseConnection;
import server.database.DatabaseConnectionMock;

public class Server {
	
	public static int serverPort = 1337;
	private ServerSocket server;
	private DatabaseConnection databaseConnection;
	private ArrayList<User> users = new ArrayList<User>();
	
	public DatabaseConnection getDatabase() { return this.databaseConnection; }
	public ArrayList<User> getUsers() { return this.users; }
	
	public Server() {
		
		this.databaseConnection = new DatabaseConnection();
		this.databaseConnection.connect();
		if(!this.databaseConnection.isSuccessfully()) {
			this.databaseConnection = new DatabaseConnectionMock();
		}
		
	
	}
	
	// insertUser(User) {
		// db.insertUser(User)
		// users.add(User)
		// return true;
	// }
	
	
	// isUsernameAvailable(String "max") {
		// return users.contains("max");
	//}
	
	
	public void start() {
		try {
			this.server = new ServerSocket(serverPort);
			System.out.println("Server gestartet");
			
			listAllUsers();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Verbindung zum Server konnte nicht hergestellt werden.");
		}
	}
	
	private void listAllUsers() {
		this.databaseConnection.getUsers();
	}
	
	public void waitForClient() {
		
		Socket client;
		
		while(true) {
			
			try {
				client = server.accept();
				OutputStream out = client.getOutputStream();
				PrintWriter writer = new PrintWriter(out);
				
				InputStream in = client.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				
				String incomingText = null;
				
				while((incomingText = reader.readLine()) != null) {
					System.out.println(incomingText);
				}
				
				writer.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
		server.waitForClient();
	}
	
}
