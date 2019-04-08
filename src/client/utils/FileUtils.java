package client.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileUtils {
	private List<String> wortListe = new ArrayList<String>();
	  
	
	public FileUtils() {
		createWortListe();
	}
	
	public String wortAufbereiten(String wort) {
		/*
		 * TODO große umlaute abfangen
		 */
		wort = wort.replaceAll("ä", "ae");
		wort = wort.replaceAll("ö", "oe");
		wort = wort.replaceAll("ü", "ue");
		wort = wort.replaceAll("ß", "ss");
		return wort.replaceAll("[^a-zA-Z]", "");
	}
	
	public String getRandomWord() {
		return wortListe.get(new Random().nextInt(wortListe.size())).toUpperCase();
	}
	
	private void createWortListe() {
		try {
		    String path = this.getClass().getResource("/files/wortliste.txt").toString().replaceFirst("file:/", "");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
		    String wort = "";
		    
		    while (wort != null) {
    	    	if(wort != null && !wort.equals("")) {
    	    		wort = wortAufbereiten(wort);
    	    		wortListe.add(wort);
    	    	}
    	     	wort = br.readLine();
    	    }
    	   br.close();
		    
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
