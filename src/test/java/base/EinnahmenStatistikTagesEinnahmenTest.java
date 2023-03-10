package base;

import template.StatistikTagesEinnahmen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EinnahmenStatistikTagesEinnahmenTest {
ArrayList<TicketIF> tickets;
StatistikTagesEinnahmen tages;
    @BeforeEach
    void setUp() {
        tages = new StatistikTagesEinnahmen();
        tickets = new ArrayList<>();
        tickets.add(new Ticket("fdsfgsdgrr", "1"));
        tickets.add(new Ticket("fasgsdhhhg", "1"));
        tickets.add(new Ticket("zzzfsddknfd", "1"));
        tickets.add(new Ticket("jnigsnlijfsnlkj", "1"));

        long unix = 1654704862;
        tickets.get(0).setDuration(unix);
        tickets.get(1).setDuration(unix);
        tickets.get(2).setDuration(unix+86400000);
        tickets.get(3).setDuration(unix+86400500);

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