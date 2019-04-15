package server.utils;

public class DecryptUtils {
	/*
	 * Decrypt the given String
	 */
	public String decryptUsername(String username) {
		StringBuilder sb = new StringBuilder();
		for(Character c : username.toCharArray()) {
			sb.append((char)(c.hashCode()/username.length()-username.length()));
		}
	
		
		return sb.toString();
	}
}
