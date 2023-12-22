import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
public class Enemy{
    private double x;
    private double y;

    private double width;
    private double height;
    
    private int direction;
     
    private Color green;
    private boolean visible;
    
    private BufferedImage enemies;
    private BufferedImage gameover;
     
    public Enemy(){
    	//1 is right 2 is  left
        direction = 1;
        //this.x = x;
        //this.y = y;
        
        x = (int)(Math.random()*760)+1;
    	y = (int)(Math.random()*300)+1;
         
        this.width = 40;
        this.height = 40;
         
        this.green = new Color(0,255,00);
        this.visible = true;
        
        try {
            enemies = ImageIO.read(new File("enemy.png"));
         } catch (IOException e) {
              e.printStackTrace();
         }
        

             
    }
     
 
    public void drawMe(Graphics g){
     
    	if(visible == true) {
	        g.drawImage(enemies, (int)x, (int)y, (int)width, (int)height,null);   
    	
    	}
    	
    }
    public  void  move() {
    	y = y+ .2;
    	if(direction == 1) {
    		x= x+.4;
    	}
    	else if(direction == 2) {
    		x = x-.4;
    	}
    	
    	if(x > 800) {
    	 direction= 2;
    		
    	}
    	else if(x<0) {
    		direction = 1;
    	}
    }
    
    
    public  int getX() {
    	return (int)x;
    }
    public int getY() {
    	return  (int)y;
    }
    public int getWidth() {
    	return (int)width;
    }
    public int getHeight() {
    	return (int)height;
    }
    
    public void  die(int points) {
    	visible = false;
    	y=0;
    	if(y >= 590) {
    		points = 0;
    		//y++;
    	}
    	
    }
    
    
    public void resetY() {
    	y =(int)(Math.random()*260)+1;
    	
    }
    public void resetX() {
    	x = (int)(Math.random()*760)+1;
    }
    
    
    public boolean getVisible() {
    	return visible;
    	
    }
     
 
     
     
 
 
}