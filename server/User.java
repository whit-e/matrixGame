package server;

import java.net.ServerSocket;

/*
 * 
 */

public class User {
	public User(String userName, int gamesPlayed, int timePlayed, int gamesWon, boolean active) {
		this.userName= userName;
		this.gamesWon = gamesWon;
		this.timePlayed = timePlayed;
		this.gamesPlayed = gamesPlayed;
		this.active = active;
	}
	
	
	
	private void testMethode() {
		Server server = new Server();
		server.getServer();
		System.out.println(server.testMethodeOfServer("hannes"));
		
	}
	ServerSocket test;
	//Attribute
	private final String userName;
	private int gamesPlayed;
	private int gamesWon;
	private int timePlayed;
	private boolean active;
	//Getter&Setter
	public String getUserName() {return this.userName;}
	public int getGamesPlayed() {return gamesPlayed;}
	public void setGamesPlayed(int gamesPlayed) {this.gamesPlayed = gamesPlayed;}
	public int getGamesWon() {return gamesWon;}
	public void setGamesWon(int gamesWon) {this.gamesWon = gamesWon;}
	/*
	 * GameTime ist in Minuten
	 */
	public int getTimePlayed() {return timePlayed;}
	public void setTimePlayed(int timePlayed) {this.timePlayed = timePlayed;}
	public boolean isActive() {return active;}
	public void setActive(boolean active) {this.active = active;}
	
	
}
