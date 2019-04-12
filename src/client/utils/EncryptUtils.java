package client.utils;

public class EncryptUtils {
	
	private String loginInfo;
	private String registerInfo;
	private PasswortDecrypter pwEncrypter;
	
	
	public EncryptUtils() {
		this.pwEncrypter = new PasswortDecrypter();
	}
	
	public String prepareLogin(String username, String password) {
		
		this.loginInfo = "login~~~" + encryptUsername(username) + "~~" + pwEncrypter.decryptPassword(password);
		return loginInfo;
	}
	
	public String prepareRegister(String username, String password) {
		
		this.registerInfo = "register~~~" + encryptUsername(username) + "~~" + pwEncrypter.decryptPassword(password);
		return registerInfo;
	}
	
	public String prepareIsRegisterPossible(String username, String password) {
		
		this.registerInfo = "isRegisterPossible~~~" + encryptUsername(username) + "~~" + pwEncrypter.decryptPassword(password);
		return registerInfo;
	}
	
	/*
	 * Encrypts the given String
	 */
	public String encryptUsername(String username) {
		StringBuilder sb = new StringBuilder();
		for(Character c: username.toCharArray()) {
			sb.append((char)((c.hashCode() + username.length()) * username.length()));
		}
		
		return sb.toString();
	}
	
	
	
}
