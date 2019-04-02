package client;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import utils.FileUtils;
import utils.FontUtils;

@SuppressWarnings("serial")
public class Container extends JPanel implements ActionListener{
	
	private Timer timer;
	
	private Settings settings;
	private Startscreen startscreen;
	private Game game;
	private FontUtils fontUtils;
	private FileUtils fileUtils;
	
	private int test;
	private int doItKai;
	private int iDidItMax;
	
	private GamestateEnum gamestate;
	
	//getter & setter
	public Settings getSettings() { return this.settings; }
	public Startscreen getStartscreen() { return this.startscreen; }
	public FontUtils getFontUtils() { return this.fontUtils; }
	public FileUtils getFileUtils() { return this.fileUtils; }
	
	public GamestateEnum getGamestate() { return this.gamestate; }
	public Timer getTimer() { return this.timer; }
	
	public Container() {
		
		this.fontUtils = new FontUtils();
		this.fileUtils = new FileUtils();
		
		this.gamestate = GamestateEnum.startscreen;
		
		this.settings = new Settings();
		this.startscreen = new Startscreen(this);
		this.game = new Game(this);
		
		this.timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		}); 
		timer.start();
		
		//stateChange is called here because initially the state is changed from nothing to startscreen
		//so here the components of startscreen are added for the first time
		stateChange();

	}
	
	/**
	 * this method is only called, if a state (e.g. from startscreen to game state) has been changed
	 * it removes the components of the last state and adds the ones of the new one.
	 * Also does some other things such as preparing everything for a game start on state change = game
	 */
	private void stateChange() {
		if(this.gamestate == GamestateEnum.startscreen) {
			game.removeComponents();
			
			startscreen.addComponents();
		} 
		else if(this.gamestate == GamestateEnum.game) {
			startscreen.removeComponents();
			
			game.addComponents();
			game.start();
		}

		//repaint and revalidate need to be called in order to 
		//remove and add the components correctly
		repaint();
		revalidate();
	}
	
	/**
	 * this method is called every x seconds (caused by the timer)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR);
		
		if(this.gamestate == GamestateEnum.startscreen) {
			
		} 
		else if(this.gamestate == GamestateEnum.game) {
			game.paintComponent(g2d);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//checks which button has been clicked to then change the
		//gamestate and invoke the method stateChange which will
		//add and remove the compontens for the current gamestate
		if(e.getActionCommand() == "Start Game") {
			this.gamestate = GamestateEnum.game;
			stateChange();
		} 
		else if(e.getActionCommand() == "Menu") {
			this.gamestate = GamestateEnum.startscreen;
			
			game.stop();
			stateChange();
		} 
		
		System.out.println(e.getActionCommand());
	}
}
