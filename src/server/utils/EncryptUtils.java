package server.utils;

public class EncryptUtils {
	/*
	 * Encrypts the given String
	 */
	public String getEncryptedString(String username) {
		StringBuilder sb = new StringBuilder();
		for(Character c: username.toCharArray()) {
			sb.append((char)((c.hashCode()+username.length())*username.length()));
		}
		return sb.toString();
	}
	
	
}