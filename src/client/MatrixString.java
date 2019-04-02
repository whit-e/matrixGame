package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;



public class MatrixString extends Thread implements Runnable{
	
	private Game game;
	private int reshuffleTime;
	private String shuffeledWord;
	private boolean running;
	
	private int startingPosY = 0;
	private int posY = 0;
	private int yspeed = 3;
	
	//getter & setter
	public boolean getRunning() { return this.running; }
	public int getPosY() { return this.posY; }
	public int getStartingPosY() { return this.startingPosY; }
	
	public void setRunning(boolean running) { this.running = running; }
	

	public MatrixString(Game game) {
		this.game = game;
		this.reshuffleTime = new Random().nextInt(2000+1)+1000;
		shuffleWord();
	}
	
	
	private void shuffleWord() {
		String tempWord = this.game.getSoughtWord();
		//tempWord = "ABCDEFGHIJKLMNOPQRSTUFWXYZ".toLowerCase();
		this.shuffeledWord = "";
		// Solange das tempWord noch buchstaben besitzt, werden zufällig ausgewählte buchstaben aus dessen entfernt 
		// und der mList hinzugefügt 
		// -> zufällige reihenfolge der Buchstaben 
		while(!tempWord.isEmpty()) {
			char rdChar = tempWord.charAt(new Random().nextInt(tempWord.length()));
			tempWord = tempWord.replaceFirst(rdChar + "", "");
			this.shuffeledWord += rdChar;
		}
	}
	
	/*
	 * Paint Methode
	 */
	public void render(Graphics g) {
		renderWord(g);
	}
	
	public void renderWord(Graphics g) {
		//getting the font used for our matrix string
		Font font = this.game.getContainer().getFontUtils().getMatrixFont();

		//getting the wordheight, to then calculate a random starting point
		//which should be out of the screen --> this is done, so that every matrix string comes
		//down at a different time
		if(this.startingPosY == 0) {
			int wordHeight = g.getFontMetrics().getHeight() * (shuffeledWord.length()+1);
			startingPosY = -(new Random().nextInt(wordHeight) + wordHeight*2);
			this.posY = this.startingPosY;
		}
		
		if(posY > game.getContainer().getSettings().getResolution().getHeight()) {
			this.posY = this.startingPosY;
		}
		
		char[] wordArray = shuffeledWord.toCharArray();
		for(int i = 0; i < shuffeledWord.length(); i++) {
			g.setColor(Color.BLACK);
			g.setFont(font);
			g.drawString("" + wordArray[i], 100, posY + g.getFontMetrics().getHeight()  * (i+1) - g.getFontMetrics().getDescent());
		}
		
		this.posY = this.posY+ this.yspeed;
		
	}

	@Override
	public void run() {
		
		while(running) {
			try {
				Thread.sleep(this.reshuffleTime);
			} catch (InterruptedException e) {
			}
			
			shuffleWord();
		}
	}
	
}
