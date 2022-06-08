package de.hbrs.team89.se1_starter_repo;

import java.util.List;

public class StatistikTagesEinnahmen extends EinnahmenStatistik {
    @Override
    public double valueBerechnen(List<TicketIF> tickets) {
        int tagInUnix = 86400;
        return tickets.stream().filter(t -> t.getEnd()>=(this.letztesAusgefahrenesTicket-tagInUnix)).mapToDouble(x->x.getPrice()).sum();
    }
}
