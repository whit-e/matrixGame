package client.utils;

public class PasswortDecrypter {
/*
 * Benötigt das Passwort beim erstellen der Klasse
 */
	private String decryptedPassword;
	
	public PasswortDecrypter() {
		
	}
	
	public String decryptPassword(String pw) {
		padPw(pw);
		return decryptedPassword;
	}
	
	//Wandelt das passwort ins Binärsystem um und padded es auf 512 zeichen
	private void padPw(String pw) {
		final int length = 512;
		String binärPw = convertPwToBin(pw);
		char[] paddedPW = new char[length];
		int countedLength = length-1;
		int spaceToFill = length-((length/binärPw.length())*binärPw.length());   //restliche noch zu füllenden zeichen im charArray
		for(int i = 0; i < length/binärPw.length(); i++) {
			for(int j = 0; j < binärPw.length(); j++) {
				paddedPW[countedLength--] = binärPw.charAt(j); 
			}
		}
		int lengthOfBinPw = binärPw.length()-1;
		for(int i = spaceToFill; i >= 0; i--) {
			paddedPW[i] = binärPw.charAt(lengthOfBinPw--);
		}
		changeToString(paddedPW, length);
	}
	
	//Wandelt den String ins binärsystem um 
	private String convertPwToBin(String pw) {
		StringBuilder sb = new StringBuilder();
		for(char c: pw.toCharArray()) {
			sb = sb.append(Integer.toBinaryString(Integer.valueOf(c)));
		}
		return sb.toString();
	}
	
	//Wandelt das char[] in ein String[] um 
	private void changeToString(char[] paddedPW, final int length) {
		String[] binString = new String[(length/32)-1];
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < paddedPW.length ; i++) {
			if(i!=0) {
				sb = sb.append(paddedPW[i]);
			}
			if(i%32==0&&i!=0) {
				binString[counter++] = sb.toString();
				sb = new StringBuilder();
			}
		}
		SplitArrayInHalf(binString);
	}
	
	//jedes Array-Element wird in der mitte gespalten und auf einer der beiden Liste übergeben
	private void SplitArrayInHalf(String[] binString) {
		String[] firstHalf = new String[binString.length];
		String[] secondHalf = new String[binString.length];
		int counter = 0;
		for(String s :binString) {
			firstHalf[counter] = s.substring(0,s.length()/2);
			secondHalf[counter++] = s.substring(s.length()/2,s.length());
		}
		secondHalf = bitFlipping(secondHalf);
		for(int i = 0; i < firstHalf.length;i++) {
		}
		settleTheBinCode(firstHalf, secondHalf);
	}
	
	//Flippt jedes Bit
	private String[] bitFlipping(String[] secondHalf) {
		String[] flipped = new String[secondHalf.length];
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		for(String s: secondHalf) {
			for(int i = 0 ; i < s.length(); i++) {
				if(s.charAt(i)=='1') {
					sb = sb.append(0);
				}else {
					sb = sb.append(1);
				}
			}
			flipped[counter++] = sb.toString();
			sb = new StringBuilder();
		}
		return flipped;
	}
	
	//Verrechnung der 2 teile in Hexadezimal
	private void settleTheBinCode(String[] frontSplit, String[] backSplit) {
		String[] xOrArray = new String[frontSplit.length]; 					//Länge -> 15 je 16 werte = 240 werte
		for(int i = 0 ; i < frontSplit.length;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < frontSplit[i].length();j++) {
					//XOR
					if((frontSplit[i].charAt(j)=='0'&& backSplit[i].charAt(j)=='0')||(frontSplit[i].charAt(j)=='1'&&backSplit[i].charAt(j)=='1')){
						sb = sb.append('0');
					}else {
						sb = sb.append('1');
					}
			}
			xOrArray[i] = sb.toString();
		}
		createHexCode(xOrArray);
	}
	
	//Kreiert aus dem String[] eine Hexadezimalzahl
	private void createHexCode(String[] xOrArray) {
		StringBuilder sb = new StringBuilder();
		for(String s: xOrArray) {sb = sb.append(Integer.toHexString(Integer.parseInt(s,2)));}
		this.decryptedPassword = sb.toString();
	}
}
