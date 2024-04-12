package drawarc;

import javax.swing.*;
import java.awt.*;

public class DrawArc extends JFrame {       
    public DrawArc() {
        setTitle("DrawArc");
        setBounds(500,200,600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);        
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.setFont( new Font( "SimSun", Font.PLAIN, 24) );
        g.drawString("Welcome to Java world", 50, 540 );
        g.setColor(Color.GREEN);
        g.fillRect(290, 220, 20, 280);
        g.setColor(Color.BLUE);
        int r = 160;
        g.fillArc(300 - r, 220 - r, 2 * r, 2 * r, 30, 30);
        g.fillArc(300 - r, 220 - r, 2 * r, 2 * r, 120, 30); 
        g.fillArc(300 - r, 220 - r, 2 * r, 2 * r, 210, 30);
        g.fillArc(300 - r, 220 - r, 2 * r, 2 * r, 300, 30);
    }

    public static void main(String[] args) { 
        new DrawArc();
    }
}