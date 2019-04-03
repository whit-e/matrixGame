package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static int serverPort = 1337;
	
	
	public static void main(String[] args) {
		try {
					
			ServerSocket server = new ServerSocket(serverPort);
			
			System.out.println("Server gestartet");
			
			while(true) {
				Socket client = server.accept();
				
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
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
