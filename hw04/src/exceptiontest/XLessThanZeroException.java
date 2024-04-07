package exceptiontest;

public class XLessThanZeroException extends Exception{
    public double Y;
    public XLessThanZeroException(double y)
    {
        Y = y;
    }

  
public String getInfo(){
    return Y +" " + "is too small";
}


}