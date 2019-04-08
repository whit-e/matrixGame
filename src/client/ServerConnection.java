package client;

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
	
	public ServerConnection() {
		
		try {
			
			this.serverConnection = new Socket("localhost", Server.serverPort);
			
			OutputStream out = this.serverConnection.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			
			InputStream in = this.serverConnection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			
			// "insertUsername~~~max~~username
			// " ".startsWith(insertUsername) -> insertUsername(string.split(~~))
			
			
			// isUserAvailable~~~max
			// startsWith.... -> sendeNachricht(users.contains("max"));
			writer.println("max");
			writer.flush();
			
			writer.close();
			reader.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
