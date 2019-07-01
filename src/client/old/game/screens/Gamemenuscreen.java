package client.old.game.screens;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Gamemenuscreen {
	
	private JPanel componentHolder;
	private JButton createLobbyBtn;
	private JButton joinLobbyBtn;
	private JButton logoutBtn;
	
	private Container container;
	
	public JButton getLogoutBtn() { return this.logoutBtn; }
	public JButton getCreateLobbyBtn() { return this.createLobbyBtn; }
	
	public Gamemenuscreen(Container container) {
		
		this.container = container;
		
		init();
		config();
		
	}
	
	private void init() {
		this.componentHolder = new JPanel();
		
		this.createLobbyBtn = new JButton("Create Lobby");
		this.joinLobbyBtn = new JButton("Join Lobby");
		this.logoutBtn = new JButton("Logout");
	}
	
	private void config() {
		//add needed listeners
		this.logoutBtn.addActionListener(container);
		this.createLobbyBtn.addActionListener(container);
		this.joinLobbyBtn.addActionListener(container);
		
		//config compononents
				
		this.componentHolder.setLayout(new GridLayout(3, 1, 10, 10));
		this.componentHolder.setOpaque(false);
		//-----------------------------------
		
		//add components to panel
		this.componentHolder.add(createLobbyBtn);
		this.componentHolder.add(joinLobbyBtn);
		this.componentHolder.add(logoutBtn);
				
	}
	
	public void addComponents() {
		this.container.add(componentHolder);
		this.container.setLayout(new FlowLayout());
	}
	
	public void removeComponents() {
		this.container.remove(componentHolder);
	}
	
	
}
