package game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{
	
	private Image img;
	
	public BackgroundPanel() {
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Resources/matrix-frameBild3.gif"));
		img = imageIcon.getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		repaint();
	}
	
}
