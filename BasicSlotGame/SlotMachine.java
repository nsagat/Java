import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SlotMachine {
    private int num1, num2, num3;
    private int winnings;
    private int balance;
    private int currentBet;

    public SlotMachine(int initialBalance) {
        this.balance = initialBalance;
        this.currentBet = 1;
    }

    public void drawMe(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, 400, 400);

        // Draw the machine border
        g.setColor(Color.black);
        g.drawRect(50, 50, 300, 200);

        // Draw lines between spinning numbers
        g.drawLine(150, 50, 150, 250);
        g.drawLine(250, 50, 250, 250);

        // Draw the spinning numbers
        Font font = new Font("Arial", Font.PLAIN, 50);
        g.setFont(font);
        g.drawString(String.valueOf(num1), 100, 150);
        g.drawString(String.valueOf(num2), 200, 150);
        g.drawString(String.valueOf(num3), 300, 150);

        // Draw balance, winnings, and bet amount
        Font infoFont = new Font("Arial", Font.PLAIN, 15);
        g.setFont(infoFont);
        g.drawString("Balance: " + balance, 10, 20);
        g.drawString("Winnings: " + winnings, 10, 40);
        g.drawString("Bet: " + currentBet, 10, 60);

        // Display the table
        displayPayoutTable(g);
    }

    public void displayPayoutTable(Graphics g) {
        // Display the payout table
        Font payoutFont = new Font("Arial", Font.BOLD, 15);
        g.setFont(payoutFont);
        g.drawString("Payout Table:", 200, 270);
        g.drawString("777 = " + (100 * currentBet) + " points", 200, 290);
        g.drawString("3 of a kind = " + (5 * currentBet) + " points", 200, 310);
        g.drawString("2 of a kind = " + (2 * currentBet) + " points", 200, 330);
    }

    public void play() {
        // Generate 3 new random numbers
        num1 = (int) (Math.random() * 9 + 1);
        num2 = (int) (Math.random() * 9 + 1);
        num3 = (int) (Math.random() * 9 + 1);

        // Calculate winnings and update balance
        if (num1 == num2 && num2 == num3) {
            winnings = 100 * currentBet;
        } else if (num1 == num2 || num2 == num3 || num1 == num3) {
            winnings = 5 * currentBet;
        } else if (num1 == num2 || num2 == num3 || num1 == num3) {
            winnings = 2 * currentBet;
        } else {
            winnings = 0;
        }

        balance = balance - currentBet + winnings;
    }

    public void setBet(int bet) {
        // Set the current bet amount
        this.currentBet = bet;
    }

    public int getBalance() {
        return balance;
    }

    public int getWinnings() {
        return winnings;
    }
}