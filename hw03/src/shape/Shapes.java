package shape;

public class Shapes{
    public Shape[] shapes;

    public Shapes(Shape[] s)
    {
        shapes = s;
    }

    public double getArea()
    {
        double sum = 0;
        for(int i=0;i<shapes.length;i++)
        {
            sum += shapes[i].getArea();
        }
        return sum;
    }

    public double getFilledArea()
    {
        double sum = 0;
        for(int i=0;i<shapes.length;i++)
        {
            if(shapes[i].isFilled())
                sum += shapes[i].getArea();
        }
        return sum;
    }

    public String toString()
    {
        String str = "[";
        for(int i=0;i<shapes.length;i++)
        {
            str += shapes[i].toString();
            if(i != shapes.length-1)
                str += ",";
        }
        str += "]";
        return str;
    }
}
