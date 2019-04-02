package client;

import javax.swing.JButton;

public class Startscreen {
	
	private JButton startGameBtn = new JButton("Start Game");
	private Container container;
	
	public Startscreen(Container container) {
		this.container = container;
		
		startGameBtn.addActionListener(container);
	}
	
	public void addComponents() {
		container.add(startGameBtn);
	}
	
	public void removeComponents() {
		container.remove(startGameBtn);
	}
}
