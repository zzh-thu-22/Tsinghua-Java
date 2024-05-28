package game;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import game.Main.chess_piece;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.Random;

public class piece {
    public static Color currentColor = Color.RED;
    public int radius = 25;
    public JPanel panel;
    public HashMap<Integer, chess_piece> map;
    public int red_number;
    public int blue_number;
    public AtomicInteger count;
    public int countdownSeconds;
    public Timer timer;
    public JLabel timeLabel;
    public int hhh=0;

    public piece(JPanel panel,HashMap<Integer, chess_piece> map,AtomicInteger count) {
        this.panel = panel;
        this.map = map;
        this.count = count;

        Time();
    
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                for (int i = 0; i < map.size(); i++) {
                    Path2D hexagon = createHexagon(map.get(i).point.x, map.get(i).point.y, 20 * Math.sqrt(3));
                    if (hexagon.contains(e.getPoint()) && !map.get(i).piecesPlace) {
                        if(!map.get(i).islegal)continue;
                        if (currentColor.equals(Color.RED)) {
                            piece.this.red_number++;
                        } else {
                            piece.this.blue_number++;
                        }
                        count.getAndIncrement();
                        map.get(i).piecesPlace = true;
                        map.get(i).pieceColors = currentColor;
                        chess_piece obj = map.get(i);
                        turn_over(obj);
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;
                        Islegal(map);
                        countdownSeconds = 30;
                        panel.repaint();
                    }
                }
                hhh=0;
                for(int i=0;i<map.size();i++) {
                    if(!map.get(i).islegal||map.get(i).piecesPlace) {
                        hhh++;
                    }
                    if(hhh==map.size())
                    {
                        if(red_number>blue_number) {
                            JOptionPane.showMessageDialog(null, "WINNER: RED", "", JOptionPane.INFORMATION_MESSAGE);
                        } else if(red_number<blue_number) {
                            JOptionPane.showMessageDialog(null, "WINNER: BLUE", "", JOptionPane.INFORMATION_MESSAGE);
                        } 
                    }
                }
            } 
        });

        JComponent pieceComponent = new JComponent() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                for (int i = 0; i < map.size(); i++) {
                    if(map.get(i).piecesPlace){
                        g2d.setColor(map.get(i).pieceColors);
                        Point2D.Double p = map.get(i).point;
                        Ellipse2D.Double circle = new Ellipse2D.Double(p.x - radius, p.y - radius, 2 * radius, 2 * radius);
                        g2d.fill(circle);
                    }
                }

                g2d.setFont(new Font("宋体", Font.BOLD, 24));
                g2d.setColor(Color.BLACK);
                if (countdownSeconds >= 0) {
                    g2d.drawString("倒计时: " + countdownSeconds + "s", 700, 50);
                } 

                g2d.dispose();
            }
        };

        panel.setLayout(null);
        panel.add(pieceComponent);
        pieceComponent.setBounds(0, 0, panel.getWidth(), panel.getHeight());
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

    public void turn_over(chess_piece obj) {
        int lenth = obj.array.length;
        ArrayList<Integer> Temp = new ArrayList<>();
        for (int i = 0; i < lenth; i++) {
            int Index = findIndex(obj.array[i]);
            chess_piece obj1 = map.get(Index);
            int length1 = obj1.array.length;
            int number=0;
            for (int j = 0; j < length1; j++) {
                double epsilon = 1.0e-3;
                double max1 = Math.max(obj1.array[j].x, obj.point.x);
                double min1 = Math.min(obj1.array[j].x, obj.point.x);
                double max2 = Math.max(obj1.array[j].y, obj.point.y);
                double min2 = Math.min(obj1.array[j].y, obj.point.y);
                if(max1-min1<epsilon&&max2-min2<epsilon) {
                    number=j;
                }
            }
            int k = number+1;
            String Last ="begin";
            int has=1;
            int hh=1;
            int begin=number,end=number;
            int count=0;
            while(k!=number) {
                if(hh==1) {
                    if(number+1==length1) {
                        k=0;
                    }
                }
                hh=0;
                int index = findIndex(obj1.array[k]);

                if(!map.get(index).piecesPlace) {
                    has=0;
                } else if(map.get(index).pieceColors!=currentColor) {
                    count++;
                    if(has==1&&(k+1==number||(number==0&&k+1==length1))) {

                        // System.out.println(number);
                        // System.out.println(begin+" "+end);
                        // System.out.println(obj1.array[begin]);
                        // System.out.println(obj1.array[end]);
                        // System.out.println(obj1.point);
                        // System.out.println("1");

                        if(length1!=6&&(begin==end+1||end==begin+1)){}
                        else{
                        if(begin>end) {
                            for(int m=end+1;m!=begin;m++) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                                if (currentColor.equals(Color.RED)) {
                                    piece.this.red_number++;
                                    piece.this.blue_number--;
                                } else {
                                    piece.this.blue_number++;
                                    piece.this.red_number--;
                                }
                            }
                        } else if(begin<end) {
                            for(int m=end+1;m!=length1;m++) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                                if (currentColor.equals(Color.RED)) {
                                    piece.this.red_number++;
                                    piece.this.blue_number--;
                                } else {
                                    piece.this.blue_number++;
                                    piece.this.red_number--;
                                }
                            }
                            for(int m=begin-1;m>=0;m--) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                                if (currentColor.equals(Color.RED)) {
                                    piece.this.red_number++;
                                    piece.this.blue_number--;
                                } else {
                                    piece.this.blue_number++;
                                    piece.this.red_number--;
                                }
                            }
                        } else {
                            if(length1==6){
                            for(int m=begin+1;m!=length1;m++) {
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                                if (currentColor.equals(Color.RED)) {
                                    piece.this.red_number++;
                                    piece.this.blue_number--;
                                } else {
                                    piece.this.blue_number++;
                                    piece.this.red_number--;
                                }
                            }
                            for(int m=0;m!=begin;m++) {
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                                if (currentColor.equals(Color.RED)) {
                                    piece.this.red_number++;
                                    piece.this.blue_number--;
                                } else {
                                    piece.this.blue_number++;
                                    piece.this.red_number--;
                                }
                            }
                        }
                        }
                    }
                    }
                } else if(map.get(index).pieceColors==currentColor) {
                    end = k;
                    if(has==1&&Last.equals("begin")&&count!=0) {

                    //     System.out.println(number);
                    // System.out.println(begin+" "+end);
                    // System.out.println(obj1.array[begin]);
                    // System.out.println(obj1.array[end]);
                    // System.out.println(obj1.point);
                    // System.out.println("2");

                    if(length1!=6&&(begin==end+1||end==begin+1))
                    {}
                      else{  if(begin<end) {
                            for(int m=begin+1;m!=end;m++) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                                if (currentColor.equals(Color.RED)) {
                                    piece.this.red_number++;
                                    piece.this.blue_number--;
                                } else {
                                    piece.this.blue_number++;
                                    piece.this.red_number--;
                                }
                            }
                        } else if(begin>end) {
                            for(int m=begin+1;m!=length1;m++) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                                if (currentColor.equals(Color.RED)) {
                                    piece.this.red_number++;
                                    piece.this.blue_number--;
                                } else {
                                    piece.this.blue_number++;
                                    piece.this.red_number--;
                                }
                            }
                            for(int m=0;m!=end;m++) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                                if (currentColor.equals(Color.RED)) {
                                    piece.this.red_number++;
                                    piece.this.blue_number--;
                                } else {
                                    piece.this.blue_number++;
                                    piece.this.red_number--;
                                }
                            }
                        } else {
                            if(length1==6){
                            for(int m=begin+1;m!=length1;m++) {
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                                if (currentColor.equals(Color.RED)) {
                                    piece.this.red_number++;
                                    piece.this.blue_number--;
                                } else {
                                    piece.this.blue_number++;
                                    piece.this.red_number--;
                                }
                            }
                            for(int m=0;m!=begin;m++) {
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                                if (currentColor.equals(Color.RED)) {
                                    piece.this.red_number++;
                                    piece.this.blue_number--;
                                } else {
                                    piece.this.blue_number++;
                                    piece.this.red_number--;
                                }
                            }
                        }
                    }
                        }
                    }
                    has=1;
                    Last="other";
                }
                k++;
                if(k==length1) {
                    k=0;
                }
            }
        }
        for(int i=0;i<Temp.size();i++) {
            map.get(Temp.get(i)).pieceColors=currentColor;
        }
    }

    public int findIndex(Point2D.Double point) {
        double epsilon = 1.0e-3;
        for (int i = 0; i < map.size(); i++) {
            double max1 = Math.max(map.get(i).point.x, point.x);
            double min1 = Math.min(map.get(i).point.x, point.x);
            double max2 = Math.max(map.get(i).point.y, point.y);
            double min2 = Math.min(map.get(i).point.y, point.y);
            if (max1 - min1 < epsilon && max2 - min2 < epsilon) {
                return i;
            }
        }
        return -1;
    }

    public void Islegal(HashMap<Integer, chess_piece> map) {
       for(int i=0;i<map.size();i++) {
           int length = map.get(i).array.length;
           int count = 0;
           for(int j=0;j<length;j++) {
               int index = findIndex(map.get(i).array[j]);
               if(map.get(index).piecesPlace) {
                   count++;
               }
           }
           if(count==length) {
               map.get(i).islegal = false;
           }
       }
    }

    public void Time() {
        this.countdownSeconds = 30;
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countdownSeconds > 0) {
                    countdownSeconds--;
                } else {
                    while(true) {
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(60);

                        while(map.get(randomNumber).piecesPlace||!map.get(randomNumber).islegal) {
                            randomNumber = rand.nextInt(60);
                        }

                        if (currentColor.equals(Color.RED)) {
                            piece.this.red_number++;
                        } else {
                            piece.this.blue_number++;
                        }
                        count.getAndIncrement();
                        map.get(randomNumber).piecesPlace = true;
                        map.get(randomNumber).pieceColors = currentColor;
                        chess_piece obj = map.get(randomNumber);
                        turn_over(obj);
                        currentColor = currentColor == Color.RED ? Color.BLUE : Color.RED;
                        Islegal(map);

                        break;
                    }
                    countdownSeconds = 30;
                    hhh=0;
                    for(int i=0;i<map.size();i++) {
                        if(!map.get(i).islegal||map.get(i).piecesPlace) {
                            hhh++;
                        }
                        if(hhh==map.size())
                        {
                            if(red_number>blue_number) {
                                JOptionPane.showMessageDialog(null, "WINNER: RED", "", JOptionPane.INFORMATION_MESSAGE);
                            } else if(red_number<blue_number) {
                                JOptionPane.showMessageDialog(null, "WINNER: BLUE", "", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "平局", "", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
                panel.repaint();
            }
        });
        timer.start();  
    }

    

}

