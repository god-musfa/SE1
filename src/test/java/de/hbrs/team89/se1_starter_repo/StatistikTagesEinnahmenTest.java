package de.hbrs.team89.se1_starter_repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StatistikTagesEinnahmenTest {
ArrayList<TicketIF> tickets;
StatistikTagesEinnahmen tages;
    @BeforeEach
    void setUp() {
        tages = new StatistikTagesEinnahmen();
        tickets = new ArrayList<>();
        tickets.add(new Ticket("fdsfgsdgrr"));
        tickets.add(new Ticket("fasgsdhhhg"));
        tickets.add(new Ticket("zzzfsddknfd"));
        tickets.add(new Ticket(("jnigsnlijfsnlkj")));

        long unix = 1654704862;
        tickets.get(0).setEnd(unix);
        tickets.get(1).setEnd(unix);
        tickets.get(2).setEnd(unix+86500);
        tickets.get(3).setEnd(unix+86500);

        tickets.get(0).setPrice(100.0);
        tickets.get(1).setPrice(200.0);
        tickets.get(2).setPrice(300.0);
        tickets.get(3).setPrice(400.0);
    }

    @Test
    void valueBerechnen() {
        double tagesPreis = tages.statistikErstellen(tickets);
        assertEquals(700,tagesPreis);
    }
}