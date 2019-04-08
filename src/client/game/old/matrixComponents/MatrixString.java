package client.game.old.matrixComponents;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import client.game.old.color.MatrixColor;

public class MatrixString extends MatrixChar{
	
	private ArrayList<MatrixChar> mList;
	/*
	 * Aus dem eingegebenen Wort werden alle buchstaben in einer 
	 * zufällige Reihenfolge in eine ArrayListe, welche MatrixChars beinhaltet übergeben
	 * Diese Liste wird mittels paint methode gezeichnet
	 */
	public MatrixString(String word) {
		this.word = word;
		createRandomCharList(word);
	}
	private String word;
	/*
	 * Kreiert aus dem Wort eine liste, in dessen die Buchstaben eine zufällige reihenfolge besitzen 
	 * Wird automatisch durch den Konstruktor aufgerufen
	 */
	private void createRandomCharList(String word) {
		String testWord = word;
		mList = new ArrayList<>();
		// Solange das testWord noch buchstaben besitzt, werden zufällig ausgewählte buchstaben aus dessen entfernt 
		// und der mList hinzugefügt 
		// -> zufällige reihenfolge der Buchstaben 
		while(!testWord.isEmpty()) {
			char rdChar = testWord.charAt(new Random().nextInt(testWord.length()));
			testWord = testWord.replaceFirst(rdChar+"", "");
			mList.add(new MatrixChar(rdChar));
		}
	}
	/*
	 * Gibt das Wort zurück, aus dem der MatrixString kreiert worden ist 
	 */
	public String getWord() {return this.word;}
	/*
	 * Paint Methode
	 * Benötigt (momentan noch) x und y koordinaten sowie die distanz wischen den jeweiligen buchstaben
	 */
	public void paint(Graphics g,int x,int y) {
		for(MatrixChar m:mList) {
			g.setColor(new MatrixColor().getMatrixCharColor());
			g.setFont(m.getFont().deriveFont(40F));
			g.drawString(""+m.getChar(), x, y-= new MatrixChar().getCharSize().intValue());
		}
	}
	
}
