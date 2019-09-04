import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RecursiveRectangle extends Fractals {

	int size;
	int x;
	int y;
	// int limit = 15;

	public RecursiveRectangle(int xLoc, int yLoc, int sizes) {
		x = xLoc;
		y = yLoc;
		size = sizes;

	}

	public void moveAndDraw(Graphics2D win) {
		super.moveAndDraw(win);
		Rectangle r0 = new Rectangle(x, y, size, size);
		win.draw(r0);
		// Rectangle r2 = new Rectangle(x + size / 4, y - size / 4, size / 2, size / 2);
		// Rectangle r3 = new Rectangle(x - size / 4, y + size / 4, size / 2, size / 2);
		// Rectangle r4 = new Rectangle(x + size / 4, y + size / 4, size / 2, size / 2);
		win.setColor(Color.WHITE);
		this.drawSquare(r0, win, layers);

	}

	public void drawSquare(Rectangle rect, Graphics2D win, int n) {

		win.setColor(Color.CYAN);

		if (n > 0) {
			
			Rectangle r1 = new Rectangle();
			Rectangle r2 = new Rectangle();
			Rectangle r3 = new Rectangle();
			Rectangle r4 = new Rectangle();
			
			win.draw(rect);
			
			r1.x = rect.x - rect.width/4;
			r1.y = rect.y - rect.width/4;
			r1.width = rect.width/2; 
			r1.height = rect.height/2;
			win.draw(r1);
			
			
			r2.x = (int)rect.getCenterX() + rect.width/4;
			r2.y = rect.y - rect.width/4;
			r2.width = rect.width/2;
			r2.height = rect.height/2;
			win.draw(r2);
			
			r3.x = rect.x - rect.width/4;
			r3.y = (int)rect.getCenterY()+ rect.width/4;
			r3.width = rect.width/2;
			r3.height= rect.height/2;
			win.draw(r3);
			
			r4.x = (int)rect.getCenterX() + rect.width/4;
			r4.y = (int)rect.getCenterY()+ rect.width/4;
			r4.width = rect.width/2;
			r4.height = rect.height/2;
			win.draw(r4);
			
			drawSquare(r1, win, n-1);
			drawSquare(r2, win, n-1);
			drawSquare(r3, win, n-1);
			drawSquare(r4, win, n-1);
	
			
			/*
			win.draw( rect1);
			win.draw(rect2);
			win.draw(rect3);
			win.draw(rect4);

			int size1 = (int) rect1.getWidth();
			int xPos1 = rect1.x;
			int yPos1 = rect1.y;

			int size2 = (int) rect2.getWidth();
			int xPos2 = rect2.x;
			int yPos2 = rect2.y;

			int size3 = (int) rect3.getWidth();
			int xPos3 = rect3.x;
			int yPos3 = rect3.y;

			int size4 = (int) rect4.getWidth();
			int xPos4 = rect4.x;
			int yPos4 = rect4.y;

			Rectangle r1 = new Rectangle(xPos1 - size1 / 4, yPos1 - size1 / 4, size1 / 2, size1 / 2);
			Rectangle r2 = new Rectangle((int) rect1.getCenterX() + size1 / 4, yPos1 - size2 / 4, size2 / 2, size2 / 2);
			Rectangle r3 = new Rectangle(xPos1 - size3 / 4, (int) rect1.getCenterY() + size3 / 4, size3 / 2, size3 / 2);
			Rectangle r4 = new Rectangle((int) rect1.getCenterX() + size1 / 4, (int) rect1.getCenterY() + size4 / 4,
					size4 / 2, size4 / 2);

			drawSquare(r1, r2, r3, r4, win, n - 1);
			*/
			n--;
		}

	}

}