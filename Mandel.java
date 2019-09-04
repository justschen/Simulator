import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mandel extends Fractals implements MouseListener{

	double scale = 2;
	Complex comp = 	new Complex(0, 0);;
	
	public Mandel() {
		// TODO Auto-generated constructor stub
	
		
	}
	
	public void moveAndDraw(Graphics2D win) {
		super.moveAndDraw(win);
		win.setColor(Color.WHITE);
		//check pixels on window
		for (int i = 0; i< Global.width;i++) {
			for (int j = 0; j<Global.width; j++) {
		//linear transformation
		// Linear transformation (0,800) -> (-2, 2)
			
		 //real
			double real = (2*scale*j/Global.width) - scale;
			double img = (2*scale*i/Global.width) - scale;
		
			Complex z = new Complex (real, img);
			
			if (z.isMandelBrot(comp,layers)) {
				win.fillRect(j, i, 1,1);
				
			}
			
	
				
			}
		}
		
		
	}
	
	



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
