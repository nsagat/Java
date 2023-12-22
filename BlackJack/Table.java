import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Table extends JPanel implements ActionListener{
	private JButton hitButton;
	private JButton startButton;
	private JButton standButton;
	private Card[] deck;
	private int playerIndex;
	private int points;
	private int totalPoints;
	private boolean check;
    public Table(){
        setLayout(null);


        check = false;

        standButton = new JButton("Stand");
        standButton.setBounds(200,10,100,30);
        standButton.addActionListener(this);
        add(standButton);

        hitButton = new JButton("Hit");
        hitButton.setBounds(10,10,100,30);
        hitButton.addActionListener(this);
        add(hitButton);

        startButton = new JButton("START THE GAME");
        startButton.setBounds(250,500,250,50);
        startButton.addActionListener(this);
        add(startButton);

		deck = new Card[52];
		deck[0] = new Card(2,"2","hearts");
		deck[1] = new Card(3,"3","hearts");
		deck[2] = new Card(4,"4","hearts");
		deck[3] = new Card(5,"5","hearts");
		deck[4] = new Card(6,"6","hearts");
		deck[5] = new Card(7,"7","hearts");
		deck[6] = new Card(8,"8","hearts");
		deck[7] = new Card(9,"9","hearts");
		deck[8] = new Card(10,"10","hearts");
		deck[9] = new Card(10,"J","hearts");
		deck[10] = new Card(10,"Q","hearts");
		deck[11] = new Card(10,"K","hearts");
		deck[12] = new Card(11,"A","hearts");

		deck[13] = new Card(2,"2","diamonds");
		deck[14] = new Card(3,"3","diamonds");
		deck[15] = new Card(4,"4","diamonds");
		deck[16] = new Card(5,"5","diamonds");
		deck[17] = new Card(6,"6","diamonds");
		deck[18] = new Card(7,"7","diamonds");
		deck[19] = new Card(8,"8","diamonds");
		deck[20] = new Card(9,"9","diamonds");
		deck[21] = new Card(10,"10","diamonds");
		deck[22] = new Card(10,"J","diamonds");
		deck[23] = new Card(10,"Q","diamonds");
		deck[24] = new Card(10,"K","diamonds");
		deck[25] = new Card(11,"A","diamonds");

		deck[26] = new Card(2,"2","spades");
		deck[27] = new Card(3,"3","spades");
		deck[28] = new Card(4,"4","spades");
		deck[29] = new Card(5,"5","spades");
		deck[30] = new Card(6,"6","spades");
		deck[31] = new Card(7,"7","spades");
		deck[32] = new Card(8,"8","spades");
		deck[33] = new Card(9,"9","spades");
		deck[34] = new Card(10,"10","spades");
		deck[35] = new Card(10,"J","spades");
		deck[36] = new Card(10,"Q","spades");
		deck[37] = new Card(10,"K","spades");
		deck[38] = new Card(11,"A","spades");

		deck[39] = new Card(2,"2","clubs");
		deck[40] = new Card(3,"3","clubs");
		deck[41] = new Card(4,"4","clubs");
		deck[42] = new Card(5,"5","clubs");
		deck[43] = new Card(6,"6","clubs");
		deck[44] = new Card(7,"7","clubs");
		deck[45] = new Card(8,"8","clubs");
		deck[46] = new Card(9,"9","clubs");
		deck[47] = new Card(10,"10","clubs");
		deck[48] = new Card(10,"J","clubs");
		deck[49] = new Card(10,"Q","clubs");
		deck[50] = new Card(10,"K","clubs");
		deck[51] = new Card(11,"A","clubs");

		standButton.setVisible(false);
        hitButton.setVisible(false);

		totalPoints = 20;
    }
     
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1000,600);
    }
 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
         
        g.setColor(Color.green);
        g.fillRect(0,0,1000,600);
		
		//draw Cards
		int x = 20;
		int y = 200;
		for(int i =0;i<playerIndex;i++){
			deck[i].drawMe(g, x, y);

			x += 80;
			
		}

		Font font = new Font("Arial",Font.PLAIN,30);
		g.setFont(font);

		g.setColor(Color.BLACK);
		g.drawString("Points: " + points,10,70);
		g.drawString("Total Points: " + totalPoints,750,70);
