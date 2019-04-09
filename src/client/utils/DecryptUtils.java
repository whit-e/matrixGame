package client.utils;

public class DecryptUtils {
	
	private String loginInfo;
	private String registerInfo;
	private PasswortDecrypter pwDecrypter;
	
	public DecryptUtils() {
		
	}
	
	public String prepareLogin(String username, String password) {
		
		this.loginInfo = "login~~~" + username + "~~" + pwDecrypter.decryptPassword(password);
		return loginInfo;
	}
	
	public String prepareRegister(String username, String password) {
		
		this.registerInfo = "register~~~" + username + "~~" + pwDecrypter.decryptPassword(password);
		return registerInfo;
	}
	
	public String prepareIsRegisterPossible(String username, String password) {
		
		this.registerInfo = "isRegisterPossible~~~" + username + "~~" + pwDecrypter.decryptPassword(password);
		return registerInfo;
	}
	
	
	
}
