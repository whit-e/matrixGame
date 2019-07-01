package client.old.game.screens;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Startscreen {
	
	//the componentHolders
	private JPanel componentHolder;
	private JPanel loginContainer;
	private JPanel registerContainer;
	
	
	//needed components
	private JTextField usernameTxtFd;
	private JPasswordField passwordFd;
	
	private JLabel usernameLbl;
	private JLabel passwordLbl;
	
	private JButton loginBtn;
	private JButton registerBtn;
	
	
	//getter
	public JButton getRegisterBtn() { return registerBtn; }
	public JButton getLoginBtn() { return loginBtn; }
	public JTextField getUserNameTxtFd() { return this.usernameTxtFd; }
	public JTextField getPasswordFd() { return this.passwordFd; }
	
	private Container container;
	
	public Startscreen(Container container) {
		this.container = container;
		
		init();
		config();
	}
	
	private void init() {
		this.componentHolder = new JPanel();
		this.loginContainer = new JPanel();
		this.registerContainer = new JPanel();
		
		this.usernameTxtFd = new JTextField("", 15);
		this.passwordFd = new JPasswordField("", 15);
		
		this.usernameLbl = new JLabel("BENUTZERNAME");
		this.passwordLbl = new JLabel("PASSWORT");
		
		this.loginBtn = new JButton("LOGIN");
		this.registerBtn = new JButton("REGISTER");
	}
	
	private void config() {
		//add needed listener
		this.registerBtn.addActionListener(container);
		this.loginBtn.addActionListener(container);

		positionComponents();
		
		//config compononents
		usernameLbl.setFont(this.container.getFontUtils().getMatrixFont().deriveFont(20F));
		passwordLbl.setFont(this.container.getFontUtils().getMatrixFont().deriveFont(20F));
		
		this.componentHolder.setLayout(new GridLayout(2, 1, 10, 10));
		this.componentHolder.setOpaque(false);
		
		this.loginContainer.setLayout(new GridLayout(3, 2, 10, 10));
		this.loginContainer.setOpaque(false);
		
		this.registerContainer.setLayout(new GridLayout(1, 1, 10, 10));
		this.registerContainer.setOpaque(true);
		//-----------------------------------
		
		//add components to panel
		this.loginContainer.add(usernameLbl);
		this.loginContainer.add(usernameTxtFd);
		
		this.loginContainer.add(passwordLbl);
		this.loginContainer.add(passwordFd);
		
		this.loginContainer.add(loginBtn);
		
		this.registerContainer.add(registerBtn);
		
		
		this.componentHolder.add(loginContainer);
		this.componentHolder.add(registerContainer);
		//-----------------------------------
		
		
	}
	
	private void positionComponents() {
		int frameWidth = this.container.getSettings().getResolution().getWidth();
		int frameHeight = this.container.getSettings().getResolution().getHeight();
		
		//the component holder should be positioned 30% from the top (y) and 50% from the left side (x)
		int holderPosX = frameWidth/100 * 50;
		int holderPosY = frameHeight/100 * 30;
		
		this.componentHolder.setBounds(holderPosX, holderPosY, 500, 200);
	}
	
	public void render(Graphics g) {
		g.setFont(this.container.getFontUtils().getMatrixFont().deriveFont(50F));
		
		String heading = "t THE MATRIX GAME u";
		
		int frameWidth = this.container.getSettings().getResolution().getWidth();
		int frameHeight = this.container.getSettings().getResolution().getHeight();
		
		//the component holder should be positioned 30% from the top (y) and 50% from the left side (x)
		int holderPosX = frameWidth/100 * 50 - g.getFontMetrics().stringWidth(heading)/2;
		int holderPosY = frameHeight/100 * 15 + g.getFontMetrics().getHeight()/2;
		
		g.drawString(heading, holderPosX, holderPosY);
	}
	
	public void addComponents() {
		this.container.setLayout(null);
		
		this.container.add(componentHolder);
	}
	
	public void removeComponents() {
		this.container.remove(componentHolder);
	}
}
