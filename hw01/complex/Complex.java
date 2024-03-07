package complex;

    public class Complex{
        public double realPart, imaginaryPart;

        public Complex(double real, double image)
        {
            realPart = real;
            imaginaryPart = image;
        }

        public String toString(){
            if(realPart==0 && imaginaryPart==0)
            {
                double n=0;
                return String.format("%.3f",n);
            }else if(realPart==0 && imaginaryPart!=0)
            {
                return String.format("%.3f",imaginaryPart)+"i";
            }else if(realPart!=0 && imaginaryPart==0)
            {
                return String.format("%.3f",realPart);
            }else
            {
                if (imaginaryPart < 0)
                return String.format("%.3f",realPart) + String.format("%.3f",imaginaryPart)+"i";
                else{
                return String.format("%.3f",realPart) + "+" + String.format("%.3f",imaginaryPart)+"i";
                }
            }
        }

        public Complex add(Complex b){
            Complex c;
            c = new Complex(realPart + b.realPart, imaginaryPart + b.imaginaryPart);
            return c;
        }

        public Complex sub(Complex b){
            Complex c;
            c = new Complex(realPart - b.realPart, imaginaryPart - b.imaginaryPart);
            return c;
        }

        public Complex mul(Complex b){
            Complex c;
            c = new Complex(realPart * b.realPart - imaginaryPart * b.imaginaryPart, realPart * b.imaginaryPart + imaginaryPart * b.realPart);
            return c;
        }

        public Complex div(Complex b){
            Complex c;
            double d = b.realPart * b.realPart + b.imaginaryPart * b.imaginaryPart;
            c = new Complex((realPart * b.realPart + imaginaryPart * b.imaginaryPart) / d, (imaginaryPart * b.realPart - realPart * b.imaginaryPart) / d);
            return c;
        }
    }