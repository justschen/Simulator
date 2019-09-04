import java.awt.Color;
import java.awt.Graphics2D;

public class TwoLines extends Fractals{

	public TwoLines() {
		// TODO Auto-generated constructor stub
	}
	
	public void drawLines(int x1, int y1, int x2, int y2, int n, int size, Graphics2D win) {
		win.setColor(Color.WHITE);
		win.drawLine(x1, y1, x2, y2);
		
			if (n>0) {
				size = size/3;
				drawLines(x1, y1+50, x1+size, y2 + 50, n-1, size,win);
				drawLines(x1 + 2*(size), y1+50, x2, y2 + 50, n-1, size,win);
			}
		}
		
		
	
	
	public void moveAndDraw(Graphics2D win) {
		super.moveAndDraw(win);
		
		int size = 300;
		
		drawLines(100, 100, 100+size, 100, layers, size, win);
		
		
	}

}
