package game;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.geom.Point2D;



public class Main
{
    public static HashMap<Integer, chess_piece> map = new HashMap<>();
    public static double Temp;
    static AtomicReference<Color> CurrentColor = new AtomicReference<>();
    static AtomicInteger sharedCount = new AtomicInteger(0);

    public static class chess_piece {
        public Point2D.Double point;
        public Point2D.Double[] array;
        public boolean piecesPlace;
        public Color pieceColors;
        public boolean islegal;
        public boolean normal;

    
        public chess_piece(Point2D.Double point, Point2D.Double[] array) {
            this.point = point;
            this.array = array;
            islegal = true;
            normal = true;
            piecesPlace = false;
        }
    
        public Point2D.Double getPoint() {
            return point;
        }
    }
    public static void main(String[] args) {

    int number = 0;

    Point2D.Double point = new Point2D.Double(300,600);
    Point2D.Double[] array = {new Point2D.Double(360, 600), new Point2D.Double(330, 600-30*Math.sqrt(3)),new Point2D.Double(270, 600-30*Math.sqrt(3))};
    chess_piece obj= new chess_piece(point, array);
    map.put(number++, obj);

    Point2D.Double point1 = new Point2D.Double(540,600);
    Point2D.Double[] array1 = {new Point2D.Double(480, 600), new Point2D.Double(510, 600-30*Math.sqrt(3)),new Point2D.Double(570, 600-30*Math.sqrt(3))};
    chess_piece obj1 = new chess_piece(point1, array1);
    map.put(number++, obj1);

    Point2D.Double point2 = new Point2D.Double(180,600-120*Math.sqrt(3));
    Point2D.Double[] array2 = {new Point2D.Double(210, 600-90*Math.sqrt(3)),new Point2D.Double(240, 600-120*Math.sqrt(3)), new Point2D.Double(210, 600-150*Math.sqrt(3))};
    chess_piece obj2 = new chess_piece(point2, array2);
    map.put(number++, obj2);

    Point2D.Double point3 = new Point2D.Double(660,600-120*Math.sqrt(3));
    Point2D.Double[] array3 = {new Point2D.Double(630, 600-90*Math.sqrt(3)),new Point2D.Double(600, 600-120*Math.sqrt(3)), new Point2D.Double(630, 600-150*Math.sqrt(3))};
    chess_piece obj3 = new chess_piece(point3, array3);
    map.put(number++, obj3);

    Point2D.Double point4 = new Point2D.Double(300,600-240*Math.sqrt(3));
    Point2D.Double[] array4 = {new Point2D.Double(270, 600-210*Math.sqrt(3)),new Point2D.Double(330, 600-210*Math.sqrt(3)),new Point2D.Double(360, 600-240*Math.sqrt(3))};
    chess_piece obj4 = new chess_piece(point4, array4);
    map.put(number++, obj4);

    Point2D.Double point5 = new Point2D.Double(540,600-240*Math.sqrt(3));
    Point2D.Double[] array5 = {new Point2D.Double(480, 600-240*Math.sqrt(3)), new Point2D.Double(510, 600-210*Math.sqrt(3)),new Point2D.Double(570, 600-210*Math.sqrt(3))};
    chess_piece obj5 = new chess_piece(point5, array5);
    map.put(number++, obj5);
    
    double x=270,y=600-30*Math.sqrt(3);
    for(int i=0;i<3;i++)
    {
        Point2D.Double point6 = new Point2D.Double(x,y);
        Point2D.Double[] array6 = {new Point2D.Double(x+30, y+30*Math.sqrt(3)),new Point2D.Double(x+60, y),new Point2D.Double(x+30, y-30*Math.sqrt(3)),new Point2D.Double(x-30, y-30*Math.sqrt(3))};
        chess_piece obj6 = new chess_piece(point6, array6);
        map.put(number++, obj6); 
        x-=30;
        y-=30*Math.sqrt(3);
    }

    x=210;
    y=600-150*Math.sqrt(3);
    for(int i=0;i<3;i++)
    {
        Point2D.Double point6 = new Point2D.Double(x,y);
        Point2D.Double[] array6 = {new Point2D.Double(x-30, y+30*Math.sqrt(3)),new Point2D.Double(x+30, y+30*Math.sqrt(3)),new Point2D.Double(x+60, y), new Point2D.Double(x+30, y-30*Math.sqrt(3))};
        chess_piece obj6 = new chess_piece(point6, array6);
        map.put(number++, obj6); 
        x+=30;
        y-=30*Math.sqrt(3);
    }

    x=630;
    y=600-150*Math.sqrt(3);
    for(int i=0;i<3;i++)
    {
        Point2D.Double point6 = new Point2D.Double(x,y);
        Point2D.Double[] array6 = {new Point2D.Double(x+30, y+30*Math.sqrt(3)),new Point2D.Double(x-30, y+30*Math.sqrt(3)),new Point2D.Double(x-60, y),new Point2D.Double(x-30, y-30*Math.sqrt(3))};
        chess_piece obj6 = new chess_piece(point6, array6);
        map.put(number++, obj6); 
        x-=30;
        y-=30*Math.sqrt(3);
    }

    x=570;
    y=600-30*Math.sqrt(3);
    for(int i=0;i<3;i++)
    {
        Point2D.Double point6 = new Point2D.Double(x,y);
        Point2D.Double[] array6 = {new Point2D.Double(x-30, y+30*Math.sqrt(3)),new Point2D.Double(x-60, y),new Point2D.Double(x-30, y-30*Math.sqrt(3)), new Point2D.Double(x+30, y-30*Math.sqrt(3))};
        chess_piece obj6 = new chess_piece(point6, array6);
        map.put(number++, obj6); 
        x+=30;
        y-=30*Math.sqrt(3);
    }
     
    x=360;
    y=600;
    for(int i=0;i<3;i++)
    {
        Point2D.Double point6 = new Point2D.Double(x,y);
        Point2D.Double[] array6 = {new Point2D.Double(x-60, y), new Point2D.Double(x-30, y-30*Math.sqrt(3)),new Point2D.Double(x+30, y-30*Math.sqrt(3)),new Point2D.Double(x+60, y)};
        chess_piece obj6 = new chess_piece(point6, array6);
        map.put(number++, obj6); 
        x+=60;
    }

    x=360;
    y=600-240*Math.sqrt(3);
    for(int i=0;i<3;i++)
    {
        Point2D.Double point6 = new Point2D.Double(x,y);
        Point2D.Double[] array6 = {new Point2D.Double(x-60, y),new Point2D.Double(x-30, y+30*Math.sqrt(3)), new Point2D.Double(x+30, y+30*Math.sqrt(3)),new Point2D.Double(x+60, y)};
        chess_piece obj6 = new chess_piece(point6, array6);
        map.put(number++, obj6); 
        x+=60;
    }

    x=330;
    y=600-30*Math.sqrt(3);
    Temp=x;
    for(int j=4;j<8;j++)
    {
        for(int i=0;i<j;i++){
        Point2D.Double point6 = new Point2D.Double(x,y);
        Point2D.Double[] array6 = {new Point2D.Double(x-60, y), new Point2D.Double(x-30, y+30*Math.sqrt(3)),new Point2D.Double(x+30, y+30*Math.sqrt(3)),new Point2D.Double(x+60, y),new Point2D.Double(x+30, y-30*Math.sqrt(3)),new Point2D.Double(x-30, y-30*Math.sqrt(3))};
        chess_piece obj6 = new chess_piece(point6, array6);
        map.put(number++, obj6); 
        x+=60;
    }
        Temp-=30;
        x=Temp;
        y-=30*Math.sqrt(3);
       
    }

    x=270;
    y=600-150*Math.sqrt(3);
    Temp=x;
    for(int j=6;j>3;j--)
    {
        for(int i=0;i<j;i++){
        Point2D.Double point6 = new Point2D.Double(x,y);
        Point2D.Double[] array6 = {new Point2D.Double(x-60, y), new Point2D.Double(x-30, y+30*Math.sqrt(3)),new Point2D.Double(x+30, y+30*Math.sqrt(3)),new Point2D.Double(x+60, y),new Point2D.Double(x+30, y-30*Math.sqrt(3)),new Point2D.Double(x-30, y-30*Math.sqrt(3))};
        chess_piece obj6 = new chess_piece(point6, array6);
        map.put(number++, obj6); 
        x+=60;
        }
        Temp+=30;
        x=Temp;
        y-=30*Math.sqrt(3);
    }
    

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 900);
    
    frame.setLocationRelativeTo(null);
    
    JPanel chessboardPanel = new chessboard().createChessboardPanel();
    frame.add(chessboardPanel);
    frame.setVisible(true);

    new Thread(() -> {
        piece Piece = new piece(chessboardPanel, map,sharedCount);
    }).start();
    
    new Thread(() -> {
        chessboard_tip Chessboard_tip = new chessboard_tip(chessboardPanel, map,sharedCount);
    }).start();

   }
}




