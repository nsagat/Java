import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Hearts {
    private BufferedImage heart;
    private boolean visible;
    
    public Hearts() {
    	
    	visible = true;
    	
    	try {
            heart = ImageIO.read(new File("heart.png"));
         } catch (IOException e) {
              e.printStackTrace();
         }
    	
    }
    
    public void drawMe(Graphics g,int cntHeart){
        
    	if(visible == true) {
    		int x = 0;
 	    	int val = 75;
 	        for(int i = 0; i < cntHeart;i++) { 
	    		g.drawImage(heart,val + x, 75, 20,20,null);
	    		x = x+25;
 	        }
    	
    	}
    	
    }
    public void  die() {
    	visible = false;
    }

}
