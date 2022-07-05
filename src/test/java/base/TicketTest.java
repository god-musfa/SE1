package base;


import multiton.FahrzeugtypHelper;
import multiton.KundentypHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    Ticket ticket1;
    Ticket ticket2;
    Ticket ticket3;
    @BeforeEach
    void setUp() {
        ticket1 = new Ticket("1","100");
        ticket1.setDuration(400);
        ticket2 = new Ticket("2","0");
        ticket2.setDuration(3600);
        ticket3 = new Ticket("3","0");
        ticket3.setDuration(7200);
    }

    @ParameterizedTest
    @DisplayName("Checks price calculation for different Vehicle Types")
    @CsvSource({"PKW, 400.0, 1800.0, 0.0", "Zweirad, 200.0, 900.0, 0.0", "Pickup, 600.0, 2700.0, 0.0" })
    void setPrice(String s, double price1, double price2, double price3) {
        ticket1.setPrice(FahrzeugtypHelper.getFahrzeug(s), KundentypHelper.getKunde("Parkhauskunde"),400000);
        assertEquals(price1,Math.round(ticket1.getPrice()*100)/100);
        ticket2.setPrice(FahrzeugtypHelper.getFahrzeug(s),KundentypHelper.getKunde("Behinderte"),3600000);
        assertEquals(price2,Math.round(ticket2.getPrice()*100)/100);
        ticket3.setPrice(FahrzeugtypHelper.getFahrzeug(s),KundentypHelper.getKunde("Abonnent"),7200000);
        assertEquals(price3,Math.round(ticket3.getPrice()*100)/100);
    }


}