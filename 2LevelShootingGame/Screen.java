import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
public class Screen extends JPanel implements KeyListener{
	
	private Color black;
	private Color red;
	private Color yellow;
	private Color white;
	
	int sunY;
	int moonY;
	
    private Projectile p1;
    private Ship s1;
    private Enemy[] enemies;
    private Star[] stars;
    private Hearts[] hearts;
    
    private boolean visibleLevel2;
    //belli bir zaman sonra level iki visible olsun
    private int timer;
    
    private int countheart;
    
    private int background;
    
    private boolean gameovervalue;
    private boolean takeLife;

    private BufferedImage gameover;
    
    private int level;
    private int enemyCount;

    private boolean mygameresult=false;
    
    public Screen(){
    	timer = 0;
    	visibleLevel2 = false;
    	takeLife = true;
    	gameovervalue = false;

    	try {
            gameover = ImageIO.read(new File("gameover.png"));
         } catch (IOException e) {
              e.printStackTrace();
         }
    	
    	black = new Color(0,0,0);
    	red = new Color(255,88,79);
         
        s1 = new Ship(400,550);
        p1 = new Projectile(400,550);
        
        stars  = new Star[100];
		for(int i = 0; i< stars.length; i++) {
			stars[i] = new Star();
		}
        
        setFocusable(true);
        addKeyListener(this);

        sunY = 800;
        moonY = 0;
        
        yellow = new Color(255,255,0);
        white = new Color(220,220,220);
   	

    }
 
    public void scrInitialize(int gamelevel) {
		level = gamelevel;
      	countheart = 2;
    	  	
    	
		if(level  == 1) {
			enemyCount  = 10;
			enemies = new Enemy[enemyCount];
	        for(int i = 0; i< enemies.length; i++) {
				enemies[i] = new Enemy();
			}
		}
		if(level == 2) {
			enemyCount = 20;
			enemies = new Enemy[enemyCount];
	        for(int i = 0; i< enemies.length; i++) {
				enemies[i] = new Enemy();
			}
		}
        hearts = new Hearts[3];
        for(int i = 0; i< hearts.length; i++) {
			hearts[i] = new Hearts();
		}
        
    }
    
    
    
    public Dimension getPreferredSize() {
        //Sets the size of the panel
            return new Dimension(800,600);
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(level == 1) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);
        }
        if(level == 2) {
        	g.setColor(red);
        	 g.fillRect(0, 0, 800, 600);
        	 g.setColor(yellow);
             g.fillOval(400+(int)(250*Math.sin(0.005*sunY)),300 + (int)(250*Math.cos(0.005*sunY)),75,75);
             sunY++;
             g.setColor(white);
             g.fillOval(400+(int)(250*Math.sin(0.0052*moonY))+10,300 + (int)(250*Math.cos(0.0052*moonY))+10,55,55);
             moonY++;
        	 
        	 
        }
         
        for(int i = 0; i< stars.length; i++) {
 			stars[i].drawMe(g);
    	}
        //Draw ship
        s1.drawMe(g);
         
        //Draw Projectile
        Font font = new Font("Arial", Font.PLAIN, 25);
        g.setFont(font);
        p1.drawMe(g,enemyCount);
        
        
        //draw enemies
        for(int i = 0; i< enemies.length; i++) {
        	enemies[i].drawMe(g);
        }
        for(int i = 0; i< hearts.length; i++) {
        	hearts[i].drawMe(g,countheart+1);
        }
        if (gameovervalue == true) {
        	g.drawImage(gameover, 0, 0, 800, 600,null);
        	
        	
        }
        
        
    } 
 
    public void gameOver() {
    	System.out.println("GAME OVER");
    	System.out.println("GAME OVER");
    	System.out.println("GAME OVER");
    	System.out.println("GAME OVER");
    	System.out.println("GAME OVER");
    	System.out.println("GAME OVER");
    	gameovervalue = true;
    	repaint();    	
    	
    }
    
    public void runlevel2() {
    	
    	Level2 lvl = new Level2();    	         
        lvl.level2();
    	        
    			
    }
    
    public void animate(int mylevel){
        //level=; 
    	scrInitialize(mylevel);
        while(true){
        	//enemyCount  = 10;
        	//level=2;
        	
        	for(int i = 0; i< stars.length; i++) {
        		stars[i].moveDown();
        	}
            //wait for .01 second
            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            p1.moveRight();
            
            //Controlling enemies crash the lower boundry
            for(int i = 0; i < enemies.length; i++) {
    	        if (enemies[i].getY() == 590) {
    	        	hearts[countheart].die();
    	        	
    	        	if (countheart==0) {
    	        		gameOver();
    	        	}
    	        	countheart--;
    	        	enemies[i].die(0);
    	        	
    	        	for(int j = 0; j < enemies.length;  j++) {
    	        		enemies[j].resetY();
    	        		enemies[j].resetX();
    	        		
    	        	}
    	        	break;
    	        }
                
            }
            
          //checking collision
            for(int i = 0; i < enemies.length; i++) {
            	p1.checkCollision(enemies[i],enemyCount);
            	mygameresult=p1.checkWin();
            	
            	System.out.println("game result = "+mygameresult);
            	if (mygameresult==true){
            		System.out.println("Level Up");
            		runlevel2();
            		break;
            	}
    	        enemies[i].move();
    	        
    	        
                
            }
            
            
            
            
            
            //repaint the graphics drawn
           repaint();
           if (gameovervalue == true) {
        	   break;
        	   
           }
           if (mygameresult == true) {
        	   break;
           }
        }
    
    }
    
    public void keyPressed(KeyEvent e) {
    	System.out.println(e.getKeyCode()); //used to detect what key is pressed
    	
    	if(e.getKeyCode() ==  32) {
    		//set visible of the projectile to true
    		p1.setPosition(s1.getX(), s1.getY() );
    		p1.shoot();
    		
    	} else if(e.getKeyCode() ==  37) {
    		//call the method for the ship to move up
    		s1.moveLeft();
    		//p1.setPosition(s1.getX(), s1.getY() );
    		
    	} else if(e.getKeyCode() ==  39) {
    		//call the method for the ship to move down
    		s1.moveRight();
    		//p1.setPosition(s1.getX(), s1.getY() );
    		
    	}
    	
    	if(e.getKeyCode() == 80) {
    		mygameresult = true;
    		p1.winlevel1();
    		enemyCount = 20;
			enemies = new Enemy[enemyCount];
	        for(int i = 0; i< enemies.length; i++) {
				enemies[i] = new Enemy();
			}
    		runlevel2();
    		
    		
    	}
    	
    
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
    public void keyTyped(KeyEvent e) {
    }
}