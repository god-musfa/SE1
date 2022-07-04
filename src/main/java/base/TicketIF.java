package base;

import multiton.Fahrzeugtyp;
import multiton.Kundentyp;

public interface TicketIF {
    double getPrice();
    void setPrice(double price);


    void setPrice(Fahrzeugtyp ft, Kundentyp kt, long duration);

    String getTicketID();
    public Long getEnd();
    public long getDuration();
    public void setDuration(long x);
    
}
