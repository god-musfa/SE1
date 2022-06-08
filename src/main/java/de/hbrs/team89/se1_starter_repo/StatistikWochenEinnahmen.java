package de.hbrs.team89.se1_starter_repo;

import java.util.ArrayList;

public class StatistikWochenEinnahmen extends Statistik{
    @Override
    public double valueBerechnen(ArrayList<TicketIF> tickets) {
        int wocheInUnix = 604800;
        return tickets.stream().filter(t -> t.getEnd()>=(this.letztesAusgefahrenesTicket-wocheInUnix)).mapToDouble(x->x.getPrice()).sum();
    }
}
