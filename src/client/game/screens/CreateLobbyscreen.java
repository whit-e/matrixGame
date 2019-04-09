package client.game.screens;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CreateLobbyscreen {
	
	private Container container;
	
	private JPanel componentHolder;
	private JButton backBtn;
	private JButton startGameBtn;
	
	//getter
	public JButton getBackBtn() { return this.backBtn; }
	public JButton getStartGameBtn() { return this.startGameBtn; }
	
	public CreateLobbyscreen(Container container) {
		this.container = container;
		
		init();
		config();
	}
	
	private void init() {
		this.componentHolder = new JPanel();
		
		this.backBtn = new JButton("Zurück");
		this.startGameBtn = new JButton("Start Game");
	}
	
	private void config() {
		//add needed listeners
		this.backBtn.addActionListener(container);
		this.startGameBtn.addActionListener(container);
		
		//config compononents
				
		this.componentHolder.setLayout(new GridLayout(2, 1, 10, 10));
		this.componentHolder.setOpaque(false);
		//-----------------------------------
		
		//add components to panel
		this.componentHolder.add(startGameBtn);
		this.componentHolder.add(backBtn);
	}
	
	public void addComponents() {
		this.container.add(componentHolder);
	}
	
	public void removeComponents() {
		this.container.remove(componentHolder);
	}
}
