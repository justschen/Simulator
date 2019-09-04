import java.awt.Color;
import java.awt.Graphics2D;

public class Aech extends Fractals {

	public Aech() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void drawAech(int x1, int x2, int y1, int y2, int layers, Graphics2D win) {
		
		if (layers >0) {
			win.setColor(Color.WHITE);
			win.drawLine(x1, y1, x2, y2);
			
		if (x1 == x2) {
			int size2 = (y2 - y1)*3/5;
			drawAech(x1 - size2*3/5, x1+size2*3/5, y1, y1, layers-1, win);
			drawAech(x1 - size2*3/5, x1+size2*3/5, y2, y2 , layers-1, win);
			}
		
		if (y1 ==y2) {
			int size1 = (x2 - x1)*3/5;
			drawAech(x1, x1, y2 - size1*3/5, y2 +size1*3/5, layers-1, win);
			drawAech(x2, x2, y2 - size1*3/5, y2 +size1*3/5, layers-1, win);
				
			}
		
		}
	}
	
	public void drawLine(Graphics2D win) {
		super.moveAndDraw(win);
		int size = 300;
		
		int x1 = Global.width/2 - size/2;
		int x2 = Global.width/2 + size/2;
		int y1 = Global.height - size;
		int y2 = Global.height - size;
		
		drawAech(x1, x2, y1, y2, layers, win);
	}
	

}
