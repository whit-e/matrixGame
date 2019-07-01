package client.view.components.panels.impl;

import javax.swing.JPanel;

import client.view.components.panels.IPanel;

/**
 * <p>
 * This class represents a container in the GUI. It holds the currently needed
 * panels for the active state, e.g. StartPanel.
 * </p>
 * 
 * @author hotzelm
 * @version 2.0
 */
@SuppressWarnings("serial")
public class ContainerPanel extends JPanel implements IPanel {

	/**
	 * A singleton is used here because there should only be one Containerpanel in
	 * the application.
	 */
	private static ContainerPanel containerPanel = new ContainerPanel();

	private ContainerPanel() {
		init();
		config();
		build();
	}

	@Override
	public void init() {
		// not needed atm.
	}

	@Override
	public void config() {
		// not needed atm.
	}

	@Override
	public void build() {
		this.add(Startpanel.getInstance());
	}

	public static ContainerPanel getInstance() {
		return containerPanel;
	}

}
