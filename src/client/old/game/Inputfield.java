package client.old.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.util.HashMap;
import java.util.Map;

import client.old.game.screens.Gamescreen;


public class Inputfield {
	//Word to resolve
	private String word;
	//Array which contains input of user(char)
	private char[] currentWord;
	//indicates the position in the currentWord
	private int currentPosition; 
	//The Spacing between each Char (at Drawing)
	private final double charSpacing = 0.5;
	private Gamescreen gamescreen;
	
	
	//getter 
	public Gamescreen getGamescreen() { 
		return this.gamescreen; 
	}
	
	public Inputfield(Gamescreen gamescreen) {
		this.gamescreen = gamescreen;
		this.word = gamescreen.getSoughtWord();
		prepareWord();
	}
	
	//maximale bounds benutzen
	private Graphics checkForCharSize(Graphics g) {
		Font f = g.getFont();
		int newSize = f.getSize();
		int maxCharBound = (int)(new TextLayout(String.valueOf(currentWord), g.getFont(), new FontRenderContext(g.getFont().getTransform(),false,false)).getBounds().getWidth());
		if(maxCharBound+100>gamescreen.getContainer().getWidth()) {
			g.setFont(new Font(g.getFont().getName(), g.getFont().getStyle(), newSize--));
		};
		return g;
	}
	
	public void render(Graphics g) {
		Map<TextAttribute, Object> attributes = new HashMap<>();
		attributes.put(TextAttribute.TRACKING, charSpacing);
		g.setFont(g.getFont().deriveFont(attributes));
		g.getFontMetrics();
		g = checkForCharSize(g);
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
