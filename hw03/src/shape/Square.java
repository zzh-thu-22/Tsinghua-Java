package shape;

public class Square extends Rectangle {

    public Square() {

    }

    public Square(double a) {
        width = a;
        height = a;
    }

    public Square(double a, String c) {
        super(a, a, c);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double a) {
        width = a;
        height = a;
    }

    public double getArea() {
        return width * width;
    }

    public double getPerimeter() {
        return 4 * width;
    }

    public String toString() {
        return "Square(" + color + ")";
    }
}
