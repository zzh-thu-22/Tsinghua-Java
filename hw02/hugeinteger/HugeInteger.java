package hugeinteger;

public class HugeInteger{

    int[] a = new int[25];
    int j;

    HugeInteger(long i)
    {
        j=0;
        if(i == 0)
        {
            j=1;
        }
        while(i!=0)
        {
            a[j] = (int)(i%10000);
            i = i/10000;
            j++;
        }
    }

    HugeInteger(String s){
        int length = s.length();
        int I = length;
        j=0;
        for (;I-4>=0;I-=4)
        {
            String ss = s.substring(I-4,I);
            a[j] = Integer.parseInt(ss);
            j++;
        }
        if(I!=0)
        {
            String sss = s.substring(0,I);
            a[j] = Integer.parseInt(sss);
            j++;
        }
    }
    
    public String toString()
    {
        String sum = "";
        int[] b = new int[25];
        for(int k = 0;k<25;k++)b[k] = a[k];
        for(int i=j-1;i>=0;i--)
        {
            if(i == j-1)
            {
            sum = sum + String.valueOf(b[i]);
            }
            else if(b[i] < 10)
            {
            sum = sum + "000" + String.valueOf(b[i]);
            }
            else if(b[i] < 100)
            {
            sum = sum + "00" + String.valueOf(b[i]);
            }
            else if(b[i] < 1000)
            {
            sum = sum + "0" + String.valueOf(b[i]);
            }
            else
            {
            sum = sum + String.valueOf(b[i]);
            }
        }
        return sum;
    }


    public void add(HugeInteger b){
        if(j<b.j)
        {
            j=b.j;
        }
        for (int k=0;k<j;k++)
        {
            a[k] = a[k] + b.a[k];
            if (a[k]>9999)
            {
                a[k] = a[k]-10000;
                a[k+1]++;
                if(k+1==j)j++;
            }
        }
    }

    int compareTo(HugeInteger o)
    {
        if (j>o.j){return 1;}
        else if (j<o.j){return -1;}
        else {for (int k=j-1;k>=0;k--)
        {
            if (a[k]>o.a[k])return 1;
            if (a[k]<o.a[k])return -1;
        }
        }
        return 0;
    }

    int compareTo(long o)
    {
        int[] b = new int[25];
        int k = 0;
        if(o == 0)k=1;
          while(o!=0)
        {
            b[k] = (int)(o%10000);
            o = o/10000;
            k++;
        }
        if (j>k){return 1;}
        else if (j<k){return -1;}
        else{
        for (int i=j-1;i>=0;i--)
        {
            if (a[i]>b[i])return 1;
            if (a[i]<b[i])return -1;
        }
        }
        return 0;
    }
}