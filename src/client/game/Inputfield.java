package client.game;

import java.awt.Color;
import java.awt.Graphics;

import client.game.screens.Gamescreen;


public class Inputfield {
	//Word to resolve
	private String word;
	//available chars 
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
		
		int x = 50;
		int y = 600;
		g.setColor(Color.white);
		for(char c: currentWord) {
			g.drawString(String.valueOf(c), x+=30, y);
		}
	}
	
	//deletes the last char and reduces counter
	public void deleteLastChar() {
		if(currentPosition > 0 && currentPosition <= word.length()+1) {
			currentPosition--;
		}
		currentWord[currentPosition] = '_';
	}
	//adds char to array and raises counter
	public void addCharToArr(char character) {
		currentWord[currentPosition] = character;
		if(currentPosition >=0 && currentPosition < word.length()-1) {
			currentPosition++;
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
