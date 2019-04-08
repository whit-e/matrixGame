package client.game;

import javax.swing.JButton;

public class Startscreen {
	
	//needed components
	private JButton startGameBtn = new JButton("Start Game");
	private JButton registerBtn = new JButton("Register");
	private JButton loginBtn = new JButton("Login");
	
	
	//getter
	public JButton getStartGameBtn() { return startGameBtn; }
	public JButton getRegisterBtn() { return registerBtn; }
	public JButton getLoginBtn() { return loginBtn; }
	
	private Container container;
	
	public Startscreen(Container container) {
		this.container = container;
		
		//add listeners to components
		startGameBtn.addActionListener(container);
		registerBtn.addActionListener(container);
		loginBtn.addActionListener(container);
	}
	
	public void addComponents() {
		container.add(startGameBtn);
		container.add(registerBtn);
		container.add(loginBtn);
	}
	
	public void removeComponents() {
		container.remove(startGameBtn);
		container.remove(registerBtn);
		container.remove(loginBtn);
	}
}
