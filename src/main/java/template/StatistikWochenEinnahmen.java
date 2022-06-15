package template;

import base.TicketIF;

import java.util.List;

public class StatistikWochenEinnahmen extends EinnahmenStatistik {
    @Override
    public double valueBerechnen(List<TicketIF> tickets) {
        int wocheInUnix = 604800;
        return tickets.stream().filter(t -> t.getEnd()>=(this.letztesAusgefahrenesTicket-wocheInUnix)).mapToDouble(x->x.getPrice()).sum();
    }
}