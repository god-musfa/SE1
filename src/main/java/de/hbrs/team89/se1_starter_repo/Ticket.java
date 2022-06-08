package de.hbrs.team89.se1_starter_repo;

public class Ticket implements TicketIF{
    private String ticketID; //TicketID as Hash from Javascript
    private double price;
    private long begin, end;
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
    public String getTicketID() {
        return this.ticketID;
    }
    public long getEnd(){
        return this.end;
    }
    public void setEnd(long end){
        this.end = end;
    }
}
