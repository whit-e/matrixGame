package client.old.game.old.color;

import java.awt.Color;
import java.util.Random;

public class MatrixColor{

	public Color getButtonColor(){return new Color(35, 220, 0).darker().darker();}
	public Color getButtonCharColor(){return new Color(40,220,0).brighter().brighter();}
	public Color getMatrixCharColor() {
		if(new Random().nextInt(50)>25) {
			return new Color(24,200,1, new Random().nextInt(200)+50).darker();
		}else {
			return new Color(24,200,1, new Random().nextInt(200)+50).brighter();
		}
	}
	public Color getLabelColor() {
		return new Color(24,200,5,200).brighter().brighter();
	}
}
