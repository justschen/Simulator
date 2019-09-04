import java.awt.Color;
import java.awt.Graphics2D;

public class TriForce extends Fractals {

	public TriForce() {
		// TODO Auto-generated constructor stub

	}

	public void drawTri(int x1, int y1, int x2, int y2, int x3, int y3, int n, int size, Graphics2D win) {
		win.setColor(Color.WHITE);

		win.drawLine(x1, y1, x3, y3);
		win.drawLine(x1, y1, x2, y2);
		win.drawLine(x3, y3, x2, y2);

		if (n > 0) {

			// left triangle
			int size1 = size / 2;
			int x1x3 = (x1 + x3) / 2;
			int y1y3 = (y1 + y3) / 2;
			int leftx = x1x3 - size1;
			int lefty = y1y3;
			int abotx = (x1x3 + leftx) / 2;
			int aboty = y1y3 + (int) ((size1) * (Math.sin(Math.toRadians(60))));
			drawTri(abotx, aboty, x1x3, y1y3, leftx, lefty, n - 1, size1, win);

			// right triangle
			int size2 = size / 2;
			int x1x2 = (x1 + x2) / 2;
			int y1y2 = (y1 + y2) / 2;
			int rightx = x1x2 + size2;
			int righty = y1y2;
			int bbotx = (x1x2 + rightx) / 2;
			int bboty = y1y2 + (int) ((size2) * (Math.sin(Math.toRadians(60))));
			drawTri(bbotx, bboty, rightx, righty, x1x2, y1y2, n - 1, size2, win);

			// top triangle
			int size3 = size / 2;
			int x2x3 = (x2 + x3) / 2;
			int y2y3 = (y2 + y3) / 2;
			int leftx1 = x2x3 + size3 / 2;
			int lefty1 = y2y3 - (int) ((size3) * (Math.sin(Math.toRadians(60))));
			int rightx2 = x2x3 - size3 / 2;
			int righty2 = lefty1;
			drawTri(x2x3, y2y3, leftx1, lefty1, rightx2, righty2, n - 1, size3, win);
		}
	}

	public void moveAndDraw(Graphics2D win) {

		super.moveAndDraw(win);
		int size = 300;

		int x1 = 400;
		int x2 = x1 + size / 2;
		int x3 = x1 - size / 2;
		int y1 = 530;
		int y2 = y1 - (int) ((size) * (Math.sin(Math.toRadians(60))));
		int y3 = y2;
		drawTri(x1, y1, x2, y2, x3, y3, layers, size, win);

	}

}
