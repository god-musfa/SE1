package base;

import template.StatistikWochenEinnahmen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EinnahmenStatistikWochenEinnahmenTest {
    ArrayList<TicketIF> tickets;
    StatistikWochenEinnahmen wochenstatistik;
    @BeforeEach
    void setUp() {
        wochenstatistik = new StatistikWochenEinnahmen();
        tickets = new ArrayList<>();
        tickets.add(new Ticket("fdsfgsdgrr", "1"));
        tickets.add(new Ticket("fasgsdhhhg", "1"));
        tickets.add(new Ticket("zzzfsddknfd", "1"));
        tickets.add(new Ticket("jnigsnlijfsnlkj", "1"));
        tickets.add(new Ticket("fnadskfnadsfnsdfn", "1"));
        tickets.add(new Ticket("jnigsnlijfsnlkjssssss", "1"));

        long unix = 1654704862;
        tickets.get(0).setEnd(unix);
        tickets.get(1).setEnd(unix);
        tickets.get(2).setEnd(unix+86500);
        tickets.get(3).setEnd(unix+87200);
        tickets.get(4).setEnd(unix+604800);
        tickets.get(5).setEnd(unix+692000);


        tickets.get(0).setPrice(100.0);
        tickets.get(1).setPrice(200.0);
        tickets.get(2).setPrice(300.0);
        tickets.get(3).setPrice(400.0);
        tickets.get(4).setPrice(10000.0);
        tickets.get(5).setPrice(20000.0);
    }
    @Test
    void valueBerechnen() {
        double wochenPreis = wochenstatistik.statistikErstellen(tickets);
        assertEquals(30400.0,wochenPreis);
    }
}