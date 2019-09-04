import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 
 * @author Justin Chen
 * @version 1.0
 * @since 2019-03-15
 * 
 * 
 */
public class Main extends GameDriverV4 {
	/*
	 * @param success counts the total number of successes.
	 * 
	 * @param totalarea is the total area of the circle or the number of
	 * total/success for Buffon's.
	 * 
	 * @param timer a timer to give each added object a delay.
	 * 
	 * @param delay a value for timer to reach before adding a new object.
	 * 
	 * @param gameState a game state value for the draw method to determine which
	 * method to run.
	 * 
	 * @param left determines if the box is left or not on the splash screen.
	 * 
	 * @param pause determines if the simulations are paused or not.
	 * 
	 * @param flag an ArrayList of JapaneseFlag which makes the random points for
	 * Monte Carlo's simulation.
	 * 
	 * @param needles an ArrayList of Buffon which makes the random needles for
	 * Boffon's Needle simulation.
	 * 
	 * @param flashingbox a BufferedImage used for the Sprite.
	 * 
	 * @param flash a SpriteSheet which creates a flashing box for the style points
	 * on the splashScreen.
	 *
	 */

	static Color col = Color.BLACK;
	double success, totalarea;
	int timer, delay;
	int gameState;
	boolean left, pause;
	// public static boolean[] Pkeys = new boolean[KeyEvent.KEY_LAST];
	Color fontcolor = Color.RED;
	ArrayList<JapaneseFlag> flag;
	ArrayList<Buffon> needles;
	Font f1 = new Font("Comic Sans MS", Font.BOLD, 35);
	Font f2 = new Font("Comic Sans MS", Font.BOLD, 20);
	BufferedImage flashingbox;
	SpriteSheet flash;
	RecursiveLines lines;
	RecursiveRectangle recurs;
	Aech h;
	TriForce tri;
	TwoLines chungus;
	SnowFlake flake;
	Mandel brot;

	public Main() {

		/**
		 * This constructor calls the reset method.
		 */
		reset();
	}

	public void reset() {
		/**
		 * This method resets all parameters.
		 */
		flake = new SnowFlake();
		brot = new Mandel();
		chungus = new TwoLines();
		flag = new ArrayList<JapaneseFlag>();
		needles = new ArrayList<Buffon>();
		recurs = new RecursiveRectangle(300, 200, 200);
		lines = new RecursiveLines();
		h = new Aech();
		tri = new TriForce();
		flashingbox = this.addImage("box.png");
		flash = new SpriteSheet(flashingbox, 2);
		flash.changeFrameDelayTo(5);
		left = true;
		timer = 0;
		gameState = 0;
		delay = 1;
		success = 0;
		totalarea = 0;
		pause = false;
	}

