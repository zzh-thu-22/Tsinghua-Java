package shape;

abstract public class Shape{
    public String color = "#";

    public Shape()
    {
    }

    public Shape(String c)
    {
        color = c;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String c)
    {
        color = c;
    }

    public boolean isFilled()
    {
        if(color.equals("#"))
            return false;
        else
            return true;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract String toString();
}
