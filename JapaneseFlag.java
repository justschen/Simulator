import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

/**
 * 
 * @author Justin Chen
 * @version 1.0
 * @since 2019-03-15
 * 
 * 
 */
public class JapaneseFlag extends Point {
	/*
	 * @param hitColor counts the total number of successes.
	 * 
	 * @param noHit an integer that is randomly generated up to 361.
	 * 
	 * @param takeAHit an integer that stores the randomly generated initial x
	 * location of the line.
	 */
	Color hitColor = Color.RED;
	Color noHit = Color.WHITE;
	boolean takeAHit = false;

	public JapaneseFlag() {

		/**
		 * This is the constructor for JapaneseFlag which creates random points on the
		 * screen.
		 * 
		 * @param rand
		 *            utilized to create randomized x and y coordinates for the point.
		 */
		Random rand = new Random();
		this.x = rand.nextInt(Global.width);
		this.y = rand.nextInt(Global.height);

	}

	public void moveAndDraw(Graphics2D win) {

		/**
		 * This is the method that draws the random points for JapaneseFlag
		 * 
		 * @param double
		 *            a double that calculates the distance between the point and a
		 *            predetermined center.
		 */
		double distance = Math.hypot(this.x - Global.centerX, this.y - Global.centerY);

		if (distance < Global.radius) {
			win.setColor(hitColor);
			takeAHit = true;
		} else {
			win.setColor(noHit);
		}

		// Fills in a rectangle over this randomized point.
		win.fillRect(this.x - 1, this.y - 1, 3, 3);

	}

}
