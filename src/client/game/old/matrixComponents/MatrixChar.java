package client.game.old.matrixComponents;

import java.awt.Font;
/*
 * Die Klasse, aus der die jeweiligen MatrixStrings erstellt werden, 
 * charSize gibt die jeweilige Buchstabengröße an
 * Die Color erhält man aus der MatrixColor klasse 
 */
public class MatrixChar {
	public MatrixChar() {
		
	}
	public MatrixChar(char matrixChar) {
		this.matrixChar = matrixChar;
	}
	private char matrixChar;
	private Font font = new Font("TimesRoman", Font.BOLD, 25);
	private Float charSize = 40F;
	public Float getCharSize() {return this.charSize;}
	public Font getFont() {return this.font;}
	protected char getChar() {return this.matrixChar;}
	
}