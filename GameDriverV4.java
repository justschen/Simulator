/**
 * @(#)GameDriverV4.java
 *
 *
 * updates:  jframe included, keylistener included, switch to render, game loop
 *    from tasktimer to thread  - needs more testing sorry
 * 
 * 
 * @version 4.0 9/13/2018
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;



public abstract class GameDriverV4 extends Canvas implements Runnable, KeyListener   {

	private int FramesPerSecond;
	protected static boolean[] Keys;
	private JFrame frame;

	private Color backGroundColor = Color.BLUE;
	private String title = "3.141592653589793238462643383279502884197169399375105820974944592307816406286 208998628034825342117067982148086513282306647093844609550582231725359408128481 117450284102701938521105559644622948954930381964428810975665933446128475648233";
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	//private int width = screenSize.width -920, height = screenSize.height - 270;
	private int width = 800, height = 600;
	
	public GameDriverV4(int frames) {
		// set up all variables related to the game
		FramesPerSecond = frames;
		
		this.addKeyListener(this);
	
		// key setup
		Keys = new boolean[KeyEvent.KEY_LAST];
		//Keys2 = new boolean[KeyEvent.KEY_LAST];
		
	}
	public GameDriverV4() {
		// default setting (60 frames per second)
		this(60);
		
	}
	
	public void start() {
		
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.add(this);
		frame.setVisible(true);
		
		this.startThread();
		
	}
	
	private synchronized void  startThread() {
		Thread t1 = new Thread(this);
		t1.start(); // calls run method after paint 
		
	
		
	}
	
	
	public void setFrames(int num) {
		this.FramesPerSecond = num;
	}
	
	
	
	
	
	private void render() {
		
		BufferStrategy buffs = this.getBufferStrategy();
		if (buffs == null) {
			this.createBufferStrategy(3);
			buffs = this.getBufferStrategy();
		}
		
		
		Graphics g = buffs.getDrawGraphics();
		
		g.setColor(this.backGroundColor);
		g.fillRect(0, 0, getWidth(), getHeight());
		draw((Graphics2D) g);
		
		g.dispose();
		
		buffs.show();
		
	}
	
	public abstract void draw(Graphics2D win);

	
	 public void run() {
		 
		
		 	this.setFocusable(true);

	        long beforeTime, timeDiff, sleep;

	        beforeTime = System.currentTimeMillis();

	        while (true) {

	            timeDiff = System.currentTimeMillis() - beforeTime;
	            
	            sleep = 1000 / this.FramesPerSecond - timeDiff;

	            if (sleep < 0) {
	                sleep = 2;
	            }

	            try {
	                Thread.sleep(sleep);
	            } catch (InterruptedException e) {
	                
	                String msg = String.format("Thread interrupted: %s", e.getMessage());
	                System.out.println(msg);
	              
	            }
	            
	            render();
	            beforeTime = System.currentTimeMillis();
	        }
	    }
	
	
	public BufferedImage addImage(String name)  {

		BufferedImage img = null;
		//Graphics r = B.getGraphics();
		
		try {
		
			img = ImageIO.read(this.getClass().getResource(name));
			
		
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return img;

	}
	public Color getBackGroundColor() {
		return backGroundColor;
	}
	public void setBackGroundColor(Color backGroundColor) {
		this.backGroundColor = backGroundColor;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Keys[e.getKeyCode()] = true;
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Keys[e.getKeyCode()] = false;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//Keys[e.getKeyCode()] = true;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
