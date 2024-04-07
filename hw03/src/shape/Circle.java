package shape;

public class Circle extends Shape {
    public double R;

    public Circle() {
    }

    public Circle(double r) {
        R = r;
    }

    public Circle(double r, String c) {
        super(c);
        R = r;
    }

    public double getRadius() {
        return R;
    }

    public void setRadius(double r) {
        R = r;
    }

    public double getArea() {
        return Math.PI * R * R;
    }

    public double getPerimeter() {
        return 2 * Math.PI * R;
    }

    public String toString() {
        return "Circle(" + color + ")";
    }
}


