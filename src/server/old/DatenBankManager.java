package server.old;

import client.old.utils.PasswortEncrypter;
import server.old.database.Connector;

public class DatenBankManager {

	public static void main(String[] args) {
		
		PasswortEncrypter pwCrypt = new PasswortEncrypter();
		
		String decryptedPW = pwCrypt.encryptPassword("apfelkuchen");
		Connector connector = new Connector();
//		if(connector.addNewUser("kleinerTesto", decryptedPW)==1) {
//			System.out.println("User wurde erfolgreich angelegt");
//		}
		System.out.println(connector.checkForUserName("kleinerTesto"));
		User user = connector.login("kleinerTesto", decryptedPW);
		System.out.println(user.getUserName()+" hat sich gerade eingeloggt");
		System.out.println(user.getGamesPlayed());
		System.out.println(user.getGamesWon());
		System.out.println(user.isActive());
		connector.closeConnection();
		System.out.println("Verbindung wurde geschlossen");
		
		
	}



}
