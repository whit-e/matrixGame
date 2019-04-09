package src.server.utils;


public class EncryptUtils {
	public static void main(String[] args) {
		EncryptUtils test = new EncryptUtils();
		test.getEncryptedString("ich bin ein Satz");
	}
	
	/*
	 * Encrypts the given String
	 */
	public String getEncryptedString(String username) {
		StringBuilder sb = new StringBuilder();
		for(Character c: username.toCharArray()) {
			sb.append((char)((c.hashCode()+username.length())*username.length()));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
