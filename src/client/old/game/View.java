package client.old.game;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import client.old.game.screens.Container;

@SuppressWarnings("serial")
public class View extends JFrame {

	private Container container;

	public View() {
		this.container = new Container();

		init();
		config();
	}

	private void init() {

		// Center frame
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gsd = ge.getScreenDevices();
		GraphicsConfiguration gc = gsd[gsd.length / 2].getDefaultConfiguration();
		Rectangle rect = gc.getBounds();
		setLocation((int) rect.getCenterX() - container.getSettings().getResolution().getWidth() / 2,
				(int) rect.getCenterY() - container.getSettings().getResolution().getHeight() / 2);
		// -------------------

	}

	private void config() {
		// add listener
		this.addComponentListener(new ComponentAdapter() {

			// does
			@Override
			public void componentHidden(ComponentEvent e) {
				container.getServerConnection().getMessageProtocol().disposeSocket();
				System.exit(0);
			}
		});

		this.setSize(new Dimension(container.getSettings().getResolution().getWidth(),
				container.getSettings().getResolution().getHeight()));
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.add(container);
	}
}
