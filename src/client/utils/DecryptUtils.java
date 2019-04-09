package src.client.utils;

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
	
	public static void main(String[] args) {
		DecryptUtils test = new DecryptUtils();
		test.getEncryptedString("ސܰހ̀ܠސߠ̀ݐސߠ̀ذܐࡀࢠ");
	}
	
	/*
	 * Decrypt the given String
	 */
	public String getEncryptedString(String username) {
		StringBuilder sb = new StringBuilder();
		for(Character c:username.toCharArray()) {
			sb.append((char)((c.hashCode()/username.length()-username.length())));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	
}
