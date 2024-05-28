package game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.geom.Path2D;

public class chessboard {
    public Image bgImage;
   
    public chessboard() {
        try {
            //  bgImage = ImageIO.read(new File("image/background.jpg"));
            bgImage = ImageIO.read(getClass().getResource("image/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JPanel createChessboardPanel() {
       
        JPanel panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bgImage != null) {
                    g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
                }

                Graphics2D g2d = (Graphics2D) g;
                double radius = 20*Math.sqrt(3); 

                double x = 300.0;
                double y = 600.0;

                for (int number = 5; number <= 9; number++) {
                    double temp = x;
                    for (int row = 0; row < number; row++) {
                        Path2D.Double hexagon = createHexagon(temp, y, radius);
                        g2d.draw(hexagon);
                        
                        temp += 60.0;
                    }
                    x -= 30.0;
                    y = y - 30*Math.sqrt(3);
                }

                x=210;
                for (int number = 8; number >= 5; number--) {
                    double temp = x;
                    for (int row = 0; row < number; row++) {
                        Path2D.Double hexagon = createHexagon(temp, y, radius);
                        g2d.draw(hexagon);
                        
                        temp += 60.0;
                    }
                    x += 30.0;
                    y = y - 30*Math.sqrt(3);
                }
            }


            public Path2D.Double createHexagon(double x, double y, double radius) {
                Path2D.Double hexagon = new Path2D.Double();
                hexagon.moveTo(x + radius * Math.cos(Math.toRadians(-30)), y + radius * Math.sin(Math.toRadians(-30)));
                for (int i = 1; i < 6; i++) {
                    double angle = 60 * i - 30;
                    double newX = x + radius * Math.cos(Math.toRadians(angle));
                    double newY = y + radius * Math.sin(Math.toRadians(angle));
                    hexagon.lineTo(newX, newY);
                }
                hexagon.closePath();
                return hexagon;
            }
        };
        panel.setOpaque(false);
        return panel;
      }
}