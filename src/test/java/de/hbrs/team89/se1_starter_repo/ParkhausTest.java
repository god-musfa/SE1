package de.hbrs.team89.se1_starter_repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkhausTest {
    String[] st1;
    String[] st2;
    String[] st3;
    ParkhausIF ph;
    Car c1;
    Car c2;
    Car c3;

    @BeforeEach
    void setUp() {
        st1 = new String[]{"1", "2", "3", "ab","as"};
        st2 = new String[]{"2", "2", "3","ab","ad"};
        st3 = new String[]{"3", "2", "3","ab","af"};
        ph = new Parkhaus();
        c1 = new Car(st1);
        c2 = new Car(st2);
        c3 = new Car(st3);
    }

    @Test
    @DisplayName("Testet ob Autos korrekt dem Parkhaus hinzugefuegt werden")
    void enterTest() {
        assertEquals(1,ph.enter(c1));
        assertEquals(2,ph.enter(c2));
        assertEquals(3,ph.enter(c3));
    }

    @Test
    @DisplayName("Testet ob Autos korrekt aus dem Parkhaus entfernt werden")
    void leaveTest() {
        ph.enter(c1);
        ph.enter(c2);
        ph.enter(c3);
        assertTrue(ph.leave(1));
        assertTrue(ph.leave(2));
        assertTrue(ph.leave(3));
        assertFalse(ph.leave(4));
    }

    @Test
    @DisplayName("Prueft ob Autos an erwarteter Position eingefuegt werden")
    void leaveEnterTest() {
        ph.enter(c1);
        ph.enter(c2);
        ph.leave(1);
        ph.enter(c3);
        assertEquals(c3.nr(),ph.getCars()[0].nr());
    }

    @AfterEach
    void tearDown() {
        st1 = null;
        st2 = null;
        st3 = null;
        ph = null;
        c1 = null;
        c2 = null;
        c3 = null;
    }

    @Test
    void getTicket() {
        ph.enter(c1);
        ph.enter(c2);
        ph.enter(c3);

        assertEquals(ph.getTicket().get(0).getTicketID(),"as");
        assertEquals(ph.getTicket().get(1).getTicketID(),"ad");
        assertEquals(ph.getTicket().get(2).getTicketID(),"af");
    }

}