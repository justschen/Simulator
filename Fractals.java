import java.awt.Color;
import java.awt.Graphics2D;

public class Fractals {

	int layers = 1, maxLayers = 20;
	int timer = 0, delay = 5;
	Color col = Color.CYAN;
	
	public Fractals() {
		
	}
	
	
	public void moveAndDraw(Graphics2D win) {
		
		if (timer > delay) {
			layers++;
			layers %=maxLayers;
			timer = 0;
		} else {
			timer++;
		}

	}
	
}
