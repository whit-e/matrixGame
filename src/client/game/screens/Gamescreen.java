package client.game.screens;

import java.awt.Graphics2D;

import javax.swing.JButton;

import client.game.Inputfield;
import client.game.MatrixString;
import client.game.SolutionString;

public class Gamescreen {
	
	private JButton backBtn = new JButton("Menu");
	private Container container;
	private String soughtWord;
	
	private MatrixString matrixString;
	private SolutionString solutionString;
	private Inputfield inputfield;
	
	//getter
	public Container getContainer() { return this.container; }
	public String getSoughtWord() { return this.soughtWord; }
	public SolutionString getSolutionString() { return this.solutionString; }
	public Inputfield getInputfield() { return this.inputfield; }
	
	public Gamescreen(Container container) {
		this.container = container;
		
		
		backBtn.addActionListener(container);
		
	}
	
	public void start() {
		this.container.requestFocus();
		this.soughtWord = container.getFileUtils().getRandomWord().toLowerCase();
		System.out.println(soughtWord);
		

		this.inputfield = new Inputfield(this);
		this.solutionString = new SolutionString(this);
		this.matrixString = new MatrixString(this);
		
		this.matrixString.setRunning(true);
		this.matrixString.start();
		
		this.solutionString.start();
		
	}
	
	public void stop() {
		this.matrixString.setRunning(false);
		this.matrixString.interrupt();
		
		this.solutionString.interrupt();
	}
	
	public void addComponents() {
		container.add(backBtn);
	}
	
	public void removeComponents() {
		container.remove(backBtn);
	}
	
	public void paintComponent(Graphics2D g) {
		matrixString.render(g);
		solutionString.render(g);
		inputfield.render(g);
	}
}
