package client.game;


import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterScreen implements FocusListener{
	
	//all the components of the register screen are added to this JPanel
	private JPanel componentHolder;
	//needed components
	private JTextField usernameTxtFd;
	private JPasswordField passwordPwFd;
	private JPasswordField passwordValidPwFd;
	
	private JLabel usernameLbl;
	private JLabel passwordLbl;
	private JLabel passwordValLbl;
	
	private JButton cancelBtn;
	private JButton registerBtn;
	
	private Container container;
	
	//getter
	public JButton getCancelBtn() { return this.cancelBtn; }
	public JButton getRegisterBtn() { return this.registerBtn; }
	public JTextField getUsernameTxtFd() { return this.usernameTxtFd; }
	public JTextField getPasswordTxtFd() { return this.passwordPwFd; }
	
	public RegisterScreen(Container container) {
		this.container = container;
		
		init();
		config();
	}
	
	private void init() {
		this.componentHolder = new JPanel();
		
		this.usernameTxtFd = new JTextField("", 15);
		this.passwordPwFd = new JPasswordField("", 15);
		this.passwordValidPwFd = new JPasswordField("", 15);
		
		this.usernameLbl = new JLabel("Benutzername");
		this.passwordLbl = new JLabel("Passwort");
		this.passwordValLbl = new JLabel("Passwort bestätigen");
		
		this.cancelBtn = new JButton("Abbrechen");
		this.registerBtn = new JButton("Registrieren");
	}
	
	private void config() {
		//adding needed listeners
		this.usernameTxtFd.addFocusListener(this);
		this.passwordPwFd.addFocusListener(this);
		this.passwordValidPwFd.addFocusListener(this);
		
		this.cancelBtn.addActionListener(container);
		this.registerBtn.addActionListener(container);
		//-----------------------------------
		
		//config compononents
		this.registerBtn.setEnabled(false);
		
		this.componentHolder.setLayout(new GridLayout(4, 2, 10, 10));
		this.componentHolder.setOpaque(false);
		//-----------------------------------
		
		//add components to panel
		this.componentHolder.add(usernameLbl);
		this.componentHolder.add(usernameTxtFd);
		
		this.componentHolder.add(passwordLbl);
		this.componentHolder.add(passwordPwFd);
		
		this.componentHolder.add(passwordValLbl);
		this.componentHolder.add(passwordValidPwFd);

		this.componentHolder.add(registerBtn);
		this.componentHolder.add(cancelBtn);
		//-----------------------------------
	}
	
	public void addComponents() {
		container.add(this.componentHolder);
	}
	
	public void removeComponents() {
		container.remove(this.componentHolder);
	}

	private boolean areInputFieldsValid() {
		if(
				//container.getDatabase().isUsernameAvailable(usernameTxtFd.getText()) &&
				usernameTxtFd.getText().length() != 0 && 
				passwordPwFd.getPassword().length != 0 &&
				passwordValidPwFd.getPassword().length != 0 && 
				Arrays.equals(passwordPwFd.getPassword(), passwordValidPwFd.getPassword())
		) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	//textfields and register button are resetted
	//is called, when the user leaves the registerscreen
	public void reset() {
		this.usernameTxtFd.setText("");
		this.passwordPwFd.setText("");
		this.passwordValidPwFd.setText("");
		
		this.registerBtn.setEnabled(false);
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(areInputFieldsValid()) {
			registerBtn.setEnabled(true);
		} else {
			registerBtn.setEnabled(false);
		}
	}
}
