package exceptiontest;

public class ExceptionTest{
    public ExceptionTest(){}

    public int getFirstValidInt()
    {
        int result = 0;
        while(true)
        {
            try
            {
                result = Test.readInt();
                break;
            }catch(NumberFormatException e){

            }
        }
        return result;
    }

    public double getX(double y)throws XLessThanZeroException, XGreaterThanOneException{
        double x = Math.log(y);
        if(x < 0)
        {
            throw new XLessThanZeroException(y);
        }else if(x > 1)
        {
            throw new XGreaterThanOneException();
        }
        return x;
    }
}
