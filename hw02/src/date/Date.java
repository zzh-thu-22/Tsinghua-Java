package date;

public class Date{

    int year, month, day;

    Date(String s)
    {
        switch(s.substring(0,3)) {
            case "Jan":
                month = 1;
                break;
            case "Feb":
                month = 2;
                break;
            case "Mar":
                month = 3;
                break;
            case "Apr":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "Jun":
                month = 6;
                break;
            case "Jul":
                month = 7;
                break;
            case "Aug":
                month = 8;
                break;
            case "Sep":
                month = 9;
                break;
            case "Oct":
                month = 10;
                break;
            case "Nov":
                month = 11;
                break;
            case "Dec":
                month = 12;
                break;    
        }

        if(s.substring(3,4).equals("t"))
        {
            s = s.replace("t", "");
        }

        String ss = s.substring(4,6);
        if(s.substring(5,6).equals(","))
        {
            String sss = s.substring(4,5);
            day = Integer.parseInt(sss);
        }else
        {
            day = Integer.parseInt(ss);
        }

        if(s.substring(6,7).equals(","))
        {
            String a = s.substring(7,11);
            year = Integer.parseInt(a);
        }else{
            String a = s.substring(6,10);
            year = Integer.parseInt(a);
       }
    }

    Date(String m, int d, int y)
    {
        day = d;
        year =y;
        switch(m.substring(0,3)) {
            case "Jan":
                month = 1;
                break;
            case "Feb":
                month = 2;
                break;
            case "Mar":
                month = 3;
                break;
            case "Apr":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "Jun":
                month = 6;
                break;
            case "Jul":
                month = 7;
                break;
            case "Aug":
                month = 8;
                break;
            case "Sep":
                month = 9;
                break;
            case "Oct":
                month = 10;
                break;
            case "Nov":
                month = 11;
                break;
            case "Dec":
                month = 12;
                break;    
        }
    }

     Date(int d, int m, int y)
    {
        day = d;
        month = m;
        year = y;
    }

    public String toString()
    {
        return year + "/" + month + "/" + day;
    }
}