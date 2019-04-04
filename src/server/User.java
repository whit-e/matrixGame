package server;


/*
 * 
 */

public class User {
	//Attribute
	private String userName;
	private int gamesPlayed;
	private int gamesWon;
	private int timePlayed;
	private boolean active;
	//Getter&Setter
	public String getUserName() {return this.userName;}
	public void setUserName(String userName) {this.userName = userName;}
	public int getGamesPlayed() {return gamesPlayed;}
	public void setGamesPlayed(int gamesPlayed) {this.gamesPlayed = gamesPlayed;}
	public int getGamesWon() {return gamesWon;}
	public void setGamesWon(int gamesWon) {this.gamesWon = gamesWon;}
	public int getTimePlayed() {return timePlayed;}
	public void setTimePlayed(int timePlayed) {this.timePlayed = timePlayed;}
	public boolean isActive() {return active;}
	public void setActive(boolean active) {this.active = active;}
	
	
}
