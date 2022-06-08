package de.hbrs.team89.se1_starter_repo;

import java.util.List;

public interface ParkhausIF {

    int enter(Car c);

    boolean leave(int nr);

    Car[] getCars();

    List<TicketIF> getTicket();
}
