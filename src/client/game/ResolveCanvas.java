package client.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Das Panel für die Eingabe des User
 * 
 */
public class ResolveCanvas extends JPanel implements KeyListener{

	public ResolveCanvas() {
		addKeyListener(this);
	}
	

	public static void main(String[] args) {
		ResolveCanvas test = new ResolveCanvas();
		test.setWord("apfelkuchen");
		JFrame frame = new JFrame();
		frame.setSize(1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.add(test);
		frame.setVisible(true);
	}
	
	//Word to resolve
	private String word;
	//available chars 
	private String chars = "abcdefghijklmnopqrstuvwxyzäüöß";
	//Array which contains input of user(char)
	private char[] resolveAr;
	//indicates the place in resolveAr
	private int counter; 
	
	//Set´s the Word 
	public void setWord(String word) {
		this.word = word;
		init();
	}
	
	//Keylistener
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if(chars.contains(""+(char)e.getKeyChar())){
			addCharToAr((char)e.getKeyChar());
		}else if(e.getKeyCode()==e.VK_ENTER) {
			getRdy();
		}else if(e.getKeyCode()==8) {
			deleteLastChar();
		}
	}
	//initialises the start for the round
	private void init() {
		resolveAr = new char[word.length()];
		getRdy();
		counter = 0;
		this.setFocusable(true);
		this.setSize(new Dimension(800, 200));
		this.setBackground(Color.blue);
	}

	public void paintComponent(Graphics g) {
		paint(g);
	}
	//Reworkable -> paints the user char input
	public void paint(Graphics g) {
		int x = 150;
		int y = 30;
		super.paintComponent(g);
		g.setColor(Color.white);
		for(char c: resolveAr) {
			g.drawString(String.valueOf(c), x+=30, y);
		}
		repaint();
	}
	
	//deletes the last char and reduces counter
	private void deleteLastChar() {
		if(counter >0 && counter <= word.length()+1) {
			counter--;
		}
		resolveAr[counter] = '_';
		repaint();
	}
	//adds char to array and raised counter
	private void addCharToAr(char character) {
		resolveAr[counter] = character;
		if(counter >=0 && counter < word.length()-1) {
			counter++;
		}
	}
	
	//Should send the users input to check if its the same 
	private void getRdy() {
		if(word.contentEquals(String.valueOf(resolveAr))) {
			System.out.println("gewonnen");
		}
		counter = 0;
		for(int i = 0; i < resolveAr.length;i++) {
			resolveAr[i] = '_';
		}
	}
	
	//returns this jpanel
	public JPanel getCanvas() {
		return this;
	}
}