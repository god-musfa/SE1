package template;

import base.TicketIF;

import java.util.List;

public abstract class EinnahmenStatistik implements EinnahmenStatistikIF {
    protected long letztesAusgefahrenesTicket;
    @Override
    final public double statistikErstellen(List<TicketIF> tickets) {
        letztesAusgefahrenesTicket = setLetztesAusgefahrenesTicket(tickets);
        double value = valueBerechnen(tickets);
        return value;
    }

    @Override
    public long setLetztesAusgefahrenesTicket(List<TicketIF> tickets){
        return tickets.stream().mapToLong(x->x.getEnd()).max().orElse(-1);
    };

    @Override
    abstract public double valueBerechnen(List<TicketIF> tickets);

}
