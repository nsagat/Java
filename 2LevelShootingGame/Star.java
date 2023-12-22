import java.awt.Color;
import java.awt.Graphics;
 
 
public class Star{
	private int x;
	private int y;
	private Color white;
	//you can set x and y to parameter
	public Star() {
		// x should within 0-798
		x = (int)(Math.random() * 799);
		// y should within 0-595
		y = (int)(Math.random()*596);
		
		white = new Color(255,255,255);
		
		
	}
	
    public void drawMe(Graphics g) {
    	 g.setColor(white);
    	 g.fillRect(x, y, 2, 2);
     }
    public void moveDown() {
    	y++;
    	if(y > 610) {
    		y = -1;
    		x = (int)(Math.random() * 799);
    		
    	}
    }
     
     
}