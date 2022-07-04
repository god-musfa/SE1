package base;

import multiton.Fahrzeugtyp;
import multiton.FahrzeugtypHelper;
import multiton.KundentypHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    Ticket ticket1,ticket2,ticket3;
    @BeforeEach
    void setUp() {
        ticket1 = new Ticket("1","100");
        ticket1.setEnd(500);
        ticket2 = new Ticket("2","0");
        ticket2.setEnd(3600);
        ticket3 = new Ticket("3","0");
        ticket3.setEnd(7200);
    }

    @Test
    @DisplayName("Checks price calculation for different Vehicle and Customer Types")
    void setPrice() {
        ticket1.setPrice(FahrzeugtypHelper.getFahrzeug("PKW"), KundentypHelper.getKunde("Parkhauskunde"),400000);
        assertEquals(400.0,ticket1.getPrice());
        ticket2.setPrice(FahrzeugtypHelper.getFahrzeug("Zweirad"),KundentypHelper.getKunde("Behinderte"),3600000);
        assertEquals(900.0,ticket2.getPrice());
        ticket3.setPrice(FahrzeugtypHelper.getFahrzeug("Pickup"),KundentypHelper.getKunde("Abonnent"),7200000);
        assertEquals(0.0,ticket3.getPrice());
    }
}