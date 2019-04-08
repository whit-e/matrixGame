package game.matrixComponents;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import game.color.MatrixColor;

public class MatrixButton extends JButton{

	private String name;
	
	public MatrixButton() {
		this.name = "";
	}
	
	public MatrixButton(String name) {
		this.name = name;
	}
	
	public JButton createBtn() {
		Color matrixGreen = new MatrixColor().getButtonColor();
		Dimension btnDim = new Dimension(105, 50);
		JButton mButton = new JButton(name);
		mButton.setForeground(new MatrixColor().getButtonCharColor());
		mButton.setBackground(matrixGreen);
		mButton.setOpaque(true);
		mButton.setMinimumSize(btnDim);
		mButton.setMaximumSize(btnDim);
		return mButton;
	}
	
}
