import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class RecursiveLines extends Fractals {


	
	public RecursiveLines() {
		// TODO Auto-generated constructor stub
	}

	public void moveAndDraw(Graphics2D win) {
		super.moveAndDraw(win);
		win.setColor(Color.CYAN);
		// Line2D.Double line = new Line2D.Double(100, 100, 200, 200);
		// win.draw(line);
		//this.drawLines(300, 100, 300, 400, 90, layers, win);
		drawLines(win,  400, 550, -90,70, layers);
	}

	
	
	public void drawLines(Graphics2D win, int x, int y, double angle, double size, int n) {
		
		if (n > 0) {
			int x1 = x + (int) (Math.cos(Math.toRadians(angle))*size);
			int y1 = y + (int) (Math.sin(Math.toRadians(angle))*size);
			size = size*.9;
		
			
			win.drawLine(x, y, x1 , y1);
			drawLines(win, x1, y1, angle + 20, size,n - 1);
			drawLines(win, x1, y1, angle - 20, size,n - 1);
			
			
		}
	}

}