/*
		if(points == 21){
			g.drawString("YOU WON!",50,200);
			totalPoints++;
			startButton.setVisible(true);
		}
		*/
		if(points == 21){
			totalPoints++;
			startButton.setVisible(true);
		}
		if(points > 21){
			this.playSound2();
			g.drawString("YOU LOST!",50,190);
			startButton.setVisible(true);
			//repaint();
			

		}
		if(points <=21 && startButton.isVisible() == true && points>=16){

			g.drawString("YOU WON!",50,190);
			if(points == 17){
				g.drawString("+1 point",210,190);
			}
			if(points == 16){
				g.drawString("+1 point",210,190);
			}
			if(points == 18){
				g.drawString("+1 points",210,190);
			}
			if(points == 19){
				g.drawString("+2 points",210,190);
			}
			if(points == 20){
				g.drawString("+3 points",210,190);
			}
			if(points == 21){
				g.drawString("+5 points",210,190);
			}
			this.playSound();
		}
    }

    public void playSound(){
    	try {
            URL url = this.getClass().getClassLoader().getResource("sound/winning.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

    }
    public void playSound2(){
         try {
            URL url2 = this.getClass().getClassLoader().getResource("sound/lose.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url2));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    public void playSound3(){
         try {
            URL url1 = this.getClass().getClassLoader().getResource("sound/hit.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url1));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    public void playSound4(){
         try {
            URL url4 = this.getClass().getClassLoader().getResource("sound/enter.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url4));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
 
    private void shuffle(){
        //write code to shuffle your deck
    	int i;
        for(int k = 0; k< deck.length-1;k++){
        	i = (int)(Math.random()*52);
        	Card temp = deck[i];
        	deck[i] = deck[0];
        	deck[0] = temp;	
        }
        for(int j = 0; j< deck.length-1;j++){
        	i = (int)(Math.random()*52);
        	Card temp = deck[i];
        	deck[i] = deck[20];
        	deck[20] = temp;	
        }
        for(int j = 0; j< deck.length-1;j++){
        	i = (int)(Math.random()*52);
        	Card temp = deck[i];
        	deck[i] = deck[7];
        	deck[7] = temp;	
        }
    }

    public void actionPerformed(ActionEvent e) {
    	if( e.getSource() == hitButton){
    		if(points < 21){
    			this.playSound3();
	    		points = 0;
	    		
	    		playerIndex++;
	    		
	    		for(int i =0;i<playerIndex;i++){
	    			points += deck[i].getValue();

	    		}
	    		check = false;
	    		repaint();
    		}
    		
    	}
    	if(e.getSource() == startButton){
    		this.playSound4();
	    		points = 0;
	    		playerIndex = 2;	
				shuffle();
				for(int i =0;i<playerIndex;i++){
		    			points += deck[i].getValue();
			    	}
		    	totalPoints--;
		    	check = false;

		    	
		    	startButton.setVisible(false);
		    	hitButton.setVisible(true);
		    	standButton.setVisible(true);
		    	
				repaint();		    	
    		
    	}

    	if(points>=16){
    		if(e.getSource() == standButton){
	    		if(points == 17){
	    			totalPoints++;

	    		}
	    		if(points == 18){
	    			totalPoints++;

	    		}
	    		if(points == 19){
	    			totalPoints += 2;

	    		}
	    		if(points == 20){
	    			totalPoints +=3;

	    		}
	    		if(points == 16){
	    			totalPoints++;

	    		}
	    		hitButton.setVisible(false);
	    		startButton.setVisible(true);
	    		standButton.setVisible(false);
	    		check = true;
	    		repaint();
	    	}

    	}


    	
    }

}
