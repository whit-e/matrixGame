package server.connection;

import java.sql.*;
import javax.sql.*;

import server.PasswortDecrypter;

public class Connector {
	
	public Connector() {
		connect();
	}
	private Connection connection;
	
	private void connect() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
		String username = "matrix_connector";
		String pw = "matrix";
		try {
			connection = DriverManager.getConnection(url,username,pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Legt einen neuen User in der Datenbank an, 
	 * @RETURN 1 = angelegt
	 */
	public int addNewUser(String userName, String decryptedPassword) {
		try {
			Statement st = connection.createStatement();
			String statement = "INSERT INTO testuser (name,password) VALUES ('"+userName+"','"+decryptedPassword+"')";
//			rs = st.execute(statement);
			return st.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
