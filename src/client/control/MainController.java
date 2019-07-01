package client.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.view.components.panels.impl.ContainerPanel;
import client.view.components.panels.impl.RegisterPanel;
import client.view.components.panels.impl.Startpanel;

public class MainController implements ActionListener {
	/**
	 * <p>
	 * A singleton is used here because there should be only one mainController in
	 * our application.
	 * </p>
	 */
	private static MainController mainController = new MainController();

	private MainController() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switchPanels(e);

		ContainerPanel.getInstance().repaint();
		ContainerPanel.getInstance().revalidate();
	}

	/**
	 * <p>
	 * This method is called after an action is performed. It switches the panels,
	 * if needed.
	 * </p>
	 * 
	 * @param e - The event itself. It it needed to find out, from which component
	 *          the event came from.
	 * 
	 * @see ActionListener
	 * @see ActionEvent
	 */
	private void switchPanels(ActionEvent e) {
		if (e.getSource() == Startpanel.getInstance().getRegisterBtn()) {
			ContainerPanel.getInstance().removeAll();
			ContainerPanel.getInstance().add(RegisterPanel.getInstance());
		} else if (e.getSource() == RegisterPanel.getInstance().getBackBtn()) {
			ContainerPanel.getInstance().removeAll();
			ContainerPanel.getInstance().add(Startpanel.getInstance());
		}
	}

	public static MainController getInstance() {
		return mainController;
	}

}
