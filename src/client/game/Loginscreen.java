package client.game;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loginscreen {
	
	//all the components of the register screen are added to this JPanel
	private JPanel componentHolder;
	//needed components
	private JTextField usernameTxtFd;
	private JPasswordField passwordPwFd;
	
	private JLabel usernameLbl;
	private JLabel passwordLbl;
	
	private JButton loginBtn;
	private JButton cancelBtn;
	
	private Container container;
	
	//getter
	public JButton getLoginBtn() { return this.loginBtn; }
	public JButton getCancelBtn() { return this.cancelBtn; }
	
	public Loginscreen(Container container) {
		this.container = container;
		
		init();
		config();
	}
	
	private void init() {
		this.componentHolder = new JPanel();
		
		this.usernameTxtFd = new JTextField("", 15);
		this.passwordPwFd = new JPasswordField("", 15);
		
		this.usernameLbl = new JLabel("Benutzername");
		this.passwordLbl = new JLabel("Passwort");
		
		this.loginBtn = new JButton("Login");
		this.cancelBtn = new JButton("Abbrechen");
	}
	
	private void config() {
		//add needed listener
		this.cancelBtn.addActionListener(container);
		this.loginBtn.addActionListener(container);
		
		//config compononents
		this.componentHolder.setLayout(new GridLayout(3, 2, 10, 10));
		this.componentHolder.setOpaque(false);
		//-----------------------------------
		
		//add components to panel
		this.componentHolder.add(usernameLbl);
		this.componentHolder.add(usernameTxtFd);
		
		this.componentHolder.add(passwordLbl);
		this.componentHolder.add(passwordPwFd);
		//-----------------------------------
	
		this.componentHolder.add(loginBtn);
		this.componentHolder.add(cancelBtn);
	}
	
	public void addComponents() {
		container.add(this.componentHolder);
	}
	
	public void removeComponents() {
		container.remove(this.componentHolder);
	}
	
}
