package de.hbrs.team89.se1_starter_repo;

public class Ticket implements TicketIF{
    String ticketID;
    double price;

    public Ticket(String ticketID){
        this.ticketID = ticketID;
    }
    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getTicketID() {
        return this.ticketID;
    }
}
