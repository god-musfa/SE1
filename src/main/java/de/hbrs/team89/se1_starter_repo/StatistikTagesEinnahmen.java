package de.hbrs.team89.se1_starter_repo;

import java.util.ArrayList;

public class StatistikTagesEinnahmen extends Statistik{
    @Override
    public double valueBerechnen(ArrayList<TicketIF> tickets) {
        int tagInUnix = 86400;
        return tickets.stream().filter(t -> t.getEnd()>=(this.letztesAusgefahrenesTicket-tagInUnix)).mapToDouble(x->x.getPrice()).sum();
    }
}
