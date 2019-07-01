package client.old.utils;

public class EncryptUtils {
	

	private PasswortEncrypter pwEncrypter;
	
	
	public EncryptUtils() {
		this.pwEncrypter = new PasswortEncrypter();
	}
	
	public String encryptPassword(String password) {
		return this.pwEncrypter.encryptPassword(password);
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
