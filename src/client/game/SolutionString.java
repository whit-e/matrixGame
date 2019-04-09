package client.game;

import java.awt.Graphics;

public class SolutionString extends Thread implements Runnable{
	
	private Gamescreen game;
	private char[] tempSolution;
	
	public SolutionString(Gamescreen game) {
		this.game = game;
		tempSolution = game.getSoughtWord().replaceAll("\\w", " ").toCharArray();
	}
	
	public void revealCharacter() {
		
	}
	
	public void render(Graphics g) {
		
		int posX = 0;
		
		for(int i = 0; i < tempSolution.length; i++) {
			if(i == 0) {
				posX = game.getContainer().getWidth()/2;
				g.drawString(""+tempSolution[i], posX, 
				game.getContainer().getHeight() - g.getFontMetrics().getHeight());
			} else {
				g.drawString("" + tempSolution[i], posX += g.getFontMetrics().stringWidth(""+tempSolution[i]), 
				game.getContainer().getHeight() - g.getFontMetrics().getHeight());
			}
			
		}
		
		
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		tempSolution[0] = game.getSoughtWord().toCharArray()[0];
		tempSolution[1] = game.getSoughtWord().toCharArray()[1];
		
	}
	
}
