package server.database;

import java.util.ArrayList;

import client.User;

public class DatabaseConnectionMock extends DatabaseConnection {
	

	private ArrayList<String> usernames = new ArrayList<String>();
	private ArrayList<User> users = new ArrayList<User>();
	
	public DatabaseConnectionMock() {
		System.out.println("Verwende Datenbankmock.");
	}
	
	public boolean isUsernameAvailable(String username) {
		
		usernames.add("Maxi");
		usernames.add("Kai");
		if(usernames.contains(username)) {
			return true;
		}
		return false;
	}
	
	public void addUser(String username, String password) {
		this.users.add(new User(username, password));
	}
	
	public boolean checkLogindata(User user) {
		if(users.contains(user)) {
			return true;
		}
		return false;
	}
	
}
