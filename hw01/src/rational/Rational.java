package rational;

public class Rational{
    public int numerator, denominator;
    
    public Rational(int num, int den)
    {
        int a,b;
        if(num<=den){b=num;
            a=den;}
        else {b=den;
            a=num;}
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        numerator = num/a;
        denominator = den/a;
    }


    public String toString(){
        if (denominator == 1)
        {
            return Integer.toString(numerator);
        }else
        {
            return numerator+"/"+denominator;
        }
    }

    public double toDouble(){
        double temp = (double)numerator/denominator;
        return temp;
    }

    public void add(Rational b){
        numerator = numerator*b.denominator + b.numerator*denominator;
        denominator = denominator*b.denominator;
        int a,c;
        if(numerator<=denominator){c=numerator;
            a=denominator;}
        else {c=denominator;
            a=numerator;}
        while(c!=0){
            int temp = c;
            c = a%c;
            a = temp;
        }
        numerator = numerator/a;
        denominator = denominator/a;
    }

    public void sub(Rational b){
        numerator = numerator*b.denominator - b.numerator*denominator;
        denominator = denominator*b.denominator;
        int a,c;
        if(numerator<=denominator){c=numerator;
            a=denominator;}
        else {c=denominator;
            a=numerator;}
        while(c!=0){
            int temp = c;
            c = a%c;
            a = temp;
        }
        numerator = numerator/a;
        denominator = denominator/a;
    }
    public void mul(Rational b){
        numerator = numerator*b.numerator;
        denominator = denominator*b.denominator;
        int a,c;
        if(numerator<=denominator){c=numerator;
            a=denominator;}
        else {c=denominator;
            a=numerator;}
        while(c!=0){
            int temp = c;
            c = a%c;
            a = temp;
        }
        numerator = numerator/a;
        denominator = denominator/a;
    }

    public void div(Rational b){
        numerator = numerator*b.denominator;
        denominator = denominator*b.numerator;
        int a,c;
        if(numerator<=denominator){c=numerator;
            a=denominator;}
        else {c=denominator;
            a=numerator;}
        while(c!=0){
            int temp = c;
            c = a%c;
            a = temp;
        }
        numerator = numerator/a;
        denominator = denominator/a;
    }
}