import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
public class Ship{
    private int x;
    private int y;
     
    private int width;
    private int height;
     
    private Color blue;
    
    private BufferedImage ship;
    public Ship(int x, int y){
         
        this.x = x;
        this.y = y;
         
        this.width = 50;
        this.height = 50;
         
        this.blue = new Color(0,0,255);
       
        
       
        try {
        	//don't forgot to change it to ship.png
            ship = ImageIO.read(new File("ship.png"));
         } catch (IOException e) {
              e.printStackTrace();
         }
        
 
    }
     
 
    public void drawMe(Graphics g){
       // g.setColor(blue);
       // g.fillRect(x,y,width,height);
       g.drawImage(ship, x - 20, y, width, height,null);
    }
     
    public void moveLeft(){
        x = x - 6;
    }
     
    public void moveRight(){
        x = x + 6;
    }
    
    public int getX() {
    	return x;
    	
    }
    public int getY() {
    	return y;
    	
    }
    
    
    
    
     
}