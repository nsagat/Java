import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Screen extends JPanel implements MouseListener,ActionListener{
	
	private Square[][] grid;
	private Square[][] colorPallete;
	private int red;
	private int green;
	private int blue;
	private JButton clearButton;
	


	public Screen(){
		
		setLayout(null);
		
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(600,400,100,50);
		add(clearButton);
		clearButton.addActionListener(this);
		clearButton.setVisible(true);
		
		
		
		
		
		grid = new Square[16][16];
		colorPallete = new Square[9][4];

		addMouseListener(this);	
		//fill the grid with white squares.
		for(int r = 0; r < grid.length;r++){
			for(int c  = 0; c < grid[r].length;c++){
				grid[r][c] = new Square(255,255,255);

			}
		}
		
		red = 60;
		green = 20;
		blue = 80;
		for(int r = 0; r < colorPallete.length;r++) {
			for(int c = 0; c < colorPallete[r].length;c++) {
				colorPallete[r][c] = new Square(red, green, blue);
				red += 5;
				green += 5;
				//blue += 5;
				
			}
			
		}
		
		
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
		
	}
	//public void pickColor() {
		
		
		//for(int r = 0; r < colorPallete.length;r++) {
			//for(int c = 0; c < colorPallete[r].length;c++) {
				//colorPallete[r][c].setColor(red, green, blue);
			//}
		//}
		//repaint();
		
//	}
	public void clear() {
		for(int r = 0; r < grid.length;r++) {
			for(int c = 0; c < grid[r].length;c++) {
				grid[r][c].setColor(255,255,255);
			}
		}
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int x = 10;
		int y = 10;
		for(int r = 0; r < grid.length;r++){
			for(int c  = 0; c < grid[r].length;c++){
				grid[r][c].drawMe(g,x,y);
				x += 30;
			}
			x = 10;
			y += 30;
		}
		
		x = 600;
		y = 50;
		for(int r = 0; r < colorPallete.length;r++) {
			for(int c = 0; c < colorPallete[r].length;c++) {
				colorPallete[r][c].drawMe(g, x, y);
				x+=30;
			}
			x = 600;
			y += 30;
		}
	
		repaint();
	}
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("X: " + e.getX() + ", Y: " + e.getY());
		
		for(int r = 0; r < colorPallete.length;r++) {
			for(int c = 0; c < colorPallete.length;c++) {
				if(e.getX() >= 30 * c + 600 && e.getX() < 31 * c + 30+600 && e.getY() > 30 * r + 50 && e.getY() < 31 *r+ 30+50) {
					System.out.println("hi");
					red = colorPallete[r][c].getRed();
					green = colorPallete[r][c].getGreen();
					blue = colorPallete[r][c].getBlue();
					
					
				}
				
			}
		}
		
		for(int r = 0; r < grid.length;r++){
			for(int c = 0; c < grid[r].length;c++){
				if(e.getX()>=30 *c +10 && e.getX() < 31*c+30 && e.getY() > 30*r +10 && e.getY() < 31*r+30){
					grid[r][c].setColor(red,green,blue);
					break;
				}
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
		// TODO Auto-generated method stub
		if(e.getSource() == clearButton) {
			clear();
		}
		
	}
	

}