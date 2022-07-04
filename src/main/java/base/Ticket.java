package base;

import multiton.Fahrzeugtyp;
import multiton.Kundentyp;

public class Ticket implements TicketIF{
    private String ticketID; //TicketID as Hash from Javascript
    private double price;
    private long begin;
    private long duration;
    public Ticket(String ticketID, String begin){
        this.ticketID = ticketID;
        this.price = 0.0;
        this.begin = Long.parseLong(begin);
        duration = 0;
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
    public void setPrice(Fahrzeugtyp ft, Kundentyp kt, long duration){
        this.duration = duration;
        price = ft.getGebuehrenfaktor()*kt.getGebuehrenfak()*((double)duration/100);
    }
    @Override
    public String getTicketID() {
        return this.ticketID;
    }
    @Override
    public Long getEnd(){
        return begin+duration;
    }

    @Override
    public void setDuration(long x){
        duration = x;
    }

    @Override
    public long getDuration() {
        return duration;
    }
}
