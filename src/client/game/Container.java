package client.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import client.ServerConnection;
import client.utils.DecryptUtils;
import client.utils.FileUtils;
import client.utils.FontUtils;

@SuppressWarnings("serial")
public class Container extends JPanel implements ActionListener{
	
	private Timer timer;
	
	private Settings settings;
	private Startscreen startscreen;
	private Gamescreen gamescreen;
	private Registerscreen registerscreen;
	private Loginscreen loginscreen;
	
	private ServerConnection serverConnection;
	private FontUtils fontUtils;
	private FileUtils fileUtils;
	private DecryptUtils encryptUtils;

	
	private GamestateEnum gamestate;
	
	//getter & setter
	public Settings getSettings() { return this.settings; }
	public Startscreen getStartscreen() { return this.startscreen; }
	public Registerscreen getRegisterscreen() { return this.registerscreen; }
	public Loginscreen getLoginscreen() { return this.loginscreen; }
	
	public ServerConnection getServerConnection() { return this.serverConnection; }
	public FontUtils getFontUtils() { return this.fontUtils; }
	public FileUtils getFileUtils() { return this.fileUtils; }
	public DecryptUtils getEncryptUtils() { return this.encryptUtils; }
	
	public GamestateEnum getGamestate() { return this.gamestate; }
	public Timer getTimer() { return this.timer; }
	
	public Container() {
		
		init();
		timer.start();
		
		this.setBackground(Color.GRAY);
		
		//stateChange is called here because initially the state is changed from nothing to startscreen
		//so here the components of startscreen are added for the first time
		stateChange();

	}
	
	//initializing the attributes
	private void init() {
		this.fontUtils = new FontUtils();
		this.fileUtils = new FileUtils();
		
		this.gamestate = GamestateEnum.startscreen;
		
		this.settings = new Settings();
		this.startscreen = new Startscreen(this);
		this.registerscreen = new Registerscreen(this);
		this.gamescreen = new Gamescreen(this);
		this.loginscreen = new Loginscreen(this);
		
		this.timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		}); 
	}
	
	
	/**
	 * this method is only called, if a state (e.g. from startscreen to game state) has been changed
	 * it removes the components of the last state and adds the ones of the new one.
	 * Also does some other things such as preparing everything for a game start on state change = game
	 */
	private void stateChange() {
		if(this.gamestate == GamestateEnum.startscreen) {
			gamescreen.removeComponents();
			registerscreen.removeComponents();
			loginscreen.removeComponents();
			
			startscreen.addComponents();
		} 
		else if(this.gamestate == GamestateEnum.gamescreen) {
			startscreen.removeComponents();
			
			gamescreen.addComponents();
			gamescreen.start();
		} else if(this.gamestate == GamestateEnum.registerscreen) {
			startscreen.removeComponents();
			
			registerscreen.addComponents();
		} else if(this.gamestate == GamestateEnum.loginscreen) {
			startscreen.removeComponents();
			
			loginscreen.addComponents();
		}

		//repaint and revalidate need to be called in order to 
		//remove and add the components correctly
		repaint();
		revalidate();
	}
	
	/**
	 * this method is called every x seconds (caused by the timer)
	 * calls the paint method of the different gamestates
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		//activate antialising
		g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR);
		//---------------------
		
		//paint the components 
		if(this.gamestate == GamestateEnum.startscreen) {
			
		} 
		else if(this.gamestate == GamestateEnum.gamescreen) {
			gamescreen.paintComponent(g2d);
		} else if(this.gamestate == GamestateEnum.registerscreen) {
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//checks which button has been clicked to then change the
		//gamestate and invoke the method stateChange which will
		//add and remove the compontens for the current gamestate
		
		if(e.getActionCommand() == "Start Game") {
			this.gamestate = GamestateEnum.gamescreen;
		} 
		else if(e.getActionCommand() == "Menu") {
			this.gamestate = GamestateEnum.startscreen;
			
			gamescreen.stop();
		} 
		//register button on startscreen has been clicked
		else if(e.getActionCommand() == startscreen.getRegisterBtn().getActionCommand()) {
			this.gamestate = GamestateEnum.registerscreen;
			
		} 
		//login button on startscreen has been clicked
		else if(e.getActionCommand() == loginscreen.getLoginBtn().getActionCommand()) {
			this.gamestate = GamestateEnum.loginscreen;
		}
		//cancel button on registerscreen has been clicked or
		//cancel button on loginscreen has been clicked
		else if(e.getActionCommand() == registerscreen.getCancelBtn().getActionCommand() ||
				e.getActionCommand() == loginscreen.getCancelBtn().getActionCommand()
				) {
			this.gamestate = GamestateEnum.startscreen;
			
			this.registerscreen.reset();
		}
		//register button has been clicked
		else if(e.getActionCommand() == registerscreen.getRegisterBtn().getActionCommand()) {
			//getting the username and pw to then 
			encryptUtils.prepareIsRegisterPossible(registerscreen.getUsernameTxtFd().getText(), 
					registerscreen.getPasswordTxtFd().getText());
		}
		
		
		stateChange();
		System.out.println(e.getActionCommand());
	}
}
