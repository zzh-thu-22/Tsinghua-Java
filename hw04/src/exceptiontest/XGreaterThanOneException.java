package exceptiontest;

public class XGreaterThanOneException extends Exception{
    public XGreaterThanOneException(){}

    public String getInfo()
    {
        return "Too large";
    }
}
