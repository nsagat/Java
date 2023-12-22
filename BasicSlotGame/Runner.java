import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Slot Machine");
        SlotMachine slotMachine = new SlotMachine(100);
        Screen screen = new Screen(slotMachine);

        JButton spinButton = new JButton("Spin");
        spinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slotMachine.play();
                screen.repaint();
                System.out.println("Balance: " + slotMachine.getBalance());
                System.out.println("Winnings: " + slotMachine.getWinnings());
            }
        });

        JButton bet1Button = new JButton("Bet 1");
        bet1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slotMachine.setBet(1);
                System.out.println("Current Bet: " + slotMachine.getWinnings());
            }
        });

        JButton bet5Button = new JButton("Bet 5");
        bet5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slotMachine.setBet(5);
                System.out.println("Current Bet: " + slotMachine.getWinnings());
            }
        });

        JButton bet10Button = new JButton("Bet 10");
        bet10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slotMachine.setBet(10);
                System.out.println("Current Bet: " + slotMachine.getWinnings());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(spinButton);
        buttonPanel.add(bet1Button);
        buttonPanel.add(bet5Button);
        buttonPanel.add(bet10Button);

        frame.add(screen);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}