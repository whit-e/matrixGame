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
	
	
	private String word;
	private String chars = "abcdefghijklmnopqrstuvwxyzäüöß";
	private char[] resolveAr;
	private int counter; 
	
	public void setWord(String word) {
		this.word = word;
		init();
	}
	
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
	
	
	private void deleteLastChar() {
		if(counter >0 && counter <= word.length()+1) {
			counter--;
		}
		resolveAr[counter] = '_';
		repaint();
	}
	
	private void addCharToAr(char character) {
		resolveAr[counter] = character;
		if(counter >=0 && counter < word.length()-1) {
			counter++;
		}
	}
	
	private void getRdy() {
		if(word.contentEquals(String.valueOf(resolveAr))) {
			System.out.println("gewonnen");
		}
		counter = 0;
		for(int i = 0; i < resolveAr.length;i++) {
			resolveAr[i] = '_';
		}
	}
	
	public JPanel getCanvas() {
		return this;
	}
}