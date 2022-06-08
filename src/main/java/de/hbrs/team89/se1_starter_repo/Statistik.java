package de.hbrs.team89.se1_starter_repo;

import java.util.ArrayList;

public abstract class Statistik implements StatistikIF{
    protected long letztesAusgefahrenesTicket;
    @Override
    final public double statistikErstellen(ArrayList<TicketIF> tickets) {
        letztesAusgefahrenesTicket = setLetztesAusgefahrenesTicket(tickets);
        double value = valueBerechnen(tickets);
        return value;
    }

    @Override
    public long setLetztesAusgefahrenesTicket(ArrayList<TicketIF> tickets){
        return tickets.stream().mapToLong(x->x.getEnd()).max().orElse(-1);
    };

    @Override
    abstract public double valueBerechnen(ArrayList<TicketIF> tickets);

}
