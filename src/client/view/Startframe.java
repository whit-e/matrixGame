package client.view;

import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.Properties;

import javax.swing.JFrame;

import client.utils.PropertyHandler;
import client.view.components.panels.impl.ContainerPanel;

/**
 * <p>
 * This class is the Frame, which holds all JPanels for the applicaiton. It is
 * the startingpoint for our application.
 * </p>
 * 
 * @author hotzelm
 * @version 2.0
 */
@SuppressWarnings("serial")
public class Startframe extends JFrame {

	public static void main(String[] args) {
		Startframe.getInstance().setVisible(true);
	}

	/**
	 * <p>
	 * A singleton is used here because there is should only be a single startscreen
	 * in our application.
	 * </p>
	 */
	private static Startframe startframe = new Startframe();

	private Startframe() {
		init();
		config();
		build();
	}

	private void init() {
		// not needed atm.
	}

	private void config() {
		Properties settingsProps = PropertyHandler.getInstance().getSettingsProps();
		int width = Integer.parseInt(settingsProps.getProperty("matrix.game.settings.width.default"));
		int height = Integer.parseInt(settingsProps.getProperty("matrix.game.settings.height.default"));

		this.setSize(width, height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		// This block centers the application in the middle of all connected monitors
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gsd = ge.getScreenDevices();
		GraphicsConfiguration gc = gsd[gsd.length / 2].getDefaultConfiguration();
		Rectangle rect = gc.getBounds();

		setLocation((int) rect.getCenterX() - width / 2, (int) rect.getCenterY() - height / 2);
	}

	private void build() {
		this.add(ContainerPanel.getInstance());
	}

	public static Startframe getInstance() {
		return startframe;
	}

}
