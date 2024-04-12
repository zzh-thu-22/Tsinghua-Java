package colorword;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ColorWord extends JFrame {  
    public Color currentColor = Color.RED;
    
    public ColorWord() {
        setTitle("ColorWord");
        setBounds(400,250,700,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        JPanel panel = new JPanel();
        
        JRadioButton redButton = new JRadioButton("Red");
        redButton.setSelected(true);
        JRadioButton blueButton = new JRadioButton("Blue");
        JRadioButton blackButton = new JRadioButton("Black");
        
        panel.add(redButton);
        panel.add(blueButton);
        panel.add(blackButton);
        
        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(blueButton);
        group.add(blackButton);
        
        getContentPane().add(panel);
        setVisible(true);  

        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.RED;
                repaint();
            }
        });

        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLUE;
                repaint();
            }
        });

        blackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLACK;
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(currentColor);
        g.setFont( new Font( "SimSun", Font.PLAIN, 24) );
        g.drawString("Welcome to Java world", 50, 270 );
    }

    public static void main(String[] args) { 
        new ColorWord();
    }
}