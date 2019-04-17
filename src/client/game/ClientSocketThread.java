package client.game;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;


public class ClientSocketThread extends Thread{
	
	private ClientSocket socket;
	private Scanner reader;
	
	public ClientSocketThread(ClientSocket socket) {
		this.socket = socket;
		
		try {
			this.reader = new Scanner(this.socket.getSocket().getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		String response;
		//listening for incoming messages
		while(true) {
			while(this.reader.hasNextLine()) {
				response = this.reader.nextLine();
				System.out.println(response);
				this.socket.getMessageProtocol().handleMessage(response);
			}
		}
	}
	
}
