package client.game;

import java.awt.Color;
import java.awt.Graphics;

import client.game.screens.Gamescreen;


public class Inputfield {
	//Word to resolve
	private String word;
	//Array which contains input of user(char)
	private char[] currentWord;
	//indicates the place in resolveAr
	private int currentPosition; 
	
	private Gamescreen gamescreen;
	
	//getter 
	public Gamescreen getGamescreen() { return this.gamescreen; }
	
	public Inputfield(Gamescreen gamescreen) {
		this.gamescreen = gamescreen;
		this.word = gamescreen.getSoughtWord();
		prepareWord();
	}
	
	public void render(Graphics g) {
		g.getFontMetrics();
		int charWidth = gamescreen.getContainer().getFontUtils().getMatrixFont().getSize();
		int x = ((gamescreen.getContainer().getWidth())-(gamescreen.getContainer().getWidth()%10))/2-((charWidth*(word.length()-word.length()%2))/2)-(charWidth*2);
		int y = gamescreen.getContainer().getHeight()-(gamescreen.getContainer().getHeight()/15);
		g.setColor(Color.white);
		for(int i = 0; i < currentWord.length;i++) {
			if(currentWord[i]=='w') {
				g.drawString(String.valueOf(currentWord[i]), x+=charWidth, y);
				charWidth = gamescreen.getContainer().getFontUtils().getMatrixFont().getSize()+5;
			}else {
				g.drawString(String.valueOf(currentWord[i]), x+=charWidth, y);
				charWidth = gamescreen.getContainer().getFontUtils().getMatrixFont().getSize();
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
		if(String.valueOf(currentWord).equals(word)) {
			return true;
		} else {
			return false;
		}
	}
	
		

}
