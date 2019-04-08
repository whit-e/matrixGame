package client.game;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class View extends JFrame{
	
	private Container container;
	
	public View() {
		this.container = new Container();
		
		init();
	}
	
	public void init() {
		
		//Center frame
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gsd = ge.getScreenDevices();
		GraphicsConfiguration gc = gsd[(int)gsd.length/2].getDefaultConfiguration();
		Rectangle rect = gc.getBounds();
		setLocation((int)rect.getCenterX()-container.getSettings().getResolution().getWidth()/2,(int)rect.getCenterY()-container.getSettings().getResolution().getHeight()/2);
		
		
		this.setSize(new Dimension(container.getSettings().getResolution().getWidth(), 
				container.getSettings().getResolution().getHeight()));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(container);
	}
}
