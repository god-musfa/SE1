package template;

import base.TicketIF;

import java.util.List;

public class WeeklyIncomeStatistic extends IncomeStatistic {
    @Override
    public double valueBerechnen(List<TicketIF> tickets) {
        int wocheInUnix = 86400000*7;
        return tickets.stream().filter(t -> t.getEnd()>=(this.letztesAusgefahrenesTicket-wocheInUnix)).mapToDouble(TicketIF::getPrice).sum();
    }
}
