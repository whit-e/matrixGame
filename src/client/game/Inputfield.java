package client.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import client.game.screens.Gamescreen;


public class Inputfield {
	//Word to resolve
	private String word;
	//Array which contains input of user(char)
	private char[] currentWord;
	//indicates the position in the currentWord
	private int currentPosition; 
	private int charWidth;
	private int spaceBetweenChars;
	private Gamescreen gamescreen;
	
	//getter 
	public Gamescreen getGamescreen() { 
		return this.gamescreen; 
	}
	
	public Inputfield(Gamescreen gamescreen) {
		this.gamescreen = gamescreen;
		this.word = gamescreen.getSoughtWord();
		this.charWidth = gamescreen.getContainer().getFontUtils().getMatrixFont().getSize()/2+(gamescreen.getContainer().getFontUtils().getMatrixFont().getSize()/4);
		this.spaceBetweenChars = charWidth+5;
		
		prepareWord();
	}
	
	private Font checkForCharSize(Graphics g) {
		Font f = g.getFont();
		FontRenderContext con = new FontRenderContext(f.getTransform(), false, false);
		int maxCharBound = (int) ((word.length()-2)*charWidth+(2*(f.getMaxCharBounds(con).getWidth()))+100);
		if(maxCharBound>gamescreen.getContainer().getWidth()) {
			this.charWidth -=10;
			this.spaceBetweenChars = charWidth+10;
			f.deriveFont(charWidth);
			return checkForCharSize(g);
		};
		return f;
	}
	
	public void render(Graphics g) {
		g.getFontMetrics();
		g.setFont(checkForCharSize(g));
		int x = ((gamescreen.getContainer().getWidth())-(gamescreen.getContainer().getWidth()%10))/2-(charWidth*(word.length()))/2-(charWidth/2)-5;
		int y = gamescreen.getContainer().getHeight()-(gamescreen.getContainer().getHeight()/15);
		g.setColor(Color.white);
		for(int i = 0; i < currentWord.length;i++) {
			if(currentWord[i]=='w' && i !=word.length()-1) {
				g.drawString(String.valueOf(currentWord[i]), x+=spaceBetweenChars, y);
				spaceBetweenChars += 5;
			}else {
				g.drawString(String.valueOf(currentWord[i]), x+=spaceBetweenChars, y);
				this.spaceBetweenChars = charWidth;
			}
		}
	}
	
	//deletes the last char and reduces counter
	public void deleteLastChar() {
		for(int i = currentWord.length-1; i >=0 ; i--) {
			if(currentWord[i] !='_') {
				currentWord[i] ='_';
				currentPosition = i;
				break;
			}
		}
	
	}
	//adds char to array and raises counter
	public void addCharToArr(char character) {
		if(currentPosition >= 0 && currentPosition <=word.length()-2) {
			currentWord[currentPosition++] = character;
		}else {
			currentWord[currentPosition] = character;
		}
	}
	
	//Should send the users input to check if its the same 
	public void prepareWord() {
		currentPosition = 0;
		currentWord = new char[word.length()];
		for(int i = 0; i < currentWord.length;i++) {
			currentWord[i] = '_';
		}
	}
	
	public boolean isReadyToEnter() {
		if(String.valueOf(currentWord).contains("_")) {
			System.out.println("Buchstaben fehlen");
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checkWon() {
		if(String.valueOf(currentWord).toLowerCase().equals(word)) {
			return true;
		} else {
			return false;
		}
	}
	
		

}
