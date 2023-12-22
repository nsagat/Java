import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class Game {
	private int[][] table;
	private int turn;
	private int box;
	
	public Game() {
		// Sets table to be a 3x3 2d array of int. 
		//They should be filled with zeros by default. 
		//Setup the turn variable.
		turn = 1;
		table = new int[3][3];
	}
	public void printTable() {
		 for (int r = 0; r < table.length; r++) {
	            for (int c = 0; c < table[r].length; c++) {
	                System.out.print(table[r][c] + "\t");
	            }
	            System.out.println();
	        }
	        System.out.println();
	}
	public void reset() {
		for(int r = 0; r < table.length;r++) {
			for(int c = 0; c < table[r].length;c++) {
				table[r][c] = 0;
			}
		}
	}
	public void insertXO(int x, int y) {
		if (turn == 1 && table[x][y] == 0) {
            table[x][y] = 1;
            turn = 2;
        } else if (turn == 2 && table[x][y] == 0) {
            table[x][y] = 2;
            turn = 1;
        } else {
            System.out.println("Not allowed - You lose your turn");
            if (turn == 2) {
                turn = 1;
            } else {
                turn = 2;
            }
        }
		printTable();
	}
	public boolean checkFull() {
		int count = 0;
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                if (table[r][c] != 0) {
                    count++;
                }
            }
        }
        if (count == 9) {
            return true;
        }
        return false;
	}
	public int checkTicTacToe() {
        //column 1
        if (table[0][0] == table[1][0] && table[0][0] == table[2][0]) {
            if (table[0][0] == 1) {
                return 1;
            } else if (table[0][0] == 2) {
                return 2;
            }
        }
        //column 2
        if (table[0][1] == table[1][1] && table[0][1] == table[2][1]) {
            if (table[0][1] == 1) { //changed these lines so that they matched up above and didn't just say table[0][0]
                return 1;
            } else if (table[0][1] == 2) {
                return 2;
            }
        }
        //column 3
        if (table[0][2] == table[1][2] && table[0][2] == table[2][2]) {
            if (table[0][2] == 1) {
                return 1;
            } else if (table[0][2] == 2) {
                return 2;
            }
        }
        //row 1
        if (table[0][0] == table[0][1] && table[0][0] == table[0][2]) {
            if (table[0][0] == 1) {
                return 1;
            } else if (table[0][0] == 2) {
                return 2;
            }
        }
        //row 2
        if (table[1][0] == table[1][1] && table[1][0] == table[1][2]) {
            if (table[1][0] == 1) {
                return 1;
            } else if (table[1][0] == 2) {
                return 2;
            }
        }
        //row 3
        if (table[2][0] == table[2][1] && table[2][0] == table[2][2]) {
            if (table[2][0] == 1) {
                return 1;
            } else if (table[2][0] == 2) {
                return 2;
            }
        }

        //diagonal 1 (from 0,0)
        if (table[0][0] == table[1][1] && table[0][0] == table[2][2]) {
            if (table[0][0] == 1) {
                return 1;
            } else if (table[0][0] == 2) {
                return 2;
            }
        }
        //diagonal 2
        if (table[0][2] == table[1][1] && table[0][2] == table[2][0]) {
            if (table[0][2] == 1) {
                return 1;
            } else if (table[0][2] == 2) {
                return 2;
            }
        }
        return 0;
    }

	
	public void drawMe(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(50, 525, 450, 525);
		g.drawLine(50, 75, 450, 75);
		g.drawLine(50, 75, 50, 525);
		g.drawLine(450, 525, 450, 75); // x,y,x,y
		g.drawLine(50, 225, 450, 225);
		g.drawLine(50, 375, 450, 375);
		g.drawLine(183, 75, 183, 525);
		g.drawLine(316, 75, 316, 525);
		int x = 100;
		int y = 70;
		Font font = new Font("Arial",Font.PLAIN,40);
		g.setColor(Color.ORANGE);
		font = new Font("Arial",Font.PLAIN,20);
		g.setFont(font);
		if(turn == 1) {
			g.drawString("Player1's Turn",150,50);
		}
		if(turn == 2) {
			g.drawString("Player2's turn", 150, 50);
		}
		for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
            	/*
               // g.drawString(table[r][c]+"",x,y);
                x += 100;
                if(x == 400) {
                	y = 170;
                	x = 100;
                }
                if(x == 400 && y == 170) {
                	y = 370;
                	x = 100;
                }
                if(x == 400 && y == 370 ) {
                	y = 470;
                	x = 100;
                	
                }
                */
            	g.setColor(Color.BLACK);
            	Font font1 = new Font("Arial",Font.PLAIN,40);
        		font1 = new Font("Arial",Font.PLAIN,30);
        		g.setFont(font1);
        		
        		if(table[r][c] != 0 && table[r][c] == 1 ) {
        			if(r == 0 && c == 0) {
        				x = 100;
        				y = 120;
        			}
        			else if(r == 0 && c == 1) {
        				x = 220;
        				y = 120;
        			}
        			else if(r == 0 && c == 2) {
        				x =340;
        				y = 120;
        			}
        			else if(r == 1 && c == 0) {
        				x = 100;
        				y = 270;
        			}
        			else if(r == 1 && c == 1) {
        				x = 220;
        				y = 270;
        			}
        			else if(r == 1 && c == 2) {
        				x =340;
        				y = 270;
        			}
        			else if(r == 2 && c == 0) {
        				x = 100;
        				y = 470;
        			}
        			else if(r == 2 && c == 1) {
        				x = 220;
        				y = 470;
        			}
        			else if(r == 2 && c == 2) {
        				x =340;
        				y = 470;
        			}
        			g.drawString("X", x, y);
        		}
        		else if(table[r][c] !=0 &&table[r][c] == 2) {
        			if(r == 0 && c == 0) {
        				x = 100;
        				y = 120;
        			}
        			else if(r == 0 && c == 1) {
        				x = 220;
        				y = 120;
        			}
        			else if(r == 0 && c == 2) {
        				x =340;
        				y = 120;
        			}
        			else if(r == 1 && c == 0) {
        				x = 100;
        				y = 270;
        			}
        			else if(r == 1 && c == 1) {
        				x = 220;
        				y = 270;
        			}
        			else if(r == 1 && c == 2) {
        				x =340;
        				y = 270;
        			}
        			else if(r == 2 && c == 0) {
        				x = 100;
        				y = 470;
        			}
        			else if(r == 2 && c == 1) {
        				x = 220;
        				y = 470;
        			}
        			else if(r == 2 && c == 2) {
        				x =340;
        				y = 470;
        			}
        			g.drawString("O", x, y);
        		}
               
            }
        }
	}
}
