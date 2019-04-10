package client.game.screens;

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
	private JPasswordField passwordPwFd;
	
	private JLabel usernameLbl;
	private JLabel passwordLbl;
	
	private JButton loginBtn;
	private JButton registerBtn;
	
	
	//getter
	public JButton getRegisterBtn() { return registerBtn; }
	public JButton getLoginBtn() { return loginBtn; }
	
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
		this.passwordPwFd = new JPasswordField("", 15);
		
		this.usernameLbl = new JLabel("BENUTZERNAME");
		this.passwordLbl = new JLabel("PASSWORT");
		
		this.loginBtn = new JButton("LOGIN");
		this.registerBtn = new JButton("REGISTER");
	}
	
	private void config() {
		//add needed listener
		this.registerBtn.addActionListener(container);
		this.loginBtn.addActionListener(container);
		
		usernameLbl.setFont(this.container.getFontUtils().getMatrixFont(20F));
		passwordLbl.setFont(this.container.getFontUtils().getMatrixFont(20F));
		
		
		//config compononents
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
		this.loginContainer.add(passwordPwFd);
		
		this.loginContainer.add(loginBtn);
		
		this.registerContainer.add(registerBtn);
		
		
		this.componentHolder.add(loginContainer);
		this.componentHolder.add(registerContainer);
		//-----------------------------------
	}
	
	
	public void addComponents() {
		this.container.add(componentHolder);
	}
	
	public void removeComponents() {
		this.container.remove(componentHolder);
	}
}
