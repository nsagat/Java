import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
 
public class Projectile{
    private int x;
    private int y;
     
    private int width;
    private int height;
     
    private Color red;
    private Color blue;
    private Color yellow;
    private boolean visible;
    
    private int points;
    private int countEnemy;
    
    private boolean gameresult;
 
     
    public Projectile(int x, int y){
         
        this.x = x;
        this.y = y;
         
        this.width = 10;
        this.height = 10;
        
        this.yellow = new Color(255,255,0);
        this.red = new Color(255,0,0);
        this.blue = new Color(51,51,255);
        this.visible = false;
        
        points  = 0;
    }
    public void shoot() {
    	visible = true;
    }
    
    public void moveRight() {
    	if( visible ) //if visible is true (visible == true)
    		y = y-2;
    	
    	if(y < 5) {
    		//make projectile false so that you can shoot again
    		visible = false;
    	}
    	
    }
    public void setPosition(int x, int y) {
    	if( visible == false ) {
    		this.x = x;
        	this.y = y;
    	}
    }
    
    
    
    public void checkCollision(Enemy e, int count) {
    	if(e.getVisible() ) {
    		//  check collision only when the enemy is visible
    		int pX = x;
        	int pY  = y;
        	int pWidth = width;
        	int pHeight = height;
        	
        	int tX = e.getX();
        	int tY = e.getY();
        	int tWidth = e.getWidth();
        	int tHeight = e.getWidth();
        	
        	if(pX+pWidth >= tX && pX <= tX + tWidth  && 
        	   pY+pHeight >= tY && pY <= tY + tHeight )
        	{
        			System.out.println("Collision");
        			e.die(points);
        			visible = false;
        			this.points = points;
        			this.points++;
        	}
    	}
    }
    
    public boolean checkWin() {
    	if (gameresult == true) {
    		return true;
    	}
    	else return false;
    	
    }
    public void winlevel1() {
    	points  = 10;
    	gameresult =  true;
    	
    }
    public void drawMe(Graphics g,int winIndicator){
    	
    	if(points == winIndicator) {
    		g.setColor(yellow);
    		Font font = new Font("Arial", Font.PLAIN, 40);
            g.setFont(font);
    		g.drawString("YOU WON!!", 300, 300);
    		g.drawString("Total Points: " + points, 300, 350);
    		gameresult=true;
    		
    	}
    	else {
    		g.setColor(blue);
        	g.drawString("Points: " + points, 75, 75);
    	}
        if(visible) {
	        g.setColor(red);
	        g.fillOval(x,y,width,height);
	    }
        
    }
    
 
}