package de.hbrs.team89.se1_starter_repo;

import java.util.ArrayList;

public interface StatistikIF {
    double statistikErstellen(ArrayList<TicketIF> tickets);
    long setLetztesAusgefahrenesTicket(ArrayList<TicketIF> tickets);
    double valueBerechnen(ArrayList<TicketIF> tickets);
}
