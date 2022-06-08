package de.hbrs.team89.se1_starter_repo;

import java.util.List;

public class StatistikWochenEinnahmen extends EinnahmenStatistik {
    @Override
    public double valueBerechnen(List<TicketIF> tickets) {
        int wocheInUnix = 604800;
        return tickets.stream().filter(t -> t.getEnd()>=(this.letztesAusgefahrenesTicket-wocheInUnix)).mapToDouble(x->x.getPrice()).sum();
    }
}
