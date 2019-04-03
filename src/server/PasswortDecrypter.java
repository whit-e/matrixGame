package server;


import java.util.ArrayList;

public class PasswortDecrypter {
	public PasswortDecrypter(String pw) {
		//gebe Passwort an erste Instanz (padding)
		padPw(pw);
	}
	private final int length = 184;

	public static void main(String[] args) {
		new PasswortDecrypter("testPasswr458!");
		
	}
	
	//Padding Methode (Verlängerung des Passwortes auf XXX zeichen
	private String padPw(String pw) {
		//Padding des pw auf 160 zeichen 
		char[] paddedPW = new char[length];
		int counter = 171;
		for(int i = pw.length()-1;i>=0;i--) {
		paddedPW[counter] = pw.charAt(i);
		counter--;
		}
		for(int i = counter;i>=0;i--) {
			paddedPW[i] = '0';
		}
		counter = 0;
		return splitArray(paddedPW);
	}

	//Splittung des passwortes in 2 gleich große teile 
	private String splitArray(char[] paddedPW) {
		char[] frontSplit = new char[length/2];
		char[] backSplit = new char[length/2];
		int counterFront = 0;
		int counterBack = 0;
		for(int i = 0; i < paddedPW.length ; i++) {
			if(i%2 == 1) {
				frontSplit[counterFront] = paddedPW[i];
				counterFront++;
			}else {
				backSplit[counterBack] = paddedPW[i];
				counterBack++;
			}
		}
		return transferToHex(frontSplit, backSplit);
	}
	//Verrechnung der 2 teile in Hexadezimal jedes array  = länge 80
	private String transferToHex(char[] frontSplit, char[] backSplit) {
		ArrayList<String> frontHex = convertString(frontSplit); 				//80x32er länge -> 4rer blöcke 
		ArrayList<String> backHex = convertString(backSplit); 					//80x32er Länge -> 4rer blöcke
		//Erzeuge 32er Blöcke 
		frontHex = convertToHexBlocks(frontHex);
		backHex = convertToHexBlocks(backHex);
		
		System.out.println(frontHex.size());
		System.out.println(backHex.size());
		
		ArrayList<String> switchedBackHex = new ArrayList<>();
		
		System.out.println("umdrehung");
		for(int i = 0 ; i < backHex.size()-1;i++) {
			String s = backHex.get(i);
			System.out.println(i);
			System.out.println(s+"    "+s.length());
			System.out.println(Long.toBinaryString(Integer.toUnsignedLong(~Integer.valueOf(s)) | 0x100000000L ).substring(1));
			switchedBackHex.add(Long.toBinaryString(Integer.toUnsignedLong(~Integer.valueOf(s)) | 0x100000000L ).substring(1));
		}
		for(int i = 0 ; i < frontHex.size();i++) {
			System.out.println("front: \t"+frontHex.get(i));
			System.out.println("back: \t"+backHex.get(i));
		}
		return null;
	}
	
	//rechnet die 32er bitBlöcke in hexadezimal um 
	private ArrayList<String> convertToHexBlocks(ArrayList<String> list) {
		ArrayList<String> hexList = new ArrayList<>();
		//Hier sollte nun die berechnung eingeleitet werden
		for(int i = 0; i < list.size()-4;i+=4) {
				hexList.add(berechneHexWert(list.get(i),list.get(i+1),list.get(i+2),list.get(i+3),list.get(i+4)));
		}
		return hexList;
	}

	
	
	
	private String berechneHexWert(String a, String b, String c, String d, String e) {
		Integer parsed = Integer.parseUnsignedInt(a)^Integer.parseUnsignedInt(b);
		String test1 = Long.toBinaryString(Integer.toUnsignedLong(Integer.valueOf(parsed)) | 0x100000000L ).substring(1);
//		System.out.println("parsed: "+parsed);
//		System.out.println("long : "+test1+"  Länge: "+test1.length());
		
		return test1;
	}

	//5 Arrayeinträge mit je 16 werten
	private ArrayList<String> convertString(char[] array) {
		ArrayList<String> testList = new ArrayList<>();
		for(int i = 0; i < array.length;i++) {
			testList.add(Long.toBinaryString(Integer.toUnsignedLong(Integer.valueOf(array[i])) | 0x100000000L ).substring(1));
		}
		return testList;
	}
	//Setzt die 4er Strings zu 32er blöcken zusammen
	private ArrayList<String> get32erBlocks(ArrayList<String> transformable){
		ArrayList<String> transformedList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < transformable.size();i++) {
			sb = sb.append(transformable.get(i));
			if(i%4==0) {
				transformedList.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		return transformedList;
	}
	
	
	private ArrayList<String> splitIntoBlocks(ArrayList<String> list){
		ArrayList<String> splittetList = new ArrayList<>();
		for(String s :list) {
			for(int i = 1; i < s.length();i++) {
				if(i%4==0) {
					splittetList.add(s.substring(i, i+4));
				}
			}
		}
		return splittetList;
	}
	
	//rückgabe 
	
}
