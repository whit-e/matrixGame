package client.old.game.old.matrixComponents;

import java.awt.Dimension;

import javax.swing.JComboBox;

import client.old.game.old.color.MatrixColor;

@SuppressWarnings("serial")
public class MatrixComboBox extends JComboBox{

	private JComboBox box;
	
	public MatrixComboBox(String[] stuff,int selectedIndex) {
		this.box = new JComboBox(stuff);
		box.setSelectedIndex(selectedIndex);
		box.setBackground(new MatrixColor().getButtonColor().brighter().brighter());
		box.setPreferredSize(new Dimension(150, 30));
		box.setMaximumSize(new Dimension(150, 30));
		box.setMinimumSize(new Dimension(150, 30));
	}
	
	public JComboBox createBox(){
		return this.box;
	}
}
