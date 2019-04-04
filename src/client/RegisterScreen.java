package client;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterScreen implements FocusListener{
	
	//needed components
	private JTextField usernameTxtFd;
	private JPasswordField passwordPwFd;
	private JPasswordField passwordValidPwFd;
	
	private Container container;
	
	
	public RegisterScreen(Container container) {
		this.container = container;
		
		
		this.usernameTxtFd = new JTextField("", 15);
		this.passwordPwFd = new JPasswordField("", 15);
		this.passwordValidPwFd = new JPasswordField("", 15);
		
		this.usernameTxtFd.addFocusListener(this);
		
		config();
	}
	
	public void config() {
	}
	
	public void addComponents() {
		container.add(usernameTxtFd);
		container.add(passwordPwFd);
		container.add(passwordValidPwFd);
	}
	
	public void removeComponents() {
		container.remove(usernameTxtFd);
		container.remove(passwordPwFd);
		container.remove(passwordValidPwFd);
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getComponent() == this.usernameTxtFd) {
			container.getDatabase().isUsernameAvailable(this.usernameTxtFd.getText());
		}
	}
}
