package client.game;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Gamemenuscreen {
	
	private JPanel componentHolder;
	private JButton createLobbyBtn;
	private JButton joinLobbyBtn;
	
	private Container container;
	
	public Gamemenuscreen(Container container) {
		
		this.container = container;
		
		init();
		config();
		
	}
	
	private void init() {
		this.componentHolder = new JPanel();
		
		this.createLobbyBtn = new JButton("Create Lobby");
		this.joinLobbyBtn = new JButton("Join Lobby");
	}
	
	private void config() {
		//config compononents
				
		this.componentHolder.setLayout(new GridLayout(4, 2, 10, 10));
		this.componentHolder.setOpaque(false);
		//-----------------------------------
		
		//add components to panel
		this.componentHolder.add(createLobbyBtn);
		this.componentHolder.add(joinLobbyBtn);
				
	}
	
	public void addComponents() {
		this.container.add(componentHolder);
	}
	
	public void removeComponents() {
		this.container.remove(componentHolder);
	}
	
	
}
