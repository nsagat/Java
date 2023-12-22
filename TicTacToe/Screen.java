import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Screen extends JPanel implements ActionListener,MouseListener{
    private String X;
    private int y;
    private int x;
	private Game game;
	private int result;s
	private int player1win;
	private int player2win;
	private int computerwin;
	private JButton newgameButton;
	private int box;
	
	
	public Screen() {
		game = new Game();
		addMouseListener(this);	D
		newgameButton = new JButton("New Game");
		newgameButton.setBounds(550,300,200, 300);
		add(newgameButton);
		newgameButton.addActionListener(this);
		newgameButton.setVisible(true);
		
		//if box == 1 player vs player
		//if box == 2 player vs computer
		box = 1;
		
		//String [] choose = { "Player vs Player" , "Player vs Computer" };
	}
	
	 public Dimension getPreferredSize() {
	        //Sets the size of the panel
	        return new Dimension(700,700);
	    }
	public void paintComponent(Graphics g){
		super.paintComponent(g);
			game.printTable();
			
			while(newgameButton.isVisible()==false) {
				game.drawMe(g);
					g.drawString("Player1: "+ player1win, 20, 550);
					g.drawString("Player2: " + player2win,20,580);
					
					int result = game.checkTicTacToe();
					boolean full = game.checkFull();
					if(result == 1) {
						g.drawString("Player1 won!",500,300);
						playWinning();
						player1win++;
						newgameButton.setVisible(true);
						break;
					}
					if(result == 2) {
						g.drawString("Player2 won!",500,300);
						player2win++;
						playWinning();
						newgameButton.setVisible(true);
						break;
					}
					if(full == true) {
						playLose();
						newgameButton.setVisible(true);
						g.drawString("TIE!",500,300);
						
						break;
					}
					repaint();
					break;
			}
			
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		//Print location of x and y
        System.out.println("X: " + e.getX() + ", Y: " + e.getY());
        playHit();
        if(newgameButton.isVisible() == false) {
	        //Check if mouse pressed position is in the brown box
	        //1st box
	        if (e.getX() >= 50 && e.getX() <= 182 && e.getY() >= 77 && e.getY() <= 226) {
	        	x = 110;
	        	y = 140;
	           
	
	            game.insertXO(0, 0);
	          
	        }
	        //2nd box
	        else if(e.getX() >= 184 && e.getX() <= 316 && e.getY() >= 77 && e.getY() <= 226){
	        	x= 240;
	        	y = 140;
	            
	
	            game.insertXO(0, 1);
	        }
	        //3rd box
	        else if(e.getX() >= 317 && e.getX() <= 448 && e.getY() >= 77 && e.getY() <= 226){
	            x = 390;
	            y = 140;
	        	game.insertXO(0, 2);
	
	        }
	        //4th box
	        else if (e.getX() >= 50 && e.getX() <= 182 && e.getY() >= 228 && e.getY() <= 377) {
	        	x = 110;
	        	y = 140;
	        	game.insertXO(1, 0);
	
	        }
	        //5th box
	        else if(e.getX() >= 184 && e.getX() <= 316 && e.getY() >= 228 && e.getY() <= 377){
	        	x= 240;
	        	y = 140;
	            game.insertXO(1, 1);
	
	        }
	        //6th box
	        else if( e.getX() >= 317 && e.getX() <= 448 && e.getY() >= 228 && e.getY() <= 377){
	        	x = 390;
	            y = 140;
	        	game.insertXO(1, 2);
	
	        }
	        else if( e.getX() >= 50 && e.getX() <= 182 && e.getY() >= 377 && e.getY() <= 526){
	        	x = 390;
	            y = 140;
	        	game.insertXO(2, 0);
	
	        }
	        else if( e.getX() >= 184 && e.getX() <= 316 && e.getY() >= 377 && e.getY() <= 526){
	        	x = 390;
	            y = 140;
	        	game.insertXO(2, 1);
	
	        }
	        else if( e.getX() >= 317 && e.getX() <= 448 && e.getY() >= 377 && e.getY() <= 526){
	        	x = 390;
	            y = 140;
	        	game.insertXO(2, 2);
	
	        }
        }
       
 
        repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == newgameButton){
			playStart();
			game.reset();
			newgameButton.setVisible(false);
			//repaint();
		}
	}

	public void playLose(){
		try {
            URL url = this.getClass().getClassLoader().getResource("sound/lose.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

	}
	public void playWinning(){
		try {
            URL url = this.getClass().getClassLoader().getResource("sound/winning.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

	}
	public void playHit(){
		try {
            URL url = this.getClass().getClassLoader().getResource("sound/hit.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

	}
	public void playStart(){
		try {
            URL url = this.getClass().getClassLoader().getResource("sound/start.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
	}	

}
