package template;

import base.TicketIF;

import java.util.List;

public class StatistikTagesEinnahmen extends EinnahmenStatistik {
    @Override
    public double valueBerechnen(List<TicketIF> tickets) {
        int tagInUnix = 86400;
        return tickets.stream().filter(t -> t.getEnd()>=(this.letztesAusgefahrenesTicket-tagInUnix)).mapToDouble(TicketIF::getPrice).sum();
    }
}
