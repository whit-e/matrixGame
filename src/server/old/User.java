package server.old;


public class User {

	//Attribute
	private final String userName;
	private int gamesPlayed;
	private String password;
	private int gamesWon;
	private int timePlayedMin;
	private boolean active;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, int gamesPlayed, int timePlayedMin, int gamesWon, boolean active) {
		this.userName= userName;
		this.gamesWon = gamesWon;
		this.timePlayedMin = timePlayedMin;
		this.gamesPlayed = gamesPlayed;
		this.active = active;
	}
	
	public void init() {
		
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public int getTimePlayedMin() {
		return timePlayedMin;
	}

	public void setTimePlayedMin(int timePlayedMin) {
		this.timePlayedMin = timePlayedMin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUserName() {
		return userName;
	}
}
