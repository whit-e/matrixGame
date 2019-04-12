package client.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import server.Server;

public class ServerConnection {

	private Socket serverConnection;
	
	private OutputStream out;
	private PrintWriter writer;
	private InputStream in;
	private BufferedReader reader;
	
	public ServerConnection() {
		
		try {
			
			this.serverConnection = new Socket("localhost", Server.serverPort);
			
			out = this.serverConnection.getOutputStream();
			writer = new PrintWriter(out);
			
			in = this.serverConnection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			
			
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
		writer.println(message);
		writer.flush();
		writer.close();
	}
	
	public void getMessage() {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
