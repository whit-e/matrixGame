package client.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class FontUtils {
	
	//needed attributes
	private Font matrixGameFont = new Font("TimesRoman", Font.BOLD, 0).deriveFont(30F);
	private Font matrixFont;
	private Font matrixFont2;
	
	
	//getter
	public Font getMatrixGameFont() { return this.matrixGameFont; }
	public Font getMatrixFont() { return this.matrixFont; }
	public Font getMatrixFont2() { return this.matrixFont2; }
	
	
	public FontUtils() {
		loadFonts("/fonts/Miltown_.ttf");
		loadFonts("/fonts/matrix.ttf");
		
		initFont();
	}
	
	private void loadFonts(String fontPath1) {
		String fontPath = fontPath1;
		InputStream is = this.getClass().getResourceAsStream(fontPath);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, is);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(font);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initFont() {
		matrixFont = new Font("Miltown", Font.BOLD, 0).deriveFont(50F);
		matrixFont2 = new Font("matrix", Font.BOLD, 0).deriveFont(50F);
	}
	
}
