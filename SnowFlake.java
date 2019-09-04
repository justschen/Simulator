import java.awt.Color;
import java.awt.Graphics2D;

public class SnowFlake extends Fractals{

	
	double xMid, yMid;
	
	public SnowFlake() {
		// TODO Auto-generated constructor stub
	}

	public void moveAndDraw(Graphics2D win) {
		super.moveAndDraw(win);
		win.setColor(Color.WHITE);
		int size = 500;
		int x1 = 100;
		int x2 = 100+size;
		int y1 = 200;
		int y2 = y1;
		drawCoke(x1, y1, x2, y2, layers, size, win);
	}
	
	public void drawCoke(int x1, int y1, int x2, int y2, int n, int size, Graphics2D win) {
		win.setColor(Color.WHITE);
		win.drawLine(x1, y1, x2, y2);
		xMid = (2/3)*x1 + (1/3)*x2;
		yMid = (2/3)*y1 + (1/3)*y2;
		win.drawLine(x1, y1, (int)xMid, (int)yMid);
		
		System.out.println(x1 + ":"+ y1 + ":" + xMid + ":" + yMid); 
		
		if (n>0) {
			size = size/3;
			int midx1  = x1+size;
			int midy1 = (y2+y1)/2;
			int midx2 = x1+2*(size);
			int midy2 = midy1;
			
			drawCoke(x1, y1, midx1, midy1, n-1, size,win);
			drawCoke(midx2, midy2, x2, y2, n-1, size,win);
			drawCoke(midx1, midy1, (x1+x2)/2, (y1+y2)/2, n-1, size, win);
			//drawCoke((x1+x2)/2, y1+10, midx2, midy2+10, n-1, size, win);
			
			int midpointx = (x1+x2)/2;
			int midpointy = (y1 +y2)/2;
			
			int newx1 = midpointx -size/2;
			int newy1 = midpointy + (int)((size/2)*Math.tan(30));
			
			int newx2 = midpointx  + size/2;
			int newy2 = newy1;
			
			int new1 = midpointx - size/2;
			
			drawCoke(midx1, midy1,(x1+x2)/2, (y1+y2)/2, n-1, size, win);
			
			double distance = Math.hypot(x2-x1,y2-y1);
			
		}
	}
	
}
