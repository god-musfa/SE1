package template;

import base.TicketIF;

import java.util.List;

public class DailyIncomeStatistic extends IncomeStatistic {
    @Override
    public double valueBerechnen(List<TicketIF> tickets) {
        int tagInUnix = 86400000;
        return tickets.stream().filter(t -> t.getEnd()>=(this.letztesAusgefahrenesTicket-tagInUnix)).mapToDouble(TicketIF::getPrice).sum();
    }
}
