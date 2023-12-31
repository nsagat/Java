import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
public class Card {
	private int value;
	private String name;
	private String suit;
	private BufferedImage suitImage;
	
	public Card(int value,String name,String suit){
		this.value = value;
		this.name = name;
		this.suit = suit;
		
		if(suit.equals("hearts")){
			try{
				suitImage = ImageIO.read(new File("images/hearts.png"));
			}catch(IOException e){
				System.out.println(e);
			}
		}
		if(suit.equals("diamonds")){
			try{
				suitImage = ImageIO.read(new File("images/diamonds.png"));
			}catch(IOException e){
				System.out.println(e);
			}
		}
		if(suit.equals("spades")){
			try{
				suitImage = ImageIO.read(new File("images/spades.png"));
			}catch(IOException e){
				System.out.println(e);
			}
		}
		if(suit.equals("clubs")){
			try{
				suitImage = ImageIO.read(new File("images/clubs.png"));
			}catch(IOException e){
				System.out.println(e);
			}
		}

		
	}
	public void drawMe(Graphics g, int x, int y){
		
		//draw the card
		g.setColor(Color.WHITE);
		g.fillRect(x,y,120,150);
		g.setColor(Color.BLACK);
		g.drawRect(x,y,120,150);
		
		//draw the card name
		Font font = new Font("Arial",Font.PLAIN,50);
		g.setFont(font);
		if(suit.equals("hearts") || suit.equals("diamonds")){
			g.setColor(Color.RED);
			
		}
		g.drawString(name, x+30,y+100);
		
		//draw suit image
		g.drawImage(suitImage,x+2,y,null);
		
		
	}
	public int getValue(){
		return value;
	} 
 
}
