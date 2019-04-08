package client.utils;

import java.awt.Font;

public class FontUtils {
	
	private Font matrixFont = new Font("TimesRoman", Font.BOLD, 0).deriveFont(30F);

	public Font getMatrixFont() { return this.matrixFont; }
	
	public FontUtils() {
		
	}
}
