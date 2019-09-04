import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * 
 * @author Justin Chen
 * @version 1.0
 * @since 2019-03-15
 * 
 * 
 */
public class Buffon extends Line2D.Double {

	/*
	 * @param r1 counts the total number of successes.
	 * 
	 * @param angle an integer that is randomly generated up to 361.
	 * 
	 * @param intialX an integer that stores the randomly generated initial x
	 * location of the line.
	 * 
	 * @param initialY an integer that stores the randomly generated initial y
	 * location of the line.
	 * 
	 * @param length an integer that is set equal to the length previously set in
	 * Global
	 * 
	 * @param endX an integer that is calculated to grant a randomly generated x
	 * coordinate for the line.
	 * 
	 * @param endY an integer that is calculated to grant a randomly generated y
	 * coordinate for the line.
	 * 
	 * @param hasHit a boolean which determines if the needle has intersected with
	 * the line or not.
	 */

	Random r1 = new Random();
	int angle;

	int initialX;
	int initialY;
	int length;

	int endX;
	int endY;
	Boolean hasHit = false;

	public Buffon() {
		// TODO Auto-generated constructor stub
		/**
		 * This is the constructor for Buffon.
		 */

		angle = r1.nextInt(361);

		initialX = r1.nextInt(750);
		initialY = r1.nextInt(550);
		length = Global.buffonLength;

		endX = initialX + (int) (Math.cos(Math.toRadians(angle)) * length);
		endY = initialY + (int) (Math.sin(Math.toRadians(angle)) * length);
	}

	
	public void moveAndDraw(Graphics2D win) {
		/**
		 * This is the method that draws the needles.
		 */
		win.setColor(Color.WHITE);

		// Draws lines across.
		for (int i = 0; i < 6; i++) {
			win.drawLine(0, i * 100, Global.width, i * 100);

		}

		// Checks intersection.
		for (int i = 0; i < 6; i++) {
			if (initialY >= i * 100 && endY <= i * 100 || initialY <= i * 100 && endY >= i * 100) {
				win.setColor(Color.RED);
				hasHit = true;
			}

		}
		// Draws needles.
		win.drawLine(initialX, initialY, endX, endY);

	}

}
