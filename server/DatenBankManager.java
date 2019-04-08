package server;

import java.sql.*;

import javax.sql.*;

import server.connection.Connector;
public class DatenBankManager {

	public DatenBankManager() {
		this.connector = new Connector();
	}
	private Connector connector;
	
	public static void main(String[] args) {
		DatenBankManager dbm = new DatenBankManager();
		dbm.test();
		
	}
	
	private void test() {
		PasswortDecrypter pwCrypt = new PasswortDecrypter();
		String decryptedPW = pwCrypt.decryptPassword("apfelkuchen");
//		if(connector.addNewUser("kleinerTesto", decryptedPW)==1) {
//			System.out.println("User wurde erfolgreich angelegt");
//		}
		System.out.println(connector.checkForUserName("kleinerTesto"));
		User user = connector.login("kleinerTesto", decryptedPW);
		System.out.println(user.getUserName()+" hat sich gerade eingeloggt");
		System.out.println(user.getGamesPlayed());
		System.out.println(user.getGamesWon());
		System.out.println(user.isActive());
		System.out.println("Verbindung wurde geschlossen");
		
	}

	public boolean testUserName(String name) {
		return connector.checkForUserName(name);
	}

}
