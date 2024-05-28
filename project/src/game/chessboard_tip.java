package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.*;
import javax.swing.*;
import game.Main.chess_piece;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

public class chessboard_tip {
    public JPanel panel;
    public Color currentColor;
    public double radius = 25;
    public int number;
    public int begin=0;
    public HashMap<Integer, chess_piece> map;
    public ArrayList<Integer> rotate = new ArrayList<>();
    public AtomicInteger count;
    public int t=1;

    public chessboard_tip(JPanel panel,HashMap<Integer, chess_piece> map,AtomicInteger count){
        this.panel = panel;
        this.map = map;
        this.count = count;

        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                for (int i = 0; i < map.size(); i++) {
                    Path2D hexagon = createHexagon(map.get(i).point);
                    Normal(map);
                    if (hexagon.contains(e.getPoint())) {
                        rotate.clear();
                        if(!map.get(i).piecesPlace&&map.get(i).islegal) {
                            chess_piece obj = map.get(i);
                            if(count.get()%2==0) {
                                currentColor = Color.RED;
                            } else {
                                currentColor = Color.BLUE;
                            }
                            rotate = Rotatable(obj,currentColor);
                        }
                        
                        number = i;
                        begin=1;
                        t=1;
                        panel.repaint();
                        // break;
                    }
                }

               
                    Path2D hexagon = createHexagon(map.get(number).point);
                    if (!hexagon.contains(e.getPoint())) {
                        t=0;
                        panel.repaint();
                    }
                
            }
        
            @Override
            public void mouseDragged(MouseEvent e) {
               
            }
        });

        JComponent pieceComponent = new JComponent() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGreenDots(g);
                drawHexagons(g);
                drawGreyHexagon(g);
            }
        };

        panel.setLayout(null);
        pieceComponent.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        panel.add(pieceComponent);
    }

    public void drawGreyHexagon(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GRAY);
    
        for(int i=0;i<map.size();i++) {
            if(!map.get(i).normal) {
                Path2D hexagon = createHexagon(map.get(i).point);
                g2d.fill(hexagon);
            }
        }
    
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).piecesPlace&&!map.get(i).normal) {
                g2d.setColor(map.get(i).pieceColors);
                Point2D.Double p = map.get(i).point;
                Ellipse2D.Double circle = new Ellipse2D.Double(p.x - radius, p.y - radius, 2 * radius, 2 * radius);
                g2d.fill(circle);
            }
        }
    }

    public void drawGreenDots(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        for (int i = 0; i < map.size(); i++) {
            if(!map.get(i).piecesPlace&&map.get(i).islegal){
                double x = map.get(i).point.x;
                double y = map.get(i).point.y;
                Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 5, 5);
                g2d.fill(circle);
            }
        }
    }

    public Path2D createHexagon(Point2D.Double center) {
        Path2D hexagon = new Path2D.Double();
        double x = center.x;
        double y = center.y;
       
        hexagon.moveTo(x + 30, y + 10*Math.sqrt(3));
        hexagon.lineTo(x + 30, y - 10*Math.sqrt(3));
        hexagon.lineTo(x, y - 20*Math.sqrt(3));
        hexagon.lineTo(x - 30, y - 10*Math.sqrt(3));
        hexagon.lineTo(x - 30, y + 10*Math.sqrt(3));
        hexagon.lineTo(x, y + 20*Math.sqrt(3));
    
        hexagon.closePath();
        return hexagon;
    }

    public void drawHexagons(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        if(!map.get(number).piecesPlace&&map.get(number).islegal&&t==1&&begin!=0){
        g2d.setColor(Color.MAGENTA);
        Path2D hexagon = createHexagon(map.get(number).point);
        g2d.draw(hexagon);
        }

        if(!map.get(number).piecesPlace) {
            for(int i=0;i<rotate.size();i++) {
                g2d.setColor(Color.YELLOW);
                Path2D hexagon = createHexagon(map.get(rotate.get(i)).point);
                g2d.draw(hexagon);
            }
        }
    }

     public ArrayList<Integer> Rotatable(chess_piece obj,Color currentColor) {
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

                    if(length1!=6&&(begin==end+1||end==begin+1)){}
                    else{
                    if(has==1&&(k+1==number||(number==0&&k+1==length1))) {
                        if(begin>end) {
                            for(int m=end+1;m!=begin;m++) {
                                if(length1!=6&&(m==length1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                            }
                        } else if(begin<end) {
                            
                            for(int m=end+1;m!=length1;m++) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                            }
                            for(int m=begin-1;m>=0;m--) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                            }
                        } else {
                            if(length1==6){
                            for(int m=begin+1;m!=length1;m++) {
                                
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                            }
                            for(int m=0;m!=begin;m++) {
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                            }
                        }
                        }
                    }
                }
                } else if(map.get(index).pieceColors==currentColor) {
                    end = k;
                    if(has==1&&Last.equals("begin")&&count!=0) {

                        if(length1!=6&&(begin==end+1||end==begin+1)){}
                        else{
                        if(begin<end) {
                            
                            for(int m=begin+1;m!=end;m++) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                            }
                        } else if(begin>end) {
                            for(int m=begin+1;m!=length1;m++) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                            }
                            for(int m=0;m!=end;m++) {
                                if(length1!=6&&(m==length1-1||m==0)) continue;
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                            }
                        } else {
                            if(length1==6){
                            for(int m=begin+1;m!=length1;m++) {
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
                            }
                            for(int m=0;m!=begin;m++) {
                                int index1 = findIndex(obj1.array[m]);
                                Temp.add(index1);
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
        return Temp;
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

    public void Normal(HashMap<Integer, chess_piece> map) {
       int tip=0;
       for(int i=0;i<map.size();i++) {
        tip=0;
          for(int j=0;j<map.size();j++) {
            if(j==i)continue;
            double x1 = map.get(i).point.x;
            double y1 = map.get(i).point.y;
            double x2 = map.get(j).point.x;
            double y2 = map.get(j).point.y;
            double distance = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
            if(distance<122&&map.get(j).islegal&&!map.get(j).piecesPlace){
                tip=1;
            }
          }
        if(tip==0&&map.get(i).piecesPlace)
        {
            map.get(i).normal=false;
        }
       }
    }

}
