package de.hbrs.team89.se1_starter_repo;

public class Ticket implements TicketIF{
    private String ticketID; //TicketID as Hash from Javascript
    private double price;
    private long end;
    public Ticket(String ticketID, long end){
        this.ticketID = ticketID;
        this.price = 0.0;
        this.end = end;

    }
    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getTicketID() {
        return this.ticketID;
    }
    public long getEnd(){
        return this.end;
    }
}
