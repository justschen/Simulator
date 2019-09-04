import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Lines extends Line2D{
	
		int initialX, initialY, length, endX, endY;
	
	
	public Lines() {
		// TODO Auto-generated constructor stub
		//initialX = r1.nextInt(800);
		//initialY = r1.nextInt(600);
		length = 50;

		//endX = initialX + (int) (Math.cos(Math.toRadians(angle)) * length);
		//endY = initialY + (int) (Math.sin(Math.toRadians(angle)) * length);

		
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point2D getP1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point2D getP2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getX1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getX2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		
	}

}
