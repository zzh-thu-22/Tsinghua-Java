package shape;

public class Rectangle extends Shape{
    public double width;
    public double height;

    public Rectangle()
    {
    }

    public Rectangle(double w, double h)
    {
        width = w;
        height = h;
    }

    public Rectangle(double w, double h, String c)
    {
        super(c);
        width = w;
        height = h;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setWidth(double w)
    {
        width = w;
    }

    public void setHeight(double h)
    {
        height = h;
    }

    public double getArea()
    {
        return width*height;
    }

    public double getPerimeter()
    {
        return 2*(width+height);
    }

    public String toString()
    {
        return "Rectangle(" + color + ")";
    }
}
