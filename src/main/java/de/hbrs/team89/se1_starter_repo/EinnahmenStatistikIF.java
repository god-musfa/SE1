package de.hbrs.team89.se1_starter_repo;

import java.util.List;

public interface EinnahmenStatistikIF {
    double statistikErstellen(List<TicketIF> tickets);
    long setLetztesAusgefahrenesTicket(List<TicketIF> tickets);
    double valueBerechnen(List<TicketIF> tickets);
}
