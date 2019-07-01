package client.view.components.panels.impl;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import client.control.MainController;
import client.view.components.panels.IPanel;

/**
 * <p>
 * This class is represents the login screen in the GUI. Here a user can create
 * a new account.
 * </p>
 * 
 * @author hotzelm
 * @version 2.0
 */
@SuppressWarnings("serial")
public class RegisterPanel extends JPanel implements IPanel {
	/**
	 * A singleton is used here because there should only be one Startpanel in the
	 * application.
	 */
	private static RegisterPanel registerPanel = new RegisterPanel();

	// needed components
	private JButton backBtn;

	private RegisterPanel() {
		init();
		config();
		build();
	}

	@Override
	public void init() {
		this.backBtn = new JButton();
	}

	@Override
	public void config() {
		this.setBackground(Color.blue);

		this.backBtn.addActionListener(MainController.getInstance());
	}

	@Override
	public void build() {
		this.add(backBtn);
	}

	public static RegisterPanel getInstance() {
		return registerPanel;
	}

	public JButton getBackBtn() {
		return backBtn;
	}
}
