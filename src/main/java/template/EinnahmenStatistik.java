package template;

import base.TicketIF;

import java.util.List;

public abstract class EinnahmenStatistik implements EinnahmenStatistikIF {
    protected long letztesAusgefahrenesTicket;
    @Override
    public final double statistikErstellen(List<TicketIF> tickets) {
        letztesAusgefahrenesTicket = setLetztesAusgefahrenesTicket(tickets);
        return valueBerechnen(tickets);
    }

    @Override
    public long setLetztesAusgefahrenesTicket(List<TicketIF> tickets){
        return tickets.stream().mapToLong(TicketIF::getEnd).max().orElse(-1);
    }

}
