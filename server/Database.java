package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
	private Connection connection;
	
	public Database() {
		connect();
		getEverything();
	}
	
	private void connect() {
		String url = "jdbc:mysql://10.176.51.108:3306/matrix?serverTimezone=UTC";
		String username = "matrix_connector";
		String password = "matrix";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getEverything() {
		ResultSet result;
		
		try {
			result = connection.createStatement().executeQuery("select * from score");
			printOutResult(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void printOutResult(ResultSet result) throws SQLException {
		while(result.next())  
			System.out.println(result.getString(1));  
			  
	}
	
	
}
