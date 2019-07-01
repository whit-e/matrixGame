package client.view.components.panels.impl;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import client.control.MainController;
import client.view.components.panels.IPanel;

/**
 * <p>
 * This class represents the starting screen GUI. From here a user should be
 * able to login or to create a new account.
 * </p>
 * 
 * @author hotzelm
 * @version 2.0
 */
@SuppressWarnings("serial")
public class Startpanel extends JPanel implements IPanel {

	/**
	 * A singleton is used here because there should only be one Startpanel in the
	 * application.
	 */
	private static Startpanel startPanel = new Startpanel();

	// needed components
	private JButton registerBtn;

	private Startpanel() {
		init();
		config();
		build();
	}

	@Override
	public void init() {
		this.registerBtn = new JButton("Register");

		this.registerBtn.addActionListener(MainController.getInstance());
	}

	@Override
	public void config() {
		this.setBackground(Color.RED);
	}

	@Override
	public void build() {
		this.add(registerBtn);
	}

	public static Startpanel getInstance() {
		return startPanel;
	}

	public JButton getRegisterBtn() {
		return registerBtn;
	}

}
