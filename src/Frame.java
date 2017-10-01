import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    Component comp;
    public Frame(Component comp){
        super("SpaceInvaders");
        this.comp=comp;
        getContentPane().add(BorderLayout.CENTER,comp);
        pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        repaint();
    }
}
