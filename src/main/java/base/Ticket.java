package base;

import multiton.Fahrzeugtyp;
import multiton.Kundentyp;

public class Ticket implements TicketIF{
    private String ticketID; //TicketID as Hash from Javascript
    private double price;
    private long begin;
    private Long end;
    public Ticket(String ticketID, String begin){
        this.ticketID = ticketID;
        this.price = 0.0;
        this.begin = Long.parseLong(begin);
    }
    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public void setPrice(Fahrzeugtyp ft, Kundentyp kt){
        price = ft.getGebuehrenfaktor()*kt.getGebuehrenfak()*duration();
    }
    @Override
    public String getTicketID() {
        return this.ticketID;
    }
    public Long getEnd(){
        return this.end;
    }
    public void setEnd(long end){
        this.end = end;
    }

    @Override
    public long duration() {
        if(end != null) { return end-begin;}
        return -1;
    }
}
