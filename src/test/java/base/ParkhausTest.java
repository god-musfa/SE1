package base;

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
        st1 = new String[]{"1", "2", "3", "ab","as","das","sdaa","dfds","sadas"};
        st2 = new String[]{"2", "2", "3","ab","ad","sda1","daff","sddd","gmgj"};
        st3 = new String[]{"3", "2", "3","ab","af","faff","ffgg","bgfs","fff"};
        ph = new Parkhaus(15);
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
        assertEquals(5.00,ph.leave(1));
        assertEquals(5.00,ph.leave(2));
        assertEquals(5.00,ph.leave(3));
        assertEquals(-1.00,ph.leave(4));
    }

    @Test
    @DisplayName("Testet ob Autos rausfahren koennen obwohl das Parkhaus leer ist." )
    void leaveTest2() {
        assertEquals(-1.00,ph.leave(1));
    }
    @Test
    @DisplayName("Testet ob Autos rausfahren koennen obwohl sie nicht im Parkhaus sind." )
    void leaveTest3() {
        ph.enter(c1);
        assertEquals(-1.00,ph.leave(2));
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