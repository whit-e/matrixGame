package client;


import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterScreen {
	
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
}
