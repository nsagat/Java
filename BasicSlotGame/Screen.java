import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Screen extends JPanel {
    private SlotMachine slotMachine;

    public Screen(SlotMachine slotMachine) {
        this.slotMachine = slotMachine;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        slotMachine.drawMe(g);
    }
}