	public void splashScreen(Graphics2D win) {
		/**
		 * This is the splashScren method which draws the splash screen.
		 * 
		 * @params win
		 */

		win.setFont(f1);
		win.setColor(Color.RED);
		win.drawString("The Kinda PI Simulator", 100, 100);
		win.setFont(f2);
		win.drawString("Monte Carlos", 200, 300);
		win.drawString("Buffon's Needle", 430, 300);
		win.drawString("<LEFT>", 200, 330);
		win.drawString("<RIGHT>", 430, 330);
		win.drawString("Press <ESC> to Pause, <R> to Restart, <SPACE> to Resume!", 100, 530);

		if (GameDriverV4.Keys[KeyEvent.VK_1]) {
			gameState = 3;

		}
		if (GameDriverV4.Keys[KeyEvent.VK_2]) {
			gameState = 4;

		}

		if (left) {
			if (GameDriverV4.Keys[KeyEvent.VK_ENTER]) {
				gameState = 1;
				pause = true;
			}

			win.drawImage(flash.loop(), null, 90, 200);
		}
		if (!left) {
			if (GameDriverV4.Keys[KeyEvent.VK_ENTER]) {
				gameState = 2;
				pause = true;

			}
			win.drawImage(flash.loop(), null, 390, 200);
		}

		if (GameDriverV4.Keys[KeyEvent.VK_LEFT]) {
			left = true;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_RIGHT]) {
			left = false;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_3]) {
			gameState = 5;
			// pause = true;

		}
		if (GameDriverV4.Keys[KeyEvent.VK_4]) {
			gameState = 6;
			// pause = true;

		}
		if (GameDriverV4.Keys[KeyEvent.VK_5]) {
			gameState = 7;
			// pause = true;
		}
		if (GameDriverV4.Keys[KeyEvent.VK_6]) {
			gameState = 8;
			// pause = true;
		}
		if (GameDriverV4.Keys[KeyEvent.VK_7]) {
			gameState = 9;
			// pause = true;
		}
	
	}

	public void monteCarlos(Graphics2D win) {
		/**
		 * This is the monteCarlos method which draws the simulation for Monte Carlo's
		 * simulation.
		 * 
		 * @param win
		 */

		success = 0;

		// Pauses the game if pause is false;
		if (pause == true) {
			for (int i = 0; i < 5000; i++) {
				if (timer > delay) {
					flag.add(new JapaneseFlag());
					timer = 0;
				} else {
					timer++;
				}
			}
		}

		for (JapaneseFlag d : flag) {
			d.moveAndDraw(win);

			if (d.takeAHit == true) {
				success++;
			}
		}

		totalarea = success * Global.height * Global.width / flag.size();

		win.setColor(fontcolor);
		win.setFont(f1);
		win.drawString("Pi is kinda = " + totalarea / Math.pow(Global.radius, 2), 0, Global.height - 100);
		System.out.println(success + ":" + flag.size());
		this.back(win);
	}

	public void buffonsNeedle(Graphics2D win) {
		/**
		 * This is the buffonsNeedle method which draws the simulation for Buffon's
		 * Needle.
		 * 
		 * @param win
		 */
		success = 0;

		// Pauses the game if pause is false;
		if (pause == true) {
			for (int i = 0; i < 10; i++) {
				if (timer > delay) {
					needles.add(new Buffon());
					timer = 0;
				} else {
					timer++;
				}

			}
		}

		for (Buffon b : needles) {
			b.moveAndDraw(win);

			if (b.hasHit == true) {
				success++;
			}

		}

		totalarea = needles.size() / success;

		win.setColor(Color.BLUE);
		win.setFont(f1);
		win.drawString("Pi is kinda = " + totalarea, 0, Global.height - 100);
		System.out.println(success + ":" + needles.size());

		this.back(win);
	}

	public void recursiveRectangles(Graphics2D win) {

		recurs.moveAndDraw(win);

		win.setColor(Color.CYAN);
		win.setFont(f1);
		win.drawString("It's IVY Day bois", 20, 540);

		this.back(win);
	}

	public void recursiveLines(Graphics2D win) {

		h.drawLine(win);

		this.back(win);
	}

	public void recursiveTree(Graphics2D win) {

		lines.moveAndDraw(win);

		this.back(win);
	}

	public void triForce(Graphics2D win) {

		tri.moveAndDraw(win);

		this.back(win);
	}

	public void bigChungus(Graphics2D win) {

		chungus.moveAndDraw(win);

		this.back(win);
	}
	
	public void cokeLine(Graphics2D win) {

		flake.moveAndDraw(win);

		this.back(win);
	}
	
	public void mandelBrot(Graphics2D win) {

		brot.moveAndDraw(win);

		this.back(win);
	}
	
	public void mandelCheck(Graphics2D win) {

		brot.moveAndDraw(win);

		this.back(win);
	}

	public void back(Graphics2D win) {
		/**
		 * This is the back method, which brings user back to splashScreen with R,
		 * ESCAPE, and SPACE.
		 * 
		 * @param win
		 */

		if (GameDriverV4.Keys[KeyEvent.VK_R]) {
			reset();
			gameState = 0;
		}

		if (GameDriverV4.Keys[KeyEvent.VK_ESCAPE]) {
			pause = false;
		}

		else if (GameDriverV4.Keys[KeyEvent.VK_SPACE]) {
			pause = true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * This is the main method.
		 * 
		 * @param args
		 *            Unused.
		 * @return Nothing.
		 * 
		 */
		Main buffonAndMonte = new Main();
		buffonAndMonte.start();
		buffonAndMonte.setBackGroundColor(col);
		buffonAndMonte.setFocusable(true);

	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub

		/**
		 * This is the draw method
		 */
		if (gameState == 0) {
			this.splashScreen(win);
		} else if (gameState == 1) {
			this.monteCarlos(win);
		} else if (gameState == 2) {
			this.buffonsNeedle(win);
		} else if (gameState == 3) {
			this.recursiveRectangles(win);
		} else if (gameState == 4) {
			this.recursiveLines(win);
		} else if (gameState == 5) {
			this.recursiveTree(win);
		} else if (gameState == 6) {
			this.triForce(win);
		} else if (gameState == 7) {
			this.bigChungus(win);
		}else if (gameState == 8) {
			this.cokeLine(win);
		}else if (gameState == 9) {
			this.mandelBrot(win);
		}
	}
}
