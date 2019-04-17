package client.utils;

import client.game.ClientSocket;

public class MessageProtocol {

	private String loginInfo;
	private String registerInfo;
	private EncryptUtils encryptUtils;
	private ClientSocket clientSocket;
	
	private boolean isLoginSuccesful = false;
	
	//getter
	public boolean isLoginSuccesful() { return this.isLoginSuccesful; }
	
	public MessageProtocol(ClientSocket clientSocket) {
		this.encryptUtils = new EncryptUtils();
		this.clientSocket = clientSocket;
	}
	
	public void handleMessage(String message) {
		if(message.startsWith("login")) {
			message = message.split("~~~")[1];
			if(message.startsWith("true")) {
				isLoginSuccesful = true;
			} else {
				isLoginSuccesful = false;
			}
		}
	}
	
	
	public void prepareLogin(String username, String password) {
		
		this.loginInfo = "login~~~" + encryptUtils.encryptUsername(username) + 
				"~~" + encryptUtils.encryptPassword(password);
		this.clientSocket.sendMessage(this.loginInfo);
		
	}
	
	public void prepareRegister(String username, String password) {
		
		this.registerInfo = "register~~~" + encryptUtils.encryptUsername(username) + 
				"~~" + encryptUtils.encryptPassword(password);
		
		this.clientSocket.sendMessage(this.registerInfo);
	}
	
	public void prepareIsRegisterPossible(String username, String password) {
		
		this.registerInfo = "isRegisterPossible~~~" + encryptUtils.encryptUsername(username) + 
				"~~" + encryptUtils.encryptPassword(password);
		
		this.clientSocket.sendMessage(this.registerInfo);
	}
	
	public void disposeSocket() {
		this.clientSocket.sendMessage("quit");
	}
	
}
