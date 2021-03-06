package server.old.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.old.utils.DecryptUtils;

public class DatabaseConnection {
	
	//attributes 
	private Connection connection;
	private DecryptUtils decryptUtils;
	private ResultSet result;
	
	private boolean isConnected = false;
	
	public DatabaseConnection() {
		this.decryptUtils = new DecryptUtils();
	}
	
	public void connect() {
		String url = "jdbc:mysql://10.176.51.108:3306/matrix?serverTimezone=UTC";
		String username = "matrix_connector";
		String password = "matrix";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Erfolgreich mit Datenbank verbunden!");
			isConnected = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Konnte keine Verbindung mit der Datenbank herstellen.");
		}
		
		
		
	}
	
	public void getUsers() {
		
	}
	
	public boolean isUsernameAvailable(String username) {
		try {
			result = connection.createStatement().executeQuery(
					"Select userName from user where userName = '" + username + "'"
				);
			
			if(result.next() == false) {
				System.out.println(true);
				return true;
			} else {
				System.out.println(false);
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void addUser(String username, String password) {
		try {
			connection.createStatement().executeUpdate("insert into user ( userName, password)" +
				"values ('" + username + "', '" + password + "')"
			);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkLogindata(String username, String password) {
		try {
			result = connection.createStatement().executeQuery(
					"select userName, password from user " +
					"where userName = '" + decryptUtils.decryptUsername(username) + "' and password = '" + password + "'"
			);
			
			boolean isDataCorrect = false;
			while(result.next())  {
				if(
					result.getString(1).equals(decryptUtils.decryptUsername(username)) && 
					result.getString(2).equals(password)
				) {
					isDataCorrect = true;
				} else {
					isDataCorrect = false;
				}
			}
			return isDataCorrect;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
//	private void printOutResult(ResultSet result) throws SQLException {
//		while(result.next())  
//			System.out.println(result.getString(1));  
//			  
//	}

	public boolean isSuccessfully() {
		return this.isConnected;
	}
	
	
}
