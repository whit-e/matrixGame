package client.old.game;

import java.io.IOException;
import java.util.Scanner;

public class ClientSocketThread extends Thread {

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

	@Override
	public void run() {
		String response;
		// listening for incoming messages
		while (true) {
			while (this.reader.hasNextLine()) {
				response = this.reader.nextLine();
				System.out.println(response);
				this.socket.getMessageProtocol().handleMessage(response);
			}
		}
	}

}
