package ticket;

public class Ticket extends Thread{
    public TicketPool Tpl;
    public int Treq;
    public int count = 0;
    public Ticket(TicketPool tpl, int treq){
        Tpl = tpl;
        Treq = treq;
    }

    public void run(){
      synchronized(Tpl){
      int temp = Tpl.getRest();
      if(temp >= Treq){
        Tpl.reduceRest(Treq);
        count = Treq;
      }else{
        Tpl.reduceRest(temp);
        count = temp;
      }
    }
    }



    public int getObtained(){
        return count;
    }
}
