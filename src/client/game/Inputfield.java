package client.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.util.HashMap;
import java.util.Map;

import client.game.screens.Gamescreen;
import client.utils.FontUtils;


public class Inputfield {
	//Word to resolve
	private String word;
	//Array which contains input of user(char)
	private char[] currentWord;
	//indicates the position in the currentWord
	private int currentPosition; 
	//The Spacing between each Char (at Drawing)
	private final double charSpacing = 0.1;
	private Font font; 
	private final int MAXFONTSIZE = 70;
	private Gamescreen gamescreen;
	
	
	//getter 
	public Gamescreen getGamescreen() { 
		return this.gamescreen; 
	}
	
	public Inputfield(Gamescreen gamescreen) {
		this.gamescreen = gamescreen;
		this.word = gamescreen.getSoughtWord();
		font = checkForCharSize();
		prepareWord();
	}
	
	
	//Checks if the String full of w would be larger as the screen if so it resizes the Font till it fit´s again
	private Font checkForCharSize() {
		Map<TextAttribute, Object> attributes = new HashMap<>();
		attributes.put(TextAttribute.TRACKING, charSpacing);
		//Test Font till we install the real Font 
		Font f = gamescreen.getContainer().getFontUtils().getMatrixGameFont().deriveFont(attributes);
		int newSize = f.getSize();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < word.length();i++) {
			sb.append('w');
		}
		int maxCharBound = (int)(new TextLayout(sb.toString(), f, new FontRenderContext(f.getTransform(),false,false)).getBounds().getWidth());
		//Makes the Font smaller till it fit´s on the screen (with a padding of 50 each side)
		if(maxCharBound+120>gamescreen.getContainer().getWidth()) {
			while(maxCharBound+100>gamescreen.getContainer().getWidth()) {
				f = new Font(f.getName(), f.getStyle(), newSize--).deriveFont(attributes);
				maxCharBound = (int)(new TextLayout(sb.toString(), f, new FontRenderContext(f.getTransform(),false,false)).getBounds().getWidth());
			}
		//Expands the Font till it stays on a good Size BUT not larger than MAXFONTSIZE
		}
		else {
			while(maxCharBound+100 <gamescreen.getContainer().getWidth()-100 && f.getSize()<=MAXFONTSIZE) {
				f = new Font(f.getName(), f.getStyle(), newSize++).deriveFont(attributes);
				maxCharBound = (int)(new TextLayout(sb.toString(), f, new FontRenderContext(f.getTransform(),false,false)).getBounds().getWidth());
			}
		}
		return f;
	}
	
	public void render(Graphics g) {
		g.setFont(font);
//		g.getFontMetrics();
		int x = gamescreen.getContainer().getWidth()/2-(int)(new TextLayout(String.valueOf(currentWord), g.getFont(), new FontRenderContext(g.getFont().getTransform(),false,false)).getBounds().getWidth()/2);
		int y = gamescreen.getContainer().getHeight()-(gamescreen.getContainer().getHeight()/15);
		g.setColor(Color.white);
		g.drawString(String.valueOf(currentWord), x, y);
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
