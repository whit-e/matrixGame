package server.old.utils;


import server.old.ServerSocketThread;


public class MessageProtocol {

	//attributes
	private ServerSocketThread socketThread;
	
	public MessageProtocol(ServerSocketThread socketThread) {
		this.socketThread = socketThread;
	}
	
	
	public String handleMessage(String message) {
		String response = "Response test";
		
		if(message.startsWith("login")) {
			String[] loginInfo = message.split("~~~");
			loginInfo = loginInfo[1].split("~~");
			
			response = "login~~~" + socketThread.getServer().getDatabase().checkLogindata(loginInfo[0], loginInfo[1]);
		} else if(message.startsWith("quit")) {
			//Thread gets killed, if the programm is quit
			//Is there, so you dont't have threads running without any client actually using them
			this.socketThread.setRunning(false);
			this.socketThread.interrupt();
		}
		
		return response;
		
	}
	
}
